package LibraryManagement.demo.Controller;

import LibraryManagement.demo.Model.LibraryCard;
import LibraryManagement.demo.Model.Student;
import LibraryManagement.demo.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @PostMapping("/addStudent")
    public Student addStudent(@RequestBody Student student) {

        return studentService.addStudent(student);
    }

    @GetMapping("/getUser/{id}")
    public ResponseEntity findStudentById(@PathVariable("id") Integer studentId) throws Exception{

        try{
            Student student = studentService.findStudentById(studentId);

            return new ResponseEntity(student , HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    // find all the students in database

    @GetMapping("/all")
    public ResponseEntity allStudents() {

        return new ResponseEntity(studentService.allStudents(),HttpStatus.OK);
    }


    // DELETE Student from the database

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") Integer studentId) throws Exception{

        try {
            String res = studentService.deleteStudent(studentId);
            return new ResponseEntity(res , HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity(e.getMessage() , HttpStatus.BAD_REQUEST);
        }
    }

    // find all student who are from ece department

    @GetMapping("/allECEstudents")
    public List<Student> eceStudents() {

        return studentService.eceStudents();
    }

     // connect the student ans libraycard

    @GetMapping("/assigncard")
    public String assignLibraryCardToStudent(@RequestParam("libraryCardId") Integer libraryCardId,
                                             @RequestParam("studentId") Integer studentId) throws Exception{
        try{
            String res = studentService.assignCardToStudent(libraryCardId,studentId);
            return res;
        }
        catch (Exception e) {
            return e.getMessage();
        }

    }


}
