package dev.patika.mappers;


import dev.patika.datatransferobject.StudentDTO;
import dev.patika.entity.Course;
import dev.patika.entity.Student;
import dev.patika.service.CourseService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;

import java.util.HashSet;
import java.util.Set;


@Mapper(componentModel = "spring")
public abstract class StudentMapper {

    @Autowired
    protected CourseService courseService;

    @Mapping(target = "courseList", expression = "java(getCourseList(studentDTO))")
    public abstract Student mapFromStudentDTOtoStudent(StudentDTO studentDTO);

    @Mapping(target = "courseListId", expression = "java(getCourseListId(student))")
    public abstract StudentDTO mapFromStudenttoStudentDTO(Student student);

    protected Set<Course> getCourseList(StudentDTO studentDTO){

        Set<Course> courses = new HashSet<>();
        studentDTO.getCourseListId().iterator().forEachRemaining(course_id -> courses.add(courseService.findById(course_id)));
        return courses;
    }

    protected Set<Integer> getCourseListId(Student student){

        Set<Integer> courseListId = new HashSet<>();
        student.getCourseList().iterator().forEachRemaining(course -> courseListId.add(course.getId()));
        return courseListId;
    }


}
