package kz.pandev.legrambotapi.models.requests;

import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.utils.FileNames;
import kz.pandev.legrambotapi.utils.MimeTypes;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * General request to Telegram bot API server
 * @author ezuykow
 */
@SuppressWarnings("unused") /*Unused methods warning*/
@Getter
public abstract class Request<T extends Request<T, R>, R extends Response> {

    /**
     * Requests parameters
     */
    private final Map<String, Object> parameters;
    /**
     * Expected response class
     */
    private final Class<? extends R> responseClass;

    protected Request(Class<? extends R> responseClass) {
        this.responseClass = responseClass;
        this.parameters = new LinkedHashMap<>();
    }

    //region API

    /**
     * Add parameter to request
     * @return this request
     */
    @SuppressWarnings("unchecked") //Cast warning - no error
    protected T addParameter(String key, Object value) {
        parameters.put(key, value);
        return (T) this;
    }

    /**
     * Add parameters to request
     * @return this request
     */
    @SuppressWarnings("unchecked") //Cast warning - no error
    protected T addAllParameters(Map<String, Object> newParams) {
        parameters.putAll(newParams);
        return (T) this;
    }

    /**
     * Method name is request simple class name with first letter in lower case
     * @return method name
     */
    public String getMethodName() {
        String className = this.getClass().getSimpleName();
        return Character.toLowerCase(className.charAt(0)) + className.substring(1);
    }

    /**
     * @return content parameter file name
     */
    public String getFileName() {
        return FileNames.GENERAL_FILE_NAME;
    }

    /**
     * @return content parameter mime type
     */
    public String getContentMimeType() {
        return MimeTypes.GENERAL_MIME_TYPE;
    }

    /**
     * @return request timeout in seconds
     */
    public int getTimeout() {
        return 0;
    }

    /**
     * @return true if request is multipart
     */
    public boolean isMultipart() {
        return false;
    }

    //endregion
}