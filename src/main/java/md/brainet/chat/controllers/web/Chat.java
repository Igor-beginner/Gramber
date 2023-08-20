package md.brainet.chat.controllers.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class Chat {
	public String getChat() {
		return "messages";
	}
}
