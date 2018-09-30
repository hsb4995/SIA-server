package springboot.samplepackage.topic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
	
	@Autowired SaveCheckinRepository saveCheckinRepository;
	
//	private List<Topic> topics =  new ArrayList<>(Arrays.asList(
//			new Topic(1,"Math","It\'s Maths"),
//			new Topic(2,"Science","science finally")));
//	
	public void addCheckin(Checkin checkin) {
		String userId = checkin.getId();
		List<DataVal> data = checkin.getData();
		int size = data.size();
		for(int i=0;i<size;++i) {
			System.out.println("Values ------>"+data.get(i).getName());
			SaveCheckin savedata = new SaveCheckin();
			savedata.setCreated_time(data.get(i).getCreated_time());
			savedata.setName(data.get(i).getName());
			savedata.setCity(data.get(i).getCity());
			savedata.setUser_id(userId);
			saveCheckinRepository.save(savedata);
		}
		
	}
	
	public List<Topic> getAll(){
//		return this.topics;
		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll().forEach(topics::add);
		return topics;
	}
	
	public Topic getTopic(int id) {
//		return topics.stream().filter(t->t.getId() == id).findFirst().get();
		return topicRepository.findById(id).get();
	}
	
	public void addTopic(Topic topic) {
		//this.topics.add(topic);
		topicRepository.save(topic);
	}
	
	public void update(int id, Topic topic) {
		topicRepository.save(topic);
//		for(int i=0;i<topics.size();++i) {
//			Topic t= topics.get(i);
//			if(t.getId() == id) {
//				topics.set(i, topic);
//			}
//		}
	}
	
	public void deleteTopic(int id) {
//		topics.removeIf(t->t.getId() == id);
		topicRepository.deleteById(id);
	}
}
