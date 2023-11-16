package kz.pandev.legrambotapi.addons.update;

import kz.pandev.legrambotapi.models.types.Update;
import kz.pandev.legrambotapi.models.types.common.CallbackQuery;
import kz.pandev.legrambotapi.models.types.common.chat.Chat;
import kz.pandev.legrambotapi.models.types.common.chat.ChatJoinRequest;
import kz.pandev.legrambotapi.models.types.common.chat.member.ChatMemberUpdated;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.common.poll.Poll;
import kz.pandev.legrambotapi.models.types.common.poll.PollAnswer;
import kz.pandev.legrambotapi.models.types.common.user.User;
import kz.pandev.legrambotapi.models.types.inline.mode.ChosenInlineResult;
import kz.pandev.legrambotapi.models.types.inline.mode.InlineQuery;
import kz.pandev.legrambotapi.models.types.payments.PreCheckoutQuery;
import kz.pandev.legrambotapi.models.types.payments.shipping.ShippingQuery;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class UpdateUtilsTest {


    private final Long fakeUserId = 12345L;
    private final Long fakeChatId = 12345L;
    private Update update;
    private User user;
    private Chat chat;

    @BeforeEach
    public void init() {
        update = new Update();
        user = new User();
        user.setId(fakeUserId);
        user.setFirstName("firstName");
        user.setIsBot(false);
        chat = new Chat();
        chat.setId(fakeChatId);
        chat.setType(Chat.Type.GROUP);
    }

    @Test
    void resolveUpdateContentTypeShouldReturnMessage() {
        update.setMessage(new Message());
        assertEquals(UpdateContentType.MESSAGE, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnCallbackQuery() {
        update.setCallbackQuery(new CallbackQuery());
        assertEquals(UpdateContentType.CALLBACK_QUERY, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnEditedMessage() {
        update.setEditedMessage(new Message());
        assertEquals(UpdateContentType.EDITED_MESSAGE, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnChannelPost() {
        update.setChannelPost(new Message());
        assertEquals(UpdateContentType.CHANNEL_POST, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnEditedChannelPost() {
        update.setEditedChannelPost(new Message());
        assertEquals(UpdateContentType.EDITED_CHANNEL_POST, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnInlineQuery() {
        update.setInlineQuery(new InlineQuery());
        assertEquals(UpdateContentType.INLINE_QUERY, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnChosenInlineQuery() {
        update.setChosenInlineResult(new ChosenInlineResult());
        assertEquals(UpdateContentType.CHOSEN_INLINE_RESULT, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnShippingQuery() {
        update.setShippingQuery(new ShippingQuery());
        assertEquals(UpdateContentType.SHIPPING_QUERY, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnPreCheckoutQuery() {
        update.setPreCheckoutQuery(new PreCheckoutQuery());
        assertEquals(UpdateContentType.PRE_CHECKOUT_QUERY, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnPoll() {
        update.setPoll(new Poll());
        assertEquals(UpdateContentType.POLL, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnPollAnswer() {
        update.setPollAnswer(new PollAnswer());
        assertEquals(UpdateContentType.POLL_ANSWER, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnMyChatMember() {
        update.setMyChatMember(new ChatMemberUpdated());
        assertEquals(UpdateContentType.MY_CHAT_MEMBER, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnChatMember() {
        update.setChatMember(new ChatMemberUpdated());
        assertEquals(UpdateContentType.CHAT_MEMBER, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldReturnChatJoinRequest() {
        update.setChatJoinRequest(new ChatJoinRequest());
        assertEquals(UpdateContentType.CHAT_JOIN_REQUEST, UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUpdateContentTypeShouldThrowIllegalArgument() {
        assertThrows(IllegalArgumentException.class, () -> UpdateUtils.resolveUpdateContentType(update));
    }

    @Test
    void resolveUserIdShouldReturnUserIdFromMessage() {
        Message m = new Message();
        m.setFrom(user);
        update.setMessage(m);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnUserIdFromCallbackQuery() {
        CallbackQuery o = new CallbackQuery();
        o.setFrom(user);
        update.setCallbackQuery(o);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnUserIdFromEditedMessage() {
        Message o = new Message();
        o.setFrom(user);
        update.setEditedMessage(o);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnUserIdFromInlineQuery() {
        InlineQuery o = new InlineQuery();
        o.setFrom(user);
        update.setInlineQuery(o);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnUserIdFromChosenInlineResult() {
        ChosenInlineResult o = new ChosenInlineResult();
        o.setFrom(user);
        update.setChosenInlineResult(o);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnUserIdFromShippingQuery() {
        ShippingQuery o = new ShippingQuery();
        o.setFrom(user);
        update.setShippingQuery(o);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnUserIdFromPreCheckoutQuery() {
        PreCheckoutQuery o = new PreCheckoutQuery();
        o.setFrom(user);
        update.setPreCheckoutQuery(o);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnUserIdFromMyChatMemberUpdated() {
        ChatMemberUpdated o = new ChatMemberUpdated();
        o.setFrom(user);
        update.setMyChatMember(o);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnUserIdFromChatMemberUpdated() {
        ChatMemberUpdated o = new ChatMemberUpdated();
        o.setFrom(user);
        update.setChatMember(o);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnUserIdFromChatJoinRequest() {
        ChatJoinRequest o = new ChatJoinRequest();
        o.setFrom(user);
        update.setChatJoinRequest(o);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnUserIdFromPollAnswer() {
        PollAnswer o = new PollAnswer();
        o.setUser(user);
        update.setPollAnswer(o);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnChatIdFromPollAnswer() {
        PollAnswer o = new PollAnswer();
        o.setVoterChat(chat);
        update.setPollAnswer(o);

        assertEquals(fakeUserId, UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveUserIdShouldReturnNull() {
        Poll o = new Poll();
        update.setPoll(o);

        assertNull(UpdateUtils.resolveSenderUserId(update));
    }

    @Test
    void resolveChatIdShouldReturnChatIdFromMessage() {
        Message o = new Message();
        o.setChat(chat);
        update.setMessage(o);

        assertEquals(fakeChatId, UpdateUtils.resolveSenderChatId(update));
    }

    @Test
    void resolveChatIdShouldReturnChatIdFromEditedMessage() {
        Message o = new Message();
        o.setChat(chat);
        update.setEditedMessage(o);

        assertEquals(fakeChatId, UpdateUtils.resolveSenderChatId(update));
    }

    @Test
    void resolveChatIdShouldReturnChatIdFromMyChatMember() {
        ChatMemberUpdated o = new ChatMemberUpdated();
        o.setChat(chat);
        update.setMyChatMember(o);

        assertEquals(fakeChatId, UpdateUtils.resolveSenderChatId(update));
    }

    @Test
    void resolveChatIdShouldReturnChatIdFromChatMember() {
        ChatMemberUpdated o = new ChatMemberUpdated();
        o.setChat(chat);
        update.setChatMember(o);

        assertEquals(fakeChatId, UpdateUtils.resolveSenderChatId(update));
    }

    @Test
    void resolveChatIdShouldReturnChatIdFromChatJoinRequest() {
        ChatJoinRequest o = new ChatJoinRequest();
        o.setChat(chat);
        update.setChatJoinRequest(o);

        assertEquals(fakeChatId, UpdateUtils.resolveSenderChatId(update));
    }

    @Test
    void resolveChatIdShouldReturnChatIdFromChannelPost() {
        Message o = new Message();
        o.setChat(chat);
        update.setChannelPost(o);

        assertEquals(fakeChatId, UpdateUtils.resolveSenderChatId(update));
    }

    @Test
    void resolveChatIdShouldReturnChatIdFromEditedChannelPost() {
        Message o = new Message();
        o.setChat(chat);
        update.setEditedChannelPost(o);

        assertEquals(fakeChatId, UpdateUtils.resolveSenderChatId(update));
    }

    @Test
    void resolveChatIdShouldReturnChatIdFromCallbackQuery() {
        Message m = new Message();
        m.setChat(chat);
        CallbackQuery o = new CallbackQuery();
        o.setMessage(m);
        update.setCallbackQuery(o);

        assertEquals(fakeChatId, UpdateUtils.resolveSenderChatId(update));
    }

    @Test
    void resolveChatIdShouldReturnNull() {
        InlineQuery o = new InlineQuery();
        update.setInlineQuery(o);

        assertNull(UpdateUtils.resolveSenderChatId(update));
    }

    @Test
    void resolveSenderChatThreadIdShouldReturnThreadIdFromUpdateWithMessage() {
        Message m = new Message();
        m.setMessageThreadId(1);
        update.setMessage(m);

        assertEquals(1, UpdateUtils.resolveSenderChatThreadId(update));
    }

    @Test
    void resolveSenderChatThreadIdShouldReturnThreadIdFromUpdateWithCallbackQueryWithMessage() {
        Message m = new Message();
        m.setMessageThreadId(1);
        CallbackQuery c = new CallbackQuery();
        c.setMessage(m);
        update.setCallbackQuery(c);

        assertEquals(1, UpdateUtils.resolveSenderChatThreadId(update));
    }

    @Test
    void resolveSenderChatThreadIdShouldReturnNullFromUpdateWithCallbackQueryWithoutMessage() {
        CallbackQuery c = new CallbackQuery();
        update.setCallbackQuery(c);

        assertNull(UpdateUtils.resolveSenderChatThreadId(update));
    }

    @Test
    void resolveSenderChatThreadIdShouldReturnNull() {
        ShippingQuery c = new ShippingQuery();
        update.setShippingQuery(c);

        assertNull(UpdateUtils.resolveSenderChatThreadId(update));
    }
}