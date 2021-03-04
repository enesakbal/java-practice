

public abstract class BattleLocation extends Location {

    Obstacle obstacle;
    String award;
    static int items = 0;
    public BattleLocation(Player player , String name , Obstacle obstacle , String award) {
        super(player);
        this.name = name;
        this.obstacle = obstacle;
        this.award = award;
    }

    @Override
    public boolean getLocation() {
        int obsCount = obstacle.obstacleCount();
        System.out.println("You are in " + this.getName() +" now.");
        System.out.println("Be careful There are " + obsCount + " " + obstacle.getName() + " here");
        System.out.print("<F>ight or <R>un :" );
        String choice = scanner.nextLine();
        if (choice.equals("F") || choice.equals("f")){
            boolean temp = combat(obsCount);
            if(temp){
                System.out.println("You destroyed all enemies !");
                end(this.award);
                System.out.println("Your awards : " + (obstacle.getLoot()*obsCount));
                player.setMoney(player.getMoney() + (obstacle.getLoot() * obsCount));
                return true;
            }
            else {
                if (player.getHealth() <=0){
                    System.out.println("Game Over...");
                    System.out.println("You Dead...");
                    return false;
                }
                else {
                    return true;
                }

            }
        }

        return true;
    }

    public boolean combat(int obscount){
        int reObstacle = obstacle.getHealth();
        for (int i = 0 ; i < obscount ; i++){
            playerStats(this.player);
            obstacleStats(this.obstacle);
            while (obstacle.getHealth() > 0 && player.getHealth() >0){

                System.out.println("<H>it or <E>scape");
                String choice = scanner.nextLine();
                if (choice.equals("H")){


                    obstacle.setHealth(obstacle.getHealth() -player.getTotalDamage());
                    if (player.getInventory().getArmor() < obstacle.getDamage()){
                        player.setHealth(player.getHealth() + player.getInventory().getArmor() - obstacle.getDamage());
                    }
                    afterHit();
                    if (obstacle.getHealth() <= 0){
                        obstacle.setHealth(reObstacle);
                        break;
                    }
                    else if (player.getHealth() <= 0){
                        return false;
                    }


                }
                else if (choice.equals("E")){
                    System.out.println("You ran away from the " + obstacle.getName());
                    return false;
                }

            }

        }

        return true;
    }

    public void playerStats(Player player){
        System.out.println("***************************************");
        System.out.println("Player Info");
        System.out.println("Damage : " + player.getDamage());
        System.out.println("Health : " + player.getHealth());
        System.out.println("Weapon : " + player.getInventory().getWeaponName());
        System.out.println("Armor  : " + player.getInventory().getArmorName());
    }
    public void obstacleStats(Obstacle obstacle){
        System.out.println("***************************************");
        System.out.println("Obstacle Info");
        System.out.println("Obstacle Kind : " + obstacle.getName());
        System.out.println("Damage : " + obstacle.getDamage());
        System.out.println("Health : " + obstacle.getHealth());

    }
    public void afterHit(){
        System.out.println("Health of Player : " + player.getHealth());
        System.out.println("Health of " + obstacle.getName() + " : " + obstacle.getHealth());

    }
    public void end(String award){

        if (award.equals("Food") && !player.getInventory().isFood()){
            player.getInventory().setFood(true);
            System.out.println("You gained Food ");
            items++;
        }
        else if (award.equals("Water") && !player.getInventory().isWater()){
            player.getInventory().setWater(true);
            System.out.println("You gained Water");
            items++;
        }
        else if (award.equals("Firewood") && !player.getInventory().isFirewood()){
            player.getInventory().setFirewood(true);
            System.out.println("You gained Firewood ");
            items++;
        }
        if (items < 4 ){
            System.out.println("Main items : " + items + "/3");
        }


    }

}

