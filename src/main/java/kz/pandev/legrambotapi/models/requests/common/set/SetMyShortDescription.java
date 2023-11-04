package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to change the bot's short description, which is shown on the bot's profile page and
 * is sent together with the link when users share the bot. Returns True on success.
 * @author ezuykow
 */
@Getter
public class SetMyShortDescription extends Request<SetMyShortDescription, Response> {

    /**
     * Optional. New short description for the bot; 0-120 characters. Pass an empty string to remove the
     * dedicated short description for the given language.
     */
    @Nullable
    private String shortDescription;
    /**
     * Optional. A two-letter ISO 639-1 language code. If empty, commands will be applied to all
     * users from the given scope, for whose language there are no dedicated description
     */
    @Nullable
    private String languageCode;

    public SetMyShortDescription() {
        super(Response.class);
    }

    //region API

    /**
     * Set parameter {@link SetMyShortDescription#shortDescription}
     * @param shortDescription new parameter value
     * @return this request
     */
    public SetMyShortDescription description(@NotNull String shortDescription) {
        this.shortDescription = shortDescription;
        return addParameter("short_description", shortDescription);
    }

    /**
     * Set parameter {@link SetMyShortDescription#languageCode}
     * @param languageCode new parameter value
     * @return this request
     */
    public SetMyShortDescription languageCode(@NotNull String languageCode) {
        this.languageCode = languageCode;
        return addParameter("language_code", languageCode);
    }

    //endregion
}