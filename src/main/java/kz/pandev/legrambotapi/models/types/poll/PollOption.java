package kz.pandev.legrambotapi.models.types.poll;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object contains information about one answer option in a poll
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class PollOption implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Option text, 1-100 characters
     */
    @SerializedName("text")
    private String text;

    /**
     * Number of users that voted for this option
     */
    @SerializedName("voter_count")
    private Integer voterCount;
}