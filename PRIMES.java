
import java.util.Scanner;

public class main {

    public static boolean prime(int number) {
        
        for (int i = 2 ; i < number ; i++){
            if (number % i == 0)
                return false;
        }
        
       return true ;
        
        
    }
    
    
    
    
    
public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    
    System.out.print("Sayi Gir :");
    int number = sc.nextInt();
    
    for (int i = 2 ; i < number ; i++ ){
        if (prime(i))
            System.out.println(i);
    }
    
    
    
    
    
}




    
}
