
public class Ekran {
    private Resoluton resoluton;
    
    private String monitor_modeli;
    
    private int monitor_fiyati;

    public Ekran(Resoluton resoluton, String monitor_modeli, int monitor_fiyati) {
        this.resoluton = resoluton;
        this.monitor_modeli = monitor_modeli;
        this.monitor_fiyati = monitor_fiyati;
    }
    
    public void ekranı_aç(){
    
        System.out.println("Ekran açılıyor....");
        
}
    public void ekranı_kapar(){
        System.out.println("Ekran kapatılıyor....");
    }
    

    public Resoluton getResoluton() {
        return resoluton;
    }

    public void setResoluton(Resoluton resoluton) {
        this.resoluton = resoluton;
    }

    public String getMonitor_modeli() {
        return monitor_modeli;
    }

    public void setMonitor_modeli(String monitor_modeli) {
        this.monitor_modeli = monitor_modeli;
    }

    public int getMonitor_fiyati() {
        return monitor_fiyati;
    }

    public void setMonitor_fiyati(int monitor_fiyati) {
        this.monitor_fiyati = monitor_fiyati;
    }
    
    
    
    
}
