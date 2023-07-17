package md.brainet.chat.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "message")
public class Message {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	//TODO One to many
	private Resource resource;
	
	@Column(name = "text")
	private String text;
	
	//TODO annotation for date
	private LocalDate sentDate;
	
	//TODO many to one
	private User owner;
}
