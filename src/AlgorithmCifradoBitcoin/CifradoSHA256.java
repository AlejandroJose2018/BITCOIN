package AlgorithmCifradoBitcoin;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class CifradoSHA256 {
	
	public static StringBuffer cadena ;
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("****Ingresa El Texto a Cifrar: ****");
		String word = sc.next();
		
		convertirSHA256(word);
		
		System.out.println(cadena);
	}
	
	public static String convertirSHA256(String password) {
		MessageDigest md = null;
		
		try {
			md = MessageDigest.getInstance("SHA-256");
		}catch(NoSuchAlgorithmException e){
			e.printStackTrace();
			return null;
		}
		
		byte[] hash = md.digest(password.getBytes(StandardCharsets.UTF_8));
		cadena = new StringBuffer();
		
		for(byte b : hash) {
			cadena.append(String.format("%02x", b));
		}
		
		return cadena.toString();
		
	}

}
