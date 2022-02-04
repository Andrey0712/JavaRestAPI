import { useEffect } from "react";
import { useSelector, useDispatch } from 'react-redux';
import { GetProd } from '../../actions/prods';
import getprod_request from "../../service/getprod_request";

const ProdList = () => {

    const dispatch = useDispatch();
    const  {list}  = useSelector(state => state.prod);
    
    const onClickDelete = (e) => 
    {
        const del=e.target.id;
        var row = document.getElementById(del);
        getprod_request.del(del)
        .then(result => {
            
            row.remove();
            
        }).catch(error=> {
            console.log(error.response);
        });

    }

    useEffect(() => {
        dispatch(GetProd());
        console.log("UseEffect done:");

    }, []);


    return (
        <>            
            <table className="table">
                <thead className="table table-bordered">
                    <tr>
                       
                        <th scope="col">Назва</th>
                        <th scope="col">Ціна</th>
                        <th scope="col">Опис</th>
                        <th scope="col">Действие</th>
                    </tr>
                </thead>
                <tbody>
                   
                            {                    
                  list && list.map((item, index) => 
                  <tr id={item.id} key={index}>
                                
                                <td>{item.name}</td>
                                <td>{item.price}</td>
                                <td>{item.description}</td>
                                <td>
                                <div className="mx-auto">
                                <i className="fa fa-trash-o text-danger fa-2x" id={item.id} 
                                            onClick={onClickDelete} style={{cursor: 'pointer'}} aria-hidden="true"></i>
                                            
                                             </div>
                                    </td>
                            </tr>)}
                </tbody>
            </table>
        </>
    )
}

export default ProdList;