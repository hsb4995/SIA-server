package springboot.samplepackage.courses;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
//	private List<Topic> topics =  new ArrayList<>(Arrays.asList(
//			new Topic(1,"Math","It\'s Maths"),
//			new Topic(2,"Science","science finally")));
//	
	public List<Course> getAll(int id){
//		return this.topics;
		List<Course> courses = new ArrayList<>();
		courseRepository.findByTopicId(id).forEach(courses::add);
		return courses;
	}
	
	public Course getCourse(int id, int courseId) {
//		return topics.stream().filter(t->t.getId() == id).findFirst().get();
		return courseRepository.findById(courseId).get();
	}
	
	public void addCourse(Course course) {
		//this.topics.add(topic);
		courseRepository.save(course);
	}
	
	public void update(int id, Course course) {
		courseRepository.save(course);
//		for(int i=0;i<topics.size();++i) {
//			Topic t= topics.get(i);
//			if(t.getId() == id) {
//				topics.set(i, topic);
//			}
//		}
	}
	
	public void deleteCourse(int id) {
//		topics.removeIf(t->t.getId() == id);
		courseRepository.deleteById(id);
	}
}
