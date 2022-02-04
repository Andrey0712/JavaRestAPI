import { GET_PRODUCTS} from './types';
import get_request from '../service/getprod_request';

export const GetProd=()=>async(dispatch)=>{

    try {
       
        const result = await get_request.getdata(); 
        console.log("Result :",result.data);        
        dispatch({type: GET_PRODUCTS, data: result.data});    
       
    }
    catch(error) {
        console.log("Problem get ",error);

    }

}