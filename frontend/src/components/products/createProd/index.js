import React, {useRef, useState} from 'react'
import { Formik, Form } from 'formik';
import { push } from "connected-react-router";
import MyTextInput from '../../common/TextInput';
import validationFields from './validation';
import { useDispatch, useSelector } from 'react-redux';
import { RegisterProd } from '../../../actions/createProd';

const ProductCreate = () => {
    const initState = {
        name: '',
        price: '',
        description: '',
        
    }
    const dispatch = useDispatch();
    const { errors } = useSelector(state => state.prod);
    const refFormik = useRef();
    const titleRef = useRef();
    const [invalid, setInvalid] = useState([]);
    




    const onSubmitHandler = async (values) => {
        console.log("errors", errors);
        try {            
            const formData = new FormData();
            Object.entries(values).forEach(([key, value]) => formData.append(key, value));
            //setLoading(true);
            dispatch(RegisterProd(formData))
                .then(result => {
                    //setLoading(false);
                    dispatch(push("/"));
                })
                .catch(ex=> {
                    //setLoading(false);
                    Object.entries(ex.errors).forEach(([key, values]) => {
                        let message = '';
                        values.forEach(text=> message+=text+" ");
                        refFormik.current.setFieldError(key,message);
                    });

                    setInvalid(ex.errors.invalid);
                    titleRef.current.scrollIntoView({ behavior: 'smooth' })
                    
                });
        }
        catch (error) {
            //setLoading(false);
            console.log("Server is bad register from", errors);
        }

        
    }

    return (
        <>
            <div className="row">
            <div className="offset-md-3 col-md-6">
                <h1 ref={titleRef} className="text-center">Створення нового продукта</h1>
                {invalid && invalid.length>0 &&
                    <div className="alert alert-danger">
                        <ul>
                        {
                            invalid.map((text, index) => {
                                return (
                                    <li key={index}>{text}</li>

                                );
                            })
                        }
                        </ul>
                    </div>

                }
                <Formik
                    innerRef = {refFormik}
                    initialValues={initState}
                    validationSchema={validationFields()}
                    onSubmit={onSubmitHandler}
                >
                    <Form>
                        <MyTextInput
                            label="Назва"
                            name="name"
                            id="name"
                            type="text" />

                        
                        <MyTextInput
                            label="Ціна"
                            name="price"
                            id="price"
                            type="text" />

                        <MyTextInput
                            label="Опис"
                            name="description" 
                            id="description"
                            type="text" />

                        {/* <EditorTinymce/> */}

                        <button type="submit" className="btn btn-primary">Добавить продукт</button>
                    </Form>
                </Formik>
            </div>

           
        </div>
        </>
    );
}

export default ProductCreate;