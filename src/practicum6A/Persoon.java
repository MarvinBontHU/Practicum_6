package practicum6A;

import java.util.ArrayList;

public class Persoon {
    private String naam;
    private double budget;
    private ArrayList<Game> games = new ArrayList<>();

    public Persoon(String nm, double bud){
        naam = nm;
        budget = bud;
    }

    public double getBudget(){
        return budget;
    }

    public boolean koop(Game g){
        if (games.contains(g)) {
            return false;
        }

        if (getBudget() >= g.huidigeWaarde()) {
            budget = budget - g.huidigeWaarde();
            games.add(g);
            return true;
        }
        return false;
    }

    public boolean verkoop(Game g, Persoon koper){
        if (games.contains(g)){
            if (!koper.games.contains(g) &&
            koper.getBudget() >= g.huidigeWaarde()){
                koper.budget = koper.budget - g.huidigeWaarde();
                budget = budget + g.huidigeWaarde();
                games.remove(g);
                koper.games.add(g);
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String nwString = "";
        for(int i = 0; i < games.size(); i++) {
            nwString += (games.get(i) + "\n").toString();
        }
        return naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:" + "\n" + nwString;
    }
}
