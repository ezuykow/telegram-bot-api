package kz.pandev.legrambotapi.models.types.passport.credentials.utils.decrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * @author ezuykow
 */
public class SecretHash {

    private final byte[] secretHashBytes;

    public SecretHash(byte[] secret, byte[] hash) throws NoSuchAlgorithmException {
        secretHashBytes = sha512(concat(secret, hash));
    }

    //region API

    public byte[] key() {
        return Arrays.copyOfRange(secretHashBytes, 0, 32);
    }

    public byte[] iv() {
        return Arrays.copyOfRange(secretHashBytes, 32, 48);
    }

    //endregion
    //region Utils

    private byte[] sha512(byte[] string) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        return md.digest(string);
    }

    private byte[] concat(byte[]... arrays) {
        int length = 0;
        for (byte[] array : arrays) {
            length += array.length;
        }
        byte[] result = new byte[length];
        int pos = 0;
        for (byte[] array : arrays) {
            for (byte element : array) {
                result[pos] = element;
                pos++;
            }
        }
        return result;
    }

    //endregion
}