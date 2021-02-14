
public class Kasa {
    
    private String kasa_modeli;
    private String kasa_markası;
    
    private int kasa_fiyati;

    public Kasa(String kasa_modeli, String kasa_markası, int kasa_fiyati) {
        this.kasa_modeli = kasa_modeli;
        this.kasa_markası = kasa_markası;
        this.kasa_fiyati = kasa_fiyati;
    }

    public void bilgisayarı_ac(){
        System.out.println("Bilgisayar açılıyor....");
    }
    public void bilgisayarı_kapat(){
        System.out.println("Bilgisayar kapanıyor....");
    }
    
    
    public String getKasa_modeli() {
        return kasa_modeli;
    }

    public void setKasa_modeli(String kasa_modeli) {
        this.kasa_modeli = kasa_modeli;
    }

    public String getKasa_markası() {
        return kasa_markası;
    }

    public void setKasa_markası(String kasa_markası) {
        this.kasa_markası = kasa_markası;
    }

    public int getKasa_fiyati() {
        return kasa_fiyati;
    }

    public void setKasa_fiyati(int kasa_fiyati) {
        this.kasa_fiyati = kasa_fiyati;
    }
    
    
    
    
    
    
}
