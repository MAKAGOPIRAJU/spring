package LibraryManagement.demo.Model;

import LibraryManagement.demo.Enums.DepartMent;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookId;

    private String bookName;

    @Enumerated(value = EnumType.STRING)
    private DepartMent departMent;

    @ManyToOne
    @JoinColumn
    @JsonIgnore
    private Author author;
}
