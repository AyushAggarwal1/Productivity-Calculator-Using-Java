package src.com.ncu.Processor;

import src.com.ncu.Exception.*;
import java.io.*;
import java.util.*;

public class SearchTasks 
{
   public boolean search() throws ChoiceNotFoundException, FileNotFoundException, IOException 
   {
   
      String fileName;                                
      String[] words=null;                                         //Intialize the word Array for reading and storing the linewise file 
      String s;     
      String search;                                               //choice by user to search string
      int count=0;                                                 // to fint the illetration of search
      boolean b = false;
      
      try
      {
        fileName="productivity_calculator.txt";
      
        FileReader fr = new FileReader(fileName);                    // File Reader object for reading file
        BufferedReader br = new BufferedReader(fr);                  // BufferedReader object for reading file
      
        Scanner sc=new Scanner(System.in);

        System.out.println("\t\t\t\t\t\t\t\t WELCOME TO THE SEARCH TASKS");
      
        System.out.println("\nEnter The Task To Search");
        search=sc.nextLine();                                        // Input word to be searched

        while((s=br.readLine())!=null)                               //Reading Content from the file
            {
                words=s.split(" ");                                       //Split the word using space
                for (String word : words)                                // for each loop : 
                    {
                        if (word.equals(search))                          //Search for the given word
                            {
                                count++;                                        //If Present increase the count by one
                            }
                    }
            }
        if(count!=0)                                                  //Check for count not equal to zero
        {
            System.out.println("The Given Word Is Present For "+count+ " Times In The File");
            return b=true;
        }
        else if(count==0)
        {
            throw new ChoiceNotFoundException("Ooops... Your Choice Not Found");
        }
        fr.close();                                           //file close
      }
      catch(ChoiceNotFoundException e)
        {
            System.out.println("Ooops... Your Choice Not Found");        // catch exeption when choice not found
        }
      
        if (b==true)
        {
            return true;
        }
        
        else
        {
            return false;
        }
    }
}


class SearchTaskDrive
{
    public static void main(String[] args) throws ChoiceNotFoundException, FileNotFoundException, IOException
    {
        SearchTasks s=new SearchTasks();
        s.search();
    }
}
