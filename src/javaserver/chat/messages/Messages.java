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
  @XmlElement(name = "receiver")
  private String receiver ;



  /**
   * Sets the peer to peer hash and message of the chat.
   * */
  public void set_msg(String senders, String a, String b, String c){
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
    LocalDateTime now = LocalDateTime.now();
    this.time = dtf.format(now);
    this.mhash = a;
    this.msg = b;
    this.receiver = c;
    this.sender = senders;
  }
}