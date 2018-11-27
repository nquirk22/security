package RSA;

import java.math.BigInteger;
import java.util.Scanner;

public class Driver {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        RSA rsa = new RSA();

        System.out.println("<------RSA------>");
        System.out.println("Input a message to " +
                "be encrypted:");

        // get message
        String message = kb.nextLine();

        System.out.println("Message encrypted");

        // convert message to chars
        char[] chars = message.toCharArray();

        // convert char array to BigInt array
        BigInteger[] bigChars = new BigInteger[chars.length];
        for (int i = 0; i < chars.length; i++) {
            bigChars[i] = BigInteger.valueOf(chars[i]);
        }

        // create array to hold cipher text
        BigInteger[] cipher = new BigInteger[bigChars.length];
        //encrypt each BigInteger value in bigChars array
        for (int i = 0; i < bigChars.length; i++) {
            cipher[i] = rsa.encrypt(bigChars[i]);
        }

        // print ciphertext
        System.out.println("The cipher: ");
        for (BigInteger ciph : cipher) {
            System.out.println(ciph);
        }

        // demonstrate public key generation
        System.out.println("The public key: ");
        BigInteger[] publicKey = rsa.getPubKey();
        System.out.println("e: " + publicKey[0].toString());
        System.out.println("n: " + publicKey[1].toString());


        System.out.println("Decrypting...");

        // create array to hold decrypted BigInts
        BigInteger[] decrypt = new BigInteger[cipher.length];
        // decrypt each BigInt in cipher array
        for (int i = 0; i < cipher.length; i++) {
            decrypt[i] = rsa.decrypt(cipher[i]);
        }

        System.out.println("The original message: ");

        // create array to hold char values
        char[] decrypted = new char[decrypt.length];
        // convert BigInteger values into chars
        for (int i = 0; i < decrypt.length; i++) {
            decrypted[i] = (char) decrypt[i].intValue();
        }

        // store as String
        String decryptedMessage = new String(decrypted);

        // print decrypted message
        System.out.println(decryptedMessage);

    }
}
