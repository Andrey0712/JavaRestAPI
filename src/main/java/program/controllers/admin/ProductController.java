package program.controllers.admin;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import program.dto.admin.proddto.FotoAddDTO;
import program.dto.admin.proddto.ProdAddDto;
import program.entities.Product;
import program.mapper.ApplicationMapper;
import program.repositories.ProductRepository;
import org.apache.commons.io.FilenameUtils;
import program.storage.StorageService;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("admin/products")
@RequiredArgsConstructor
public class ProductController {
    private final StorageService storageService;
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
    return product.getId();}

    @PostMapping("/upload")//добавить фото на сервак
    public String upload(FotoAddDTO model) {
        //Product product=mapper.ProdByFotoProdDto(model);
        String fileName=storageService.store(model.getImage());
        //product.setImage(fileName);
        //productRepository.save(product);
        //return product.getId();
        return fileName;
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


//    @PostMapping("/foto")
//    public String saveDocument(@RequestParam("images[]") MultipartFile[] files,
//                               RedirectAttributes redirectAttributes)
//    {
//        for (int i = 0; i < files.length; i++) {
//            MultipartFile file = files[i];
//
//            String name = UUID.randomUUID().toString()+"."+FilenameUtils.getExtension(file.getOriginalFilename());
//            try {
//                byte[] bytes = file.getBytes();
//
//                // Creating the directory to store file
//                String rootPath =  "src/main/resources/static.images";
//                System.out.println(rootPath);
//                File dir = new File(rootPath + File.separator + "uploads");
//                if (!dir.exists())
//                    dir.mkdirs();
//
//                // Create the file on server
//                File serverFile = new File(dir.getAbsolutePath()
//                        + File.separator + name);
//                BufferedOutputStream stream = new BufferedOutputStream(
//                        new FileOutputStream(serverFile));
//                stream.write(bytes);
//                stream.close();
//
////                logger.info("Server File Location="
////                        + serverFile.getAbsolutePath());
//
//            } catch (Exception e) {
//                return "You failed to upload " + name + " => " + e.getMessage();
//            }
//        }
//        return "ok";
//    }
}
