package fr.esisar.cs312.crypto.algos;

import java.util.Map;

import fr.esisar.cs312.crypto.Algo;
import fr.esisar.cs312.crypto.InvalidKey;

import java.util.HashMap;

public class Sub implements Algo {
    private Map<Character, Character> subTab = new HashMap<>();
    private final String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    // Constructeur avec un tableau de substitution par défaut (l'alphabet dans l'ordre inverse)
    public Sub() {
        int max = alpha.length() - 1;
        for (int i = 0; i < max+1; i++) {
            this.subTab.put(alpha.charAt(i), alpha.charAt(max - i));
        }
    }

    // Fonction efficace (l'autre étant juste là pour l'instanciation de la classe)
    public void setKey(String key) throws InvalidKey {
        if (key.length() != 26 && key.length() != 52) {
            throw new InvalidKey("Invalid key (length must be 26 or 52)");
        }
        for (int i = 0; i < key.length(); i++) {
            this.subTab.put(alpha.charAt(i), key.charAt(i));
        }
    }

    @Override
    public String encrypt(String text) {
        return substitute(text, this.subTab);
    }
    
    @Override
    public String decrypt(String text) {
        return substitute(text, invert());
    }

    @Override
    // Dans notre cas la fonction a instancier ne dépend pas de la longueur du texte donc on appelle une autre fonction 
    public void setKey(String key, int textLength) throws InvalidKey {
        setKey(key);
    }

    // Inversion du tableau (utile pour le déchiffremment)
    private Map<Character, Character> invert() {
        Map<Character, Character> invMap = new HashMap<>();
        for (Map.Entry<Character, Character> entry : this.subTab.entrySet()) {
            invMap.put(entry.getValue(), entry.getKey());
        }
        return invMap;
    }

    // Substitution du texte
    private String substitute(String text, Map<Character, Character> map) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (map.containsKey(c)) { c = map.get(c); }
            sb.append(c);
        }
        return sb.toString();
    }
}