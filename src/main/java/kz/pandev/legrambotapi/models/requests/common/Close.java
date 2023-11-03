package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;

/**
 * Use this method to close the bot instance before moving it from one local
 * server to another. You need to delete the webhook before calling this method
 * to ensure that the bot isn't launched again after server restart. The method
 * will return error 429 in the first 10 minutes after the bot is launched.
 * Returns True on success. Requires no parameters.
 * @author ezuykow
 */
public class Close extends Request<Close, Response> {

    public Close() {
        super(Response.class);
    }
}