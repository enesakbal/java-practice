
import java.util.Random;
import java.util.Scanner;


public class Game {
    
    Random rand = new Random();
    Scanner sc = new Scanner(System.in);
    
    int rows , column , num_of_mines, num_of_flag = 0, score=0;
    int[][] backGround;
    char[][] playGround;
    char block = '#';

    public Game(int rows, int column, int num_of_mines) {
        this.rows = rows;
        this.column = column;
        this.num_of_mines = num_of_mines;
        this.playGround = new char[rows][column];
        this.backGround = new int[rows][column];
    }
    
    public void Run(){
       
        Place_Mines();
        Add_Points();
        Show_BackGround();
        SetValue();
        System.out.println("Welcome....");
        int rowss , columnn , choise ,temp=0;
        boolean over = true;
        String menu = "1 - Scrape mode \n"
                    + "2 - Flag mode \n"
                    + "3 - Remove flag mode\n";
                   
        do {            
            Show_PlayGround();
            System.out.println(menu);
            System.out.print("Choice :");
            choise = sc.nextInt();
            
            
            switch(choise){
                
                case 1 -> {    
                    System.out.print("Line :");
                    rowss = sc.nextInt();
                    System.out.print("Column :");
                    columnn = sc.nextInt();
                    
                    if (Coordinate(rowss, columnn)){
                        if(Coordinate(rowss, columnn) && playGround[rowss][columnn] == '#'){
                            over = End();
                            
                        }
                        
                    }
                    else{
                        
                        System.out.println("Game Over !");
                        System.out.println("*****************************");
                        Show_BackGround();
                        temp = 1;
                        over = false;
                        
                        
                    }
                }
                    
                
                case 2 -> {
                    System.out.print("Line :");
                    rowss = sc.nextInt();
                    System.out.print("Column :");
                    columnn = sc.nextInt();   
                    playGround[rowss][columnn] = 'D';
                    num_of_flag++;
                    over = End();
                }
                case 3 -> {
                    System.out.print("Line :");
                    rowss = sc.nextInt();
                    System.out.print("Column :");
                    columnn = sc.nextInt();   
                    playGround[rowss][columnn] = '#';
                    if (backGround[rowss][columnn] == -1 ){
                        num_of_flag--;
                    }
                }
                default -> {
                    System.out.println("Wrong choice ! Try Again");
                }
            
            }
            
        
            if (over == false && End() == false && temp == 0){
                System.out.println("You win !\nScore :" + score);
                System.out.println("***************************");
                Show_BackGround();
                
            }
            
            
     
        } while (over);
        
       
              
    }
  
    public void Place_Mines(){
        int randRows, randColumn , count = 0;
        
        while (count != num_of_mines) {
            randRows = (rand.nextInt(rows-2)+1);
            randColumn = (rand.nextInt(column-2)+1);
            
            if (backGround[randRows][randColumn] != -1){
                backGround[randRows][randColumn] = -1;
                count++;
            }
            
        }
        
    }
    
    public void Show_BackGround(){
        
        for (int i = 1; i < rows-1; i++) {
            
            for (int j = 1; j < column-1; j++) {
                
                if (backGround[i][j] != -1){
                    System.out.print(" ");
                }
                System.out.print(backGround[i][j] + " ");
                
                
            }
            System.out.println("");
        }
        
    }
    
    public void Show_PlayGround(){
        
        for (int i = 0; i < rows; i++) {
            
            for (int j = 0; j < column; j++) {
                System.out.print(playGround[i][j] + "  ");
            }
            System.out.println("");
        }
    
    }
    
    public void Add_Points(){
        
        for (int i = 0; i < rows; i++) {
            
            for (int j = 0; j < column; j++) {
                if (backGround[i][j] == -1){
                    
                    for (int k = -1; k < 2; k++) {
                        
                        for (int l = -1; l < 2; l++) {
                            if (k == 0 && l == 0)
                                continue;
                            
                            if (backGround[i+k][j+l] >=0){
                                backGround[i+k][j+l]++;
                            }
                            
                        }
                        
                    }
                    
                }
                
                
            }
            
        }
        
        
        
        
        
    }
    
    public boolean Coordinate(int rowss , int columnn){
        
        if (backGround[rowss][columnn] == -1){
            return false;
            
        }
        else if (backGround[rowss][columnn] > 0 ){
            
            char temp = (char) (backGround[rowss][columnn]+ '0');
            score += backGround[rowss][columnn];
            playGround[rowss][columnn] = temp;
        }
        else{
            Scraping(rowss, columnn);
            
        }
        return true;
    }
    
    public void Scraping(int rowss , int columnn){
        
        for (int i = -1; i < 2; i++) {
            
            for (int j = -1; j < 2; j++) {
                
                if ((rowss+i < 1 ) || (columnn+j < 1) || (rowss+i > rows) || (rowss+j >rows))
                    continue;
                
                
                if (backGround[rowss+i][columnn+j] > 0 && playGround[rowss+i][columnn+j] == block){
                    char temp =(char) (backGround[rowss+i][columnn+j]+ '0');
                    playGround[rowss+i][columnn+j] = temp;
                    
                    
                }
                else if (backGround[rowss+i][columnn+j] == 0 && playGround[rowss+i][columnn+j] == block){
                    playGround[rowss+i][columnn+j] = '0';
                    Scraping(rowss+i, columnn+j);
                    
                }
                
                
                
            }
            
        }
        
        
        
        
        
    }
 
    public void SetValue(){
        
        for (int i = 1; i < rows-1; i++) {
            
            for (int j = 1; j < column-1; j++) {
                
                playGround[i][j] =block;
                
            }
            
        }
        
    }
    
    public boolean End(){
        if (num_of_flag > 0){
            
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < column; j++) {
                    
                    if (backGround[i][j] == -1 && playGround[i][j] != 'D'){
                        return true;
                    }
                    
                    
                }
            }
            
            
        }
        
        return false;
        
        
        
        
        
        
    }
    
}
