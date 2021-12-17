package javaserver.chat;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javaserver.chat.opens.*;
import javaserver.chat.closed.*;
import javaserver.chat.messages.*;


/**
 * Handles all chats and registration.
 * 
 * */
@XmlRootElement(name = "chat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chat {
  @XmlElement(name = "opens")
  private Opens opens = new Opens();
  
  public void new_open(String uh, String sid){
    opens.add(opens.new_user(uh, sid));
  }

  @XmlElement(name = "closed")
  private Closed close = new Closed();
  
  public void new_close(String uh,String ph, String sid){
    close.add(close.new_user(uh,ph,sid));
  }


  @XmlElement(name = "allmsgs")
  private AllMsg all_msg= new AllMsg();
  
  /**
   * Removes the user from the list of open users.
   * */
  public Boolean remove_open_user(String uh){
    return opens.remove_user(uh);
  }
  /**
   * Removes the user from the list of closed users.
   * */
  public Boolean remove_closed_user(String uh){
    return close.remove_user(uh);
  }


  public void new_msg(String senders, String msghash, String msg, String msgsender){
    all_msg.set_msg(senders,msghash,msg,msgsender);
  }

}

