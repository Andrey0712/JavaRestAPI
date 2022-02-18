package program.dto.admin.proddto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class FotoAddDTO {
    private String name;
    private BigDecimal price;
    private String description;
    private String image;
}
