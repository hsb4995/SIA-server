package springboot.samplepackage.topic;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;

public class Checkin {
		
		private String id;
		List<DataVal> data = new ArrayList<>();
		
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public List<DataVal> getData() {
			return data;
		}
		public void setData(List<DataVal> data) {
			this.data = data;
		}
		
}
