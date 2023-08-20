package md.brainet.chat.dao.interfaces;

import md.brainet.chat.entity.User;

public interface FriendManager {
	void sendRequest(int idFrom, int idDest);
	void removeFriend(int dealerId, int friendId);
}
