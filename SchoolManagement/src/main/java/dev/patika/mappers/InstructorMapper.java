package dev.patika.mappers;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.patika.datatransferobject.InstructorDTO;
import dev.patika.entity.Instructor;
import dev.patika.entity.PermanentInstructor;
import dev.patika.entity.VisitingResearcher;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Qualifier;
import org.springframework.context.annotation.Primary;

@Mapper
public interface InstructorMapper {


    // target = mapping to course in course entity, expression = converting id to course object
//    @Mapping(target = "courseList", expression = "java(walletService.findCustomerById(walletDTO.getCustomerId()))")
    public abstract Instructor mapFromInstructorDTOtoInstructor(InstructorDTO instructorDTO);
    public abstract InstructorDTO mapFromInstructortoInstructorDTO(Instructor instructor);

//    protected Set<Integer> getCourseId()
}
