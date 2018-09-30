package springboot.samplepackage.courses;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import springboot.samplepackage.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService courseService ;
	
	@RequestMapping("topic/{id}/course")
	public List<Course> getAllCourse(@PathVariable int id) {
		return courseService.getAll(id);
//		JSONObject json = new JSONObject();
//		try {
//			json.put("Key", "value");
//			return json;
//		}catch(Exception e) {
//			
//		}
//		return json;
	}
	
	@RequestMapping("topic/{id}/course/{courseId}")
	public Course getCourse(@PathVariable("id") int id,@PathVariable("courseId") int courseId) {
		return courseService.getCourse(id,courseId);
 	}
	
	@RequestMapping(value="topic/{id}/course", method=RequestMethod.POST)
	public String addCourse(@RequestBody Course course, @PathVariable int id) {
		course.setTopic(new Topic(id,"",""));
		courseService.addCourse(course);
		return "done";
	}
	
	@RequestMapping(value="topic/{id}/course/{courseId}", method=RequestMethod.PUT) 
	public void updateId(@PathVariable int id, @RequestBody Course course, @PathVariable int courseId) {
		courseService.update(courseId,course);
	}
	
	@RequestMapping(value="topic/{id}/course/{courseId}", method=RequestMethod.DELETE)
	public void delete(@PathVariable int id, @PathVariable int courseId) {
		courseService.deleteCourse(courseId);
	}
}
