package LibraryManagement.demo.Repository;

import LibraryManagement.demo.Model.Transcation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TranscationRepository extends JpaRepository<Transcation,Integer> {
}
