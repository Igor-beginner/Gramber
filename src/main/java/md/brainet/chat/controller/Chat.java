package md.brainet.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/messages")
public class Chat {

	@GetMapping
	public String getPage() {
		return "messages";
	}
}
