package model;

import java.util.ArrayList;
import java.util.List;

public class BestelBus<T extends TeLadenVoorwerp> {

    private String naam;
    private int totaalGewicht;
    private int maximumGewicht;
    private List<T> lading;

    public BestelBus(String naam, int maximumGewicht) {
        this.naam = naam;
        this.totaalGewicht = 0;
        this.maximumGewicht = maximumGewicht;
        this.lading = new ArrayList<>();
    }

    public void laadPakket(T voorwerp) {
        if (voorwerp.getGewicht() < 0) {
            System.out.println("Lading heeft verkeerd gewicht.");
            return;
        }
        if (totaalGewicht + voorwerp.getGewicht() > maximumGewicht) {
            System.out.println("Lading kan niet geladen, bus raakt overbelast.");
        } else {
            lading.add(voorwerp);
            totaalGewicht += voorwerp.getGewicht();
        }
    }

    public T zoekZwaarstePakket() {
        if (lading.isEmpty()) {
            return null;
        } else {
            return zoekZwaarstePakket(0);
        }
    }

    private T zoekZwaarstePakket(int index) {
        if (index == lading.size()) {
            return lading.get(index - 1);
        }
        T zwaarste = zoekZwaarstePakket(index + 1);
        if (lading.get(index).getGewicht() >
                zwaarste.getGewicht()) {
            return lading.get(index);
        } else {
            return zwaarste;
        }
    }


    public List<T> getLading() {
        return lading;
    }

    public int getTotaalGewicht() {
        return totaalGewicht;
    }

}