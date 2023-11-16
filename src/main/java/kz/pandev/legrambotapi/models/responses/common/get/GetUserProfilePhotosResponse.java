package kz.pandev.legrambotapi.models.responses.common.get;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.user.UserProfilePhotos;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to GetUserProfilePhotosRequest request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class GetUserProfilePhotosResponse extends Response {

    /**
     * Result of request as {@link UserProfilePhotos}
     */
    @SerializedName("result")
    private UserProfilePhotos photos;
}