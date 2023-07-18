package md.brainet.chat.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import md.brainet.chat.rest.Chat;

@Component
public class HibernateChatManagerImpl implements ChatManager{
	
	@Autowired
	private Session session;
	
	@Override
	public void addNewChat(Chat newChat) {
		session.save(newChat);
	}

	@Override
	public void deleteChatById(int chatId) {
		session.createQuery("delete chat where id = :chatId")
		.setParameter("chatId", chatId)
		.executeUpdate();
	}

	@Override
	public void editChat(Chat editedChat) {
		session.update(editedChat);
	}

	@Override
	public Chat getChatById(int chatId) {
		return session.get(Chat.class, chatId);
	}
}
