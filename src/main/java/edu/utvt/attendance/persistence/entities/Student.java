package edu.utvt.attendance.persistence.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import edu.utvt.attendance.persistence.common.StudentType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name= "tc_students")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Student {
	
	@Id
	@Column(length = 12)
	private String id;
	
	@Column(length = 50, nullable = false)
	private String firstname;
	@Column(length = 100, nullable = false)
	private String lastname;
	@Column(length = 50, nullable = false)
	private String email;
	
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private StudentType type;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date birthDate;
	
	@JsonFormat(pattern = "dd/MM/yyy  HH:mm:ss")
	@Column(nullable = false, updatable = false, columnDefinition = "TIMESTAMP")
	@CreationTimestamp
	private Date createOn;
	

}
