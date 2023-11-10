/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.bachlor.client;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import com.mycompany.bachlor.entity.Clients;
import java.util.Scanner;
import com.mycompany.bachlor.entity.Carte;

/**
 *
 * @author lml
 */
public class Test {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        List<Carte> jeuDeCartes = Carte.genererCartes();
        Collections.shuffle(jeuDeCartes);
        int[] scores = new int[2];

        List<Carte> jeuDeCartesP1 = new ArrayList<>();
        List<Carte> jeuDeCartesP2 = new ArrayList<>();
        Clients a;
        Clients b;

        System.out.println("Joueur 1 : ");
        String joueur1 = scanner.next();
        a = new Clients(joueur1);
        System.out.println("Joueur 2 : ");
        String joueur2 = scanner.next();
        b = new Clients(joueur2);

        
        for (int i = 0; i < jeuDeCartes.size(); i++) {
            if (i % 2 == 0) {
                jeuDeCartesP1.add(jeuDeCartes.get(i));
            } else {
                jeuDeCartesP2.add(jeuDeCartes.get(i));
            }
        }

        for (int i = 0; i < jeuDeCartesP1.size(); i++) {
            Carte carteP1 = jeuDeCartesP1.get(i);
            Carte carteP2 = jeuDeCartesP2.get(i);

            System.out.println(a.getNom() + " a " + carteP1.getValeur() + " de " + carteP1.getCouleur());
            System.out.println(b.getNom() + " a " + carteP2.getValeur() + " de " + carteP2.getCouleur());

            comparerCartes(carteP1, carteP2, a, b, scores);
        }

        System.out.println("Score final :");
        System.out.println(a.getNom() + " : " + scores[0]);
        System.out.println(b.getNom() + " : " + scores[1]);
        
        if(scores[0]> scores[1]){
            System.out.println(a.getNom() + " Gagne cette partie");
        }else if(scores[0]< scores[1]){
            System.out.println(b.getNom() + " Gagne cette partie");
        }else{
            System.out.println("Egalite parfaite");
        }
    }

    private static void comparerCartes(Carte carte1, Carte carte2, Clients joueur1, Clients joueur2, int[] scores) {
        String[] valeurs = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};

        int indiceCarte1 = Arrays.asList(valeurs).indexOf(carte1.getValeur());
        int indiceCarte2 = Arrays.asList(valeurs).indexOf(carte2.getValeur());

        if (indiceCarte1 > indiceCarte2) {
            scores[0]++;
            System.out.println(joueur1.getNom() + " gagne la manche ! et a un score de : " + scores[0]);
        } else if (indiceCarte1 < indiceCarte2) {
            scores[1]++;
            System.out.println(joueur2.getNom() + " gagne la manche ! et a un score de : " + scores[1]);
        } else {
            System.out.println("Égalité dans la manche.");
        }
    }
}
