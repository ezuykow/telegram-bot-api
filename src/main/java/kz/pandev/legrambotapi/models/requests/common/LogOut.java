package kz.pandev.legrambotapi.models.requests.common;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;

/**
 * Use this method to log out from the cloud Bot API
 * server before launching the bot locally.
 * You must log out the bot before running it locally,
 * otherwise there is no guarantee that the bot will receive updates.
 * After a successful call, you can immediately log in on a local server,
 * but will not be able to log in back to the cloud Bot API server for
 * 10 minutes. Returns True on success. Requires no parameters.
 * @author ezuykow
 */
public class LogOut extends Request<LogOut, Response> {

    public LogOut() {
        super(Response.class);
    }
}