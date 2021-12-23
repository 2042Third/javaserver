package javaserver.chat.opens;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "openuser")
@XmlAccessorType(XmlAccessType.FIELD)
public class OpenUsers {
	private String time; // server time
  private String uhash; // user name hash
	private String sock_id; // user socket id

  public void setUsers (String tm, String uh, String sid){
    this.time = tm;
    this.uhash = uh;
    this.sock_id = sid;
  }

  /**
   * Checks if the user is the input user.
   * */
  public Boolean is_user(String uh){
    return uhash.equals(uh);
  }
}
