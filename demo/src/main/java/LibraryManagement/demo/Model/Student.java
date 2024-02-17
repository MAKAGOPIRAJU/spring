package LibraryManagement.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer studentid; // primary key

    private String name;

    private String department;

    public Integer getId() {
        return studentid;
    }

    public void setId(Integer studentid) {
        this.studentid = studentid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
