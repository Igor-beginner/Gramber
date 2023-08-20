package md.brainet.chat.dao.implementations;

import org.springframework.stereotype.Repository;

import jakarta.persistence.Query;
import md.brainet.chat.dao.GeneralLifecycleDaoObject;
import md.brainet.chat.dao.interfaces.UserReader;
import md.brainet.chat.entity.User;

@Repository
public class UserReaderImpl extends GeneralLifecycleDaoObject implements UserReader{

	@Override
	public User getUserById(int id) {
		return getSession().get(User.class, id);
	}

	@Override
	public User getUserByUserNick(String nick) {
		Query query = getSession()
				.createQuery("FROM User WHERE :nick = nick");
		query.setParameter("nick", nick);
		return (User)query.getSingleResult();
	}
	
}
