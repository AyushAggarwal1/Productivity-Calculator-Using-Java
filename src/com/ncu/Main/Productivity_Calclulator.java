package src.com.ncu.Main;

import src.com.ncu.Exception.*;
import src.com.ncu.Processor.*;
import src.com.ncu.Validators.*;
import java.io.IOException;
import java.util.*;

public class Productivity_Calclulator
{
    public static void main(String[] args) throws ChoiceNotFoundException , NotValidOptionException , IOException, PasswordException
    {
            char choice ;                               //for choosing add , update , delete , search 
            char choice2 ;                              //for choice exit or not 
            int i = 1;                                  //for repeatation of while loop 
            boolean b;                                  //for sucessful login
            boolean c;                                  //for search update
            boolean d;                                  //for search delete
            
            System.out.println("\t\t\t\t\t\t\t WELCOME TO PRODUCYIVITY CALCULAOR");
            System.out.println("\t\t\t\t\t\t\t  Please Enter The Login Details");
            
            Scanner sc=new Scanner(System.in);
            
            try
            {
                LoginPage l= new LoginPage();                           //login page
                b=l.loginPage();                            
                if(b==true)                                     //for sucessful login
                {
                System.out.println("\nHello User");
                System.out.println("\nHiii I Am Your Bot 'KENSHO'");
                while(i==1)                                    //loop for choice exit or not
                {   
                    System.out.println("\nUser Tell Me What You Want To Do"+"\n"+"\nIf You Want To 'ADD' Something Then Enter 'A'"+"\n"+"\nIf Yor Want To 'UPDATE' Something Then Enter 'U' " +"\n"+"\nIf You Want To 'DELETE' Something Then Enter 'D'"+"\n"+"\nIf You Want To 'SEARCH' Something Then Enter 'S'"+"\n"+"\nIf You Want To 'Exit' Then Enter 'E'");
                    choice=sc.next().charAt(0);
                    System.out.println("User You Entered " +choice);
                    try
                        {
                            if(choice=='A'||choice=='U'||choice=='D'||choice=='S'||choice=='E')
                            {
                                switch (choice) 
                                {
                                    case 'A':
                                        System.out.println("Now You Are Able To 'ADD' Data");
                                        AddTasks A=new AddTasks();          // for adding tasks
                                        A.taskEntries();
                                        break;
                                    case 'U':
                                        System.out.println("Before 'UPDATE' Data");
                                        System.out.println("\nFirst You Have to 'Search' Data");    
                                        SearchTasks S=new SearchTasks();
                                        c=S.search();                       //for searching 
                                        if(c==true)
                                        {
                                             UpdateTasks U = new UpdateTasks();     // for update tasks
                                             U.update();
                                        }
                                        break;
                                    case 'D':
                                        System.out.println("\nBefore 'DELETE' Data");
                                        System.out.println("\nFirst You Have to 'Search' Data");
                                        SearchTasks Z=new SearchTasks();
                                        d=Z.search();                       //for searching
                                        if(d==true)
                                        {
                                            DeleteTasks t= new DeleteTasks();   // for deleting
                                            t.delete();
                                        }
                                        break;
                                    case 'S':
                                        SearchTasks P=new SearchTasks();        // only for search
                                        P.search();
                                        break;
                                    case 'E':
                                        System.out.println("\nPlease Confirm");
                                        break;
                                }                   //end of switch case
                            }                       //if statement ends
                            else
                            {
                                throw new ChoiceNotFoundException("Oops.... You Enter Other Than :'A','U','D','S'");                    
                            }
                        }                           // end of try block
                    
                    catch(ChoiceNotFoundException e)
                        {
                            System.out.println("Oops.... You Enter Other Than :'A','U','D','S','E'");
                        }
                    
                System.out.println("\nPress 'N' To Exit Or Any Other Key To Continue:");
                choice2=sc.next().charAt(0);                    // choice for exit
                
                if(choice2=='N')
                {
                    i=0;
                    System.out.println("\t\t\t\t\t\t\t PRODUCTIVITY CALCULATOR");
                }
                }                       //end while loop
            }
            }
            
            catch(InvalidLoginException e)
            {
                System.out.println("Oops You Enter Wrong Username Or Password");   // catch block to handle exception
            }
            sc.close();
    }
}