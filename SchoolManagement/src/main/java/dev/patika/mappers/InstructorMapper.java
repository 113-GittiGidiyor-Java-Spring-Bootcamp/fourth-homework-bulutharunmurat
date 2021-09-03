package dev.patika.mappers;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import dev.patika.datatransferobject.InstructorDTO;
import dev.patika.entity.Instructor;
import dev.patika.entity.PermanentInstructor;
import dev.patika.entity.VisitingResearcher;
import org.mapstruct.Mapper;
import org.mapstruct.Qualifier;
import org.springframework.context.annotation.Primary;

@Mapper
public interface InstructorMapper {
    Instructor mapFromInstructorDTOtoInstructor(InstructorDTO instructorDTO);
    InstructorDTO mapFromInstructortoInstructorDTO(Instructor instructor);
}
