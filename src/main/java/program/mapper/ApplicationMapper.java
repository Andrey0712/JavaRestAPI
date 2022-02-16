package program.mapper;

import org.mapstruct.Mapper;
import program.dto.admin.proddto.FotoAddDTO;
import program.dto.admin.proddto.ProdAddDto;
import program.entities.Product;

@Mapper(componentModel = "spring")
public interface ApplicationMapper {
    Product ProdByAddProdDto(ProdAddDto dto);
    Product ProdByFotoProdDto(FotoAddDTO dto);
}
