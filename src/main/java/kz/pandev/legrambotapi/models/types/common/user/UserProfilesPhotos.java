package kz.pandev.legrambotapi.models.types.common.user;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.PhotoSize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object represent a user's profile pictures.
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class UserProfilesPhotos implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Total number of profile pictures the target user has
     */
    @SerializedName("total_count")
    private Integer totalCount;

    /**
     * Requested profile pictures (in up to 4 sizes each)
     */
    @SerializedName("photos")
    private List<List<PhotoSize>> photos;
}