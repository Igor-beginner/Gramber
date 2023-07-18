package md.brainet.chat.entity;

import java.util.List;

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
@Table(name = "chat")
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "owner_id")
	private User owner;
	
	@Column(name = "photo_link")
	private String photoLink;
	
	@OneToMany
	@JoinColumn(name = "message_id")
	private List<Message> messages;
	
	//TODO many to many
	private List<ChatMember> chatMembers;
}
