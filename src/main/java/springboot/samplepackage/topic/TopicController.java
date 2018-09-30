package springboot.samplepackage.topic;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService ;
	
	@RequestMapping("/topic")
	public List<Topic> getAllTopic() {
		return topicService.getAll();
//		JSONObject json = new JSONObject();
//		try {
//			json.put("Key", "value");
//			return json;
//		}catch(Exception e) {
//			
//		}
//		return json;
	}
	
	@RequestMapping("/topic/{id}")
	public Topic getTopic(@PathVariable("id") int id) {
		return topicService.getTopic(id);
 	}
							
	@RequestMapping(value="/topic", method=RequestMethod.POST)
	public String addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
		return "done";
	}
	@RequestMapping(value="/saveCheckin", method=RequestMethod.POST)
	public String addCheckin(@RequestBody Checkin checkin) {
		System.out.println("got"+checkin.getId());
		//topicService.addTopic(topic);
		topicService.addCheckin(checkin);
//		Process process = Runtime.getRuntime().exec(command)
		return "done";
	}
	
	@RequestMapping(value="topic/{id}", method=RequestMethod.PUT) 
	public void updateId(@PathVariable int id, @RequestBody Topic topic) {
		topicService.update(id,topic);
	}
	
	@RequestMapping(value="topic/{id}", method=RequestMethod.DELETE)
	public void delete(@PathVariable int id) {
		topicService.deleteTopic(id);
	}
}
