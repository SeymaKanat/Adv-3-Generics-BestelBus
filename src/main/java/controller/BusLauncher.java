package controller;

import model.Pakket;
import model.PakketLezer;
import model.BestelBus;

import java.util.List;

public class BusLauncher {

    public static void main(String[] args) {
        BestelBus kuBus = new BestelBus("rode bus", 170);
        List<Pakket> lijstVanBestand;
        PakketLezer lezerBestand = new PakketLezer();
        lijstVanBestand = lezerBestand.leesPakketLijst("src/main/resources/pakketlijst.txt");
        System.out.println(lijstVanBestand);
        for (Pakket p : lijstVanBestand) {
            kuBus.laadPakket(p);
        }
        System.out.println(kuBus.zoekZwaarstePakket());

        BestelBus<Pakket> kwiBus = new BestelBus<>("blue bus", 160);
        for (Pakket p : lijstVanBestand) {
            kwiBus.laadPakket(p);
        }
        System.out.println(kwiBus.zoekZwaarstePakket());


    }
}