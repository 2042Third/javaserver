package javaserver.chat.messages;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;


/**
 * Tracks one massage.
 * 
*/
@XmlRootElement(name = "chatmsg")
@XmlAccessorType(XmlAccessType.FIELD)
public class Messages {
  @XmlElement(name = "mhash")
  private String mhash ;
  @XmlElement(name = "msg")
  private String msg ;
  @XmlElement(name = "time")
  private String time ;
  @XmlElement(name = "sender")
  private String sender ;



  /**
   * Sets the peer to peer hash and message of the chat.
   * */
  public void set_msg(String a, String b, String c){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();
    this.time = dtf.format(now);
    this.mhash = a;
    this.msg = b;
    this.sender = c;
  }
}