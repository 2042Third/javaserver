package javaserver.chat.opens;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


/**
 * When a client tries to chat, they would be creating a Opens object.
 * 
*/
@XmlRootElement(name = "opens")
@XmlAccessorType(XmlAccessType.FIELD)
public class Opens {
  @XmlElement(name = "user")
  private List<Users> users = new ArrayList<Users>();

  public void add(Users a){
    users.add(a);
  }

  public Users new_user(String uh){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();
    Users a = new Users();
    a.setUsers(dtf.format(now),uh);
    return a;
  }
}