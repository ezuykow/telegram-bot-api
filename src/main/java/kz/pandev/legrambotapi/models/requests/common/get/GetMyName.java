package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyNameResponse;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to get the current bot name for the given user language. Returns BotName on success.
 * @author ezuykow
 */
@Getter
public class GetMyName extends Request<GetMyName, GetMyNameResponse> {

    /**
     * Optional. A two-letter ISO 639-1 language code or an empty string
     */
    @Nullable
    private String languageCode;

    public GetMyName() {
        super(GetMyNameResponse.class);
    }

    //region API

    /**
     * Set parameter {@link GetMyName#languageCode}
     * @param languageCode new parameter value
     * @return this request
     */
    public GetMyName languageCode(@NotNull String languageCode) {
        this.languageCode = languageCode;
        return addParameter("language_code", languageCode);
    }

    //endregion
}