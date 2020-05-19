package com.bookstore.entity;

import javax.persistence.*;

 
@Entity 							// defines class can be mapped to a table in DB
									//@Table(name="Users_1") This is optional and only used when name of table in DB is different than class name

@NamedQueries(
		{
			@NamedQuery(name="Users.findAll",query="SELECT u FROM Users u ORDER BY u.fullName"),
			@NamedQuery(name="Users.findByEmail",query="SELECT u FROM Users u WHERE u.email = :email"),
			@NamedQuery(name="Users.countAll",query="SELECT count(*) FROM Users u")
		}
		)
public class Users {
	
	public Users() {
		super();
		
	}
	private Integer userId;
	private String email;
	private String fullName;
	private String password;

	
	
	public Users(String email, String fullName, String password) {
		super();
		this.email = email;
		this.fullName = fullName;
		this.password = password;
	}

	//Use @Column to specify column name if it is different in DB
	
	@Column(name="user_id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="full_name")
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
