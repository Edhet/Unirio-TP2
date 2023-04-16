public class Main {
    public static void main(String[] args) {
        final String original = "abc";
        String encrypted = CaeserCipher.encrypt("abc");
        String decrypted = CaeserCipher.decrypt("bcd");

        System.out.println("Original: "+original);
        System.out.println("Encrypted: "+encrypted);
        System.out.println("Decrypted: "+decrypted);
    }
}

class CaeserCipher {
    private static final int factor = 3;

    public static String encrypt(String original) {
        StringBuilder encryptedString = new StringBuilder();
        for (char character : original.toCharArray()) {
            encryptedString.append((char)((int)character + factor));
        }
        return encryptedString.toString();
    }

    public static String decrypt(String original) {
        StringBuilder decryptedString = new StringBuilder();
        for (char character : original.toCharArray()) {
            decryptedString.append((char)((int)character - factor));
        }
        return decryptedString.toString();
    }
}
