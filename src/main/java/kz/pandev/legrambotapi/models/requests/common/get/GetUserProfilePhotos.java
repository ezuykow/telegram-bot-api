package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetUserProfilePhotosResponse;

/**
 * Use this method to get a list of profile pictures for a user. Returns a UserProfilePhotos object.
 * @author ezuykow
 */
public class GetUserProfilePhotos extends Request<GetUserProfilePhotos, GetUserProfilePhotosResponse> {

    /**
     * @param userId Unique identifier of the target user
     */
    public GetUserProfilePhotos(long userId) {
        super(GetUserProfilePhotosResponse.class);
        addParameter("user_id", userId);
    }

    //region API

    /**
     * Set parameter limit
     * @param limit Limits the number of photos to be retrieved. Values between 1-100 are accepted. Defaults to 100.
     * @return this request
     */
    public GetUserProfilePhotos limit(int limit) {
        return addParameter("limit", limit);
    }

    /**
     * Set parameter offset
     * @param offset Sequential number of the first photo to be returned. By default, all photos are returned
     * @return this request
     */
    public GetUserProfilePhotos offset(int offset) {
        return addParameter("offset", offset);
    }

    //endregion
}