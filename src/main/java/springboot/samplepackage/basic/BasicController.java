package springboot.samplepackage.basic;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {
		
		@RequestMapping("/*")
		public String basic() {
			return "What You Lookin for ?";
		}
		
}
