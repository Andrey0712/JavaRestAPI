package program.controllers;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import program.dto.admin.proddto.BookAddDto;
import program.dto.admin.proddto.BookDto;
import program.entities.Book;
import program.entities.Images;
import program.mapper.ApplicationMapper;
import program.repositories.BookRepository;
import program.repositories.ProductRepository;
import program.storage.StorageService;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
@RequiredArgsConstructor
public class BookController {

    private final StorageService storageService;
    private final BookRepository repository;
    private  final ApplicationMapper mapper;

    //добавить книгу
    @PostMapping( "/addbook")
    public int create(@RequestBody BookAddDto bookAddDto) throws IOException {

        Book book = mapper.BookDtoToBook(bookAddDto);

        for (Images image:book.getImage()) {

            String bases64 = image.getImage();

            if (!bases64.isEmpty()) {
                String name = storageService.store(bases64);
                image.setImage(name);
                image.setBook(book);

            }
        }

        repository.save(book);
        return book.getId();
    }

    //  Метод повертає колекцію книжок з БД
    @GetMapping("/get")
    public List<Book> getBooks()
    {
        return repository.findAll();
    }


}
