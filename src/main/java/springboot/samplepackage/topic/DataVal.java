package springboot.samplepackage.topic;

public class DataVal {
	private String created_time;
	private String name;
	private String city;
	
public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	//	public DataVal(String created_time, String name) {
//		super();
//		this.created_time = created_time;
//		this.name = name;
//	}
	public String getCreated_time() {
		return created_time;
	}
	public void setCreated_time(String created_time) {
		this.created_time = created_time;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
