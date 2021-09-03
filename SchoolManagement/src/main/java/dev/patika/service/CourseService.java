package dev.patika.service;


import dev.patika.datatransferobject.CourseDTO;
import dev.patika.entity.Course;
import dev.patika.mappers.CourseMapper;
import dev.patika.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements BaseService<Course> {

    private final CourseRepository repository;
    private final CourseMapper courseMapper;

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
