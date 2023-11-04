package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetUserProfilePhotosResponse;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object.
 * @author ezuykow
 */
@Getter
public class GetUserProfilePhotos extends Request<GetUserProfilePhotos, GetUserProfilePhotosResponse> {

    /**
     * Optional. Sequential number of the first photo to be returned. By default, all photos are returned
     */
    @Nullable
    private Integer offset;
    /**
     * Optional. Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     */
    @Nullable
    private Integer limit;

    /**
     * @param userId Unique identifier of the target user
     */
    public GetUserProfilePhotos(long userId) {
        super(GetUserProfilePhotosResponse.class);
        addParameter("user_id", userId);
    }

    //region API

    /**
     * Set parameter {@link GetUserProfilePhotos#limit}
     * @param limit new parameter value
     * @return this request
     */
    public GetUserProfilePhotos limit(int limit) {
        this.limit = limit;
        return addParameter("limit", limit);
    }

    /**
     * Set parameter {@link GetUserProfilePhotos#offset}
     * @param offset new parameter value
     * @return this request
     */
    public GetUserProfilePhotos offset(int offset) {
        this.offset = offset;
        return addParameter("offset", offset);
    }

    //endregion
}