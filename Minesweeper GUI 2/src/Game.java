
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;




public class Game implements MouseListener{
    
    int rows = 18, column = 18, num_of_mines ,number_of_mines_remaining ;
    int width = 750 , height = 700;
    boolean quit = false;
    
    
    
    Button[][] board = new Button[rows][column];
    menuclass menu2;
    JFrame frame;
    JMenu menu;
    JMenuBar menuBar;
    Random rand = new Random();

    
    ImageIcon defaultImageIcon  = resize("t.png");
    ImageIcon mineIcon          = resize("bomb.png");
    ImageIcon flagIcon          = resize("flag.png");
    ImageIcon gray              = resize("gray.png");
    ImageIcon pointOneIcon      = resize("1.png");
    ImageIcon pointTwoIcon      = resize("2.png");
    ImageIcon pointThreeIcon    = resize("3.png");
    ImageIcon pointFourIcon     = resize("4.png");
    ImageIcon pointFiveIcon     = resize("5.png");
    ImageIcon pointSixIcon      = resize("6.png");
    ImageIcon pointSevenIcon    = resize("7.png");
    ImageIcon pointEigthIcon    = resize("8.png");
    
    String str ;

    
    
    public void play(){
        
        frame = new JFrame("Minesweeper (Created by ea)");  
        menu2 = new menuclass(frame);
        
        
        menu2.set();
        frame.setSize(width, height);      
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(rows ,column));
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);
        
        
        

        
        
        
        

        str = JOptionPane.showInputDialog("Number of Mines");
   
        if (str == null){
            System.exit(0);  
        }
       
        
        
        try {
            num_of_mines = Integer.parseInt(str);
            
        } catch (NumberFormatException e) {
            int random = rand.nextInt(20);
            num_of_mines = random;
            JOptionPane.showMessageDialog(null, "Missing or wrong choice\n I set number of mines to " + random);
            
        }
        
        number_of_mines_remaining = num_of_mines;
        
        
        for (int i = 0 ; i < rows ; i++){
            
            for (int j = 0 ; j < column ; j++){
                Button button = new Button(i, j);

                board[i][j] = button;
                board[i][j].setIcon(defaultImageIcon);
                button.addMouseListener(this);
                frame.add(button);
                
            }
        }
        
        frame.setVisible(true);
        
        placesMines();
        addPoints();
        
        while (true) {            
            end();
            if (end() == true){
                
                JOptionPane.showMessageDialog(frame, "YOU WIN !");
                showMines(flagIcon);
                quit = true;
                break;
            }
            
            end();
        }
        
   
    }
        
    public ImageIcon resize(String pic){
        
            ImageIcon imageicon = new ImageIcon(pic);
            Image image = imageicon.getImage();
            Image newimage = image.getScaledInstance(width/rows, height/column, java.awt.Image.SCALE_SMOOTH);
            imageicon = new ImageIcon(newimage);
            return imageicon;
    }
    
    public void placesMines(){
        int randRows, randColumn, count=0;
        
        while (count != num_of_mines) {            
            randRows    = rand.nextInt(rows);
            randColumn  = rand.nextInt(column);
            if (!board[randRows][randColumn].isMine()){
                board[randRows][randColumn].setMine(true);
                
                board[randRows][randColumn].setCount(-10);
                
                
                count++;
            }                       
        }       
    }
    
    public void addPoints(){
        
        for (int i = 0; i < rows; i++) {
            
            for (int j = 0; j < column; j++) {
                
                if (board[i][j].isMine() == true){
                    for (int k = -1; k < 2; k++) {
                        
                        for (int l = -1; l < 2; l++) {
                            
                            if (k == 0 && l == 0) {
                            } else{
                                try {
                                    int temp = board[i+k][j+l].getCount();
                                    board[i+k][j+l].setCount(++temp);
                                } catch (Exception e) {
                                }
                                
                                
                            }
                            
                        }
                        
                    }
                } else {
                }
                
            }
            
        }
        
        
        
        
    }
    
    public void openBox(int r , int c){
        
        if (board[r][c].getCount() > 0){
            board[r][c].setOpen(true);
            try {
                
                switch(board[r][c].getCount()){
                        
                    case 1 -> board[r][c].setIcon(pointOneIcon);
                    case 2 -> board[r][c].setIcon(pointTwoIcon);
                    case 3 -> board[r][c].setIcon(pointThreeIcon);
                    case 4 -> board[r][c].setIcon(pointFourIcon);
                    case 5 -> board[r][c].setIcon(pointFiveIcon);
                    case 6 -> board[r][c].setIcon(pointSixIcon);
                    case 7 -> board[r][c].setIcon(pointSevenIcon);
                    case 8 -> board[r][c].setIcon(pointEigthIcon);
                }
                
            } catch (Exception e) {
            }
                
            
        }
        
        else if (board[r][c].getCount() == 0 && board[r][c].isEnabled() == true && board[r][c].isFlag() == false){
        
            board[r][c].setOpen(true);
            scraping(r, c);
            
            
            
        }
    
    }

    public void scraping(int r, int c){
    board[r][c].setOpen(true);
    for (int i = -1; i < 2; i++) {
        
        for (int j = -1; j < 2; j++) {
            
            if ((r+i < 0 ) || (c+j < 0) || (r+i >= rows) || (c+j >= rows)){
                continue;
            }
                
            
            if (board[r+i][c+j].getCount() > 0 && board[r+i][c+j].isEnabled() == true){
                openBox(r+i, c+j);
            }
            
            if (board[r+i][c+j].getCount() == 0 && board[r+i][c+j].isEnabled() == true){
                if (board[r+i][c+j].isFlag())
                    continue;
                board[r+i][c+j].setOpen(true);
                board[r+i][c+j].setEnabled(false);
                board[r+i][c+j].setIcon(gray);
                scraping(r+i, c+j);
                
            }
            
            
            
            
        }
        
    }
    
    
    
    
    
    
    
    
}
    
    public void showMines(ImageIcon icon){
        
        for (int i = 0 ; i < rows ; i++) {
            
            for (int j = 0 ; j < column ; j++) {
                
                if (board[i][j].isMine()){
                    board[i][j].setIcon(icon);
                    board[i][j].setIcon(icon);            
                }
                else{
                    openBox(i, j);
                }
                
                
                
            }
            
            
        }
        
        
    }
   
    public boolean end(){
        boolean k = true;
        for (int i = 0 ; i < rows ; i++) {
            
            for (int j = 0 ; j < column ; j++) {
                
                if ((board[i][j].isMine() && !board[i][j].isFlag())){
                    
                    k = false;
                    
                
                }
                if (board[i][j].isMine() == false &&  board[i][j].isOpen() == false){
                    
                    k = false;
                }
                
            }
            
            
        }
        
        return k;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        Button buton = (Button) e.getComponent();
        
        if (e.getButton() == 1 &&  quit == false && buton.isFlag() == false) {
            buton.setOpen(true);
        if (buton.isMine() == true && buton.isFlag() == false){
            
            JOptionPane.showMessageDialog(frame, "GAME OVER");
            quit = true;
            showMines(mineIcon);
            
        }
            openBox(buton.getRows(), buton.getColumn());
            
        }
        else if (e.getButton() == 3 && quit == false && buton.isOpen() == false ){
            
            if (buton.isEnabled() == true  ){
            
                if (buton.isFlag() == false && number_of_mines_remaining > 0){
                    buton.setIcon(flagIcon);
                    buton.setFlag(true);
                    
                    number_of_mines_remaining--;
                   
                }
                else if (buton.isFlag() == true ) {
                    
                   
                    number_of_mines_remaining++;
                    buton.setIcon(defaultImageIcon);
                    buton.setFlag(false);
                    
                }
            }
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
    
}
