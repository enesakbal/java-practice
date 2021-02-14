
public class main {
    
    
    public static void main(String[] args) {
    Anakart anakart1 = new Anakart("DS5421","ASUS", 186);
    Resoluton resoluton1 = new Resoluton(1920, 1080);
    Ekran ekran1 = new Ekran(resoluton1, "Casper", 625);
    Kasa kasa1 = new Kasa("SDA563", "Monster", 1590);
    
    Bilgisayar pc321 = new Bilgisayar(anakart1, ekran1, kasa1);
        
      pc321.getEkran1().ekranı_kapar();
      pc321.toplamfiyat();
        
    }
    

    
   
    
       

    
    
    
    
}
