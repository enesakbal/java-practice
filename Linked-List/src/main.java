
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;


public class main {
    
    private static LinkedList<String> Cities = new LinkedList<String>();
    
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       
        
        
        Cities.add("Edirne");
        Cities.add("Istanbul");
        Cities.add("Ankara");
        Cities.add("Malatya");
        Cities.add("Sivas");
        Cities.add("Trabzon");
        Cities.add("Kars");
        Cities.add("Manisa");
        Cities.add("Izmir");
        Cities.add("Antalya");
        
        // 10 adet girdi girdim.
        
        Show_Cities(Cities);
        
        Turkey_tour();
        
    }
    
    public static void Show_Cities(LinkedList<String> cities){
        
        /*for (String a : cities ){
            
            System.out.println(a);
            
        }*/
        
        ListIterator<String> Iterator = Cities.listIterator();
        int i = 1;
        while (Iterator.hasNext()) {            
            
            System.out.println(i+ ". Şehir :" + Iterator.next());
            i++;
            
            
        }
        System.err.println("");
        
        
        
        
    }
    
   
    
    
    
    
    
    
    
    public static void Turkey_tour(){
        Scanner sc = new Scanner(System.in);
        int opr;
        boolean quit = true , change = true;
        String city;
        ListIterator<String> iterator = Cities.listIterator();
        System.out.println("Turumuza hoş geldiniz !");
        System.out.println("Şehirlerimiz\n"
                         + "*************");
        Show_Cities(Cities);
                   System.out.println("Işlemlerimiz\n"
                             + "**************\n"
                             + "1 - Işlemleri görüntüle\n"
                             + "2 - Sonraki şehre git\n"
                             + "3 - Önceki şehre dön\n"
                             + "4 - Turu sonlandır\n");
        
        
      
        while (quit) {            
 
            
            System.out.print("Işlem :");
            opr = sc.nextInt();
            
            switch(opr){
                
                case 1 :
                    break;
                    
                
                case 2 :
                    if (!change){
                        if (iterator.hasNext()){
                         iterator.next();   
                        }
                    change = true;    
                    }
                    
                    
                    if (iterator.hasNext())                         
                        System.out.println("Sonraki şehir :" + iterator.next());
                        
                       
                    
                    else
                        System.out.println("Gidilecek şehir kalmadı...");

                        
                    break;
                case 3 :
                    if (change){
                        if (iterator.hasPrevious()){
                            iterator.previous();
                        }
                    change = false;
                    }
                    
                    if (iterator.hasPrevious())
                        System.out.println("Geri dönülen şehir:" + iterator.previous());
                    else
                        System.out.println("Geri dönülemez....");
                       
                    
                    
                    
                    break;
                case 4 :
                    System.out.println("Turumuz bitmiştir yine bekleriz ! ");
                    quit = false;
                    break;
                    
                default:
                    System.err.println("YANLIŞ GİRİŞ YAPTINIZ....");
                    continue;
                    
            }
            
            
            
            
            
            
            
            
        }
        
        
        
        
        
    }
    
    
    
    
}

