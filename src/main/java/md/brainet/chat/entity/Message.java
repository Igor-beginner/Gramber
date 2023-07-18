package md.brainet.chat.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
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
@Table(name = "message")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@OneToMany
	@JoinColumn(name = "resource_id")
	private Resource resource;
	
	@Column(name = "text")
	private String text;
	
	@Column(columnDefinition = "TIMESTAMP", name = "sent_date")
	private LocalDate sentDate;
	
	@ManyToOne
	@JoinColumn(name =  "owner_id")
	private User owner;
}
