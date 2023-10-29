package kz.pandev.legrambotapi.models.types.bot.command.scope;

import com.google.gson.annotations.SerializedName;

/**
 * This object represents the scope to which bot commands are applied
 * @author ezuykow
 */
public abstract class BotCommandScope {

    /**
     * Scope type
     */
    @SerializedName("type")
    protected String type;
}