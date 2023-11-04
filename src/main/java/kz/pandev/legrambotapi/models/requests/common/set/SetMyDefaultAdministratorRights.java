package kz.pandev.legrambotapi.models.requests.common.set;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.common.chat.ChatAdministratorRights;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to change the default administrator rights requested by the bot when it's added
 * as an administrator to groups or channels. These rights will be suggested to users, but they are
 * free to modify the list before adding the bot. Returns True on success.
 * @author ezuykow
 */
@Getter
public class SetMyDefaultAdministratorRights extends Request<SetMyDefaultAdministratorRights, Response> {

    /**
     * Optional. New default administrator rights. If not specified, the default administrator rights will be cleared.
     */
    @Nullable
    private ChatAdministratorRights rights;
    /**
     * Optional. Pass True to change the default administrator rights of the bot in channels. Otherwise,
     * the default administrator rights of the bot for groups and supergroups will be changed.
     */
    @Nullable
    private Boolean forChannels;

    public SetMyDefaultAdministratorRights() {
        super(Response.class);
    }

    //region API

    /**
     * Set parameter {@link SetMyDefaultAdministratorRights#rights}
     * @param chatAdministratorRights new parameter value
     * @return this request
     */
    public SetMyDefaultAdministratorRights rights(ChatAdministratorRights chatAdministratorRights) {
        this.rights = chatAdministratorRights;
        return addParameter("rights", chatAdministratorRights);
    }

    /**
     * Set parameter {@link SetMyDefaultAdministratorRights#forChannels}
     * @param forChannels new parameter value
     * @return this request
     */
    public SetMyDefaultAdministratorRights forChannels(boolean forChannels) {
        this.forChannels = forChannels;
        return addParameter("for_channels", forChannels);
    }

    //endregion
}