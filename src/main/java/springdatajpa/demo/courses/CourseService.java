package springdatajpa.demo.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;


    /*public List<Course> getAllCourses(String id)
    {
        List<Course> courseList = new ArrayList<>();
        //courseRepository.findAll().forEach(course -> { courseList.add(course); });
        //OR use method reference:
        courseRepository.findAll().forEach(courseList::add);
        return courseList;
    }*/


    public Optional<Course> getCourse(String id)
    {
        Optional<Course> course = courseRepository.findById(id);
        return course;
    }


    /*public void addCourse(Course course)
    {
        courseRepository.save(course);
    }*/


    /*public void updateCourse(Course course, String id)
    {
        courseRepository.save(course);
    }*/

    /*public void deleteCourse(String id)
    {
        courseRepository.deleteById(id);
    }*/
}
