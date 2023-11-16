package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyShortDescriptionResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to get the current bot short description for the given user language.
 * Returns BotShortDescription on success.
 * @author ezuykow
 */
public class GetMyShortDescription extends Request<GetMyShortDescription, GetMyShortDescriptionResponse> {

    public GetMyShortDescription() {
        super(GetMyShortDescriptionResponse.class);
    }

    //region API

    /**
     * Set parameter language_code
     * @param languageCode A two-letter ISO 639-1 language code or an empty string
     * @return this request
     */
    public GetMyShortDescription languageCode(@NotNull String languageCode) {
        return addParameter("language_code", languageCode);
    }

    //endregion
}