package kz.pandev.legrambotapi.models.temp;

import lombok.Getter;
import lombok.Setter;

import java.io.File;

/**
 * @author ezuykow
 */
@SuppressWarnings("unused") /*Unused methods warning*/
@Getter
@Setter
public class InputFile {

    private File file;
    private byte[] bytes;
    private String fileName;
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