package javaserver.chat.closed;


import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "closeuser")
@XmlAccessorType(XmlAccessType.FIELD)
public class CloseUsers {
  private String time; // server time
  private String p2phash; // peer to peer hash
  private String uhash; // user name hash (this is the server opener)
  private String sock_id; // user socket id

  public Boolean  is_user(String uh){
    return uhash.equals(uh);
  }
  public Boolean  is_p2p(String p2ph){
    return p2phash.equals(p2ph);
  }

  public void setUsers (String tm, String uh, String ph,String sid){
    this.time = tm;
    this.uhash = uh;
    this.p2phash=ph;
    this.sock_id=sid;
  }
}
