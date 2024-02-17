package LibraryManagement.demo.Controller;

import LibraryManagement.demo.Model.LibraryCard;
import LibraryManagement.demo.Model.Student;
import LibraryManagement.demo.Service.LibraryCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LibaryCardController {
    @Autowired
    private LibraryCardService libraryCardService;

    @PostMapping("/add")
    public LibraryCard addLibrayCard(@RequestBody LibraryCard libraryCard) {

        return libraryCardService.addLibrayCard(libraryCard);
    }

    // get the student assign to the card

    @GetMapping("/getStudent/{cardId}")
    public ResponseEntity getStudent(@PathVariable("cardId") Integer cardId)throws Exception{

        try{

            Student student = libraryCardService.getStudent(cardId);
            return new ResponseEntity(student , HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }
}
