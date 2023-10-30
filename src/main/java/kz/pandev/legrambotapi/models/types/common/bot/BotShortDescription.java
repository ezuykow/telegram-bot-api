package kz.pandev.legrambotapi.models.types.common.bot;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents the bot's short description.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class BotShortDescription implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * The bot's short description
     */
    @SerializedName("short_description")
    private String shortDescription;
}