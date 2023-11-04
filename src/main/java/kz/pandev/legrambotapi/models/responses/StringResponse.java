package kz.pandev.legrambotapi.models.responses;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * General Telegram bot API server response to methods, which result is String object
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class StringResponse extends Response implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * If request successful, the result String
     */
    @SerializedName("result")
    private String result;
}