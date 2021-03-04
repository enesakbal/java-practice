public abstract class NormalLocaction extends Location {

    public NormalLocaction(Player player , String name) {
        super(player);
        this.name = name;
    }

    @Override
    public boolean getLocation() {
        return true;
    }
}
