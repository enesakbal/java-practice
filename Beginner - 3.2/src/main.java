
import java.util.Scanner;

public class main {
  
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
int maas, kisisayisi;
Calisanlar calisan1 = new Calisanlar("Mahmut", 3200);
String isim , makam, islem;
    System.out.println("Hoşgeldiniz..");
    System.out.println("**************");
    System.out.println("İşlemler");
    System.out.println("**************");
    System.out.println("1 - Çalışan işlemleri...");
    System.out.println("2 - Yönetici işlemleri...");
    System.out.println("Çıkmak için q'ya basınız.");
    
    while (true) {        
        System.out.print("İşlem :");
        islem = sc.nextLine();
            
        if (islem.equals("q")){
            System.out.println("Programdan Çıkılıyor...");
            break;
        }
        else if (islem.equals("1")){
            System.out.print("Çalışan eklemek ister misiniz ? (y/n)");
            String islem2 = sc.nextLine();
            if (islem2.equals("n")){
                
                System.out.println("Mevcut Çalışanımız\n"
                                 + "********************");
                
                calisan1.bilgileri_goster();
                
            }
            else if (islem2.equals("y")){
                System.out.println("Yeni Çalışan\n"
                                 + "**************");
                System.out.println("İsim : ");
                isim = sc.nextLine();
                System.out.println("Maas : ");
                maas = sc.nextInt();
                if (maas > 4500){
                    System.out.println("Bu kadar bütçemiz yok üzgünüz....");
                    continue;
                }
                else {
                    System.out.println("Hayırlı uğurlu olsun!....");
                    Calisanlar calisan2 = new Calisanlar(isim, maas);
                    calisan1 = calisan2 ;
                    
                }
            }
            
            
        }
        
        else if (islem.equals("2")){
            Yonetici yönetici1 = new Yonetici("Enes", 15000, "Şef", 15);
                
                
            System.out.println("Yönetici işlemleri.....\n"
                                 + "************************");
            System.out.println("İşlemler\n"
                             + "1 - Eleman alımı yap\n"
                             + "2 - Bilgileri göster...\n"
                             + "Çıkmak için q'ya basınız...");
            
            while (true) {
                System.out.print("İşlem:");
                String islem3 = sc.nextLine();
                if (islem3.equals("q")){
                    System.out.println("Ana menüye dönülüyor...");
                    break;
                }
                else if (islem3.equals("1")){
                        System.out.println("Mevcut durum...");
                        yönetici1.bilgileri_goster();
                        
                        System.out.print("Eleman eklemek istiyor musunuz ? (y/n)");
                        String yesno = sc.nextLine();
                        if (yesno.equals("n")){
                            continue;
                        }
                        else if (yesno.equals("y")){
                            yönetici1.eleman_ekle();
                            
                        }
                        else {
                            System.out.println("Yanlış giriş....");
                        }
                      
                        
                    }
                else if (islem3.equals("2")){
                    System.out.println("Mevcud bilgileriniz\n"
                                     + "********************");
                yönetici1.bilgileri_goster();
                }
                    
                }
                
                
                
                
            }
        
        
        
    }






}

   
}
