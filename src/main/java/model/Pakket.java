package model;

public class Pakket  implements  TeLadenVoorwerp{

    private String naamVanKind;
    private String cadeau;
    private int gewicht;

    public Pakket(String naamVanKind, String cadeau, int gewicht) {
        this.naamVanKind = naamVanKind;
        this.cadeau = cadeau;
        this.gewicht = gewicht;
    }

    @Override
    public int getGewicht() {
        return gewicht;
    }

    @Override
    public String toString() {
        return String.format("{Kind: %s; cadeau: %s; gewicht: %d}", naamVanKind, cadeau, gewicht);
    }


}