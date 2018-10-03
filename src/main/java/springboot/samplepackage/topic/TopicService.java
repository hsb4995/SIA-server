package springboot.samplepackage.topic;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	Process process;

	@Autowired SaveCheckinRepository saveCheckinRepository;
	
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
	
}
