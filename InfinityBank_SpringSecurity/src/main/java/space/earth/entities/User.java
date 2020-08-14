package space.earth.entities;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;



@Entity
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId; 
	private String firstName; 
	private String LastName;
	private String username; 
	private String password; 
	private String email; 
	private String phone;
	
	 @ManyToMany
	    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@OneToOne
	private PrimaryAccount primaryAccount; 
	
	@OneToOne
	private SavingsAccount savingsAccount; 
	
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(String firstName, String lastName, String username, String password, String email, String phone) {
		super();
		this.firstName = firstName;
		LastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
		this.phone = phone;
	}
	
	





	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}


	public PrimaryAccount getPrimaryAccount() {
		return primaryAccount;
	}


	public void setPrimaryAccount(PrimaryAccount primaryAccount) {
		this.primaryAccount = primaryAccount;
	}


	public SavingsAccount getSavingsAccount() {
		return savingsAccount;
	}


	public void setSavingsAccount(SavingsAccount savingsAccount) {
		this.savingsAccount = savingsAccount;
	}

	
	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
	

}
