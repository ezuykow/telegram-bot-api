package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyDefaultAdministratorRightsResponse;

/**
 * Use this method to get the current default administrator rights of the bot.
 * Returns ChatAdministratorRights on success.
 * @author ezuykow
 */
public class GetMyDefaultAdministratorRights extends Request<GetMyDefaultAdministratorRights, GetMyDefaultAdministratorRightsResponse> {

    public GetMyDefaultAdministratorRights() {
        super(GetMyDefaultAdministratorRightsResponse.class);
    }

    //region API

    /**
     * Set parameter for_channels
     * @param forChannels Pass True to get default administrator rights of the bot in channels. Otherwise, default
     *                   administrator rights of the bot for groups and supergroups will be returned.
     * @return this request
     */
    public GetMyDefaultAdministratorRights forChannels(boolean forChannels) {
        return addParameter("for_channels", forChannels);
    }

    //endregion
}