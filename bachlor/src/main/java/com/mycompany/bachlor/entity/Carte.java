/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mycompany.bachlor.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lml
 */
public class Carte implements Serializable {
    private String valeur;
    private String couleur;

    public Carte(String valeur, String couleur) {
        this.valeur = valeur;
        this.couleur = couleur;
    }

    public String getValeur() {
        return valeur;
    }

    public String getCouleur() {
        return couleur;
    }

    public static List<Carte> genererCartes() {
        List<Carte> jeuDeCartes = new ArrayList<>();
        String[] valeurs = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Dame", "Roi", "As"};
        String[] couleurs = {"Coeur", "Carreau", "Trèfle", "Pique"};

        for (String couleur : couleurs) {
            for (String valeur : valeurs) {
                Carte carte = new Carte(valeur, couleur);
                jeuDeCartes.add(carte);
            }
        }

        return jeuDeCartes;
    }
    
    public static List<Carte> joueur1() {
        List<Carte> deck1 = new ArrayList<>();

        return deck1;
    }
    

}
