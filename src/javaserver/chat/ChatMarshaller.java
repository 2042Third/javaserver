package javaserver.chat;

import javaserver.chat.Chat;
import javaserver.chat.opens.Opens;
import java.io.File;
import java.io.StringReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;


public class ChatMarshaller {

  public static void test() throws JAXBException { 
    System.out.println("///////////// MARSHAL TEST (before remove)/////////////////");

    Chat a= new Chat();
    a.new_open("users_hash1");
    a.new_open("users_hash2");
    a.new_open("users_hash3");
    a.new_close("users_hash1","p2pusers_hash1");
    a.new_close("users_hash2","p2pusers_hash2");
    a.new_close("users_hash3","p2pusers_hash3");
    
    JAXBContext jaxbContext = JAXBContext.newInstance(Chat.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
    if(a.remove_open_user("users_hash3")){
      System.out.println("Removal from opens success!");
    }
    else {
      System.out.println("Removal from opens failed!");
    }
    if(a.remove_closed_user("p2pusers_hash3")){
      System.out.println("Removal from closed success!");
    }
    else {
      System.out.println("Removal from closed failed!");
    }


    // Marshal the employees list in console
    jaxbMarshaller.marshal(a, System.out);
    System.out.println("///////////// MARSHAL TEST END /////////////////");
    


  }


  public static void reader_test() throws JAXBException,FileNotFoundException { 
    Chat a= new Chat();
    String locat_file = "C:\\Users\\18604\\Desktop\\net\\test_bed\\chat\\target\\user.xml";
    a.new_open("users_hash1");
    a.new_open("users_hash2");
    a.new_open("users_hash3");
    a.new_close("users_hash1","p2pusers_hash1");
    a.new_close("users_hash2","p2pusers_hash2");
    a.new_close("users_hash3","p2pusers_hash3");
    create_marshall(a,locat_file );
    System.out.println("///////////// FIRST MARSHAL /////////////////");
    print_marshall(a);
    Chat b = get_chat_from_file(locat_file);
    System.out.println("///////////// SECOND MARSHAL /////////////////");
    print_marshall(b);

  }

  public static Chat get_chat_from_file(String xml)throws JAXBException, FileNotFoundException{
    FileInputStream fileInputStream = new FileInputStream(xml);
    JAXBContext context = JAXBContext.newInstance(Chat.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    // StringReader reader = new StringReader(xml);
    return (Chat) unmarshaller.unmarshal(fileInputStream);
  }

  public static void print_marshall(Chat a)throws JAXBException{

    JAXBContext jaxbContext = JAXBContext.newInstance(Chat.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    // Marshal the employees list in console
    jaxbMarshaller.marshal(a, System.out);

    // Marshal the employees list in file
    // jaxbMarshaller.marshal(a, new File("./users.xml"));
  }

  public static void create_marshall(Chat a, String locat_file)throws JAXBException{

    JAXBContext jaxbContext = JAXBContext.newInstance(Chat.class);
    Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

    // Marshal the employees list in console
    // jaxbMarshaller.marshal(a, System.out);

    // Marshal the employees list in file
    jaxbMarshaller.marshal(a, new File(locat_file));
  }

}