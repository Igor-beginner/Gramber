package md.brainet.chat.dao.interfaces;

import java.util.List;

import md.brainet.chat.entity.RequestOnFriend;
import md.brainet.chat.entity.User;

public interface FriendReader {
	List<User> getFriendsFrom(int id);
	List<RequestOnFriend> getIncomingRequestsFrom(User src);
	List<User> getOutcomingRequestsFrom(User src);
}

