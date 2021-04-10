import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        form frm = new form();
        frm.addJlist();
        Run run = new Run();


        while (true){
            run.runtime(frm.getMode());


        }


    }
}
