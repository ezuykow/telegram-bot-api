package kz.pandev.legrambotapi.models.requests.forum.topic;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetForumTopicIconStickersResponse;

/**
 * Use this method to get custom emoji stickers, which can be used as a forum topic icon by any user.
 * Requires no parameters. Returns an Array of Sticker objects.
 * @author ezuykow
 */
public class GetForumTopicIconStickers extends Request<GetForumTopicIconStickers, GetForumTopicIconStickersResponse> {

    public GetForumTopicIconStickers() {
        super(GetForumTopicIconStickersResponse.class);
    }

}