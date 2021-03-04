
public class Store extends NormalLocaction {


    public Store(Player player) {
        super(player, "You're in Store");
    }

    @Override
    public boolean getLocation() {
        System.out.println("***************************************");
        System.out.println("Welcome to Store...");
        System.out.println("You can buy weapons and armors in this place");
        System.out.println("Your Current money :" + player.getMoney());

        System.out.println("1 - Weapons");
        System.out.println("2 - Armors");
        System.out.println("3 - Quit");
        System.out.print("Choice :");
        int choice = scanner.nextInt();

        while (choice > 3 || choice < 1) {
            System.out.println("Wrong Choice...");
            System.out.print("Choice :");
            choice = scanner.nextInt();
        }

        switch (choice){
            case 1 :
                buyWeapon(weaponsMenu());
                break;
            case 2 :
                buyArmor(armorsMenu());
                break;
            case 3 :
                break;

        }
        System.out.println("Current Money :" + player.getMoney());



        return true;
    }

    public int armorsMenu(){
        System.out.println("***************************************");
        System.out.println("1 - Light Armor \tBlock : 1\tPrice : 15");
        System.out.println("2 - Medium Armor \tBlock : 3\tPrice : 25");
        System.out.println("3 - Heavy Armor \tBlock : 5\tPrice : 40");
        System.out.println("4 - Exit");
        System.out.print("Your Choice :");
        int choice = scanner.nextInt();
        while (choice > 3 ||choice < 1){
            System.out.println("Wrong Choice");
            System.out.print("Your Choice :");
            choice = scanner.nextInt();
        }
        return choice;
    }


    public void buyArmor(int armorID){
        int block = 0 , price = 0;
        String armorName = null;
        switch (armorID) {
            case 1 -> {
                block = 1;
                price = 15;
                armorName = "Light Armor";
            }
            case 2 -> {
                block = 3;
                price = 25;
                armorName = "Medium Armor";
            }
            case 3 -> {
                block = 5;
                price = 40;
                armorName = "Heavy Armor";
            }
            case 4 -> System.out.println("Exiting...");
            default -> System.out.println("Wrong Choice...");
        }
        if (player.getMoney() >= price){
            System.out.println("OLD ARMOR :" + player.getInventory().getArmor());
            player.getInventory().setArmorName(armorName);
            player.getInventory().setArmor(block);
            player.setMoney(player.getMoney() - price);
            System.out.println("You bought an armor !");
            System.out.println("CURRENT ARMOR :" + (player.getInventory().getArmor()));

        }else {
            System.out.println("Insufficient money...");
        }




    }



    public int weaponsMenu() {
        System.out.println("***************************************");
        System.out.println("1 - Pistol\tDamage : +2\tPrice : 25");
        System.out.println("2 - Sword\tDamage : +3\tPrice : 35");
        System.out.println("3 - Rifle\tDamage : +7\tPrice : 45");
        System.out.println("4 - Exit");

        System.out.print("Your Choice :");
        int choice = scanner.nextInt();
        while (choice > 3 ||choice < 1){
            System.out.println("Wrong Choice");
            System.out.print("Your Choice :");
            choice = scanner.nextInt();
        }
        return choice;
    }

    public void buyWeapon(int weaponID){
        int damage = 0 , price = 0;
        String weaponName = null;
        switch (weaponID) {
            case 1 -> {
                damage = 2;
                price = 5;
                weaponName = "Pistol";
            }
            case 2 -> {
                damage = 3;
                price = 35;
                weaponName = "Sword";
            }
            case 3 -> {
                damage = 7;
                price = 45;
                weaponName = "Rifle";
            }
            case 4 -> System.out.println("Exiting...");
            default -> System.out.println("Wrong Choice...");
        }
            if (player.getMoney() >= price){
                    player.getInventory().setDamage(damage);
                    player.getInventory().setWeaponName(weaponName);
                    player.setMoney(player.getMoney() - price);
                System.out.println("You bought a weapon !");
                System.out.println("OLD DAMAGE :" + player.getTotalDamage());
                System.out.println("CURRENT DAMAGE :" + (player.getDamage() + player.getInventory().getDamage()));

            }else {
                System.out.println("Insufficient money...");
            }




    }




}