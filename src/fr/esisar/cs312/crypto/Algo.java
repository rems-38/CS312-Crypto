package fr.esisar.cs312.crypto;

public interface Algo {

    String encrypt(String text);
    String decrypt(String text);

    void setKey(String key);

}