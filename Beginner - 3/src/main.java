
import java.util.Scanner;

public class main {
  
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
String ad , departman;
int maas;



    System.out.print("AD :");
    ad = sc.nextLine();
    
    System.out.print("MAAS :");
    maas = sc.nextInt();
    sc.nextLine();
    System.out.print("DEPARTMAN :");
    departman = sc.nextLine();
    
    
    
    Yonetici mudur = new Yonetici(ad, maas, departman);
    
    System.out.println("Zam istiyor musunuz ? (y/n)");
    char yesno=sc.next().charAt(0);
        
    if (yesno == 'n'){
        System.out.println("Iyi calismalar....");
    }
    
    else {
           
    mudur.zam_yap();

    System.out.println("YENİ CALISAN BİLGİLERİ");
    System.out.println("**********************");

    mudur.bilgileri_goster(); 
    
        System.out.print("Extra eleman lazim mi = (y/n)");
        yesno = sc.next().charAt(0);
        
        if (yesno == 'n'){
            System.out.println("Iyı gunler...");
        }
        
        else {
            System.out.print("Gerekli kisi sayisi :");
            mudur.sorumlu_arttir(sc.nextInt());
            
                System.out.println("YENİ CALISAN BİLGİLERİ");
                System.out.println("**********************");

                mudur.bilgileri_goster(); 
            
        }
        
        
    }

    


}

   
}
