import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;

public class Music {
    private String musicName;
    private double finalSec;
    private int    totalSec;



    public void addMusic(){






    }

    private int getDuration(File file) throws Exception {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file);
        AudioFormat format = audioInputStream.getFormat();
        long audioFileLength = file.length();
        int frameSize = format.getFrameSize();
        int frameRate = (int) format.getFrameRate();
        int durationInSeconds = (int) (audioFileLength / (frameSize * frameRate));
        return (durationInSeconds);
    }


    public String getMusicName() {
        return musicName;
    }

    public void setMusicName(String musicName) {
        this.musicName = musicName;
    }

    public double getFinalSec() {
        return finalSec;
    }

    public void setFinalSec(double finalSec) {
        this.finalSec = finalSec;
    }

    public int getTotalSec() {
        return totalSec;
    }

    public void setTotalSec(int totalSec) {
        this.totalSec = totalSec;
    }
}
