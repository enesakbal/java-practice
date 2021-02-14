
public class Idman {
    
    private int number_of_burpees;
    private int number_of_pushups;
    private int number_of_situps;
    private int number_of_squats;

    public Idman(int number_of_burpees, int number_of_pushups, int number_of_situps, int number_of_squats) {
        this.number_of_burpees = number_of_burpees;
        this.number_of_pushups = number_of_pushups;
        this.number_of_situps = number_of_situps;
        this.number_of_squats = number_of_squats;
    }

    public int getNumber_of_burpees() {
        return number_of_burpees;
    }

    public void setNumber_of_burpees(int number_of_burpees) {
        this.number_of_burpees = number_of_burpees;
    }

    public int getNumber_of_pushups() {
        return number_of_pushups;
    }

    public void setNumber_of_pushups(int number_of_pushups) {
        this.number_of_pushups = number_of_pushups;
    }

    public int getNumber_of_situps() {
        return number_of_situps;
    }

    public void setNumber_of_situps(int number_of_situps) {
        this.number_of_situps = number_of_situps;
    }

    public int getNumber_of_squats() {
        return number_of_squats;
    }

    public void setNumber_of_squats(int number_of_squats) {
        this.number_of_squats = number_of_squats;
    }

    public void do_burpee(int number){
        if (number_of_burpees==0)
            System.out.println("Burpee hareketi bitti.");
        else if (number_of_burpees - number < 0 ){
            System.out.println("Hedefi geçtin ! Tebrikler...");
            number_of_burpees=0;
        }
        
        else {
            number_of_burpees-=number;
            System.out.println("Kalan burpee :" + (number_of_burpees));
        }
            
    }
    
    public void do_pushups(int number){
        if (number_of_pushups==0)
            System.out.println("Pushups hareketi bitti.");
        else if (number_of_pushups - number < 0 ){
            System.out.println("Hedefi geçtin ! Tebrikler...");
            number_of_pushups=0;
        }
        
        else {
            number_of_pushups-=number;
            System.out.println("Kalan Pushups :" + number_of_pushups);
        }
            
    }
        
     public void do_situps(int number){
        if (number_of_situps==0)
            System.out.println("Situps hareketi bitti.");
        else if (number_of_situps - number < 0 ){
            System.out.println("Hedefi geçtin ! Tebrikler...");
            number_of_situps=0;
        }
        
        else {
            number_of_situps-=number;
            System.out.println("Kalan Situps :" + number_of_situps);
        }
            
    }    
     
     
     public void do_squats(int number){
        if (number_of_squats==0)
            System.out.println("Squats hareketi bitti.");
        else if (number_of_squats - number < 0 ){
            System.out.println("Hedefi geçtin ! Tebrikler...");
            number_of_squats=0;
        }
        
        else {
            number_of_squats-=number;
            System.out.println("Kalan Squats :" + number_of_squats);
        }
            
    }
    
     
    
    public void do_it(String kind_of_moves , int number){
        
        if (kind_of_moves.equals("Burpee")){
            do_burpee(number);
        }
        
        else if (kind_of_moves.equals("Pushup")){
            do_pushups(number);
        }
        
        else if (kind_of_moves.equals("Situp")){
            do_situps(number);
        }
        
        else if (kind_of_moves.equals("Squat")){
            do_squats(number);
        }
        
        else
            System.out.println("Geçersiz Hareket...");
        
        
        
    }
    
    public boolean Finish(){
        
    return number_of_burpees==0 && number_of_pushups==0 && number_of_situps==0 && number_of_squats==0 ;
        
        
    }
    
    
    
}
