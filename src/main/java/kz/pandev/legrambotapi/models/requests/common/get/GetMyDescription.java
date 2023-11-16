package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyDescriptionResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to get the current bot description for the given user language. Returns BotDescription on success.
 * @author ezuykow
 */
public class GetMyDescription extends Request<GetMyDescription, GetMyDescriptionResponse> {

    public GetMyDescription() {
        super(GetMyDescriptionResponse.class);
    }

    //region API

    /**
     * Set parameter language_code
     * @param languageCode A two-letter ISO 639-1 language code or an empty string
     * @return this request
     */
    public GetMyDescription languageCode(@NotNull String languageCode) {
        return addParameter("language_code", languageCode);
    }

    //endregion
}