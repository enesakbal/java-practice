
public class Bilgisayar {

    private Anakart anakart1;
    private Ekran ekran1;
    private Kasa kasa1;



    public Bilgisayar(Anakart anakart1, Ekran ekran1, Kasa kasa1) {
        this.anakart1 = anakart1;
        this.ekran1 = ekran1;
        this.kasa1 = kasa1;
    }
    
    public void toplamfiyat(){
        
        System.out.println("PC fiyati :" + (anakart1.getAnakart_fiyati()+ekran1.getMonitor_fiyati()+kasa1.getKasa_fiyati()));
        
    }
    

    public Anakart getAnakart1() {
        return anakart1;
    }

    public void setAnakart1(Anakart anakart1) {
        this.anakart1 = anakart1;
    }

    public Ekran getEkran1() {
        return ekran1;
    }

    public void setEkran1(Ekran ekran1) {
        this.ekran1 = ekran1;
    }

    public Kasa getKasa1() {
        return kasa1;
    }

    public void setKasa1(Kasa kasa1) {
        this.kasa1 = kasa1;
    }


    
    
    
}
