package md.brainet.chat.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import md.brainet.chat.dao.ChatManager;
import md.brainet.chat.dao.MemberContainer;
import md.brainet.chat.entity.ChatMember;
import md.brainet.chat.entity.Role;

@RestController
@RequestMapping("/chat")
public class Chat {
	
	@Autowired
	private ChatManager chat;
	
	@Autowired
	private MemberContainer container;
	
	@PutMapping
	public void create(@RequestBody Chat chat) {
		this.chat.addNewChat(chat);
	}
	
	@PatchMapping
	public void edit(@RequestBody Chat chat) {
		this.chat.editChat(chat);
	}
	
	@GetMapping("/{chatId}")
	public Chat get(@PathVariable("chatId") int id) {
		return chat.getChatById(id);
	}
	
	@DeleteMapping("/{chatId}")
	public void delete(@PathVariable("chatId") int id) {
		chat.deleteChatById(id);
	}
	
	@PutMapping("/{chatId}")
	public void addMemberById(@PathVariable("chatId") int chatId,
			@RequestParam("user_id") int userId) {
		container.addById(chatId, userId);
	}
	
	@DeleteMapping("/{chatId}")
	public void deleteMemberById(@PathVariable("chatId") int chatId,
			@RequestParam("user_id") int userId) {
		container.deleteById(chatId, userId);
	}
	
	@PatchMapping("/{chatId}")
	public void editRoleForMember(@PathVariable("chatId") int chatId,
			@RequestParam("user_id") int userId,
			@RequestParam("role") Role role) {
		container.editRoleById(chatId, userId, role);
	}
}
