package md.brainet.chat.dao.interfaces;

import java.util.List;

import md.brainet.chat.entity.ActivityType;
import md.brainet.chat.entity.Message;
import md.brainet.chat.entity.Post;
import md.brainet.chat.entity.User;

public interface PostReader {
	List<User> getActivityByEnumAndPostId(ActivityType activityType, int postId);
	List<Message> getCommentsById(String id);
}
