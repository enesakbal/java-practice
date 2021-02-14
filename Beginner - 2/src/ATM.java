
import java.util.Scanner;


public class ATM {
    
    public void Run(Account hesap1){
        Scanner sc = new Scanner(System.in);
        Login yabanci = new Login();
        
        if (yabanci.login(hesap1)){
            System.out.println("BASARILI...");
        }
        else{
            System.out.println("Giris Basarisiz....");
            return;
        }
        
        System.out.println("******************\n\nBankamıza Hosgeldiniz\n\n****************");
        System.out.println("Islemler :\n1-Bakiye Sorgula\n2-Para Cekme\n3- Para Yatirma\nCıkmak icin q ya basın..");
        
        while (true) {   
            System.out.print("Islem :");
            String islem = sc.nextLine();
            
            if (islem.equals("q"))
                break;
            
            else{
            
                if (islem.equals("1")){
                    System.out.println("Toplam Bakiye :" + hesap1.getBalance());
                    
                }
                else if (islem.equals("2")){
                    System.out.print("Cekmek istediginiz tutar :");
                    hesap1.RemoveMoney(sc.nextInt());
                    sc.nextLine();

                }
                else if (islem.equals("3")){
                    System.out.print("Yatirmak istediğiniz tutar :");
                    hesap1.AddMoney(sc.nextInt());
                    sc.nextLine();

                    
                }
                else {
                    System.out.println("Yanlis giris yaptiniz..");
                }
            
            
            
            
            
            
            
            
            }
            
            
            
        }
            
            
            
            
            
        
        
      
                
                
       }
                
                
                
}               
        
        
        

    
    
    
    
