package program.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@Table(name = "products")
@RequiredArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100,nullable = false)
    private String name;

    @Column(nullable = true)
    private BigDecimal price;

    @Column(length = 100,nullable = true)
    private String description;

    @Column(length = 200, nullable = true)
    private String image;

}
