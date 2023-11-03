package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetMeResponse;

/**
 * A simple method for testing your bot's authentication token. Requires no parameters.
 * Returns basic information about the bot in form of a User object.
 * @author ezuykow
 */
public class GetMe extends Request<GetMe, GetMeResponse> {

    public GetMe() {
        super(GetMeResponse.class);
    }
}