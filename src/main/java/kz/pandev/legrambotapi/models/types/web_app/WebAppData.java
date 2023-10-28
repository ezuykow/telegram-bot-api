package kz.pandev.legrambotapi.models.types.web_app;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * Describes data sent from a Web App to the bot
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class WebAppData implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The data. Be aware that a bad client can send arbitrary data in this field
     */
    @SerializedName("data")
    private String data;

    /**
     * Text of the web_app keyboard button from which the Web App was opened.
     * Be aware that a bad client can send arbitrary data in this field
     */
    @SerializedName("button_text")
    private String buttonText;
}