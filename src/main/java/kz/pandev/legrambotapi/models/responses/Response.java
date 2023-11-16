package kz.pandev.legrambotapi.models.responses;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.ResponseParameters;
import lombok.Getter;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

import java.io.Serial;
import java.io.Serializable;

/**
 * General Telegram bot API server response
 * @author ezuykow
 */
@Getter
@ToString
public class Response implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * True, if request was successful.
     * In case of an unsuccessful request, 'ok' equals false and the error is explained in the 'description'
     */
    @SerializedName("ok")
    private boolean ok;

    /**
     * Optional. A human-readable description of the result
     */
    @SerializedName("description")
    @Nullable
    private String description;

    /**
     * Optional. Code of error if request is unsuccessful
     */
    @SerializedName("error_code")
    @Nullable
    private Integer errorCode;

    /**
     * Optional. Describes why a request was unsuccessful
     */
    @SerializedName("parameters")
    @Nullable
    private ResponseParameters parameters;
}