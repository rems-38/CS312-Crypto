package fr.esisar.cs312.crypto;

public class Otp implements Algo {
    private String key;

    public Otp(String key) {
        this.key = key;
    }

    @Override
    public String encrypt(String text) {
        return vernam(text, 1);
    }

    @Override
    public String decrypt(String text) {
        return vernam(text, -1);
    }

    private String vernam(String text, int neg) throws IllegalArgumentException {
        if (this.key.length() < text.length()) {
            throw new IllegalArgumentException("Key must be at least as long as the plaintext");
        }

        // -------- DONT WORKING YET --------
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i); 
            if (c >= 'A' && c <= 'Z') {
                sb.append((char) ((((c - 'A') + neg * (this.key.charAt(i) - 'A')) % 26) + 'A'));
            }
            else if (c >= 'a' && c <= 'z') {
                sb.append((char) ((((c - 'a') + neg * (this.key.charAt(i) - 'a')) % 26) + 'a'));
            }
            else { sb.append(c); }
        }
        return sb.toString();
        // ---------------------------------
    }
}