package kz.pandev.legrambotapi.models.responses.common;

import com.google.gson.annotations.SerializedName;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.forum.ForumTopic;
import lombok.Getter;
import lombok.ToString;

/**
 * Telegram bot API server response to CreateForumTopic request
 * @author ezuykow
 */
@Getter
@ToString(callSuper = true)
public class CreateForumTopicResponse extends Response {

    /**
     * Result as {@link ForumTopic}
     */
    @SerializedName("result")
    private ForumTopic forumTopic;
}