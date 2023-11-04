package kz.pandev.legrambotapi.models.types.common.menu;

import com.google.gson.annotations.SerializedName;
import lombok.Getter;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object describes the bot's menu button in a private chat
 * @author ezuykow
 */
@Getter
public class MenuButton implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Menu button type
     */
    @SerializedName("type")
    private String type;

    public MenuButton(String type) {
        this.type = type;
    }

}