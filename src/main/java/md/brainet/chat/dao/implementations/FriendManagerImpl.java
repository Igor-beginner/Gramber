package md.brainet.chat.dao.implementations;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.persistence.Query;
import md.brainet.chat.dao.GeneralLifecycleDaoObject;
import md.brainet.chat.dao.interfaces.FriendManager;
import md.brainet.chat.dao.interfaces.FriendReader;
import md.brainet.chat.entity.RequestOnFriend;
import md.brainet.chat.entity.User;

@Repository
@RequestScope
public class FriendManagerImpl extends GeneralLifecycleDaoObject implements FriendManager, FriendReader{
	
	@Override
	public void sendRequest(int fromId, int toId) {
		User sender = getSession().get(User.class, fromId);
		User receiver = getSession().get(User.class, toId);
		
		RequestOnFriend requestOnFriend = new RequestOnFriend();
		requestOnFriend.setSender(sender);
		requestOnFriend.setReceiver(receiver);
		getSession().persist(requestOnFriend);
	}

	@Override
	public void removeFriend(int dealerId,int friendId) {
		String hql = "FROM RequestOnFriend "
				+ "WHERE (sender.id = :dealer "
				+ "AND receiver.id = :friend) "
				+ "OR (sender.id = :friend "
				+ "AND receiver.id = :dealer)";
		Query query = getSession().createQuery(hql);
		query.setParameter("friend", friendId);
		query.setParameter("dealer", dealerId);
		getSession().remove(query.getSingleResult());
	}

	@Override
	public List<User> getFriendsFrom(int id) {
		String hql = "SELECT DISTINCT u "
				+ "FROM User u "
				+ "JOIN RequestOnFriend rof "
				+ "    ON (u.id = rof.sender.id AND rof.receiver.id = :userId) "
				+ "    OR (u.id = rof.receiver.id AND rof.sender.id = :userId) "
				+ "WHERE rof.isAccept = true "
				+ "";
		Query query = getSession().createQuery(hql);
		query.setParameter("userId", id);
		return query.getResultList();
	}

	@Override
	public List<RequestOnFriend> getIncomingRequestsFrom(User src) {
		String hql = "FROM RequestOnFriend WHERE receiver = :user "
				+ "AND isAccept = false";
		Query query = getSession().createQuery(hql);
		query.setParameter("user", src);
		return query.getResultList();
	}

	@Override
	public List<User> getOutcomingRequestsFrom(User src) {
		String hql = "FROM RequestOnFriend WHERE sender = :user "
				+ "AND isAccept = false";
		Query query = getSession().createQuery(hql);
		query.setParameter("user", src);
		return query.getResultList();
	}
}
