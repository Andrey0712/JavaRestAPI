import http from '../http_common';

class ProdDataService {

    getdata() {
        return http.get("admin/products/list");
                
    }  
    del(data){
        return http
            .post("admin/products/delete", data);
    }
    register(data) {
        return http.post("admin/products", data);     
    }
    
    
}

export default new ProdDataService();