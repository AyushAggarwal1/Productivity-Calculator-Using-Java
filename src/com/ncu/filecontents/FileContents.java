package src.com.ncu.filecontents;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import src.com.ncu.Exception.*;

public class FileContents 
{
 public static void main(String args[]) throws FileNotLoadException, Exception
   {
      File fileName = null;
      try 
         {
            fileName = new File("productivity_calculator.txt");                // file opening
            FileReader fReader = new FileReader(fileName);                     // file opens in reading mode                
            BufferedReader reader= new BufferedReader(fReader);                // reading file
            String sr;
            System.out.println("\nThe Contents History Of The File Are: ");	
            while((sr=reader.readLine())!=null)                           // while loop starts for printing file contents
            {
              System.out.println(sr);
            }
            reader.close();
         }
      catch (Exception e) 
         {
            System.out.println("Sorry File Not Ready Yet ");
         }
   }   
}
