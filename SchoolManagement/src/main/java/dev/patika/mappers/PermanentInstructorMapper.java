package dev.patika.mappers;


import dev.patika.datatransferobject.PermanentInstructorDTO;
import dev.patika.datatransferobject.VisitingResearcherDTO;
import dev.patika.entity.PermanentInstructor;
import org.mapstruct.Mapper;

@Mapper
public interface PermanentInstructorMapper {

    PermanentInstructor mapFromPermanentInstructorDTOtoPermanentInstructor(PermanentInstructorDTO permanentInstructorDTO);
    PermanentInstructorDTO mapFromPermanentInstructortoPermanentInstructorDTO(PermanentInstructor permanentInstructor);
}
