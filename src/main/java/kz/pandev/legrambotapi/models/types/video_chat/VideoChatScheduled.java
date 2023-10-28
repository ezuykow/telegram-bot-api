package kz.pandev.legrambotapi.models.types.video_chat;

import com.google.gson.annotations.SerializedName;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;

/**
 * This object represents a service message about a video chat scheduled in the chat
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class VideoChatScheduled implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * Point in time (Unix timestamp) when the video chat is supposed to be started by a chat administrator
     */
    @SerializedName("start_date")
    private Integer startDate;
}