
import java.util.Scanner;


public class Yonetici extends Calisanlar{
    
    private int sorumlukisi = 10;
    
    public Yonetici(String isim, int maas, String departman) {
        
        super(isim, maas, departman);
    }
    
    
    
    public void bilgileri_goster(){
        
        super.bilgileri_goster();
        System.out.println("Sorumlu kisi sayisi :" + sorumlukisi);
        
        
    }
    
    
    public void zam_yap(){
        Scanner sc = new Scanner(System.in) ;
        int zam;
        System.out.print("Zam mikari :");
        zam = sc.nextInt();
        
        super.zam_yap(zam);
                
        
    }
    
    public void sorumlu_arttir(int ekleneceksayi){
        
        sorumlukisi += ekleneceksayi;
        
        
        
    }
    
    
    
    
}
