package fr.esisar.cs312.crypto;

import java.util.Map;
import java.util.HashMap;

public class Sub implements Algo {
    private Map<Character, Character> subTab;

    public Sub(Map<Character, Character> key) {
        this.subTab = key;
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