package fr.esisar.cs312.crypto;

public class Caesar implements Algo {
    private int shift;

    public Caesar(int shift) {
        this.shift = shift;
    }

    public Caesar() {
        this(1);
    }

    @Override
    public String encrypt(String text) {
        return shiftText(text, shift);
    }

    @Override
    public String decrypt(String text) {
        return shiftText(text, -shift);
    }

    private String shiftText(String text, int shift) {
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isUpperCase(c)) { sb.append((char) ('A' + (c - 'A' + shift + 26) % 26)); }
            else if (Character.isLowerCase(c)) { sb.append((char) ('a' + (c - 'a' + shift + 26) % 26)); }
            else { sb.append(c); }
        }
        return sb.toString();
    }

}