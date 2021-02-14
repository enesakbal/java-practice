
import java.util.Scanner;

public class Login {

    public boolean login(Account User1){
        
        Scanner sc = new Scanner(System.in);
        
        String Username;
        String Password;
        
        System.out.print("Username :");
        Username = sc.nextLine();
        
        System.out.print("Password :");
        Password = sc.nextLine();
        
        if (User1.getUsername().equals(Username) && User1.getPassword().equals(Password)){
            
            return true;
            
        }
        
        else
            return false;
        
        
        
    }

    
    
    



    
}
