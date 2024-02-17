package LibraryManagement.demo.Repository;

import LibraryManagement.demo.Model.LibraryCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibraryCardRepository extends JpaRepository<LibraryCard , Integer> {
}
