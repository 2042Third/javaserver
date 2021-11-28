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
  
  public void new_open(String uh){
    opens.add(opens.new_user(uh));
  }

  @XmlElement(name = "closed")
  private Closed close = new Closed();
  
  public void new_close(String uh,String ph){
    close.add(close.new_user(uh,ph));
  }


  @XmlElement(name = "allmsgs")
  private AllMsg all_msg= new AllMsg();
  

  public void new_msg(String senders, String a, String b, String c){
    all_msg.set_msg(senders,a,b,c);
  }

}

