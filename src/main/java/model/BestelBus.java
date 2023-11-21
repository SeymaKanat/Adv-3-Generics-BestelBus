package model;

import java.util.ArrayList;
import java.util.List;

public class BestelBus <L extends  Weegbaar> {

    private String naam;
    private int totaalGewicht;
    private int maximumGewicht;
    private List<L> lading;

    public BestelBus(String naam, int maximumGewicht) {
        this.naam = naam;
        this.totaalGewicht = 0;
        this.maximumGewicht = maximumGewicht;
        this.lading = new ArrayList<>();
    }

    public void laadVoorwerp(L voorwerp) {
     if (voorwerp.getGewicht() < 0) {
         System.out.println("Voorwerp heeft verkeerd gewicht.");
         return;
     }
     if (totaalGewicht + voorwerp.getGewicht() > maximumGewicht) {
         System.out.println("Voorwerp kan niet geladen, bus raakt overbelast.");
     } else {
         lading.add(voorwerp);
         totaalGewicht += voorwerp.getGewicht();
     }
    }

    private L zoekZwaarstePakket(int index) {
        if (index == lading.size()) {
            return lading.get(index - 1);
        }
        L zwaarste = zoekZwaarstePakket(index + 1);
        if (lading.get(index).getGewicht() >
                zwaarste.getGewicht()) {
            return lading.get(index);
        } else {
            return zwaarste;
        }
    }

    public List<L> getLading() {
        return lading;
    }

    public int getTotaalGewicht() {
        return totaalGewicht;
    }
}
