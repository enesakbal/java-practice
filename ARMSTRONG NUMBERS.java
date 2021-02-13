
import java.util.Scanner;

public class main {

public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int max = 5500 ;
    int digits;
    int temp, temp2;
    int sum = 0;
        
    for (int i = 1 ; i < max ; i++  ){
        digits = 0;
        sum = 0;
        temp = i;
        temp2 = i;
        while (temp != 0) {
            temp/=10;
            digits++;
            
        }
        
        for (int j = 0 ; j<digits ; j++){
            sum+=Math.pow(temp2%10, digits);
            temp2 /= 10;
            
        }
        
        if (i == sum){
            System.out.println(sum);
        }

        
        
   }
    
    
    
}




    
}
