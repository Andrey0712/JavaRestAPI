import http from '../http_common';

class ProdDataService {

    getdata() {
        return http.get("admin/products/list");
                
    }  
    del(data){
        return http
            .post("admin/products/delete", data);}
    
}

export default new ProdDataService();