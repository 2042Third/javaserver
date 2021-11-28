package javaserver.chat;

import javaserver.chat.Chat;
import javaserver.chat.opens.Opens;
import java.io.File;
import java.util.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class ChatMarshaller {

  public static void test() throws JAXBException { 
    System.out.println("///////////// MARSHAL TEST/////////////////");

    Chat a= new Chat();
    a.new_open("users_hash1");
    a.new_open("users_hash2");
    a.new_open("users_hash3");
    
    JAXBContext jaxbContext = JAXBContext.newInstance(Chat.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    // Marshal the employees list in console
    jaxbMarshaller.marshal(a, System.out);
    System.out.println("///////////// MARSHAL TEST END /////////////////");

    // Marshal the employees list in file
    // jaxbMarshaller.marshal(a, new File("./users.xml"));
    

  }


  public static void create_marshell(Chat a)throws JAXBException{

    JAXBContext jaxbContext = JAXBContext.newInstance(Chat.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    // Marshal the employees list in console
    jaxbMarshaller.marshal(a, System.out);

    // Marshal the employees list in file
    jaxbMarshaller.marshal(a, new File("./users.xml"));
  }

}