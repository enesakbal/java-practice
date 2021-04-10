
import javax.sound.sampled.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ItemEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;


public class form extends JFrame{
    private JPanel panel1;
    private JList list1;
    private JButton previousButton;
    private JButton playButton;
    private JButton stopButton;
    private JButton nextButton;
    private JSlider slider1;
    private JPanel panel2;
    private JPanel panel3;
    DefaultListModel demoList;
    private int mode=1;

    Run run;

    public void addJlist() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        run = new Run();
        demoList = new DefaultListModel();
        for (int i = 0 ; i < run.file2.listFiles().length ; i++){
            demoList.add(i,run.namesoffiles()[i]);

        }
        list1.setModel(demoList);

    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }

    public form() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
        add(panel1);
        addJlist();

        setSize(500,350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);






        playButton.addMouseListener(new MouseAdapter() {
            @Override

            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

                if (e.getButton() == 1 && !list1.isSelectionEmpty()){

                    setMode(0);

                }
            }

        });
        stopButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if (e.getButton() == 1){
                    setMode(1);
                }
            }
        });



    }





}
