package kz.pandev.legrambotapi.models.types.video_chat;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a service message about a video chat ended in the chat
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class VideoChatEnded implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Video chat duration in seconds
     */
    @SerializedName("duration")
    private Integer duration;
}