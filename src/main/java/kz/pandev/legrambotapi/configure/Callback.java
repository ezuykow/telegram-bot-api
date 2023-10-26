package kz.pandev.legrambotapi.configure;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.Response;


/**
 * Handler of request result with methods onResponse (when request executed successfully) and onFailure
 * (when request executed unsuccessfully)
 * @author ezuykow
 */
public interface Callback<T extends Request<T, R>, R extends Response> {

    void onResponse(T request, R response);

    void onFailure(T request, Exception e);
}