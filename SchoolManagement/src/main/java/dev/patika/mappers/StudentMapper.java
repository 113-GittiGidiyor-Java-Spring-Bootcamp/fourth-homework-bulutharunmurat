package dev.patika.mappers;


import dev.patika.datatransferobject.StudentDTO;
import dev.patika.entity.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {

    Student mapFromStudentDTOtoStudent(StudentDTO studentDTO);
    StudentDTO mapFromStudenttoStudentDTO(Student student);

}
