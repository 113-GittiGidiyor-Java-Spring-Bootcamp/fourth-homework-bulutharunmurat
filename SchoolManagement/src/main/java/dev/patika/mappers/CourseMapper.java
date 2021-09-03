package dev.patika.mappers;

import dev.patika.datatransferobject.CourseDTO;


import dev.patika.entity.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper {

    Course mapFromCourseDTOtoCourse(CourseDTO courseDTO);
    CourseDTO mapFromCoursetoCourseDTO(Course course);
}
