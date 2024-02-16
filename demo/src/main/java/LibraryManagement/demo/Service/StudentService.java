package LibraryManagement.demo.Service;

import LibraryManagement.demo.Model.Student;
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
}
