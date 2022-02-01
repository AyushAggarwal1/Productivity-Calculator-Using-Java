package src.com.ncu.Processor;

import java.io.*;
import java.util.*;
import src.com.ncu.Exception.*;

public class UpdateTasks 
{
    public void update() throws IOException , ChoiceNotFoundException
    {
        String fileName ;                   // file name
        String initial;                     // task name to update
        String finall;                      // new name for upgradation 
        String currentReadingLine;          // for line reading
        String modifiedFileContent;         // modifier after update
        String choice;                      // maybe hours and task name
        
        fileName = "productivity_calculator.txt";    
            
        String originalFileContent = "";  
        
        System.out.println("\t\t\t\t\t\t\t\t WELCOME TO THE UPDATETASKS");
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("\nPlease Enter The Type Of Task (Hours or Task Name)");
        System.out.println("\nFor Hours 'H' And for Name 'N' Use");
        choice = sc.nextLine();
                
        BufferedReader reader = null;                   // for reading file
        BufferedWriter writer = null;                   // for writting file
        
        try 
        {
            if("H".equals(choice) || "N".equals(choice))
            {
            System.out.println("\nPlease Enter The Initial Data Name");
            initial=sc.nextLine();                     
        
            System.out.println("\nPlease Enter The Final Data Name");
            finall=sc.nextLine();
            
            reader = new BufferedReader(new FileReader(fileName));          //file reader
            
            currentReadingLine = reader.readLine();                         //reading file
            
            while (currentReadingLine != null) 
            {
                originalFileContent += currentReadingLine + System.lineSeparator();     //saving content 
                currentReadingLine = reader.readLine();
            }
            
            modifiedFileContent = originalFileContent.replaceAll(initial, finall);      //replacing initial to final
            
            writer = new BufferedWriter(new FileWriter(fileName));              //file writter
            
            writer.write(modifiedFileContent);                      //writting new name into file
            }
            
            else
            {
                throw new ChoiceNotFoundException("Oops... Please Entere 'H' or 'N'");
            }
        }// try block ends
        
        catch(ChoiceNotFoundException v)
        {
            System.out.println("Oops... Please Entere 'H' or 'N'");
        }
        
        catch (IOException e) 
        {
            System.out.println(e);
        }
        
        finally 
        {
            try 
            {
                if (reader != null) 
                {
                    reader.close();                 //closing reader file
                }
                if (writer != null) 
                {
                    writer.close();                 //closing writer file
                }
            } 
            
            catch (IOException e) 
            {
                System.out.println(e);
            }
        }
        
    }
}


class UpdateTaskDriver
{
    public static void main(String[] args) throws IOException, ChoiceNotFoundException 
    {
        UpdateTasks U = new UpdateTasks();
        U.update();
    }
}

