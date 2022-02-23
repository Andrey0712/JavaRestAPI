package program.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Table(name = "tbl_images")
@RequiredArgsConstructor
public class Images {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name",columnDefinition="TEXT")
    private String image;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name="book_id")
    private Book book;
}
