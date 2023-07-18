package md.brainet.chat.dao;

import md.brainet.chat.entity.ChatMember;
import md.brainet.chat.entity.Role;

public interface MemberContainer {
	void addById(int chatId, int userId);
	void deleteById(int chatId, int userId);
	void editRoleById(int chatId, int userId, Role role);
}
