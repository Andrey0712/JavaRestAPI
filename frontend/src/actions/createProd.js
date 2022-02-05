
import { REGISTER, REGISTER_BEGIN, 
    REGISTER_FAILED} from "../actions/types";
import getprod_request from "../service/getprod_request";

export const RegisterProd = (model) => async (dispatch) => {
    //const history = useHistory();

    try {
        dispatch({type: REGISTER_BEGIN});
        const result = await getprod_request.register(model);
        console.log("register reuslt", result);
        dispatch({type: REGISTER});
        return Promise.resolve(result);
        
    }
    catch(err) {
        const {data} = err.response;
        //console.log("register error", );
        dispatch({type: REGISTER_FAILED});
        
        //console.log("Propblem register");
        return Promise.reject(data);
    }
}