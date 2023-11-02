package kz.pandev.legrambotapi.models.types.passport.credentials.utils.decrypt;

import com.google.gson.Gson;
import kz.pandev.legrambotapi.models.types.passport.credentials.Credentials;

import java.util.Arrays;

/**
 * Passport fata decryptor
 * @author ezuykow
 */
public final class Decryptor {

    private Decryptor() {}

    //region API

    public static Credentials decryptCredentials(String privateKey, String data, String hash, String secret) throws Exception {
        byte[] encryptedSecret = RsaOaep.decrypt(privateKey, base64(secret));
        SecretHash secretHash = new SecretHash(encryptedSecret, base64(hash));
        byte[] encryptedData = decryptAes256Cbc(secretHash.key(), secretHash.iv(), base64(data));
        String credStr = new String(encryptedData);
        return new Gson().fromJson(credStr, Credentials.class);
    }

    public static String decryptData(String data, String dataHash, String secret) throws Exception {
        byte[] encryptedData = decryptFile(base64(data), dataHash, secret);
        return new String(encryptedData);
    }

    public static byte[] decryptFile(byte[] data, String fileHash, String secret) throws Exception {
        SecretHash secretHash = new SecretHash(base64(secret), base64(fileHash));
        return decryptAes256Cbc(secretHash.key(), secretHash.iv(), data);
    }

    //endregion
    //region Utils

    private static byte[] decryptAes256Cbc(byte[] key, byte[] iv, byte[] data) throws Exception {
        byte[] encryptedData = new Aes256Cbc(key, iv).decrypt(data);
        int padding = encryptedData[0] & 0xFF;
        encryptedData = Arrays.copyOfRange(encryptedData, padding, encryptedData.length);
        return encryptedData;
    }

    private static byte[] base64(String str) {
        return Base64.decode(str, 0);
    }

    //endregion
}