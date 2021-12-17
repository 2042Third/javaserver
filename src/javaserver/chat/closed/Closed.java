package javaserver.chat.closed;
import java.util.List;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


/**
 * After a client has join a opened client, they would be removed
 * from opens, and create a closed field.
 * No more clients can join.
 * 
*/
@XmlRootElement(name = "closed")
@XmlAccessorType(XmlAccessType.FIELD)
public class Closed {
  @XmlElement(name = "closeuser")
  private List<CloseUsers> users = new ArrayList<CloseUsers>();



  /**
   * Removes the starter user, if not found tries to remove one from p2p
   * list if match.
   * */
  public Boolean remove_user(String uh){
    for (int i=0; i<users.size();i++){
      if(users.get(i).is_user(uh)){
        users.remove(i);
        return true;
      }
    }
    return remove_p2p(uh);
  } 

  public Boolean remove_p2p(String p2p){
    for (int i=0; i<users.size();i++){
      if(users.get(i).is_p2p(p2p)){
        users.remove(i);
        return true;
      }
    }
    return false;
  } 

  /**
   * Adds new users.
   * */
  public void add(CloseUsers a){
    users.add(a);
  }
  /**
   * @param uh user hash
   * @param ph p2p hash
   * 
   * */
  public CloseUsers new_user(String uh, String ph, String sid){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();
    CloseUsers a = new CloseUsers();
    a.setUsers(dtf.format(now),uh,ph, sid);
    return a;
  }

}


