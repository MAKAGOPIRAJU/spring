package LibraryManagement.demo.Service;

import LibraryManagement.demo.Exceptions.LibraryCardNotExist;
import LibraryManagement.demo.Exceptions.StudentNotExist;
import LibraryManagement.demo.Model.LibraryCard;
import LibraryManagement.demo.Model.Student;
import LibraryManagement.demo.Repository.LibraryCardRepository;
import LibraryManagement.demo.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    public Student addStudent(Student student) {

        Student student1 = studentRepository.save(student);

        return  student1;
    }

    public Student findStudentById(Integer studentId) throws Exception{

        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if(optionalStudent.isEmpty()) {

            throw  new Exception("Student with id not exist");
        }

        return optionalStudent.get(); // return student
    }

    public List<Student> allStudents() {

        List<Student> all = studentRepository.findAll();

        return all;
    }

    public String deleteStudent(Integer studentId) throws Exception{

        // the student with studentId should exist in database

        Optional<Student> optionalStudent = studentRepository.findById(studentId);

        if(optionalStudent.isEmpty()) {
            throw new Exception("student not exist");
        }

        // student exist

        studentRepository.deleteById(studentId);

        return "Student deleted successfully";

    }

    public List<Student> eceStudents() {

        List<Student> allStudents = studentRepository.findAll();

        // only ECE students

        List<Student> ece = new ArrayList<>();

        for(Student student : allStudents) {

            if(student.getDepartment().equals("ECE")) ece.add(student);
        }

        return ece;
    }

    public String assignCardToStudent(Integer libraryCardId , Integer studentId) throws Exception{

        // get the librarycard and student

        Optional<LibraryCard> optionalLibraryCard = libraryCardRepository.findById(libraryCardId);

        if(optionalLibraryCard.isEmpty()) {
            throw new LibraryCardNotExist("card with " + libraryCardId + "is not exist");
        }

        LibraryCard libraryCard = optionalLibraryCard.get();

        // get the student

        Optional<Student> optional= studentRepository.findById(studentId);

        if(optional.isEmpty()) {
            throw new StudentNotExist("student is not exist with  id " + studentId);
        }

        Student student = optional.get();

        // assign librarycard to student

        libraryCard.setStudent(student);

        // here i updted something librarycard

        libraryCardRepository.save(libraryCard); // save updated librarycard into database

        return "student with " + studentId + " is successfully assigned with library card id " + libraryCardId;
    }
}
