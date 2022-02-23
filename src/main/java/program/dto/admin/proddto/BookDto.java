package program.dto.admin.proddto;

import lombok.Data;

import java.util.List;

@Data
public class BookDto {
    private int id;
    private String name;
    private List<ImageAddDto> image;
}
