package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to change the bot's description, which is shown in the chat with the bot if the chat is empty.
 * Returns True on success.
 * @author ezuykow
 */
@Getter
public class SetMyDescription extends Request<SetMyDescription, Response> {

    /**
     * Optional. New bot description; 0-512 characters. Pass an empty string to remove the dedicated
     * description for the given language.
     */
    @Nullable
    private String description;
    /**
     * Optional. A two-letter ISO 639-1 language code. If empty, commands will be applied to all
     * users from the given scope, for whose language there are no dedicated description
     */
    @Nullable
    private String languageCode;

    public SetMyDescription() {
        super(Response.class);
    }

    //region API

    /**
     * Set parameter {@link SetMyDescription#description}
     * @param description new parameter value
     * @return this request
     */
    public SetMyDescription description(@NotNull String description) {
        this.description = description;
        return addParameter("description", description);
    }

    /**
     * Set parameter {@link SetMyDescription#languageCode}
     * @param languageCode new parameter value
     * @return this request
     */
    public SetMyDescription languageCode(@NotNull String languageCode) {
        this.languageCode = languageCode;
        return addParameter("language_code", languageCode);
    }

    //endregion
}