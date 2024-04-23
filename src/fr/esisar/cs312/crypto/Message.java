package fr.esisar.cs312.crypto;

public class Message {

    Algo algo;
    Boolean encrypt;
    String plaintext;
    String key;
    String ciphertext;

    public Message(Algo algo, Boolean encrypt, String plaintext, String key, String ciphertext) {
        this.algo = algo;
        this.encrypt = encrypt;
        this.plaintext = plaintext;
        this.key = key;
        this.ciphertext = ciphertext;
    }

    public Message(Algo algo, Boolean encrypt, String plaintext, String key) {
        this(algo, encrypt, plaintext, key, null);
    }

    public Message(Algo algo, Boolean encrypt, String plaintext) {
        this(algo, encrypt, plaintext, null);
    }

    public Message() {
        this(null, null, null);
    }

    /*
     * On a ici codé beaucoup de constructeurs pour couvrir tous les cas possibles
     * Mais en pratique et en corrélation avec le code qui à été écrit dans le Main
     * On aurait pu se contenter d'un seul constructeur :
     * public Message() {
     *    this.algo = null;
     *    this.encrypt = null;
     *    this.plaintext = null;
     *    this.key = null;
     *    this.ciphertext = null;
     * }
     */

}

