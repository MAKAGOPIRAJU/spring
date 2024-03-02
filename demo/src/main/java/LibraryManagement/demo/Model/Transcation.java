package LibraryManagement.demo.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "transcation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transcation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transcationId;

    private Integer libraryCardId;

    private LocalDate issudeDate;

    private LocalDate  expectedDate;

    private Integer fine;


}
