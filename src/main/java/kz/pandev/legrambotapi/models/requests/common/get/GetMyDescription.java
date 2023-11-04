package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyDescriptionResponse;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to get the current bot description for the given user language. Returns BotDescription on success.
 * @author ezuykow
 */
@Getter
public class GetMyDescription extends Request<GetMyDescription, GetMyDescriptionResponse> {

    /**
     * Optional. A two-letter ISO 639-1 language code or an empty string
     */
    @Nullable
    private String languageCode;

    public GetMyDescription() {
        super(GetMyDescriptionResponse.class);
    }

    //region API

    /**
     * Set parameter {@link GetMyDescription#languageCode}
     * @param languageCode new parameter value
     * @return this request
     */
    public GetMyDescription languageCode(@NotNull String languageCode) {
        this.languageCode = languageCode;
        return addParameter("language_code", languageCode);
    }

    //endregion
}