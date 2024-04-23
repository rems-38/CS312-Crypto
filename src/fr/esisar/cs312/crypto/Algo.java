package fr.esisar.cs312.crypto;

public interface Algo {

    String encrypt(String text);
    String decrypt(String text);

    void setKey(String key, int textLength) throws InvalidKey;
    /* 
     * On met setKey() dans l'interface afin que tous les algorithmes en ait une implémentation
     * Cela permet d'avoir un Main plus concis car on peut appeler setKey() sans se soucier de l'algorithme utilisé
     * NB : dans la plupart des algorithmes, setKey() ne fera rien.
     */

}