public class SafeHouse extends NormalLocaction{

    public SafeHouse(Player player) {
        super(player, "Safe House");
    }

    @Override
    public boolean getLocation() {
        player.setHealth(player.getRealHealth());
        System.out.println("You Healed");
        return true;
    }
}
