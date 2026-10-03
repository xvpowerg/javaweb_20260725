package tw.com.db;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.HexFormat;

public class PasswordUtil {

    public static String hash(String password) throws Exception {

        MessageDigest md = MessageDigest.getInstance("SHA-256");

        byte[] result = md.digest(
                password.getBytes(StandardCharsets.UTF_8)
        );

        return HexFormat.of().formatHex(result);
    }
}