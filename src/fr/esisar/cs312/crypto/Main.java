package fr.esisar.cs312.crypto;

public class Main {

	public static void main(String args[]) {
		
		Algo rot13 = new Rot13();

		String first = "Hello World";
		System.out.println("Rot13: " + rot13.encrypt(first));
	}
}
