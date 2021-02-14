
public class main {
    
    
    public static void main(String[] args) {
        
        ATM atm = new ATM();
        Account FirstUser = new Account("Enes","12345", 3000);
        
        atm.Run(FirstUser);
        
        
        
        
        System.out.println("Programdan Cikiliyor...");
        
    }
    
    
    
}
