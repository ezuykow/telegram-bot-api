package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to change the bot's short description, which is shown on the bot's profile page and
 * is sent together with the link when users share the bot. Returns True on success.
 * @author ezuykow
 */
public class SetMyShortDescription extends Request<SetMyShortDescription, Response> {

    public SetMyShortDescription() {
        super(Response.class);
    }

    //region API

    /**
     * Set parameter short_description
     * @param shortDescription New short description for the bot; 0-120 characters. Pass an empty string to remove
     *                        the dedicated short description for the given language.
     * @return this request
     */
    public SetMyShortDescription description(@NotNull String shortDescription) {
        return addParameter("short_description", shortDescription);
    }

    /**
     * Set parameter language_code
     * @param languageCode A two-letter ISO 639-1 language code. If empty, commands will be applied to all users from
     *                    the given scope, for whose language there are no dedicated description
     * @return this request
     */
    public SetMyShortDescription languageCode(@NotNull String languageCode) {
        return addParameter("language_code", languageCode);
    }

    //endregion
}