public class Account {
    
    private String Username;
    private String Password;
    private int Balance;

    public Account(String Username, String Password, int Balance) {
        this.Username = Username;
        this.Password = Password;
        this.Balance = Balance;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public int getBalance() {
        return Balance;
    }

    public void setBalance(int Balance) {
        this.Balance = Balance;
    }
    
    public void CurrentBalance(int Balance){
        this.Balance=Balance;
        
    }
    
    public void AddMoney(int sum){
        Balance+=sum;
        System.out.println("Current balance : " + Balance );
    }
    
    
    public void RemoveMoney(int sum){
        int max=Balance-sum;
        Balance = max>=0 ? max : Balance ;
        if (max < 0)
            System.out.println("insufficient balance..\nCurrent balance :"+Balance);
        else{
            
            System.out.println("Current Balance :"+Balance);
        }
            
    }
    
    
     
    
    
     
    
    
    
    
    
    
}
