package springlogin.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "App_User")
public class account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int user_id;
	@Column(name = "user_Name", length = 36)
	private String User_Name;
	@Column(name = "encryted_Password", length = 128)
	private String encryted_Password;
	@Column(name = "enabled", length = 1)
	private Boolean enabled;
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getUser_Name() {
		return User_Name;
	}
	public void setUser_Name(String user_Name) {
		User_Name = user_Name;
	}
	public String getEncryted_Password() {
		return encryted_Password;
	}
	public void setEncryted_Password(String encryted_Password) {
		this.encryted_Password = encryted_Password;
	}
	public Boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


}
