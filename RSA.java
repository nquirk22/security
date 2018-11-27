package RSA;


import java.math.BigInteger;
import java.util.Random;


public class RSA {
    private Random r = new Random();
    private BigInteger n;
    private BigInteger phi;
    private BigInteger e;
    private BigInteger d;

    private int BIT_LENGTH = 1024;

    public RSA() {
        initialize();
    }

    public RSA(int bitLength) {
        this.BIT_LENGTH = bitLength;
        initialize();
    }

    private void initialize() {
        // pick two random numbers with bit length of 1024
        BigInteger p = new BigInteger(BIT_LENGTH, 100, r);
        BigInteger q = new BigInteger(BIT_LENGTH, 100, r);

        // calculate modulus
        n = p.multiply(q);

        // phi(n)=(p-1)*(q-1) Euler Totient
        phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));

        // calculate public key exponent
        e = calcE();

        // calculate private key exponent
        d = e.modInverse(phi);
    }

    // find an e that is less than n and is relatively prime to phi(n)
    private BigInteger calcE() {
        BigInteger temp;
        do {
            temp = new BigInteger(n.bitLength()/2, 100, r);
        } while (!phi.gcd(temp).equals(BigInteger.ONE));
        //System.out.println(temp);
        return temp;
    }

    //
    public BigInteger encrypt(BigInteger message) {
        return message.modPow(e, n);
    }

    public BigInteger decrypt(BigInteger cipher) {
        return cipher.modPow(d, n);
    }

    public BigInteger[] getPubKey() {
        BigInteger[] pubKey = {e, n};
        return pubKey;
    }

}
