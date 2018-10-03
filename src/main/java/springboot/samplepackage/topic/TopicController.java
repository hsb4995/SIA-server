package springboot.samplepackage.topic;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService ;
	
	
	@GetMapping("/topic")
	public String getTopic() throws Exception {
		System.out.println("topic called");
		String fileName = "/home/ubuntu/abc.txt";
		File file = new File(fileName);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String line;
		String value="";
		while((line = br.readLine()) != null){
		    //process the line
		    System.out.println(line);
		    value+=line+",";
		}
		return value;
		//return topicService.getTopic(id);
 	}
	
	@Async
	@RequestMapping(value="/saveCheckin", method=RequestMethod.POST, produces="application/json")
	public String addCheckin(@RequestBody Checkin checkin) {
		System.out.println("got"+checkin.getId());
		//topicService.addTopic(topic);
		topicService.addCheckin(checkin);
//		Process process = Runtime.getRuntime().exec(command)
		//Resp resp=new Resp();
		//resp.setStatus("OK");
		return "{\"status\":\"OK\"}";
	}
	
	@RequestMapping(value = "/Image/1", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage() throws IOException {
		BufferedImage bImage = ImageIO.read(new File("/home/ubuntu/count.jpg"));
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      ImageIO.write(bImage, "jpg", bos );
	      byte [] image = bos.toByteArray();
	    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}
	
	@RequestMapping(value = "/Image/2", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage2() throws IOException {
		BufferedImage bImage = ImageIO.read(new File("/home/ubuntu/density.jpg"));
	      ByteArrayOutputStream bos = new ByteArrayOutputStream();
	      ImageIO.write(bImage, "jpg", bos );
	      byte [] image = bos.toByteArray();
	    return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);
	}
	
	
	
}
