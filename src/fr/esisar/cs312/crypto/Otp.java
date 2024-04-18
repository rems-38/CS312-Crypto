package fr.esisar.cs312.crypto;

public class Otp implements Algo {
    private String key;

    public Otp(String key) {
        this.key = key;
    }

    public Otp() {
        this("");
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

    private String vernam(String text, int neg) {
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