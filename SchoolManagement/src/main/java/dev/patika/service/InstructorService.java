package dev.patika.service;


import dev.patika.datatransferobject.InstructorDTO;
import dev.patika.datatransferobject.PermanentInstructorDTO;
import dev.patika.datatransferobject.VisitingResearcherDTO;
import dev.patika.entity.Instructor;
import dev.patika.entity.PermanentInstructor;
import dev.patika.entity.VisitingResearcher;
import dev.patika.exceptions.CourseIsAlreadyExistException;
import dev.patika.exceptions.InstructorIsAlreadyExistException;
import dev.patika.mappers.InstructorMapper;
import dev.patika.mappers.PermanentInstructorMapper;
import dev.patika.mappers.VisitingResearcherMapper;
import dev.patika.repository.InstructorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class InstructorService implements BaseService<Instructor>{

    private final InstructorRepository repository;


    private final InstructorMapper instructorMapper;
    private final PermanentInstructorMapper permanentInstructorMapper;
    private final VisitingResearcherMapper visitingResearcherMapper;

    @Override
    @Transactional(readOnly = true)
    public List<Instructor> findAll() {

        List<Instructor> courseList = new ArrayList<>();
        Iterable<Instructor> students = repository.findAll();
        students.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)
    public Instructor findById(int id) {
        return repository.findById(id).get();
    }


    @Transactional
    public Instructor save(InstructorDTO instructorDTO) {
        Instructor instructor = instructorMapper.mapFromInstructorDTOtoInstructor(instructorDTO);
        return repository.save(instructor);
    }

    @Transactional
    public Instructor update(InstructorDTO instructorDTO) {
        Instructor instructor = instructorMapper.mapFromInstructorDTOtoInstructor(instructorDTO);
        return repository.save(instructor);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<Instructor> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    @Transactional
    public void deleteByName(String name){
        repository.deleteByName(name);
    }

    public List<Instructor>  getThreeMostEarningInstructor(){

        List<Instructor> allInstructors = repository.getThreeMostEarningInstructor();
        List<Instructor> instructorsOfThreeMost = new ArrayList<>();

        for(int i=0; i<3; i++){
            instructorsOfThreeMost.add(allInstructors.get(i));
        }
       return instructorsOfThreeMost;
    }

    public Instructor saveVisitingResearcher(VisitingResearcherDTO visitingResearcherDTO) {
        boolean isExist = repository.selectExistsPhoneNumber(visitingResearcherDTO.getPhoneNumber());
        if(isExist){
            throw new InstructorIsAlreadyExistException("Instructor with Phone Number : " + visitingResearcherDTO.getPhoneNumber() + " is already exists!");
        }
        VisitingResearcher visitingResearcher = visitingResearcherMapper.mapFromVisitingResearcherDTOtoVisitingResearcher(visitingResearcherDTO);
        return repository.save(visitingResearcher);
    }

    public Instructor savePermanentInstructor(PermanentInstructorDTO permanentInstructorDTO) {
        boolean isExist = repository.selectExistsPhoneNumber(permanentInstructorDTO.getPhoneNumber());
        if(isExist){
            throw new InstructorIsAlreadyExistException("Instructor with Phone Number : " + permanentInstructorDTO.getPhoneNumber() + " is already exists!");
        }
        PermanentInstructor permanentInstructor = permanentInstructorMapper.mapFromPermanentInstructorDTOtoPermanentInstructor(permanentInstructorDTO);
        return repository.save(permanentInstructor);
    }
}
