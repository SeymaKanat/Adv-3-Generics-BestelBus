package model;

import java.util.ArrayList;
import java.util.List;

public class BestelBus <T extends  Weegbaar> {

    private String naam;
    private int totaalGewicht;
    private int maximumGewicht;
    private List<Pakket> lading;

    public BestelBus(String naam, int maximumGewicht) {
        this.naam = naam;
        this.totaalGewicht = 0;
        this.maximumGewicht = maximumGewicht;
        this.lading = new ArrayList<>();
    }

    public void laadPakket(Pakket pakket) {
        if (pakket.getGewicht() >= 0 && (totaalGewicht + pakket.getGewicht()) <= maximumGewicht) {
            lading.add(pakket);
            totaalGewicht += pakket.getGewicht();
        }
    }


    public List<Pakket> getLading() {
        return lading;
    }

    public int getTotaalGewicht() {
        return totaalGewicht;
    }

    public Pakket zoekZwaarstePakket() { // returns the heaviest package from a list of packages
        if (lading.isEmpty()) {
            return null; // Geen pakketten in de bus
        }
        Pakket zwaarstaPakket = lading.get(0);
        for (Pakket pakket : lading) {
            if (pakket.getGewicht() > zwaarstaPakket.getGewicht()) {
                zwaarstaPakket = pakket;
            }

        }
        return zwaarstaPakket;
    }


}
