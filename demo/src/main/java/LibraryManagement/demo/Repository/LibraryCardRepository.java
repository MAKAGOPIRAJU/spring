package LibraryManagement.demo.Repository;

import LibraryManagement.demo.Enums.DepartMent;
import LibraryManagement.demo.Model.LibraryCard;
import LibraryManagement.demo.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard , Integer> {

    // all students belong to ece


}
