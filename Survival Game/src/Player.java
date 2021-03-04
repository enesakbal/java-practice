import java.util.Scanner;

public class Player {
    Inventory inventory = new Inventory();
    private final String playerName;
    private String charName;
    private int health , damage , money , realHealth;
    Scanner scanner = new Scanner(System.in);

    public Player(String playerName) {
        this.playerName = playerName;
    }

    public void selectChar(){

        switch (showChar()) {
            case 1 -> createChar("Samurai", 5, 21, 15);
            case 2 -> createChar("Archer", 7, 18, 20);
            case 3 -> createChar("Knight", 8, 24, 5);
            default -> createChar("Knight", 8, 24, 5);
        }
        charInfo();

    }

    public void charInfo(){
        System.out.println("Your Character is " + getCharName());
        System.out.println("DAMAGE : " +getDamage()+"\nHEALTH :" + getHealth() + "\nMoney :" + getMoney());

    }




    public int showChar(){
        System.out.println("Welcome to Survival Game " + playerName);
        System.out.println("1 - Samurai  \t Damage : 5 \t Health : 21 \t Money : 15");
        System.out.println("2 - Archer  \t Damage : 7 \t Health : 18 \t Money : 20");
        System.out.println("3 - Knight  \t Damage : 8 \t Health : 24 \t Money : 5");
        int choice;
        System.out.print("Your Choice :");
        choice = scanner.nextInt();
        while ((choice < 1 || choice > 3)){
            System.out.println("Wrong Choice. Try again...");
            choice = scanner.nextInt();
        }
        return choice;

    }

    public void createChar(String name , int dmg , int health , int money){

            setCharName(name);
            setDamage(dmg);
            setHealth(health);
            setMoney(money);
            setRealHealth(health);

    }

    public int getTotalDamage(){
        return getDamage() + getInventory().getDamage();
    }

    public int getRealHealth() {
        return realHealth;
    }

    public void setRealHealth(int realHealth) {
        this.realHealth = realHealth;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public String getCharName() {
        return charName;
    }

    public void setCharName(String charName) {
        this.charName = charName;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }
}
