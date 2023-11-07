package kz.pandev.legrambotapi.models.requests;

import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.utils.enums.DefaultFileName;
import kz.pandev.legrambotapi.utils.enums.MimeType;
import lombok.Getter;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * General request to Telegram bot API server
 * @author ezuykow
 */
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
        return DefaultFileName.GENERAL.getTextVal();
    }

    /**
     * @return content parameter mime type
     */
    public String getContentMimeType() {
        return MimeType.GENERAL.getTextVal();
    }

    /**
     * @return request timeout in seconds
     */
    public Integer getTimeout() {
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