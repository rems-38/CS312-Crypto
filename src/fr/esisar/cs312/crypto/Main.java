package fr.esisar.cs312.crypto;

public class Main {

	public static void main(String args[]) {
		
		Algo rot13 = new Rot13();

		String first = "Hello World";
		System.out.println("[E] Rot13: " + rot13.encrypt(first));
		System.out.println("[D] Rot13: " + rot13.decrypt(rot13.encrypt(first)));
	}
}
