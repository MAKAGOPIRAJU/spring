package LibraryManagement.demo.Model;

import LibraryManagement.demo.Enums.CardStatus;
import jakarta.persistence.*;



@Entity
public class LibraryCard {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cardid;

    private String collegename;

    // card status

    public Integer getCardid() {
        return cardid;
    }

    public void setCardid(Integer cardid) {
        this.cardid = cardid;
    }

    public String getCollegename() {
        return collegename;
    }

    public void setCollegename(String collegename) {
        this.collegename = collegename;
    }

    public CardStatus getCardstatus() {
        return cardstatus;
    }

    public void setCardstatus(CardStatus cardstatus) {
        this.cardstatus = cardstatus;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    /*
    1. Block
    2.Active
    3.Expiry
     */

    @Enumerated(value = EnumType.STRING) // to let sql knows this refers to the enum
    private CardStatus cardstatus;


    // connection

    @OneToOne // mapping
    @JoinColumn // primary key(column)
    private Student student; // parent

}
