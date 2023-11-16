package kz.pandev.legrambotapi.configure.api;

import kz.pandev.legrambotapi.exceptions.BadFilePathException;
import kz.pandev.legrambotapi.models.types.common.File;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Methods to interact with files on Telegram bot API server
 * @author ezuykow
 */
public class TelegramFileApi {

    /**
     * URL to Telegram bot API server file API
     */
    private final String botFileApiUrl;

    public TelegramFileApi(String botApiUrl, String botToken) {
        this.botFileApiUrl = botApiUrl + "/file/bot" + botToken + "/";
    }

    //region API

    /**
     * @param file target {@link File}
     * @return full path to target file on Telegram bot API server
     */
    public String getFullFilePath(File file) {
        try {
            String filePath = file.getFilePath();
            if (filePath == null) {
                throw new NullPointerException();
            }
            int slash = filePath.lastIndexOf('/') + 1;
            String path = filePath.substring(0, slash);
            String fileName = filePath.substring(slash);
            return botFileApiUrl + path + URLEncoder.encode(fileName, StandardCharsets.UTF_8)
                    .replace("+", "%20");
        } catch (Exception e) {
            throw new BadFilePathException(e);
        }
    }

    /**
     * @param file target {@link File}
     * @return file content as byte array
     * @throws IOException if an I/O exception occur
     */
    public byte[] getFileContent(File file) throws IOException {
        String fileUrl = getFullFilePath(file);
        URLConnection connection = new URL(fileUrl).openConnection();
        try (InputStream is = connection.getInputStream();
             ByteArrayOutputStream bos = new ByteArrayOutputStream())
        {
            is.transferTo(bos);
            return bos.toByteArray();
        }
    }

    //endregion
}