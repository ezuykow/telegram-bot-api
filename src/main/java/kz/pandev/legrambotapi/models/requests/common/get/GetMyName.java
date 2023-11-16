package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyNameResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to get the current bot name for the given user language. Returns BotName on success.
 * @author ezuykow
 */
public class GetMyName extends Request<GetMyName, GetMyNameResponse> {

    public GetMyName() {
        super(GetMyNameResponse.class);
    }

    //region API

    /**
     * Set parameter language_code
     * @param languageCode A two-letter ISO 639-1 language code or an empty string
     * @return this request
     */
    public GetMyName languageCode(@NotNull String languageCode) {
        return addParameter("language_code", languageCode);
    }

    //endregion
}