package com.example.demo.students;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents()
    {
        return studentRepository.findAll();
    }

    public void addNewStudent(Student student) {
        Optional<Student> studentByEmail = studentRepository.findStudentByEmail(student.getEmail());
        if(studentByEmail.isPresent()){
            throw new IllegalStateException("email taken");
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)){
            throw new IllegalStateException("Student with id: " + studentId + " Does not Exist");
        }
        studentRepository.deleteById(studentId);
    }

    public Optional<Student> getStudent(Long studentId) {
        Optional<Student> res = studentRepository.findById(studentId);
        if(!res.isPresent()){
            throw new IllegalStateException("User with id: " + studentId + " Doesn't exist");
        }
        return res;
    }
}
