package dev.patika.mappers;

import dev.patika.datatransferobject.PermanentInstructorDTO;
import dev.patika.datatransferobject.VisitingResearcherDTO;
import dev.patika.entity.PermanentInstructor;
import dev.patika.entity.VisitingResearcher;
import org.mapstruct.Mapper;

@Mapper
public interface VisitingResearcherMapper {
    VisitingResearcher mapFromVisitingResearcherDTOtoVisitingResearcher(VisitingResearcherDTO visitingResearcherDTO);
    VisitingResearcherDTO mapFromVisitingResearchertoVisitingResearcherDTO(VisitingResearcher visitingResearcher);
}
