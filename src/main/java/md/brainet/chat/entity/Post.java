package md.brainet.chat.entity;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Where;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "topic")
	private String topic;
	
	@Column(name = "description")
	private String description;
	
	@OneToMany
	@JoinColumn(name = "resource_id")
	private Resource resource;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "message_id")
	private Message message;
	
	@ManyToMany
	@JoinTable(name = "activity",
			joinColumns = @JoinColumn(name = "post_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	@Where(clause = "activity_type = 'LIKE'")
	private Set<User> userLikes;
	
	@ManyToMany
	@JoinTable(name = "activity",
			joinColumns = @JoinColumn(name = "post_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	@Where(clause = "activity_type = 'SHARE'")
	private Set<User> userShared;
	
	@OneToMany
	@JoinColumn(name = "post_id")
	private List<Message> commentsList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Resource getResource() {
		return resource;
	}

	public void setResource(Resource resource) {
		this.resource = resource;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Message getMessage() {
		return message;
	}

	public void setMessage(Message message) {
		this.message = message;
	}

	public Set<User> getUserLikes() {
		return userLikes;
	}

	public void setUserLikes(Set<User> userLikes) {
		this.userLikes = userLikes;
	}

	public Set<User> getUserShared() {
		return userShared;
	}

	public void setUserShared(Set<User> userShared) {
		this.userShared = userShared;
	}

	public List<Message> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<Message> commentsList) {
		this.commentsList = commentsList;
	}
}
