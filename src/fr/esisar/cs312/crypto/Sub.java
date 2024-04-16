package fr.esisar.cs312.crypto;

import java.util.Map;
import java.util.HashMap;

public class Sub implements Algo {
    private Map<Character, Character> subTab = new HashMap<>();
    private String alpha = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public Sub(Map<Character, Character> key) {
        this.subTab = key;
    }

    public Sub(String key) throws IllegalArgumentException {
        if (key.length() != 26 && key.length() != 52) {
            throw new IllegalArgumentException("Key length not valid (must be 26 or 52)");
        }
        for (int i = 0; i < key.length(); i++) {
            this.subTab.put(alpha.charAt(i), key.charAt(i));
        }
    }

    public Sub() {
        int max = alpha.length() - 1;
        for (int i = 0; i < max+1; i++) {
            this.subTab.put(alpha.charAt(i), alpha.charAt(max - i));
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

    private Map<Character, Character> invert() {
        Map<Character, Character> invMap = new HashMap<>();
        for (Map.Entry<Character, Character> entry : this.subTab.entrySet()) {
            invMap.put(entry.getValue(), entry.getKey());
        }
        return invMap;
    }

    private String substitute(String text, Map<Character, Character> map) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (map.containsKey(c)) { c = map.get(c); }
            sb.append(c);
        }
        return sb.toString();
    }
}