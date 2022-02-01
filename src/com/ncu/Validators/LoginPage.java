package src.com.ncu.Validators;

import src.com.ncu.Exception.*;
import java.util.*;

public class LoginPage
{
public boolean loginPage() throws InvalidLoginException, PasswordException
{

    String username ;
    String password;
    String choice;
    String user;
    String pass;

    Scanner scan = new Scanner(System.in);

    System.out.println("First You Have To Register Our Site");
    System.out.println("Create Username:");
    username = scan.nextLine();                   // to create user name

    
    System.out.println("Create Password:"); 
    password = scan.nextLine();                   // to create password

    if(password.matches(".*[0-9]{1,}.*") && password.matches(".*[@#$]{1,}.*") && password.length()>=6 && password.length()<=20)
    {
        System.out.println("\nValid Password");
    }
    
    else
    {
        throw new PasswordException("Password Type Not Followed \nPassword Validations :\\n \\nIt contanins Atleast 1 Numeric value ,\\n \\n1 Special Character (@#$) ,\\n \\nIt Also contains Characters ,\\n \\nAnd Length Is Between 6 to 20\\n\");\n" );
    }
    
    
    System.out.println("\nDo You Want To Login(yes or no) :");

    choice = scan.nextLine();                 // ask user to login or not


    while (true)
    {
        if (choice.equals("yes"))
        {
            System.out.println("\nUsername:");
            user = scan.nextLine();
            if (user == username) 
            {
               continue;
            }
            System.out.println("\nPassword");
            pass = scan.nextLine();
            if (pass.equals(password) && user.equals(username))                                 //for sucessful login 
            {
               System.out.println("You Are Logged In");
               return true ;
            }                                                              // if statement ends
            if (!password.equals(pass))                               // wrong username or password
            {
               throw new InvalidLoginException("Oops You Enter Wrong Username or Password");
            }                                                             // if statement ends
        }

        if (choice.equals("no"))
            return false ;
        
    }
}
}


class logintest
{
    public static void main(String[] args) throws InvalidLoginException, PasswordException 
    {
      LoginPage l=new LoginPage();
      l.loginPage();
    }
}





