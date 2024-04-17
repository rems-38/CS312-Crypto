package fr.esisar.cs312.crypto;

public class Main {

	public static void main(String args[]) {
		Message m = new Message();
		String[] names = getNames("src/fr/esisar/cs312/crypto");
		
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

		
		
	}
	
	private static String[] getNames(String href) {
		String[] files = new java.io.File(href).list();
		String[] names = new String[files.length - 2];
		
		int i = 0;
		for (String file : files) {
			if (file.endsWith(".java") && !file.equals("Main.java") && !file.equals("Algo.java")) {
				names[i] = file.toLowerCase().replace(".java", "");
				i++;
			}
		}

		return names;
	}
}
