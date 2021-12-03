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
  @XmlElement(name = "openuser")
  private List<OpenUsers> users = new ArrayList<OpenUsers>();

  public void add(OpenUsers a){
    users.add(a);
  }

  public Boolean remove_user(String uh){
    for (int i=0; i<users.size();i++){
      if(users.get(i).is_user(uh)){
        users.remove(i);
        return true;
      }
    }
    return false;
  }

  public OpenUsers new_user(String uh){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();
    OpenUsers a = new OpenUsers();
    a.setUsers(dtf.format(now),uh);
    return a;
  }
}