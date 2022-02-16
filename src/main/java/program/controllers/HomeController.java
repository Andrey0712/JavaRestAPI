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

@Controller
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

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> serveFile(@PathVariable String filename) throws Exception {

        Resource file = storageService.loadAsResource(filename);
        String urlFileName =  URLEncoder.encode("сало.jpg", StandardCharsets.UTF_8.toString());
        return ResponseEntity.ok()
                //.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
                .contentType(MediaType.IMAGE_JPEG)

                .header(HttpHeaders.CONTENT_DISPOSITION,"filename=\""+urlFileName+"\"")
                .body(file);
    }


}
