package md.brainet.chat.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "chat")
public class Chat {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	// TODO One to Many
	private User owner;
	
	@Column(name = "photo_link")
	private String photoLink;
	
	//TODO one to many
	private List<Message> messages;
	
	//TODO many to many
	private List<ChatMember> chatMembers;
}
