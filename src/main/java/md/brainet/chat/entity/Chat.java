package md.brainet.chat.entity;

import java.util.List;

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
import jakarta.persistence.Table;

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
	@JoinColumn(name = "chat_id")
	private List<Message> messages;
	
	@ManyToMany
	@JoinTable(name = "chat_members",
			joinColumns = @JoinColumn(name = "chat_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private List<ChatMember> chatMembers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}

	public List<ChatMember> getChatMembers() {
		return chatMembers;
	}

	public void setChatMembers(List<ChatMember> chatMembers) {
		this.chatMembers = chatMembers;
	}
}
