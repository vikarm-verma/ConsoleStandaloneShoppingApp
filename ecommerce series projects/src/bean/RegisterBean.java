package bean;

import java.io.Serializable;

public class RegisterBean  implements Comparable<RegisterBean> ,Serializable {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private int regId;
private String email;
private String password;
/**
 * @param regId
 * @param email
 * @param password
 */
public RegisterBean(int regId, String email, String password) {
	super();
	this.regId = regId;
	this.email = email;
	this.password = password;
}
/**
 * @return the regId
 */
public int getRegId() {
	return regId;
}
/**
 * @param regId the regId to set
 */
public void setRegId(int regId) {
	this.regId = regId;
}
/**
 * @return the email
 */
public String getEmail() {
	return email;
}
/**
 * @param email the email to set
 */
public void setEmail(String email) {
	this.email = email;
}
/**
 * @return the password
 */
public String getPassword() {
	return password;
}
/**
 * @param password the password to set
 */
public void setPassword(String password) {
	this.password = password;
}
@Override
public String toString() {
	return "RegisterBean [regId=" + regId + ", email=" + email + ", password=" + password + "]";
}
@Override
public int compareTo(RegisterBean rb) {
	// TODO Auto-generated method stub
	if(this.regId>rb.regId)
		return 1;
	else if(this.regId<rb.regId)
		return -1;
	else 
		return 0;
}

}
