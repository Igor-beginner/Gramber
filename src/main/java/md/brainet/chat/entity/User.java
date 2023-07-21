package md.brainet.chat.entity;

import java.util.List;

import org.hibernate.annotations.Where;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "surname")
	private String surname;
	
	@Column(name = "age")
	private int age;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "photo_link")
	private String photoLink;
	
	@Column(name = "bio")
	private String bio;
	
	@ManyToMany
	@JoinTable(name = "request_on_friend",
			joinColumns = @JoinColumn(name = "from_id"),
			inverseJoinColumns = @JoinColumn(name = "to_id"))
	@Where(clause = "is_accept = true")
	private List<User> friendsList;
	
	@OneToMany(mappedBy = "sender")
	private List<RequestOnFriend> incomingFriendRequests;
	
	@OneToMany(mappedBy = "receiver")
	private List<RequestOnFriend> outcomingFriendRequests;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhotoLink() {
		return photoLink;
	}

	public void setPhotoLink(String photoLink) {
		this.photoLink = photoLink;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public List<User> getFriendsList() {
		return friendsList;
	}

	public void setFriendsList(List<User> friendsList) {
		this.friendsList = friendsList;
	}

	public List<RequestOnFriend> getIncomingFriendRequests() {
		return incomingFriendRequests;
	}

	public void setIncomingFriendRequests(List<RequestOnFriend> incomingFriendRequests) {
		this.incomingFriendRequests = incomingFriendRequests;
	}

	public List<RequestOnFriend> getOutcomingFriendRequests() {
		return outcomingFriendRequests;
	}

	public void setOutcomingFriendRequests(List<RequestOnFriend> outcomingFriendRequests) {
		this.outcomingFriendRequests = outcomingFriendRequests;
	}
}
