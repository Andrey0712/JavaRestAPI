package program.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import program.dto.admin.proddto.*;
import program.entities.Book;
import program.entities.Images;
import program.entities.Product;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    Product ProdByAddProdDto(ProdAddDto dto);
    Product ProdByFotoProdDto(FotoAddDTO dto);

    @Mapping(source = "image", target = "image")
    ImageDto ImageToImageDto (Images images);
    @Mapping(source = "image", target = "image")
    BookDto BookToBookDto(Book book);
    @Mapping(source = "image", target = "image")
    Book BookDtoToBook (BookAddDto bookDto);
    @Mapping(source = "image", target = "image")
    Images ImageDtoToImage(ImageAddDto imageDto);

    List<BookDto> BookList(List<Book> bookList);
}
