
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;


public class menuclass implements ActionListener{
    Random rand = new Random();
    JMenuBar menubar;
    JMenu menu;
    JFrame f;
    JMenuItem item1JMenuItem, item2JMenuItem, item3JMenuItem, item4JMenuItem;
    public menuclass(JFrame f) {
        this.f = f;
    }
    
    
    
    public void set(){
        
        
        
        menubar = new JMenuBar();
        menu = new JMenu("Difficulty");
        
        item1JMenuItem = new JMenuItem("Beginner Level");
        item2JMenuItem = new JMenuItem("Medium Level");
        item3JMenuItem = new JMenuItem("Hard Level");
        item4JMenuItem = new JMenuItem("Restart");
        menu.add(item1JMenuItem);
        menu.add(item2JMenuItem);
        menu.add(item3JMenuItem);
        menu.add(item4JMenuItem);
        item4JMenuItem.addActionListener(this);
        
        menubar.add(menu);
        
        f.setJMenuBar(menubar);
        

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    
 
        
    }


  
    
    
    
    
    
}

