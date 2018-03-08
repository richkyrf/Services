package F;

import static java.lang.System.out;
import java.security.MessageDigest;
import static java.security.MessageDigest.getInstance;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.Random;

public class Enc {

    private static final Random random = new Random((new Date()).getTime());

    @SuppressWarnings("Deprecated")
    public static String getEncryptedPassword(String clearTextPassword) {
        try {
            MessageDigest md = getInstance("SHA-256");
            md.update(clearTextPassword.getBytes());
            return new sun.misc.BASE64Encoder().encode(md.digest()).substring(1, 43);
        } catch (NoSuchAlgorithmException e) {
            out.println("E3" + e);
        }
        return null;
    }

    private Enc() {
    }

}
