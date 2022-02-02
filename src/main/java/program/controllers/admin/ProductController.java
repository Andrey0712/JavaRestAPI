package program.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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
}
