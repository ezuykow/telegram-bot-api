package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to change the bot's name. Returns True on success.
 * @author ezuykow
 */
@Getter
public class SetMyName extends Request<SetMyName, Response> {

    /**
     * Optional. New bot name; 0-64 characters. Pass an empty string to remove the dedicated name
     * for the given language.
     */
    @Nullable
    private String name;
    /**
     * Optional. A two-letter ISO 639-1 language code. If empty, commands will be applied to all
     * users from the given scope, for whose language there are no dedicated name
     */
    @Nullable
    private String languageCode;

    public SetMyName() {
        super(Response.class);
    }

    //region API

    /**
     * Set parameter {@link SetMyName#name}
     * @param name new parameter value
     * @return this request
     */
    public SetMyName name(@NotNull String name) {
        this.name = name;
        return addParameter("name", name);
    }

    /**
     * Set parameter {@link SetMyName#languageCode}
     * @param languageCode new parameter value
     * @return this request
     */
    public SetMyName languageCode(@NotNull String languageCode) {
        this.languageCode = languageCode;
        return addParameter("language_code", languageCode);
    }

    //endregion
}