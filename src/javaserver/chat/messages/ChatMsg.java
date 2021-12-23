package javaserver.chat.messages;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


/**
 * When a client tries to chat, they would be creating a Opens object.
 * 
*/
@XmlRootElement(name = "chatmsgs")
@XmlAccessorType(XmlAccessType.FIELD)
public class ChatMsg {
  @XmlElement(name = "msgs")
  private List<Messages> msgs=new ArrayList<Messages>() ;

  @XmlElement(name = "p2phash")
  private String p2phash ;

  /**
   * Sets the p2p hash
   * 
   * */
  public void set_senders(String a){
    this.p2phash = a;
  }

  public String get_senders(){
    return p2phash;
  }

  /**
   * Adde one new msg
   * */
  public void add_msg(String senders,String a, String b, String c){
    Messages nm = new Messages();
    nm.set_msg(senders,a,b,c);
    msgs.add(nm);
  }
}