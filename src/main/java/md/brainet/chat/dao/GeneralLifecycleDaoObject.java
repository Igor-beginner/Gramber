package md.brainet.chat.dao;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public abstract class GeneralLifecycleDaoObject {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private Session session;
	
	@PostConstruct
	public void init() {
		session = sessionFactory.openSession();
		session.beginTransaction();
	}
	
	@PreDestroy
	public void destroy() {
		session.getTransaction().commit();
		session.close();
	}

	public Session getSession() {
		return session;
	}
}
