package histopatologialab.password;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

public class PasswordUtils {
	
	 private static final Random RANDOM = new SecureRandom();
	    private static final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	    private static final int ITERATIONS = 10000;
	    private static final int KEY_LENGTH = 256;
	    private static final String SALT = "HISTOPATOLOGIA2021_998877$"; 
	   // private static final String SALT = "HISTOPATOLOGIA2021"; 
	    
	/*     public static String getSalt(int length) {
	        StringBuilder returnValue = new StringBuilder(length);
	        for (int i = 0; i < length; i++) {
	            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
	        }
	        return new String(returnValue);
	    }  */
	    public static byte[] hash(char[] password, byte[] salt) {
	        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
	        Arrays.fill(password, Character.MIN_VALUE);
	        try {
	            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	            return skf.generateSecret(spec).getEncoded();
	        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
	            throw new AssertionError("Error al generar password: " + e.getMessage(), e);
	        } finally {
	            spec.clearPassword();
	        }
	    }
	    public static String generateSecurePassword(String password) {
	        String returnValue = null;
	        byte[] securePassword = hash(password.toCharArray(), SALT.getBytes());
	 
	        returnValue = Base64.getEncoder().encodeToString(securePassword);
	 
	        return returnValue;
	    }
	    
	   // public static boolean verifyUserPassword(String providedPassword, String securedPassword, String salt)
	    public static boolean verifyUserPassword(String providedPassword, String securedPassword)
	    {
	        boolean returnValue = false;
	        
	        // Generando el password con el valor Salt
	        String newSecurePassword = generateSecurePassword(providedPassword);
	        
	        // Validando si los valores son iguales 
	        returnValue = newSecurePassword.equalsIgnoreCase(securedPassword);
	        
	        return returnValue;
	    }
	

}
