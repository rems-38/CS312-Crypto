package fr.esisar.cs312.crypto;

import java.util.Map;
import java.util.HashMap;

/*
 * javac 13.0.7
 * jar 13.0.7
 * openjdk 13.0.7 2021-04-20
 * OpenJDK Runtime Environment (build 13.0.7+5-Ubuntu-0ubuntu120.04)
 * OpenJDK 64-Bit Server VM (build 13.0.7+5-Ubuntu-0ubuntu120.04, mixed mode)
 */

public class Main {

	public static void main(String args[]) throws InvalidAlg, InvalidKey {
		Message m = new Message();
		Map<String, Algo> algos = getAlgo();
		
		// Vérification des arguments
		// Nombres d'arguments
		if (args.length > 4) {
			System.out.println("Usage: -e|-d alg text [args ...]");
			System.exit(1);
		}

		// Flag d'encryptage/décryptage
		if (args[0].equals("-e")) { m.encrypt = true; }
		else if (args[0].equals("-d")) { m.encrypt = false; }
		else {
			System.out.println("Usage: -e|-d alg text [args ...]");
			System.exit(1);
		}

		// Algorithme supporté par notre programme
		if (algos.containsKey(args[1])) { m.algo = algos.get(args[1]); }
		else { throw new InvalidAlg("Invalid alg.\nUsage : -e|-d alg text [args ...]"); }

		// Récupération du texte à encrypter/décrypter
		if (m.encrypt) { m.plaintext = args[2]; }
		else { m.ciphertext = args[2]; }

		// Récupération de la clé si elle est fournie
		if (args.length == 4) {
			m.key = args[3];
			m.algo.setKey(m.key, m.plaintext.length());
		}

		// Réalisation de l'opération demander et affichage du résultat
		if (m.encrypt) {
			m.ciphertext = m.algo.encrypt(m.plaintext);
			System.out.println(m.ciphertext);
		} else {
			m.plaintext = m.algo.decrypt(m.ciphertext);
			System.out.println(m.plaintext);
		}
		
	}

	// Récupération des algorithmes disponibles
	private static Map<String, Algo> getAlgo() {
		Map<String, Algo> algos = new HashMap<>();
		String[] files = new java.io.File("src/fr/esisar/cs312/crypto/algos").list();
		
		for (String file : files) {
			if (file.endsWith(".java")) { // on ne charge que les fichiers .java
				String name = file.substring(0, file.length() - 5); // on enlève le .java
				try {
					Class<?> c = Class.forName("fr.esisar.cs312.crypto.algos." + name); // on charge la classe associée
					Algo algoInstance = (Algo) c.getDeclaredConstructor().newInstance(); // on instancie la classe
					algos.put(name.toLowerCase(), algoInstance); // on ajoute l'algo à la liste
				} catch (Exception e) {
					System.out.println("Error while loading " + name);
				}
			}
		}

		/*
		 * Une alternative non dynamique serait de faire :
		 * algos.put("rot13", new Rot13());
		 * algos.put("caesar", new Caesar());
		 * algos.put("sub", new Sub());
		 * algos.put("otp", new Otp());
		 */
		
		return algos;
	}
}
