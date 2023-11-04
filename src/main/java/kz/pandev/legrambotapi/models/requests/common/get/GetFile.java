package kz.pandev.legrambotapi.models.requests.common.get;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.common.get.GetFileResponse;
import org.jetbrains.annotations.NotNull;

/**
 * Use this method to get basic information about a file and prepare it for downloading.
 * For the moment, bots can download files of up to 20MB in size (from default Telegram bot API server).
 * On success, a File object is returned.
 * The file can then be downloaded via the link
 * <a href="https://api.telegram.org/file/bot">https://&lt;server_url&gt;/file/bot&lt;token&gt;/&lt;file_path&gt;</a>,
 * where &lt;file_path&gt; is taken from the response.
 * It is guaranteed that the link will be valid for at least 1 hour (on default Telegram bot API server).
 * When the link expires, a new one can be requested by calling getFile again.
 * @author ezuykow
 */
public class GetFile extends Request<GetFile, GetFileResponse> {

    /**
     * @param fileId File identifier to get information about
     */
    public GetFile(@NotNull String fileId) {
        super(GetFileResponse.class);
        addParameter("file_id", fileId);
    }
}