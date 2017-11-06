package bd.ac.seu.aj.streamlabtask.service;

import bd.ac.seu.aj.streamlabtask.model.Course;
import bd.ac.seu.aj.streamlabtask.repository.CourseRepository;

import java.util.List;
import java.util.stream.Collectors;

public class CourseService {
    public List<Course> findAll() {
        return CourseRepository.getCourseList();
    }

    public List<Course> findByPrefix(String prefix) {
        return findAll().stream().filter(course -> course.getCourseCode().startsWith(prefix)).distinct().collect(Collectors.toList());
    }
}
