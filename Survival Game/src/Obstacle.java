import java.util.Random;

public class Obstacle {

    private int damage , health , loot , maxNumber;
    private String name;

    public Obstacle(int damage, int health, int loot , String name , int maxNumber) {
        this.damage = damage;
        this.health = health;
        this.loot = loot;
        this.name = name;
        this.maxNumber = maxNumber;
    }

    public int obstacleCount(){
        Random random = new Random();
        maxNumber = random.nextInt(this.maxNumber) + 1;
        return maxNumber;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getLoot() {
        return loot;
    }

    public void setLoot(int loot) {
        this.loot = loot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
