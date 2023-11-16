package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.chat.ChatAdministratorRights;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to change the default administrator rights requested by the bot when it's added
 * as an administrator to groups or channels. These rights will be suggested to users, but they are
 * free to modify the list before adding the bot. Returns True on success.
 * @author ezuykow
 */
public class SetMyDefaultAdministratorRights extends Request<SetMyDefaultAdministratorRights, Response> {

    public SetMyDefaultAdministratorRights() {
        super(Response.class);
    }

    //region API

    /**
     * Set parameter rights
     * @param chatAdministratorRights New default administrator rights. If not specified, the default administrator
     *                               rights will be cleared.
     * @return this request
     */
    public SetMyDefaultAdministratorRights rights(@NotNull ChatAdministratorRights chatAdministratorRights) {
        return addParameter("rights", chatAdministratorRights);
    }

    /**
     * Set parameter for_channels
     * @param forChannels Pass True to change the default administrator rights of the bot in channels. Otherwise,
     *                   the default administrator rights of the bot for groups and supergroups will be changed.
     * @return this request
     */
    public SetMyDefaultAdministratorRights forChannels(boolean forChannels) {
        return addParameter("for_channels", forChannels);
    }

    //endregion
}