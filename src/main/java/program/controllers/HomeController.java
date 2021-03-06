package program.controllers;

import org.springframework.core.io.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import program.dto.admin.proddto.FotoAddDTO;
import program.entities.Product;
import program.mapper.ApplicationMapper;
import program.repositories.ProductRepository;
import program.storage.StorageService;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;

@RestController("/")
@RequiredArgsConstructor
public class HomeController {
    private final ProductRepository productRepository;
    private final StorageService storageService;
    private  final ApplicationMapper mapper;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("Products", productRepository.findAll());
        return "main/index";
    }
    //получить фаил из файловой системы
    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws Exception {//запрос на сервак по имени файла

        Resource file = storageService.loadAsResource(filename);// вытягиваем фаил из файловой системы
        String urlFileName =  URLEncoder.encode("моя.jpg", StandardCharsets.UTF_8.toString());//будет выдавать моя
        return ResponseEntity.ok()// если ок отправляем на фронт
                //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
                .contentType(MediaType.IMAGE_JPEG)// тип контента

                .header(HttpHeaders.CONTENT_DISPOSITION,"filename=\""+urlFileName+"\"")
                .body(file);//имя файла и фаил
    }

    @PostMapping("/upload")//добавить фото на сервак
    public String upload(FotoAddDTO model) {
        //Product product=mapper.ProdByFotoProdDto(model);
        String fileName=storageService.store(model.getImage());
        //product.setImage(fileName);
        //productRepository.save(product);
        //return product.getId();
        return fileName;
    }


}
