package kz.pandev.legrambotapi.models.requests;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

import java.io.File;

/**
 * General request for all Upload*** methods
 * @author ezuykow
 */
public abstract class AbstractUploadRequest<T extends Request<T, R>, R extends Response> extends Request<T, R> {

    private final boolean isMultipart;

    protected AbstractUploadRequest(@NotNull Class<? extends R> responseClass, @NotNull String paramName, @NotNull Object data) {
        super(responseClass);
        if (data instanceof String) {
            isMultipart = false;
        } else if (data instanceof File || data instanceof byte[]) {
            isMultipart = true;
        } else {
            throw new WrongParameterTypeException("Sending data should be String, java.io.File or byte[]");
        }
        addParameter(paramName, data);
    }

    //region API

    /**
     * @return true if request is multipart
     */
    @Override
    public boolean isMultipart() {
        return isMultipart;
    }

    //endregion
}