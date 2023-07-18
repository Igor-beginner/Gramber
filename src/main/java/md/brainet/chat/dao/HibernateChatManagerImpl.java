package md.brainet.chat.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import md.brainet.chat.rest.Chat;

@Component
@RequestScope
public class HibernateChatManagerImpl implements ChatManager{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	@PostConstruct
	public void inti() {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}
	
	@PreDestroy
	public void destroy() {
		session.getTransaction().commit();
		session.close();
	}
	
	@Override
	public void addNewChat(Chat newChat) {
		session.save(newChat);
	}

	@Override
	public void deleteChatById(int chatId) {
		session.createQuery("delete Chat where id = :chatId")
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
