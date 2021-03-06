import { useField } from "formik";
import classnames from "classnames";

const TextInput = ({ label, ...props }) => {

    // useField() returns [formik.getFieldProps(), formik.getFieldMeta()] 
    // which we can spread on <input>. We can use field meta to show an error 
    // message if the field is invalid and it has been touched (i.e. visited) 
    const [field, meta] = useField(props); 
    //console.log("field:",field);
    return ( 
      <div className="mb-3"> 
        <label htmlFor={props.id || props.name} className="form-label">{label}</label> 
        <input className={classnames("form-control",
        {"is-valid":meta.touched&&!meta.error},
        {"is-invalid":meta.touched&&meta.error})} {...field} {...props} /> 

       {(meta.touched&&meta.error) && <div className="invalid-feedback">{meta.error}</div> }
      </div> 
    ); 
  };

  export default TextInput;