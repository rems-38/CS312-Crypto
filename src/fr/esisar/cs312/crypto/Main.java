package fr.esisar.cs312.crypto;

import java.util.Map;
import java.util.HashMap;

public class Main {

	public static void main(String args[]) {
		
		Algo rot13 = new Rot13();
		Algo caesar8 = new Caesar(8);
		Algo caesar = new Caesar();

		Map<Character, Character> map = new HashMap<>();		
		map.put('a', 'z');
		map.put('b', 'e');
		map.put('c', 'b');
		map.put('d', 'r');
		map.put('e', 'a');
		map.put('f', 'f');
		map.put('g', 'i');
		map.put('h', 'o');
		map.put('i', 'l');
		map.put('j', 'u');
		map.put('k', 'g');
		map.put('l', 'q');
		map.put('m', 'p');
		map.put('n', 'm');
		map.put('o', 'y');
		map.put('p', 't');
		map.put('q', 'd');
		map.put('r', 'w');
		map.put('s', 'h');
		map.put('t', 'c');
		map.put('u', 'n');
		map.put('v', 'x');
		map.put('w', 'v');
		map.put('x', 'k');
		map.put('y', 'j');
		map.put('z', 's');
		Algo sub = new Sub(map);

		String first = "Hello World";
		System.out.println("[E] Rot13: " + rot13.encrypt(first));
		System.out.println("[D] Rot13: " + rot13.decrypt(rot13.encrypt(first)));
	
		System.out.println("[E] Caesar8: " + caesar8.encrypt(first));
		System.out.println("[D] Caesar8: " + caesar8.decrypt(caesar8.encrypt(first)));

		System.out.println("[E] Caesar: " + caesar.encrypt(first));
		System.out.println("[D] Caesar: " + caesar.decrypt(caesar.encrypt(first)));

		System.out.println("[E] Sub: " + sub.encrypt(first.toLowerCase()));
		System.out.println("[D] Sub: " + sub.decrypt(sub.encrypt(first.toLowerCase())));	
	
	}
}
