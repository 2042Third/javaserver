package javaserver.chat.messages;
import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;

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
@XmlRootElement(name = "allmsgs")
@XmlAccessorType(XmlAccessType.FIELD)
public class AllMsg {
  @XmlElement(name = "p2p")
  private List<ChatMsg> p2p_msgs = new ArrayList<ChatMsg>();

  private HashSet<String> senders_set = new HashSet<String>();



  /**
   * Sets the peer to peer hash and message of the chat.
   * */
  public void set_msg(String senders, String a, String b, String c){

    if(senders_set.contains(senders)){
      new_msg(senders,a,b,c);
    }
    else {
      senders_set.add(senders);
      ChatMsg nmsg = new ChatMsg();
      nmsg.set_senders(senders);
      p2p_msgs.add(nmsg);
      new_msg(senders,a,b,c);
    }
  }


  public void new_msg(String senders,String a, String b, String c){
    for(int i=0; i<p2p_msgs.size();i++){
      if(p2p_msgs.get(i).get_senders().equals(senders)){
        p2p_msgs.get(i).add_msg(senders, a,b,c);
        return;
      }
    }
  }

}