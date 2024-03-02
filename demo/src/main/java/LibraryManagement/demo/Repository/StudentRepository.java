package LibraryManagement.demo.Repository;

import LibraryManagement.demo.Enums.DepartMent;
import LibraryManagement.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student , Integer> {

//    List<Student> findStudentsByDepartment(String departMent);
//
//    Student findStudentByStudentId(Integer studentid);

   // all apis exception handling

    // custom query methods 5

    // filters add




}
