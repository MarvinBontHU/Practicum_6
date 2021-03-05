package practicum6A;
import java.time.LocalDate;


public class Game {
    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rJ, double nwpr){
        naam = nm;
        releaseJaar = rJ;
        nieuwprijs = nwpr;
    }

    public String getNaam(){
        return naam;
    }

    public double huidigeWaarde(){
        int keer = LocalDate.now().getYear() - releaseJaar;
        double huidig = nieuwprijs;
        double korting = 30;

        if(keer != 0){
            while (keer != 0){
                huidig = (huidig - ((huidig /100) * korting));
                keer = keer -1;
            }
            return huidig;

        }
        return nieuwprijs;
    }

    public boolean equals(Object andereObject){
        boolean gelijkeObjecten = false;

        if (andereObject instanceof Game){
            Game andereGame = (Game) andereObject;

            if (this.naam.equals(andereGame.naam) &&
                    this.releaseJaar == andereGame.releaseJaar) {
                gelijkeObjecten = true;
            }
        }
        return gelijkeObjecten;
    }

    public String toString(){
        return naam + ", uitgegeven in " + releaseJaar + "; nieuwprijs: €" + String.format("%.2f",nieuwprijs) + " nu voor €" + String.format("%.2f", huidigeWaarde());
    }

}
