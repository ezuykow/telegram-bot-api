package kz.pandev.legrambotapi.models.requests.stickers;

import kz.pandev.legrambotapi.additional.test.classes.FileTest;
import kz.pandev.legrambotapi.additional.test.classes.MessageTest;
import kz.pandev.legrambotapi.additional.test.classes.PhotoSizeTest;
import kz.pandev.legrambotapi.additional.test.classes.StickerTest;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.responses.common.get.GetFileResponse;
import kz.pandev.legrambotapi.models.responses.stickers.GetCustomEmojiStickersResponse;
import kz.pandev.legrambotapi.models.responses.stickers.GetStickerSetResponse;
import kz.pandev.legrambotapi.models.types.common.PhotoSize;
import kz.pandev.legrambotapi.models.types.common.message.Message;
import kz.pandev.legrambotapi.models.types.stickers.InputSticker;
import kz.pandev.legrambotapi.models.types.stickers.MaskPosition;
import kz.pandev.legrambotapi.models.types.stickers.Sticker;
import kz.pandev.legrambotapi.models.types.stickers.StickerSet;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

import static kz.pandev.legrambotapi.Config.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author ezuykow
 */
class StickersTest {

    @Test
    void sendSticker() throws InterruptedException {
        Message message = bot.execute(new SendSticker(personalChatId, testAnimatedSticker).emoji("\uD83D\uDE00")).getMessage();
        MessageTest.checkMessage(message);
        StickerTest.check(message.getSticker(), false, true);
        assertTrue(message.getSticker().getIsAnimated());
        assertEquals("\uD83D\uDE00", message.getSticker().getEmoji());
        assertEquals(Sticker.Type.REGULAR, message.getSticker().getType());

        message = bot.execute(new SendSticker(personalChatId, testStaticSticker).thumbnail(testThumbnail)
                .emoji("\uD83D\uDE00")).getMessage();
        MessageTest.checkMessage(message);
        StickerTest.check(message.getSticker(), true, false);
        assertFalse(message.getSticker().getIsAnimated());

        message = bot.execute(new SendSticker(personalChatId, testImageBytes).thumbnail(testThumbnailBytes)).getMessage();
        MessageTest.checkMessage(message);
        StickerTest.check(message.getSticker(), false, true);
        Thread.sleep(1000);
    }

    @Test
    void uploadStickerFile() throws IOException, InterruptedException {
        byte[] bytes = Files.readAllBytes(testStaticSticker.toPath());
        GetFileResponse response = bot.execute(new UploadStickerFile(myUserID, bytes, Sticker.Format.STATIC));
        FileTest.check(response.getFile(), false);
        Thread.sleep(1000);
    }

    @Test
    void createNewStickerSet() throws InterruptedException {
        String setName = "test_" + System.currentTimeMillis() + "_by_ZuyTestingBot";
        String title = "test112312312";
        CreateNewStickerSet req = new CreateNewStickerSet(myUserID, setName, title, List.of(
                new InputSticker(testStaticSticker, List.of("\uD83D\uDE00"))
                        .keywords(List.of("yes", "no"))
                        .maskPosition(new MaskPosition(MaskPosition.Point.FOREHEAD, 10f, 20f, 1f))
        ), Sticker.Format.STATIC)
                .stickerType(Sticker.Type.REGULAR)
                .needsRepainting(false);
        Response response = bot.execute(req);
        System.out.println(response);
        assertTrue(response.isOk());

        StickerSet set = bot.execute(new GetStickerSet(setName)).getStickerSet();
        assertEquals(setName, set.getName());
        assertEquals(title, set.getTitle());
        if (set.getIsVideo() != null) {
            assertFalse(set.getIsVideo());
        }
        List<Sticker> stickers = set.getStickers();
        assertEquals(1, stickers.size());
        assertEquals("\uD83D\uDE00", stickers.get(0).getEmoji());
        if (set.getIsVideo() != null) {
            assertFalse(stickers.get(0).getIsVideo());
        }
        assertNull(stickers.get(0).getNeedsRepainting());
        assertNull(stickers.get(0).getPremiumAnimation());
        assertNull(stickers.get(0).getCustomEmojiId());

        response = bot.execute(new SetStickerSetTitle(setName, "new title"));
        assertTrue(response.isOk());

        String stickerId = stickers.get(0).getFileId();
        response = bot.execute(new SetStickerEmojiList(stickerId, List.of("\uD83D\uDE00")));
        assertTrue(response.isOk());

        response = bot.execute(new SetStickerKeywords(stickerId).keywords(List.of("ok")));
        assertTrue(response.isOk());

        response = bot.execute(new SetStickerMaskPosition(stickerId)
                .maskPosition(new MaskPosition(MaskPosition.Point.MOUTH, 0f, 0f, 0f)));
        assertFalse(response.isOk());
        assertEquals("Bad Request: STICKER_MASK_COORDS_NOT_SUPPORTED", response.getDescription());

        response = bot.execute(new AddStickerToSet(myUserID, setName,
                new InputSticker(testStaticSticker, List.of("\uD83D\uDE00"))));
        assertTrue(response.isOk());

        response = bot.execute(new DeleteStickerSet(setName));
        assertTrue(response.isOk());
        Thread.sleep(1000);
    }

