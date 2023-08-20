package md.brainet.chat.dao.interfaces;

import md.brainet.chat.entity.*;

public interface ChatManager {
	void addNewChat(Chat newChat);
	void deleteChatById(int chatId);
	void editChat(Chat editedChat);
	Chat getChatById(int chatId);
}
