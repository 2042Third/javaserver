package javaserver.chat.opens;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "openuser")
@XmlAccessorType(XmlAccessType.FIELD)
public class OpenUsers {
	private String time; // server time
	private String uhash; // user name hash

  public void setUsers (String tm, String uh){
    this.time = tm;
    this.uhash = uh;
  }

  /**
   * Checks if the user is the input user.
   * */
  public Boolean is_user(String uh){
    return uhash.equals(uh);
  }
}