    @Test
    void getStickerSet() throws InterruptedException {
        String setName = "test_" + System.currentTimeMillis() + "_by_ZuyTestingBot";
        String title = "test112312312";
        CreateNewStickerSet req = new CreateNewStickerSet(myUserID, setName, title, List.of(
                new InputSticker(testStaticSticker, List.of("\uD83D\uDE00"))
                        .maskPosition(new MaskPosition(MaskPosition.Point.FOREHEAD, 10f, 20f, 1f))
        ), Sticker.Format.STATIC)
                .stickerType(Sticker.Type.MASK);
        bot.execute(req);

        GetStickerSetResponse response = bot.execute(new GetStickerSet(setName));
        System.out.println(response);
        StickerSet stickerSet = response.getStickerSet();
        for (Sticker sticker : response.getStickerSet().getStickers()) {
            StickerTest.check(sticker, true, true);
        }
        // clean up stickers, max 120 allowed
        if (stickerSet.getStickers().size() > 50) {
            for (int i = stickerSet.getStickers().size() - 1; i > stickerSet.getStickers().size() - 10; i--) {
                bot.execute(new DeleteStickerFromSet(stickerSet.getStickers().get(i).getFileId()));
            }
        }
        assertEquals(Sticker.Type.MASK, stickerSet.getStickerType());
        assertEquals(setName, stickerSet.getName());
        assertEquals(title, stickerSet.getTitle());
        if (stickerSet.getIsAnimated()) {
            assertFalse(stickerSet.getIsAnimated());
        }

        Sticker sticker = stickerSet.getStickers().get(0);
        assertEquals(setName, sticker.getSetName());
        MaskPosition maskPosition = sticker.getMaskPosition();
        assertEquals(MaskPosition.Point.FOREHEAD.name().toLowerCase(), maskPosition.getPoint());
        assertEquals(10f, maskPosition.getXShift(), 0.01f);
        assertEquals(20f, maskPosition.getYShift(), 0.01f);
        assertEquals(1f, maskPosition.getScale(), 0.01f);

        Response execute = bot.execute(new DeleteStickerSet(setName));
        assertTrue(execute.isOk());
        Thread.sleep(1000);
    }

    @Test
    void setStickerPositionInSet() throws InterruptedException {
        String setName = "test_" + System.currentTimeMillis() + "_by_ZuyTestingBot";
        String title = "test112312312";
        CreateNewStickerSet req = new CreateNewStickerSet(myUserID, setName, title, List.of(
                new InputSticker(testStaticSticker, List.of("\uD83D\uDE00"))
                        .maskPosition(new MaskPosition(MaskPosition.Point.FOREHEAD, 10f, 20f, 1f)),
                new InputSticker(testStaticSticker, List.of("\uD83D\uDE00"))
                        .maskPosition(new MaskPosition(MaskPosition.Point.FOREHEAD, 10f, 20f, 1f))
        ), Sticker.Format.STATIC);
        bot.execute(req);

        GetStickerSetResponse setResponse = bot.execute(new GetStickerSet(setName));
        Sticker sticker = setResponse.getStickerSet().getStickers().get(0);

        Response response = bot.execute(new SetStickerPositionInSet(sticker.getFileId(), 0));
        assertTrue(response.isOk());

        Response execute = bot.execute(new DeleteStickerSet(setName));
        assertTrue(execute.isOk());
        Thread.sleep(1000);
    }

