import {GET_PRODUCTS } from "../actions/types";


const initialState ={
  list:[]
  
}

function prodReducer(state=initialState,action)
{
    const{type,data}=action;
    console.log("Reducer user data :", data);

    switch(type)
    {
        case GET_PRODUCTS: {
            return {               
              list:data
             
            }            
        }
        default: 
        return state;
    }
    
}
export default prodReducer;