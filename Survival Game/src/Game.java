import java.util.Scanner;

public class Game {

    Scanner scanner = new Scanner(System.in);
    Player player;
    Location location;

    public void run(){
        login();
        player.selectChar();
        int selc;
        while (true){

            System.out.println();
            System.out.println("***************************************");
            System.out.println("1 - Safe Home");
            System.out.println("2 - Cave");
            System.out.println("3 - Forest");
            System.out.println("4 - River");
            System.out.println("5 - Store");

            System.out.print("Where you want to go : ");
            selc = scanner.nextInt();
            while (selc > 5 || selc < 1){
                System.out.println("Wrong Choice");
                System.out.print("Where you want to go : ");
                selc = scanner.nextInt();
            }

            switch (selc) {
                case 1 -> location = new SafeHouse(player);
                case 2 -> location = new Cave(player);
                case 3 -> location = new Forest(player);
                case 4 -> location = new River(player);
                case 5 -> location = new Store(player);
                default -> location = new SafeHouse(player);
            }
            location.getLocation();
            if (player.getInventory().isWater() && player.getInventory().isFirewood() && player.getInventory().isFood()){
                System.out.println("You win the game...");
                break;
            }


        }


    }

    public void login(){

        System.out.print("Your Name :");
        String playerName = scanner.nextLine();
        player = new Player(playerName);


    }






}