    @Test
    void deleteStickerFromSet() throws InterruptedException {
        String setName = "test_" + System.currentTimeMillis() + "_by_ZuyTestingBot";
        String title = "test112312312";
        CreateNewStickerSet req = new CreateNewStickerSet(myUserID, setName, title, List.of(
                new InputSticker(testStaticSticker, List.of("\uD83D\uDE00"))
                        .maskPosition(new MaskPosition(MaskPosition.Point.FOREHEAD, 10f, 20f, 1f)),
                new InputSticker(testStaticSticker, List.of("\uD83D\uDE00"))
                        .maskPosition(new MaskPosition(MaskPosition.Point.FOREHEAD, 10f, 20f, 1f))
        ), Sticker.Format.STATIC);
        bot.execute(req);

        GetStickerSetResponse setResponse = bot.execute(new GetStickerSet(setName));
        int size = setResponse.getStickerSet().getStickers().size();
        Sticker sticker = setResponse.getStickerSet().getStickers().get(setResponse.getStickerSet().getStickers().size() - 1);

        Response response = bot.execute(new DeleteStickerFromSet(sticker.getFileId()));
        if (!response.isOk()) {
            assertEquals(400, response.getErrorCode());
            assertEquals("Bad Request: STICKERSET_NOT_MODIFIED", response.getDescription());
        } else {
            assertTrue(response.isOk());
        }

        Response execute = bot.execute(new DeleteStickerSet(setName));
        assertTrue(execute.isOk());
        Thread.sleep(1000);
    }

    @Test
    void setStickerSetThumb() throws InterruptedException {
        String setName = "test_" + System.currentTimeMillis() + "_by_ZuyTestingBot";
        String title = "test112312312";
        CreateNewStickerSet req = new CreateNewStickerSet(myUserID, setName, title, List.of(
                new InputSticker(testAnimatedSticker, List.of("\uD83D\uDE00"))
                        .maskPosition(new MaskPosition(MaskPosition.Point.FOREHEAD, 10f, 20f, 1f))
        ), Sticker.Format.ANIMATED)
                .stickerType(Sticker.Type.REGULAR);
        bot.execute(req);

        Response response = bot.execute(new SetStickerSetThumbnail(setName, myUserID, testAnimatedSticker));
        assertTrue(response.isOk());

        StickerSet set = bot.execute(new GetStickerSet(setName)).getStickerSet();
        assertTrue(set.getIsAnimated());
        PhotoSize thumb = set.getThumbnail();
        PhotoSizeTest.checkPhotos(List.of(thumb));
        assertEquals(100, thumb.getWidth());
        assertEquals(100, thumb.getHeight());
        assertEquals(8244, thumb.getFileSize());

        // clear thumb by not sending it
        response = bot.execute(new SetStickerSetThumbnail(setName, myUserID));
        assertTrue(response.isOk());

        Response execute = bot.execute(new DeleteStickerSet(setName));
        assertTrue(execute.isOk());
        Thread.sleep(1000);
    }

    @Test
    void getCustomEmojiStickers() throws InterruptedException {
        GetCustomEmojiStickersResponse response = bot.execute(new GetCustomEmojiStickers("5434144690511290129"));
        assertTrue(response.isOk());
        assertEquals(1, response.getStickers().size());
        Thread.sleep(1000);
    }

    @Test
    void setCustomEmojiStickerSetThumbnail() throws InterruptedException {
        String setName = "test_" + System.currentTimeMillis() + "_by_ZuyTestingBot";

        Response response = bot.execute(
                new CreateNewStickerSet(myUserID, setName, "title",
                        List.of((new InputSticker(testAnimatedSticker, List.of("\uD83D\uDE15")))),
                        Sticker.Format.ANIMATED
                )
                        .stickerType(Sticker.Type.CUSTOM_EMOJI)
        );
        assertTrue(response.isOk());

        response = bot.execute(new SetCustomEmojiStickerSetThumbnail(setName).customEmojiId("0"));
        assertTrue(response.isOk());

        response = bot.execute(new DeleteStickerSet(setName));
        assertTrue(response.isOk());
        Thread.sleep(1000);
    }

}