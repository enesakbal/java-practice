
import java.util.Scanner;


public class main {
    
    
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        Idman student1 = new Idman(6, 5, 8, 3);
        
        int times;
        String kind;
        while (student1.Finish()==false) {            
            System.out.print("Hareket türü :");
            kind = sc.nextLine();
            System.out.print("Hareket sayisi :");
            times = sc.nextInt();
            sc.nextLine();
            
            student1.do_it(kind, times);
        
        
        }
        
        
        
        
        
        
    }
    
}
