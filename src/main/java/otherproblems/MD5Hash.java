package otherproblems;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;

public class MD5Hash {

    public void generateHash() throws Exception {
        String password = "ILoveJava";

        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(password.getBytes());
        byte[] digest = md.digest();
        String myHash = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
    }

}
