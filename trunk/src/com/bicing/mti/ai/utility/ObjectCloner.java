package com.bicing.mti.ai.utility;

import java.io.*;
// TODO: Auto-generated Javadoc

/**
 * The Class ObjectCloner returns a deep copy of the old object
 * @author      Anshuman Mehta
 * @author 		<a href="mailto:mehta.anshuman@gmail.com">mehta.anshuman@gmail.com</a>
 * @since       1.0
 */
public class ObjectCloner
{
   
   /**
    * Instantiates a new object cloner.
    */
   private ObjectCloner(){}

   /**
    * Returns the Deep copy of the object.
    * 
    * @param oldObj the old obj
    * 
    * @return the object
    * 
    * @throws Exception the exception
    */
   static public Object deepCopy(Object oldObj) throws Exception
   {
      ObjectOutputStream oos = null;
      ObjectInputStream ois = null;
      try
      {
         ByteArrayOutputStream bos = 
               new ByteArrayOutputStream(); 
         oos = new ObjectOutputStream(bos); 
         oos.writeObject(oldObj);   
         oos.flush();               
         ByteArrayInputStream bin = 
               new ByteArrayInputStream(bos.toByteArray()); 
         ois = new ObjectInputStream(bin);                 
        
         return ois.readObject(); 
      }
      catch(Exception e)
      {
         System.out.println("Exception in ObjectCloner = " + e);
         throw(e);
      }
      finally
      {
         oos.close();
         ois.close();
      }
   }
   
}