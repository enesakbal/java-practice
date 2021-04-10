import javax.lang.model.element.NestingKind;
import javax.sound.sampled.*;
import java.io.EOFException;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;

public class Run {

    File file = new File("C:\\Users\\Tom Bombadil\\Desktop\\mucis\\1.wav");
    File file2 = new File("C:\\Users\\Tom Bombadil\\Desktop\\mucis\\");
    AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
    Clip clip = AudioSystem.getClip();
    private int duration;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public File getFile2() {
        return file2;
    }

    public void setFile2(File file2) {
        this.file2 = file2;
    }

    public float getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public Run() throws IOException, UnsupportedAudioFileException, LineUnavailableException {
        this.file = file;
        this.audioStream = audioStream;
        this.clip = clip;
        clip.open(audioStream);

    }

    public AudioInputStream getAudioStream() {
        return audioStream;
    }

    public void setAudioStream(AudioInputStream audioStream) {
        this.audioStream = audioStream;
    }



    public Clip getClip() {
        return clip;
    }

    public void setClip(Clip clip) {
        this.clip = clip;
    }

    public String[] namesoffiles(){
        File[] dd = file2.listFiles();
        String[] names = new String[file2.listFiles().length];

        for (int i = 0 ; i < file2.listFiles().length ; i++){

            if (dd[i].getName().endsWith(".wav")){

                int num = dd[i].getName().length();


                names[i] = dd[i].getName().substring(0,num-4);

            }

        }
        return names;
    }




    public void runtime (int mod) throws Exception {

        //System.out.println(file2.listFiles().length);


        if (mod == 0){

            clip.start();


        }
        else if (mod == 1){
            clip.stop();

        }


    }



}
