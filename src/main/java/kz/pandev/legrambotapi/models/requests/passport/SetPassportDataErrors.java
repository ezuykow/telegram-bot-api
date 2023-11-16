package kz.pandev.legrambotapi.models.requests.passport;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;
import kz.pandev.legrambotapi.models.types.passport.errors.PassportElementError;
import org.jetbrains.annotations.NotNull;

/**
 * Informs a user that some of the Telegram Passport elements they provided contains errors.
 * The user will not be able to re-submit their Passport to you until the errors are fixed
 * (the contents of the field for which you returned the error must change). Returns True on success. <br>
 * Use this if the data submitted by the user doesn't satisfy the standards your service requires for any reason.
 * For example, if a birthday date seems invalid, a submitted document is blurry, a scan shows evidence of
 * tampering, etc. Supply some details in the error message to make sure the user knows how to correct the issues.
 * @author ezuykow
 */
public class SetPassportDataErrors extends Request<SetPassportDataErrors, Response> {

    public SetPassportDataErrors(long userId, @NotNull PassportElementError... errors) {
        super(Response.class);
        addParameter("user_id", userId);
        addParameter("errors", errors);
    }
}