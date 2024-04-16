package fr.esisar.cs312.crypto;

public class Rot13 implements Algo {

    @Override
    public String encrypt(String text) {
        return rot13(text);
    }

    @Override
    public String decrypt(String text) {
        return rot13(text);
    }

    public String rot13(String text) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if ((c >= 'a' && c <= 'm') || (c >= 'A' && c <= 'M')) { c += 13; }
            else if ((c >= 'n' && c <= 'z') || (c >= 'N' && c <= 'Z')) { c -= 13; }
            sb.append(c);
        }
        return sb.toString();
    }

}