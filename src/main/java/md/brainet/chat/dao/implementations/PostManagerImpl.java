package md.brainet.chat.dao.implementations;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.RequestScope;

import jakarta.persistence.Query;
import md.brainet.chat.dao.GeneralLifecycleDaoObject;
import md.brainet.chat.dao.interfaces.PostReader;
import md.brainet.chat.dao.interfaces.PostWriter;
import md.brainet.chat.entity.ActivityType;
import md.brainet.chat.entity.Message;
import md.brainet.chat.entity.Post;
import md.brainet.chat.entity.User;

@Repository
@RequestScope
public class PostManagerImpl extends GeneralLifecycleDaoObject implements PostReader, PostWriter {

	@Override
	public void enrollPost(Post post) {
		getSession().persist(post);
	}

	@Override
	public void deletePostById(int id) {
		String hql = "DELETE FROM Post WHERE :id = id";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		query.executeUpdate();
	}

	@Override
	public void editPost(Post editedPost) {
		getSession().merge(editedPost);
	}
	
	public List<User> getActivityByEnumAndPostId(ActivityType activityType, int id){
		String hql = "SELECT DISTINCT a "
				+ "FROM Activity a "
				+ "WHERE :id = a.post.id"
				+ "AND a.activityType = 'SHARE'";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		query.setParameter("activity", activityType);
		return query.getResultList();
	}

	@Override
	public List<Message> getCommentsById(String id) {
		String hql = "SELECT c.message FROM Comment c WHERE :id = c.post.id";
		Query query = getSession().createQuery(hql);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
