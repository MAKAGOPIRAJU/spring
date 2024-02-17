package LibraryManagement.demo.Service;

import LibraryManagement.demo.Exceptions.LibraryCardNotExist;
import LibraryManagement.demo.Exceptions.StudentNotExist;
import LibraryManagement.demo.Model.LibraryCard;
import LibraryManagement.demo.Model.Student;
import LibraryManagement.demo.Repository.LibraryCardRepository;
import org.aspectj.apache.bcel.classfile.Module;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LibraryCardService {
    @Autowired
    private LibraryCardRepository libraryCardRepository;

    public LibraryCard addLibrayCard(LibraryCard libraryCard) {

      LibraryCard libraryCard1 =   libraryCardRepository.save(libraryCard);

      return libraryCard1;
    }

    public Student getStudent(Integer cardId) throws Exception{

        // card may be not exist

        Optional<LibraryCard> optionalLibraryCard = libraryCardRepository.findById(cardId);

        if(optionalLibraryCard.isEmpty()) {
            throw new LibraryCardNotExist("card with " + cardId + " is not exist");
        }

        LibraryCard libraryCard = optionalLibraryCard.get();

        // student may be not exist

        if(libraryCard.getStudent() == null) {
            throw new StudentNotExist("no student assigned to card with card id" + cardId);
        }

        Student student = libraryCard.getStudent();

        // successfull

        return student;
    }
}
