package fr.esisar.cs312.crypto;

public class Main {

	public static void main(String args[]) throws InvalidAlg, InvalidKey {
		Message m = new Message();
		
		if (args.length > 4) {
			System.out.println("Usage: -e|-d alg text [args ...]");
			System.exit(1);
		}

		if (args[0].equals("-e")) { m.encrypt = true; }
		else if (args[0].equals("-d")) { m.encrypt = false; }
		else {
			System.out.println("Usage: -e|-d alg text [args ...]");
			System.exit(1);
		}

		if (args[1].equals("rot13")) { m.algo = new Rot13(); }
		else if (args[1].equals("caesar")) { m.algo = new Caesar(); }
		else if (args[1].equals("sub")) { m.algo = new Sub(); }
		else if (args[1].equals("otp")) { m.algo = new Otp(); }
		else { throw new InvalidAlg("Invalid alg.\nUsage : -e|-d alg text [args ...]"); }

		if (m.encrypt) { m.plaintext = args[2]; }
		else { m.ciphertext = args[2]; }

		if (args.length == 4) {
			m.key = args[3];
			m.algo.setKey(m.key, m.plaintext.length());
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
