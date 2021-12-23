import javaserver.chat.*;

import jakarta.xml.bind.JAXBException;
public  class Main {
   public static void  main(String[] args) throws JAXBException
    {
        ChatMarshaller a = new ChatMarshaller();
        a.test();
        try{
         a.reader_test();
         a.reader_test2();
        }
        catch(Exception e){
         System.out.println("Test failure!");
        }
    }
}