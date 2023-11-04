package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetMyDefaultAdministratorRightsResponse;
import lombok.Getter;
import org.jetbrains.annotations.Nullable;

/**
 * Use this method to get the current default administrator rights of the bot.
 * Returns ChatAdministratorRights on success.
 * @author ezuykow
 */
@Getter
public class GetMyDefaultAdministratorRights extends Request<GetMyDefaultAdministratorRights, GetMyDefaultAdministratorRightsResponse> {

    /**
     * Optional. Pass True to get default administrator rights of the bot in channels. Otherwise,
     * default administrator rights of the bot for groups and supergroups will be returned.
     */
    @Nullable
    private Boolean forChannels;

    public GetMyDefaultAdministratorRights() {
        super(GetMyDefaultAdministratorRightsResponse.class);
    }

    //region API

    /**
     * Set parameter {@link GetMyDefaultAdministratorRights#forChannels}
     * @param forChannels new parameter value
     * @return this request
     */
    public GetMyDefaultAdministratorRights forChannels(boolean forChannels) {
        this.forChannels = forChannels;
        return addParameter("for_channels", forChannels);
    }

    //endregion
}