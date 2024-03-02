package LibraryManagement.demo.Service;

import LibraryManagement.demo.Enums.CardStatus;
import LibraryManagement.demo.Enums.DepartMent;
import LibraryManagement.demo.Enums.Type;
import LibraryManagement.demo.Exceptions.LibraryCardNotExist;
import LibraryManagement.demo.Exceptions.StudentNotExist;
import LibraryManagement.demo.Model.Book;
import LibraryManagement.demo.Model.LibraryCard;
import LibraryManagement.demo.Model.Student;
import LibraryManagement.demo.Model.Transcation;
import LibraryManagement.demo.Repository.BookRepository;
import LibraryManagement.demo.Repository.LibraryCardRepository;
import LibraryManagement.demo.Repository.StudentRepository;
import LibraryManagement.demo.Repository.TranscationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private LibraryCardRepository libraryCardRepository;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private TranscationRepository transcationRepository;

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

//    public  List<Student> allEceStudents(String departMent) {
//
//        List<Student> students = studentRepository.findStudentsByDepartment(departMent);
//
//        return students;
//    }

//    public Student findStudent(Integer studentId) {
//
//        return studentRepository.findStudentByStudentId(studentId);
//    }

    public String blockCard(Integer studentId) {

        Student student = studentRepository.findById(studentId).get();

        LibraryCard libraryCard = student.getLibraryCard();

        libraryCard.setCardstatus(CardStatus.BLOCK);

        student.setLibraryCard(libraryCard);

        studentRepository.save(student);

        return student.getName()+ " libracard blocked successfully";
    }

    public String bookAssign(Integer bookId , Integer studentId) {

        // book

        // student

        // library card

        // transaction create

        Book book = bookRepository.findById(bookId).get();

        Student student = studentRepository.findById(studentId).get();

        LibraryCard libraryCard = student.getLibraryCard();

        // Create Transcation


        Transcation transcation = new Transcation();

        transcation.setTranscationId(1);
        transcation.setLibraryCardId(libraryCard.getCardid());
        transcation.setFine(0);
        transcation.setIssudeDate(LocalDate.now()); // book assign date

        Type bookType = book.getType();

        int noOfDays = 0;

        if(bookType.toString().equals("ORDINARY")) noOfDays = 90;

        if(bookType.toString().equals("ELITE")) noOfDays = 30;

        if(bookType.toString().equals("PRIME")) noOfDays = 15;

        transcation.setExpectedDate(LocalDate.now().plusDays(noOfDays));

        transcationRepository.save(transcation);

        return book.getBookName() + " is issued successfuully to " + student.getName();
    }
}
