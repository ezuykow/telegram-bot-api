package kz.pandev.legrambotapi.addons.update;

import kz.pandev.legrambotapi.models.types.Update;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.jetbrains.annotations.Nullable;

/**
 * Extends type {@link Update}. Adds fields {@link ExtendedUpdate#contentType}, {@link ExtendedUpdate#senderUserId},
 * {@link ExtendedUpdate#senderChatId}
 * @author ezuykow
 */
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class ExtendedUpdate extends Update {

    /**
     * Type of update's content as {@link UpdateContentType}
     */
    private UpdateContentType contentType;
    /**
     * ID of the user from whom update came
     */
    private Long senderUserId;
    /**
     * ID of the chat from which the update came
     */
    private Long senderChatId;
    /**
     * ID of the chat thread from which the update came
     */
    @Nullable
    private Integer senderChatThreadId;

    //region API

    /**
     * @return {@link ExtendedUpdate#contentType}
     */
    public UpdateContentType getContentType() {
        checkInitialisation();
        return contentType;
    }

    /**
     * @return {@link ExtendedUpdate#senderUserId}
     */
    public Long getSenderUserId() {
        checkInitialisation();
        return senderUserId;
    }

    /**
     * @return {@link ExtendedUpdate#senderChatId}
     */
    public Long getSenderChatId() {
        checkInitialisation();
        return senderChatId;
    }

    /**
     * @return {@link ExtendedUpdate#senderChatThreadId}
     */
    public Integer getSenderChatThreadId() {
        checkInitialisation();
        return senderChatThreadId;
    }

    //endregion
    //region Utils

    private void init() {
        this.contentType = UpdateUtils.resolveUpdateContentType(this);
        this.senderUserId = UpdateUtils.resolveSenderUserId(this);
        this.senderChatId = UpdateUtils.resolveSenderChatId(this);
        this.senderChatThreadId = UpdateUtils.resolveSenderChatThreadId(this);
    }

    private void checkInitialisation() {
        if (contentType == null) {
            init();
        }
    }

    //endregion
}