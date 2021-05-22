import java.util.LinkedList;

public class Piece {

    int xp;
    int yp;
    int x;
    int y;
    boolean isWhite;
    String name;
    LinkedList<Piece> ps;

    public Piece(int xp, int yp, boolean isWhite, String name, LinkedList<Piece> ps) {
        this.xp = xp;
        this.yp = yp;
        x = xp * 64;
        y = yp * 64;
        this.isWhite = isWhite;
        this.name = name;
        this.ps = ps;
        ps.add(this);

    }

    public void move(int xp, int yp) {


        if (Main.getPiece(xp * 64, yp * 64) != null) {


            if (Main.getPiece(xp * 64, yp * 64).isWhite != Main.selectedPiece.isWhite) {
                Main.getPiece(xp * 64, yp * 64).kill();

            } else {
                comeBack();
                return;
            }


        }
        carryPiece(xp, yp);

    }








public void comeBack(){
    x = this.xp * 64;
    y = this.yp * 64;
}
public void carryPiece(int xp , int yp){
    this.xp = xp;
    this.yp = yp;
    x = xp * 64;
    y = yp * 64;


}


    public void kill(){
        ps.remove(this);
    }





}
