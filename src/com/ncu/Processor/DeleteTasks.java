package src.com.ncu.Processor;

import src.com.ncu.Exception.ChoiceNotFoundException;
import java.io.*;
import java.util.*;

public class DeleteTasks 
{
    public void delete() throws FileNotFoundException, IOException 
    {
        try 
        {
        String choice ;                     // maybe hours or task name 
        String fileName ;                   // file name
        String name;                        // task to delete
        String currentReadingLine;          // for line reading
        String modifiedFileContent;         // modifier after update

        
        fileName = "productivity_calculator.txt";    

        String originalFileContent = "";  
        
        System.out.println("\t\t\t\t\t\t\t\t WELCOME TO THE DELETETASKS");
        
        Scanner sc=new Scanner(System.in);
        
        System.out.println("\nPlease Enter The Task Type To Delete (Hours or Task Name)");
        choice=sc.nextLine();
        if("Hours".equals(choice) || "Name".equals(choice))
            {
                System.out.println("\nPlease Enter The "+choice +" To Delete");
                name=sc.nextLine();                     
        
                BufferedReader reader = null;                   // for reading file
                BufferedWriter writer = null;                   // for writting file
        
            try 
                {
                    reader = new BufferedReader(new FileReader(fileName));          //file reader
            
                    currentReadingLine = reader.readLine();                         //reading file
            
                    while (currentReadingLine != null) 
                        {
                            originalFileContent += currentReadingLine + System.lineSeparator();     //saving content 
                            currentReadingLine = reader.readLine();
                        }
            
                    modifiedFileContent = originalFileContent.replaceAll(name, "");      //deleting
            
                    writer = new BufferedWriter(new FileWriter(fileName));              //file writter
            
                    writer.write(modifiedFileContent);                      //writting
                }                                                   // try block ends
            
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
            }                                                  //if statement ends                                                 
        else
            {
                throw new ChoiceNotFoundException("Oops...You Enter Other Than Hours and Name");        //throws error when choice other than hours and name
            }
        }                                  //try block ends
        
        catch(ChoiceNotFoundException e)
            {
                System.out.println("Oops...You Enter Other Than Hours and Name");
            }
        
    }
}


class DeleteTasksDriver
{
    public static void main(String[] args) throws FileNotFoundException ,IOException 
    {
        DeleteTasks d= new DeleteTasks();
        d.delete();
    }
}
