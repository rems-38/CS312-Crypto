package fr.esisar.cs312.crypto;

public class Main {

	public static void main(String args[]) {
		
		Algo rot13 = new Rot13();
		Algo caesar8 = new Caesar(8);
		Algo caesar = new Caesar();

		String first = "Hello World";
		System.out.println("[E] Rot13: " + rot13.encrypt(first));
		System.out.println("[D] Rot13: " + rot13.decrypt(rot13.encrypt(first)));
	
		System.out.println("[E] Caesar8: " + caesar8.encrypt(first));
		System.out.println("[D] Caesar8: " + caesar8.decrypt(caesar8.encrypt(first)));

		System.out.println("[E] Caesar: " + caesar.encrypt(first));
		System.out.println("[D] Caesar: " + caesar.decrypt(caesar.encrypt(first)));
	
	
	}
}
