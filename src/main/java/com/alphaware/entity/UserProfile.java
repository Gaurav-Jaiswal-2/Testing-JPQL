	package com.alphaware.entity;
	
	import com.fasterxml.jackson.annotation.JsonIgnore;
	
	import jakarta.persistence.Column;
	import jakarta.persistence.Entity;
	import jakarta.persistence.GeneratedValue;
	import jakarta.persistence.GenerationType;
	import jakarta.persistence.Id;
	import jakarta.persistence.JoinColumn;
	import jakarta.persistence.OneToOne;
	import jakarta.persistence.Table;
	import lombok.AllArgsConstructor;
	import lombok.Data;
	import lombok.NoArgsConstructor;
	
	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Entity
	@Table(name = "user_profiles")
	public class UserProfile {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
	
		@Column(length = 50, nullable = false)
		private String firstname;
	
		@Column(length = 50)
		private String middlename;
	
		@Column(length = 50, nullable = false)
		private String lastname;
		
		@JsonIgnore
		@OneToOne
		@JoinColumn(name = "user_id", nullable = false)
		private Users user;
	}
