package LibraryManagement.demo.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "student")
public class Student {
    @Id // primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Integer id; // primary key

    private String name;

    private String department;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
