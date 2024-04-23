package fr.esisar.cs312.crypto.algos;

import fr.esisar.cs312.crypto.Algo;
import fr.esisar.cs312.crypto.InvalidKey;

public class Rot13 implements Algo {

    // Pas de constructeur car on n'a pas besoin de stocker de données

    @Override
    public String encrypt(String text) {
        return rot13(text);
    }

    @Override
    public String decrypt(String text) {
        return rot13(text);
    }

    @Override
    // On ne fait rien car on n'a pas besoin de clé mais elle doit être implémentée pour l'instanciation de la classe
    public void setKey(String key, int textLength) throws InvalidKey {}

    // Chiffrement de César avec un décalage de 13
    private String rot13(String text) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M')) { c += 13; }
            else if ((c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z')) { c -= 13; }
            sb.append(c);
        }
        return sb.toString();
    }

}