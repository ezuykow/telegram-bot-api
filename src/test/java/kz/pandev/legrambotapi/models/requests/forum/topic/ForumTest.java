package kz.pandev.legrambotapi.models.requests.forum.topic;

import kz.pandev.legrambotapi.exceptions.WrongParameterTypeException;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.common.CreateForumTopicResponse;
import kz.pandev.legrambotapi.models.types.common.forum.ForumTopic;
import kz.pandev.legrambotapi.models.types.stickers.Sticker;
import org.junit.jupiter.api.Test;

import java.util.List;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class ForumTest {

    @Test
    void getForumTopicIconStickers() throws InterruptedException {
        List<Sticker> stickers = bot.execute(new GetForumTopicIconStickers()).getStickers();
        assertFalse(stickers.isEmpty());
        Thread.sleep(1000);
    }

    @Test
    void createForumTopic() throws InterruptedException {
        Integer color = 7322096;
        String emoji = "5434144690511290129";
        CreateForumTopicResponse createResponse = bot.execute(
                new CreateForumTopic(testGroupId, "test_topic").iconColor(color).iconCustomEmojiId(emoji)
        );
        assertTrue(createResponse.isOk());
        ForumTopic topic = createResponse.getForumTopic();
        assertNotNull(topic);
        assertEquals(color, topic.getIconColor());
        assertEquals(emoji, topic.getIconCustomEmojiId());

        assertThrows(WrongParameterTypeException.class, () ->
                new CreateForumTopic(testImage, "test_topic"));

        String name = "test_topic_edit";
        Response response = bot.execute(
                new EditForumTopic(testGroupId, topic.getMessageThreadId()).name(name).iconCustomEmojiId("")
        );
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                new EditForumTopic(testImage, topic.getMessageThreadId()));

        response = bot.execute(new CloseForumTopic(testGroupId, topic.getMessageThreadId()));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new CloseForumTopic(testImage, topic.getMessageThreadId())));

        response = bot.execute(new ReopenForumTopic(testGroupId, topic.getMessageThreadId()));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new ReopenForumTopic(testImage, topic.getMessageThreadId())));

        response = bot.execute(new DeleteForumTopic(testGroupId, topic.getMessageThreadId()));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new DeleteForumTopic(testImage, topic.getMessageThreadId())));

        Thread.sleep(1000);
    }

    @Test
    void unpinAllForumTopicMessages() throws InterruptedException {
        Response response = bot.execute(new UnpinAllForumTopicMessages(testGroupId, 1));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new UnpinAllForumTopicMessages(testImage, 1)));

        Thread.sleep(1000);
    }

    @Test
    void unpinAllGeneralForumTopicMessages() throws InterruptedException {
        Response response = bot.execute(new UnpinAllGeneralForumTopicMessages(testGroupId));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new UnpinAllGeneralForumTopicMessages(testImage)));

        Thread.sleep(1000);
    }

    @Test
    void editGeneralForumTopic() throws InterruptedException {
        String name = "General " + System.currentTimeMillis();
        Response response = bot.execute(new EditGeneralForumTopic(testGroupId, name));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new EditGeneralForumTopic(testImage, name)));

        response = bot.execute(new CloseGeneralForumTopic(testGroupId));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new CloseGeneralForumTopic(testImage)));

        response = bot.execute(new HideGeneralForumTopic(testGroupId));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new HideGeneralForumTopic(testImage)));

        response = bot.execute(new UnhideGeneralForumTopic(testGroupId));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new UnhideGeneralForumTopic(testImage)));

        response = bot.execute(new ReopenGeneralForumTopic(testGroupId));
        assertTrue(response.isOk());

        assertThrows(WrongParameterTypeException.class, () ->
                bot.execute(new ReopenGeneralForumTopic(testImage)));

        Thread.sleep(1000);
    }

}