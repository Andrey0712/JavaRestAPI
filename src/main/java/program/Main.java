package program;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import program.storage.StorageProperties;
import program.storage.StorageService;


@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello");
        SpringApplication.run(Main.class, args);
    }
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/admin/products/list").allowedOrigins("http://localhost:3000");
                registry.addMapping("/admin/products/delete/{id}").allowedOrigins("http://localhost:3000");
                registry.addMapping("/admin/products").allowedOrigins("http://localhost:3000");
                registry.addMapping("/admin/products/foto").allowedOrigins("http://localhost:3000");
            }
        };
    }
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//        return new WebMvcConfigurer() {
//            @Override
//            public void addCorsMappings(CorsRegistry registry) {
//                registry.addMapping("/admin/roles").allowedOrigins("http://localhost:3000");
//            }
//        };
//    }
    //создаст метод согласно интерфейса
    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            //storageService.deleteAll();
            try {
                storageService.init();
            }
            catch(Exception ex) {
                System.out.println("----propblem cteate folder--------");
            }
        };
    }
}
