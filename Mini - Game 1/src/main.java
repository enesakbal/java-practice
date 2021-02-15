
import java.util.Scanner;

public class main {
    

    private static Cards[][] cards = new Cards[4][4];
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cards[0][0] = new Cards('B');
        cards[0][1] = new Cards('A');
        cards[0][2] = new Cards('C');
        cards[0][3] = new Cards('D');
        
        cards[1][0] = new Cards('J');
        cards[1][1] = new Cards('K');
        cards[1][2] = new Cards('P');
        cards[1][3] = new Cards('T');
        
        cards[2][0] = new Cards('T');
        cards[2][1] = new Cards('A');
        cards[2][2] = new Cards('B');
        cards[2][3] = new Cards('C');
        
        cards[3][0] = new Cards('D');
        cards[3][1] = new Cards('J');
        cards[3][2] = new Cards('K');
        cards[3][3] = new Cards('P');
        
        
        
        do {
            PlayGround();
                    
            int line1 , column1;
            int line2 , column2;
          
            System.out.println("First box\n"
                             + "**********");
            System.out.print("Line :");
            line1 = sc.nextInt();
            
            if (line1>3){
                System.err.println("Enter less than 4"); 
                continue;
            }
           
            System.out.print("Column :");
            column1 = sc.nextInt();
            
            if (column1>3){
                System.err.println("Enter less than 4"); 
                continue;
            }
            
            
            if (cards[line1][column1].isGuess()!=true){
                cards[line1][column1].setGuess(true);
                PlayGround();
                
            }
            else{
                System.out.println("Already open...");               
                continue;
            }
                   
            
            System.out.println("Second box\n"
                             + "**********");
            System.out.print("Line :");
            line2 = sc.nextInt();
            
            
            if (line2>3){
                System.err.println("Enter less than 4"); 
                cards[line1][column1].setGuess(false);
                continue;
            }
            
            
            
            System.out.print("Column :");
            column2 = sc.nextInt();
            
            
            if (column2>3){
                System.err.println("Enter less than 4"); 
                cards[line1][column1].setGuess(false);
                continue;
            }
            
            
            if(cards[line2][column2].isGuess() == true){
                System.out.println("Already open...");
                cards[line1][column1].setGuess(false);
                
                continue;
            }
            
            else {
                cards[line2][column2].setGuess(true);
                
                if (cards[line1][column1].isGuess() == cards[line2][column2].isGuess()){
                    System.out.println("\n\nWELL DONE !");
                    
                    
                }
                else{
                    System.out.println("Sorry , try again...");
                    cards[line1][column1].setGuess(false);
                    cards[line2][column2].setGuess(false);
                }
                
                
            }
            

            
            
        } while (GameOver()!=true);
        
        
        
        
        
        
        
        
        
        
            
    }
    
    
    
    /*public static void play(int column , int line){
        
        if (cards[line][column].isGuess() == true)
            System.out.println("Already open...");
        
        else{
            cards[line][column].setGuess(true);
            
        }
        
        
           
        
        
        
        
    }*/
    
    
    
    
    
    
    
    public static void PlayGround(){
        System.out.println("\n\n*****************");
        for (int i = 0; i <4; i++) {
            
            for (int j = 0; j <4; j++) {
                
                if (cards[i][j].isGuess()){
                    
                    System.out.print(" |" + cards[i][j].getCharacter() + "| ");
                    
                    
                }
                else{
                    System.out.print(" |" + "| ");
                }
                
                
            }
            System.out.println("");
        }
        
        System.out.println("*****************\n\n");
    
    }
    
    
    public static boolean GameOver(){
        
        for (int i = 0; i < 4; i++) {
            
            for (int j = 0; j < 4; j++) {
                
                if (cards[i][j].isGuess() ==false){
                    return false;
                }
                
                
            }
            
        PlayGround();
        }
        return true;
    
    }
    
    
    
    
    
    
}
