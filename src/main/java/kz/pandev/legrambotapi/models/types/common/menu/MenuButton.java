package kz.pandev.legrambotapi.models.types.common.menu;

import com.google.gson.annotations.SerializedName;

/**
 * This object describes the bot's menu button in a private chat
 * @author ezuykow
 */
public abstract class MenuButton {

    /**
     * Menu button type
     */
    @SerializedName("type")
    protected String type;
}