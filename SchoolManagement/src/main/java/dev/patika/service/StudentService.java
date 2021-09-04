package dev.patika.service;



import dev.patika.datatransferobject.StudentDTO;
import dev.patika.entity.Student;
import dev.patika.exceptions.CourseIsAlreadyExistException;
import dev.patika.exceptions.StudentAgeNotValidException;
import dev.patika.mappers.StudentMapper;
import dev.patika.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentService implements BaseService<Student> {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Student> findAll() {

        List<Student> studentList = new ArrayList<>();
        Iterable<Student> students = repository.findAll();
        students.iterator().forEachRemaining(studentList::add);
        return studentList;
    }

    @Override
    @Transactional(readOnly = true)
    public Student findById(int id) {
        return repository.findById(id).get();
    }

    @Transactional
    public Student save(StudentDTO studentDTO) {

        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int age = currentYear - studentDTO.getBirthDate().getYear();

        if(age < 18 || age > 40){
            throw new StudentAgeNotValidException("Student Age should be between 18 and 40!");
        }
        Student student = studentMapper.mapFromStudentDTOtoStudent(studentDTO);
        return repository.save(student);
    }

//    @Override
    @Transactional
    public Student update(StudentDTO studentDTO) {
        Student student = studentMapper.mapFromStudentDTOtoStudent(studentDTO);
        return repository.save(student);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public int getNumberOfStudents() {
        return repository.getNumberOfStudents();
    }

    public List<?> getGenderWithGrouping() {
        return repository.getGenderWithGrouping();
    }

    public List<?> getGenderWithGroupingWithNativeQuery() {
        return repository.getGenderWithGroupingWithNativeQuery();
    }

    public List<Student> getStudentWithName(String name) {
        return repository.findByName(name);
    }

    public List<Student> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    @Transactional
    public void deleteByName(String name){
        repository.deleteByName(name);
    }
}
