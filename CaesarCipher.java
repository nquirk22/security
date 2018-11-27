
/**
 * Nathan Quirk
 * CSC 302
 * Homework 2
 * Submitted 11.05.18
 * 
 */

package ceasar_cipher;

public class CaesarCipher {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String message1 = "ABCDEFGHIJKLMOPQRSTUVWXYZ";
        System.out.println(encrypt(message1, 3));
        System.out.println(decrypt(encrypt(message1, 3), 3));
        System.out.println(encrypt(message1.toLowerCase(), 5));
        System.out.println(decrypt(encrypt(message1.toLowerCase(), 5), 5));
    }
    
    static String encrypt(String message, int shiftKey) {
        char[] charMessage = message.toCharArray();
        StringBuilder cipher = new StringBuilder();
        shiftKey = shiftKey % 26;
        for (int i = 0; i < charMessage.length; i++) {
            int temp = (int) charMessage[i];
            if (Character.isUpperCase(charMessage[i])) {
                temp = (((temp + shiftKey) - 65) % 26) + 65;
            } else {
                temp = (((temp + shiftKey) - 97) % 26) + 97;
            }
            
            cipher.append((char) (temp));
        }
        return cipher.toString();
    }
    
    static String decrypt(String cipher, int shiftKey) {
        char[] charCipher = cipher.toCharArray();
        StringBuilder message = new StringBuilder();
        shiftKey = shiftKey % 26;
        for (int i = 0; i < charCipher.length; i++) {
            int temp = (int) charCipher[i];          
            if (Character.isUpperCase(charCipher[i])) {
                temp = (((temp + (26 - shiftKey)) - 65) % 26) + 65;                
            } else {
                temp = (((temp + (26 - shiftKey)) - 97) % 26) + 97;
            }
            
            message.append((char) (temp));
        }
        return message.toString();
        
        
    }
    

}

