package fr.esisar.cs312.crypto;

import java.util.Map;
import java.util.HashMap;

public class Main {

	public static void main(String args[]) {
		
		Algo rot13 = new Rot13();
		Algo caesar8 = new Caesar(8);
		Algo caesar = new Caesar();
		Algo sub = new Sub();
		Algo otp = new Otp("HQJWBQLQUWYQOY");

		String first = "Hello World aZ";
		System.out.println("[E] Rot13: " + rot13.encrypt(first));
		System.out.println("[D] Rot13: " + rot13.decrypt(rot13.encrypt(first)));
	
		System.out.println("[E] Caesar8: " + caesar8.encrypt(first));
		System.out.println("[D] Caesar8: " + caesar8.decrypt(caesar8.encrypt(first)));

		System.out.println("[E] Caesar: " + caesar.encrypt(first));
		System.out.println("[D] Caesar: " + caesar.decrypt(caesar.encrypt(first)));

		System.out.println("[E] Sub: " + sub.encrypt(first));
		System.out.println("[D] Sub: " + sub.decrypt(sub.encrypt(first)));	

		System.out.println("[E] Otp: " + otp.encrypt(first));
		System.out.println("[D] Otp: " + otp.decrypt(otp.encrypt(first)));	
	
	}
}
