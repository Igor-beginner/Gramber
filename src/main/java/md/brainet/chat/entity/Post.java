package md.brainet.chat.entity;

import java.util.List;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Data
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
	
	//TODO realtion...
	private Set<User> userLikes;
	
	//TODO reltion...
	private Set<User> userShared;
	
	//TODO relation...
	private List<Message> commentsList;
	
}