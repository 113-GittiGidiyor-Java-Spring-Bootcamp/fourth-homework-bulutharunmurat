package dev.patika.repository;

import dev.patika.entity.Course;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepository extends CrudRepository<Course, Integer> {

    List<Course> findByName(String c);
    List<Course> findByNameContaining(String c);
    void deleteByName(String c);


}
