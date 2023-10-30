package kz.pandev.legrambotapi.models.types.common.video.chat;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.types.common.user.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

/**
 * This object represents a service message about new members invited to a video chat
 * @author ezuykow
 */
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class VideoChatParticipantsInvited implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * New members that were invited to the video chat
     */
    @SerializedName("users")
    private List<User> users;
}