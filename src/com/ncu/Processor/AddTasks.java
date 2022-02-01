package src.com.ncu.Processor;

import src.com.ncu.Exception.*;
import java.util.*;
import java.io.*;

public class AddTasks 
{
    @SuppressWarnings("ConvertToTryWithResources")
    public void taskEntries() throws NotValidOptionException , ChoiceNotFoundException, IOException
    {
        
        try
        {
            int entries ;                                     // for total number of task to perform
            String fileName ;                                 // file name
            int hours[] ;                                     // for storing hours for tasks  
            int sum = 0 ;                                     // for storing the sum of hours of productive tasks
            int sum2 = 0 ;                                    // for storing the sum of hours of non productive tasks 
            
            System.out.println("\t\t\t\t\t\t\t\t WELCOME TO THE ADDTASKS");
            
            fileName = "productivity_calculator.txt";
            
            BufferedWriter out = new BufferedWriter(new FileWriter(fileName));          // opening file as writting mode
            
            Scanner sc = new Scanner(System.in);               // scanner for user input

            // FOR PRODUCTIVE TASKS
            
            System.out.println("\nEnter Total Number Of Productive Tasks You Want To Perform :");
            
            out.write("PRODUCTIVE TASKS");
            
            entries = sc.nextInt();                             // user input for total entries
            
            System.out.println("\nNow Enter The Productive Tasks");
            
            for(int i = 0 ; i <= entries ; i++)
            {
                if(entries == 0)
                {
                    throw new NotValidOptionException("Oops... You Enter Zero"); //throw exception when entries is 0
                }
                else
                {
                    sc.hasNext();                       
                    out.write(sc.nextLine());                        //writtiing into file
                    out.newLine();
                }            
            }
            System.out.println("\nNow Enter Hours");
           
            out.write("HOURS OF PRODUCTIVE TASKS\n");
            
            hours = new int[entries];
            for (int i = 0 ; i < entries ; i++) 
            {
                hours[i]=sc.nextInt();
                out.write(hours[i]+"");
                out.newLine();
            }
            
            for(int i = 0 ; i < entries ; i++)
            {
               sum = sum + hours[i];                                  // for calculating sum of hours
            }
            
            if(sum <= 24)
            {
                System.out.println("\nThe Total Productive Hours Are : "+sum);
                System.out.println("\nThe Total Hours You Left With : "+(24-sum));
            }
            else if (sum > 24)
            {
                throw new TimeException("You Cannot Complete Your Task In A Day");
            }
                
            // FOR NON PRODUCTIVE TASKS
            
            System.out.println("\nEnter Total Number Of Non Productive Tasks You Want To Perform :");
            
            out.write("NON PRODUCTVE TASKS");
            
            entries = sc.nextInt();                             // user input for total entries
            
            System.out.println("\nNow Enter The Non Productive Tasks");
            
            for(int i = 0 ; i <= entries ; i++)
            {
                if(entries == 0)
                {
                    throw new NotValidOptionException("Oops... You Enter Zero"); //throw exception when entries is 0
                }
                else
                {
                    sc.hasNext();                       
                    out.write(sc.nextLine());                        //writtiing into file
                    out.newLine();
                }            
            }
            System.out.println("\nNow Enter Hours");
            
            out.write("HOURS OF NON PRODUCTIVE TASKS\n");
            
            hours = new int[entries];
            for (int i = 0 ; i < entries ; i++) 
            {
                hours[i]=sc.nextInt();
                out.write(hours[i]+"");
                out.newLine();
            }
            
            for(int i = 0 ; i < entries ; i++)
            {
               sum2 = sum2 + hours[i];                                  // for calculating sum of hours
            }
            
            if(sum2+sum < 24)
            {
                System.out.println("\nThe Total Non Productive Hours Are : "+sum2);
                System.out.println("\nThe Total Hours You Left With : "+(24-(sum+sum2)));
            }
           
            else if (sum2+sum > 24)
            {
                throw new TimeException("You Cannot Complete Your Task In A Day");
            }

            out.close();                        // file close
            
        }
        
        catch(NotValidOptionException e)
        {
            System.out.println("Oops You Enter Zero");              //catch exception when entries is 0
        }
        
        catch(TimeException v)
        {
            System.out.println("You Cannot Complete Your Task In A Day");
        }
        
    }
}


class TasksDriver
{
    public static void main(String[] args) throws Exception 
    {
        AddTasks t=new AddTasks();
        t.taskEntries();
    }
}