package kz.pandev.legrambotapi.addons.update;

import kz.pandev.legrambotapi.models.types.Update;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.poll.PollAnswer;
import org.jetbrains.annotations.NotNull;

/**
 * Useful methods for working with Update
 * @author ezuykow
 */
public final class UpdateUtils {

    private UpdateUtils() {}

    //region API

    /**
     * Defines and returns the content type of update
     * @param update processed {@link Update}
     * @return Update's content type as {@link UpdateContentType}
     */
    public static UpdateContentType resolveUpdateContentType(@NotNull Update update) {
        if (update.getMessage() != null) {
            return UpdateContentType.MESSAGE;
        }
        if (update.getCallbackQuery() != null) {
            return UpdateContentType.CALLBACK_QUERY;
        }
        if (update.getEditedMessage() != null) {
            return UpdateContentType.EDITED_MESSAGE;
        }
        if (update.getChannelPost() != null) {
            return UpdateContentType.CHANNEL_POST;
        }
        if (update.getEditedChannelPost() != null) {
            return UpdateContentType.EDITED_CHANNEL_POST;
        }
        if (update.getInlineQuery() != null) {
            return UpdateContentType.INLINE_QUERY;
        }
        if (update.getChosenInlineResult() != null) {
            return UpdateContentType.CHOSEN_INLINE_QUERY;
        }
        if (update.getShippingQuery() != null) {
            return UpdateContentType.SHIPPING_QUERY;
        }
        if (update.getPreCheckoutQuery() != null) {
            return UpdateContentType.PRE_CHECKOUT_QUERY;
        }
        if (update.getPoll() != null) {
            return UpdateContentType.POLL;
        }
        if (update.getPollAnswer() != null) {
            return UpdateContentType.POLL_ANSWER;
        }
        if (update.getMyChatMember() != null) {
            return UpdateContentType.MY_CHAT_MEMBER;
        }
        if (update.getChatMember() != null) {
            return UpdateContentType.CHAT_MEMBER;
        }
        if (update.getChatJoinRequest() != null) {
            return UpdateContentType.CHAT_JOIN_REQUEST;
        }
        throw new IllegalArgumentException("Unknown update content type!");
    }

    /**
     * Determines the id of the user from whom {@code update} came
     * @param update processed {@link Update}
     * @return id of the user from whom {@code update} came, or null, for updates in which arrived
     *      information about the poll {@link UpdateContentType#POLL} (does not store the User who voted), about
     *      publishing a channel {@link UpdateContentType#CHANNEL_POST} or changing the channel publication
     *      {@link UpdateContentType#EDITED_CHANNEL_POST} (store fake User, i.e. fake userId)
     */
    public static Long resolveSenderUserId(@NotNull Update update) {
        return resolveSenderUserIdByType(update, contentType(update));
    }

    /**
     * Determines the id of the chat from which the update came
     * @param update processed {@link Update}
     * @return id of the chat from which {@code update} came, or null, for updates in which arrived
     *       inline request {@link UpdateContentType#INLINE_QUERY}, result of inline request
     *       {@link UpdateContentType#CHOSEN_INLINE_QUERY}, shipping request {@link UpdateContentType#SHIPPING_QUERY},
     *       pre-checkout request {@link UpdateContentType#PRE_CHECKOUT_QUERY}, new poll status
     *       {@link UpdateContentType#POLL}, changing the user's answer in the survey {@link UpdateContentType#POLL_ANSWER}
     */
    public static Long resolveSenderChatId(@NotNull Update update) {
        return resolveSenderChatIdByType(update, contentType(update));
    }

    /**
     * Determines the id of the chat thread from which the update came
     * @param update processed {@link Update}
     * @return id of the chat thread from which {@code update} came, or null, for updates, which
     *      types is not {@link UpdateContentType#MESSAGE} or {@link UpdateContentType#CALLBACK_QUERY}
     */
    public static Integer resolveSenderChatThreadId(@NotNull Update update) {
        return resolveSenderChatThreadIdByType(update, contentType(update));
    }

    //endregion
    //region Utils

    private static UpdateContentType contentType(Update update) {
        return (update instanceof ExtendedUpdate e)
                ? e.getContentType()
                : resolveUpdateContentType(update);
    }

    @SuppressWarnings("DataFlowIssue") /*NullPointerException if parameters are incorrect*/
    private static Long resolveSenderUserIdByType(Update update, UpdateContentType contentType) {
        Long userId = 0L;
        switch (contentType) {
            case MESSAGE -> userId = update.getMessage().getFrom().getId();
            case CALLBACK_QUERY -> userId = update.getCallbackQuery().getFrom().getId();
            case EDITED_MESSAGE -> userId = update.getEditedMessage().getFrom().getId();
            case INLINE_QUERY -> userId = update.getInlineQuery().getFrom().getId();
            case CHOSEN_INLINE_QUERY -> userId = update.getChosenInlineResult().getFrom().getId();
            case SHIPPING_QUERY -> userId = update.getShippingQuery().getFrom().getId();
            case PRE_CHECKOUT_QUERY -> userId = update.getPreCheckoutQuery().getFrom().getId();
            case MY_CHAT_MEMBER -> userId = update.getMyChatMember().getFrom().getId();
            case CHAT_MEMBER -> userId = update.getChatMember().getFrom().getId();
            case CHAT_JOIN_REQUEST -> userId = update.getChatJoinRequest().getFrom().getId();
            case POLL_ANSWER -> {
                PollAnswer pollAnswer = update.getPollAnswer();
                if (pollAnswer.getUser() != null) {
                    userId = pollAnswer.getUser().getId();
                } else if (pollAnswer.getVoterChat() != null) {
                    userId = pollAnswer.getVoterChat().getId();
                }
            }
            default -> userId = null;
        }
        return userId;
    }

    @SuppressWarnings("DataFlowIssue") /*NullPointerException if parameters are incorrect*/
    public static Long resolveSenderChatIdByType(Update update, UpdateContentType contentType) {
        Long chatId = 0L;
        switch (contentType) {
            case MESSAGE -> chatId = update.getMessage().getChat().getId();
            case EDITED_MESSAGE -> chatId = update.getEditedMessage().getChat().getId();
            case MY_CHAT_MEMBER -> chatId = update.getMyChatMember().getChat().getId();
            case CHAT_MEMBER -> chatId = update.getChatMember().getChat().getId();
            case CHAT_JOIN_REQUEST -> chatId = update.getChatJoinRequest().getChat().getId();
            case CHANNEL_POST -> chatId = update.getChannelPost().getChat().getId();
            case EDITED_CHANNEL_POST -> chatId = update.getEditedChannelPost().getChat().getId();
            case CALLBACK_QUERY -> {
                Message relatedMessage = update.getCallbackQuery().getMessage();
                if (relatedMessage != null) {
                    chatId = relatedMessage.getChat().getId();
                }
            }
            default -> chatId = null;
        }
        return chatId;
    }

    @SuppressWarnings("DataFlowIssue") /*NullPointerException if parameters are incorrect*/
    private static Integer resolveSenderChatThreadIdByType(Update update, UpdateContentType contentType) {
        switch (contentType) {
            case MESSAGE -> {
                return update.getMessage().getMessageThreadId();
            }
            case CALLBACK_QUERY -> {
                Message relatedMessage = update.getCallbackQuery().getMessage();
                if (relatedMessage != null) {
                    return relatedMessage.getMessageThreadId();
                }
                return null;
            }
            default -> {
                return null;
            }
        }
    }

    //endregion
}