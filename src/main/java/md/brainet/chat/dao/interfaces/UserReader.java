package md.brainet.chat.dao.interfaces;

import md.brainet.chat.entity.User;

public interface UserReader {
	User getUserById(int id);
	User getUserByUserNick(String nick);
}
