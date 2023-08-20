package md.brainet.chat.dao.implementations;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import md.brainet.chat.dao.GeneralLifecycleDaoObject;
import md.brainet.chat.dao.interfaces.ChatManager;
import md.brainet.chat.entity.*;

@Component
@RequestScope
public class HibernateChatManagerImpl extends GeneralLifecycleDaoObject implements ChatManager{
	
	@Override
	public void addNewChat(Chat newChat) {
		getSession().persist(newChat);
	}

	@Override
	public void deleteChatById(int chatId) {
		getSession().createQuery("delete Chat where id = :chatId")
		.setParameter("chatId", chatId)
		.executeUpdate();
	}

	@Override
	public void editChat(Chat editedChat) {
		getSession().merge(editedChat);
	}

	@Override
	public Chat getChatById(int chatId) {
		return getSession().get(Chat.class, chatId);
	}
}
