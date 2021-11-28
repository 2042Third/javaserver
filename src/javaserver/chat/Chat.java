package javaserver.chat;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import javaserver.chat.opens.*;

@XmlRootElement(name = "chat")
@XmlAccessorType(XmlAccessType.FIELD)
public class Chat {
  @XmlElement(name = "opens")
  private Opens opens = new Opens();
  
  public void new_open(String uh){
    opens.add(opens.new_user(uh));
  }
}

