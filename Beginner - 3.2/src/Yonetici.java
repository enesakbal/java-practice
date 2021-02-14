
import java.util.Scanner;


public class Yonetici extends Calisanlar{
    
    private int sorumlu_kisi_sayisi;
    private int eleman;
    private String makam;
    
    public Yonetici(String isimString, int maas, String makam,int sorumlu_kisi_sayisi) {
        super(isimString, maas);
        this.makam = makam;
        this.sorumlu_kisi_sayisi = sorumlu_kisi_sayisi;
        
        
    }
    

    @Override
    public void bilgileri_goster() {
        super.bilgileri_goster();
        System.out.println("Sorumlu kisi sayisi : " + sorumlu_kisi_sayisi);
        System.out.println("Makamı : " + makam);
    }
    
    public void eleman_ekle(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Eklenecek eleman sayisi : ");
        sorumlu_kisi_sayisi+=eleman = sc.nextInt();
        
        
        
        
    }
    
    
    
}
