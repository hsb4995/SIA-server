package springboot.samplepackage.courses;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CourseRepository extends CrudRepository<Course, Integer> {
		//Methods from crud
		List<Course> findByTopicId(int topicId);
	
}
