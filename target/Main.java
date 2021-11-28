import javaserver.chat.*;

import javax.xml.bind.JAXBException;
public  class Main {
   public static void  main(String[] args) throws JAXBException
    {
        ChatMarshaller a = new ChatMarshaller();
        a.test();
    }
}