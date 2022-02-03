package program.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import program.dto.admin.proddto.ProdAddDto;
import program.entities.Product;
import program.mapper.ApplicationMapper;
import program.repositories.ProductRepository;

import java.util.List;

@RestController
@RequestMapping("admin/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepository;
    private  final ApplicationMapper mapper;

    @GetMapping("list")
    public List<Product> list() {
        return productRepository.findAll();
    }
//@GetMapping("list")
//    public  String list(){
//        return"Hello";
//    }
@PostMapping("")
public int create(ProdAddDto model) {
        Product product=mapper.ProdByAddProdDto(model);
    productRepository.save(product);
    return product.getId();
}

    @PostMapping("/delete/{id}")
    public String delete(@PathVariable("id") Integer id){
        productRepository.deleteById(id);
        return "ok";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable("id") Integer id, ProdAddDto model){
        Product update = productRepository.getById(id);
        update.setName(model.getName());
        update.setPrice(model.getPrice());
        update.setDescription(model.getDescription());
        productRepository.save(update);
        return "Обновили продукт №:" + update.getId();

    }
}
