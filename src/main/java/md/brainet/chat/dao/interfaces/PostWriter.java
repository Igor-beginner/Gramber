package md.brainet.chat.dao.interfaces;

import md.brainet.chat.entity.Post;

public interface PostWriter {
	void enrollPost(Post post);
	void deletePostById(int id);
	void editPost(Post editedPost);
}
