package kz.pandev.legrambotapi.models.types.common.input;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * This object represents the contents of a file to be uploaded
 * @author ezuykow
 */
@SuppressWarnings("unused") /*Unused methods warning*/
@Getter
@Setter
public class InputFile {

    /**
     * File to be uploaded as {@link File}
     */
    private File file;
    /**
     * File to be uploaded as byte array
     */
    private byte[] bytes;
    /**
     * Name of file to be uploaded
     */
    private String fileName;
    /**
     * Mime type of file to be uploaded
     * @see kz.pandev.legrambotapi.utils.MimeTypes
     */
    private String contentType;

    public InputFile(File file, String fileName, String contentType) {
        this.file = file;
        this.fileName = fileName;
        this.contentType = contentType;
    }

    public InputFile(byte[] bytes, String fileName, String contentType) {
        this.bytes = bytes;
        this.fileName = fileName;
        this.contentType = contentType;
    }
}