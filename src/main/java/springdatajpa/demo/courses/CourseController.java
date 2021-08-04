package springdatajpa.demo.courses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CourseController {


    @Autowired
    private CourseService courseService;


   /* @RequestMapping("/topics/{id}/courses")
    public List<Course> getAllCourses (@PathVariable String id)
    {
        return courseService.getAllCourses(id);
    }*/


    @RequestMapping("/topics/{topicId}/courses/{courseId}")
    public Optional<Course> getCourse(@PathVariable String courseId)
    {
        return courseService.getCourse(courseId);
    }


    /*@RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void addCourse(@RequestBody Course course)
    {
        courseService.addCourse(course);
    }*/


    /*@RequestMapping(method = RequestMethod.PUT, value = "/courses/{id}")
    public void updateCourse(@RequestBody Course course, @PathVariable String id)
    {
        courseService.updateCourse(course, id);
    }*/


    /*@RequestMapping(method = RequestMethod.DELETE, value = "/courses/{id}")
    public void deleteCourse(@PathVariable String id)
    {
        courseService.deleteCourse(id);
    }*/

}
