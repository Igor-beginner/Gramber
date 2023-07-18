package md.brainet.chat.dao;

import md.brainet.chat.rest.Chat;

public interface ChatManager {
	void addNewChat(Chat newChat);
	void deleteChatById(int chatId);
	void editChat(Chat editedChat);
	Chat getChatById(int chatId);
}
