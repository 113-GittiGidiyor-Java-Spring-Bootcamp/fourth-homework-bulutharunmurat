package dev.patika.service;


import dev.patika.datatransferobject.CourseDTO;
import dev.patika.entity.Course;
import dev.patika.entity.Log;
import dev.patika.repository.LogRepository;
import dev.patika.service.LogService;
import dev.patika.exceptions.CourseIsAlreadyExistException;
import dev.patika.mappers.CourseMapper;
import dev.patika.repository.CourseRepository;
import lombok.RequiredArgsConstructor;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course> {

    private final CourseRepository repository;
    private final CourseMapper courseMapper;
    private final LogRepository logRepository;

    Logger logger = LoggerFactory.getLogger(CourseService.class);

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAll() {

        List<Course> courseList = new ArrayList<>();
        Iterable<Course> students = repository.findAll();
        students.iterator().forEachRemaining(courseList::add);
        return courseList;
    }

    @Override
    @Transactional(readOnly = true)
    public Course findById(int id) {
        return repository.findById(id).get();
    }


    @Transactional
    public Course save(CourseDTO courseDTO) {
        boolean isExist = repository.selectExistsCode(courseDTO.getCode());
        if(isExist){
            logger.info("error saving course");
            Log log = new Log(System.currentTimeMillis(),"Course with Code : " + courseDTO.getCode() +
                    " is already exists!", "course error");
//            Log log = Log.builder()
//                    .message("Course with Code : " + courseDTO.getCode() + " is already exists!")
//                            .localDate(System.currentTimeMillis())
//                                    .errorType("course error")
//                                            .build();
            logRepository.save(log);
            throw new CourseIsAlreadyExistException("Course with Code : " + courseDTO.getCode() + " is already exists!");
        }
        Course course = courseMapper.mapFromCourseDTOtoCourse(courseDTO);
        return repository.save(course);
    }

    @Transactional
    public Course update(CourseDTO courseDTO) {

        Course course = courseMapper.mapFromCourseDTOtoCourse(courseDTO);
        return repository.save(course);

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        repository.deleteById(id);
    }

    public List<Course> findByNameContaining(String name) {
        return repository.findByNameContaining(name);
    }

    @Transactional
    public void deleteByName(String name){
        repository.deleteByName(name);
    }
}
