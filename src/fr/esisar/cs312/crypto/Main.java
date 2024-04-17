package fr.esisar.cs312.crypto;

public class Main {

	public static void main(String args[]) {
		Message m = new Message();
		
		if (args.length != 3 || args.length != 4) {
			System.out.println("Usage: -e|-d alg text [args ...]");
			System.exit(1);
		}

		if (args[0].equals("-e")) {
			m.encrypt = true;
		} else if (args[0].equals("-d")) {
			m.encrypt = false;
		} else {
			System.out.println("Usage: -e|-d alg text [args ...]");
			System.exit(1);
		}

		if (args[1] == "rot13") {
			m.algo = new Rot13();
		} else if (args[1] == "caesar") {
			m.algo = new Caesar();
		} else if (args[1] == "sub") {
			m.algo = new Sub();
		} else if (args[1] == "otp") {
			m.algo = new Otp();
		} else {
			System.out.println("Usage: -e|-d alg text [args ...]");
			System.exit(1);
		}

		if (m.encrypt) {
			m.plaintext = args[2];
		} else {
			m.ciphertext = args[2];
		}

		if (args.length == 4) {
			m.key = args[3];
			m.algo.setKey(m.key);
		}

		if (m.encrypt) {
			m.ciphertext = m.algo.encrypt(m.plaintext);
			System.out.println(m.ciphertext);
		} else {
			m.plaintext = m.algo.decrypt(m.ciphertext);
			System.out.println(m.plaintext);
		}
		
	}
}
