package kz.pandev.legrambotapi.models.requests;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import lombok.Getter;

import java.io.File;

/**
 * General request for all Send*** methods, which send any file
 * @author ezuykow
 */
public abstract class AbstractMultipartRequest<T extends AbstractMultipartRequest<T>> extends AbstractSendRequest<T> {

    /**
     * True if request is multipart
     */
    private boolean isMultipart;
    /**
     * Content file name
     */
    private String fileName;
    /**
     * Content mime type
     */
    private String contentType;
    /**
     * Thumbnail of the file sent; can be ignored if thumbnail generation for the file is supported server-side.
     * The thumbnail should be in JPEG format and less than 200 kB in size.
     * A thumbnail's width and height should not exceed 320.
     * Ignored if the file is not uploaded using multipart/form-data.
     * Thumbnails can't be reused and can be only uploaded as a new file, so you can pass
     * “attach://&lt;file_attach_name&gt;” if the thumbnail was uploaded using multipart/form-data
     * under &lt;file_attach_name&gt;
     */
    @Getter
    protected Object thumbnail;

    protected AbstractMultipartRequest(Object chatId, Object file) {
        super(chatId);
        if (file instanceof String) {
            this.isMultipart = false;
        } else if (file instanceof File f) {
            this.isMultipart = true;
            this.fileName = f.getName();
        } else if (file instanceof byte[]) {
            this.isMultipart = true;
        } else {
            throw new WrongParameterTypeException("Type of parameter file should be java.io.File, byte[] or String" +
                    " (if it's a file_id of file that exists on the Telegram servers or HTTP URL for Telegram to get" +
                    " a photo from the Internet)");
        }
        addParameter(getFileParamName(), file);
    }

    //region API

    /**
     * Set parameter {@link AbstractMultipartRequest#fileName}
     * @param fileName new parameter value
     * @return this request
     */
    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T fileName(String fileName) {
        this.fileName = fileName;
        return (T) this;
    }

    /**
     * Set parameter {@link AbstractMultipartRequest#contentType}
     * @param contentType new parameter value
     * @return this request
     */
    @SuppressWarnings("unchecked") /*Unchecked cast - no error*/
    public T contentType(String contentType) {
        this.contentType = contentType;
        return (T) this;
    }

    /**
     * Set parameter {@link AbstractMultipartRequest#thumbnail}
     * @param thumbnail new parameter value
     * @return this request
     */
    protected T thumbnail(Object thumbnail) {
        this.isMultipart = true;
        this.thumbnail = thumbnail;
        return addParameter("thumbnail", thumbnail);
    }

    /**
     * @return true if request is multipart
     */
    @Override
    public boolean isMultipart() {
        return isMultipart;
    }

    /**
     * @return content parameter file name
     */
    @Override
    public String getFileName() {
        if (fileName != null && !fileName.isEmpty()) {
            return fileName;
        } else {
            return getDefaultFileName();
        }
    }

    /**
     * @return content parameter mime type
     */
    @Override
    public String getContentMimeType() {
        return (contentType != null && !contentType.isEmpty()) ? contentType : getDefaultContentType();
    }

    protected abstract String getDefaultFileName();

    protected abstract String getDefaultContentType();

    protected abstract String getFileParamName();

    //endregion
}