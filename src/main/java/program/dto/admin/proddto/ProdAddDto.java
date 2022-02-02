package program.dto.admin.proddto;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;

@Data
public class ProdAddDto {
    private String name;
    private BigDecimal price;
    private String description;
}
