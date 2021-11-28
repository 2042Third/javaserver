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
  public CloseUsers new_user(String uh, String ph){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();
    CloseUsers a = new CloseUsers();
    a.setUsers(dtf.format(now),uh,ph);
    return a;
  }

}


