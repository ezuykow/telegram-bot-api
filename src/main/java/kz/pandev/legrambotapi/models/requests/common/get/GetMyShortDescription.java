package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyShortDescriptionResponse;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to get the current bot short description for the given user language.
 * Returns BotShortDescription on success.
 * @author ezuykow
 */
@Getter
public class GetMyShortDescription extends Request<GetMyShortDescription, GetMyShortDescriptionResponse> {

    /**
     * Optional. A two-letter ISO 639-1 language code or an empty string
     */
    @Nullable
    private String languageCode;

    public GetMyShortDescription() {
        super(GetMyShortDescriptionResponse.class);
    }

    //region API

    /**
     * Set parameter {@link GetMyShortDescription#languageCode}
     * @param languageCode new parameter value
     * @return this request
     */
    public GetMyShortDescription languageCode(@NotNull String languageCode) {
        this.languageCode = languageCode;
        return addParameter("language_code", languageCode);
    }

    //endregion
}