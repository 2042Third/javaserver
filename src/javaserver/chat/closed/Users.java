package javaserver.chat.closed;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "user")
@XmlAccessorType(XmlAccessType.FIELD)
public class Users {
  private String time; // server time
  private String p2phash; // peer to peer hash
  private String uhash; // user name hash (this is the server opener)

  public void setUsers (String tm, String uh, String ph){
    this.time = tm;
    this.uhash = uh;
    this.p2phash=ph;
  }
}
