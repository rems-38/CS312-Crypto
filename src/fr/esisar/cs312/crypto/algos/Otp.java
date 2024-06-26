package fr.esisar.cs312.crypto.algos;

import fr.esisar.cs312.crypto.Algo;
import fr.esisar.cs312.crypto.InvalidKey;

public class Otp implements Algo {
    private String key;

    // Constructeur avec une clé par défaut vide
    public Otp() {
        this.key = "";
    }

    @Override
    public String encrypt(String text) {
        return vernam(text, 1);
    }

    @Override
    public String decrypt(String text) {
        return vernam(text, -1);
    }

    @Override
    public void setKey(String key, int textLength) throws InvalidKey {
        if (key.length() < textLength) {
            throw new InvalidKey("Invalid key (must be at least as long as the plaintext)");
        }
        this.key = key;
    }

    // Chiffrement de Vernam
    private String vernam(String text, int neg) {
        StringBuilder sb = new StringBuilder();
        System.out.println("key: " + this.key);
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            char d = this.key.charAt(i);
            
            if (d >= 'a' && d <= 'z') { d = (char) (d - 'a' + 'A'); }
            else if (d >= 'A' && d <= 'Z') { d = (char) (d - 'A'); }
            
            if (c >= 'A' && c <= 'Z') { sb.append((char) ((c - 'A' + neg * d) % 26 + 'A')); }
            else if (c >= 'a' && c <= 'z') { sb.append((char) ((c - 'a' + neg * d) % 26 + 'a'));}
            else { sb.append(c); }
        }
        return sb.toString();
    }
}