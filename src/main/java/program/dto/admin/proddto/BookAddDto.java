package program.dto.admin.proddto;

import lombok.Data;

import java.util.List;

@Data
public class BookAddDto {
    private String name;
    private List<ImageAddDto> Image;
}
