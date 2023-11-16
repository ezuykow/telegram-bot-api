package kz.pandev.legrambotapi.models.requests.payments;

import kz.pandev.legrambotapi.models.requests.Request;
import kz.pandev.legrambotapi.models.responses.StringResponse;
import kz.pandev.legrambotapi.models.types.payments.LabeledPrice;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

/**
 * Use this method to create a link for an invoice. Returns the created invoice link as String on success.
 * @author ezuykow
 */
public class CreateInvoiceLink extends Request<CreateInvoiceLink, StringResponse> {

    /**
     * @param title Product name, 1-32 characters
     * @param description Product description, 1-255 characters
     * @param payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user,
     *               use for your internal processes.
     * @param providerToken Payment provider token, obtained via @BotFather
     * @param currency Three-letter ISO 4217 currency code, see more on
     *                 <a href="https://core.telegram.org/bots/payments#supported-currencies">currencies</a>
     * @param prices Price breakdown, array of components (e.g. product price, tax, discount, delivery cost,
     *              delivery tax, bonus, etc.)
     */
    public CreateInvoiceLink(@NotNull String title, @NotNull String description, @NotNull  String payload,
                             @NotNull String providerToken, @NotNull String currency, @NotNull LabeledPrice... prices) {
        this(title, description, payload, providerToken, currency, Arrays.asList(prices));
    }

    /**
     * @param title Product name, 1-32 characters
     * @param description Product description, 1-255 characters
     * @param payload Bot-defined invoice payload, 1-128 bytes. This will not be displayed to the user,
     *               use for your internal processes.
     * @param providerToken Payment provider token, obtained via @BotFather
     * @param currency Three-letter ISO 4217 currency code, see more on
     *                 <a href="https://core.telegram.org/bots/payments#supported-currencies">currencies</a>
     * @param prices Price breakdown, list of components (e.g. product price, tax, discount, delivery cost,
     *              delivery tax, bonus, etc.)
     */
    public CreateInvoiceLink(@NotNull String title, @NotNull String description, @NotNull  String payload,
                       @NotNull String providerToken, @NotNull String currency, @NotNull List<LabeledPrice> prices) {
        super(StringResponse.class);
        addParameter("title", title);
        addParameter("description", description);
        addParameter("payload", payload);
        addParameter("provider_token", providerToken);
        addParameter("currency", currency);
        addParameter("prices", prices);
    }

    //region API

    /**
     * Set parameter provider_data
     * @param providerData Data about the invoice, which will be shared with the payment provider. A detailed
     *                     description of required fields should be provided by the payment provider.
     * @return this request
     */
    public CreateInvoiceLink providerData(@NotNull String providerData) {
        return addParameter("provider_data", providerData);
    }

    /**
     * Set parameter photo_url
     * @param photoUrl URL of the product photo for the invoice. Can be a photo of the goods or a marketing image
     *                 for a service. People like it better when they see what they are paying for.
     * @return this request
     */
    public CreateInvoiceLink photoUrl(@NotNull String photoUrl) {
        return addParameter("photo_url", photoUrl);
    }

    /**
     * Set parameter photo_size
     * @param photoSize Photo size in bytes
     * @return this request
     */
    public CreateInvoiceLink photoSize(int photoSize) {
        return addParameter("photo_size", photoSize);
    }

    /**
     * Set parameter photo_width
     * @param photoWidth Photo width
     * @return this request
     */
    public CreateInvoiceLink photoWidth(int photoWidth) {
        return addParameter("photo_width", photoWidth);
    }

    /**
     * Set parameter photo_height
     * @param photoHeight Photo height
     * @return this request
     */
    public CreateInvoiceLink photoHeight(int photoHeight) {
        return addParameter("photo_height", photoHeight);
    }

    /**
     * Set parameter need_name
     * @param needName Pass True if you require the user's full name to complete the order
     * @return this request
     */
    public CreateInvoiceLink needName(boolean needName) {
        return addParameter("need_name", needName);
    }

    /**
     * Set parameter need_phone_number
     * @param needPhoneNumber Pass True if you require the user's phone number to complete the order
     * @return this request
     */
    public CreateInvoiceLink needPhoneNumber(boolean needPhoneNumber) {
        return addParameter("need_phone_number", needPhoneNumber);
    }

    /**
     * Set parameter need_email
     * @param needEmail Pass True if you require the user's email address to complete the order
     * @return this request
     */
    public CreateInvoiceLink needEmail(boolean needEmail) {
        return addParameter("need_email", needEmail);
    }

    /**
     * Set parameter need_shipping_address
     * @param needShippingAddress Pass True if you require the user's shipping address to complete the order
     * @return this request
     */
    public CreateInvoiceLink needShippingAddress(boolean needShippingAddress) {
        return addParameter("need_shipping_address", needShippingAddress);
    }

    /**
     * Set parameter is_flexible
     * @param isFlexible Pass True if the final price depends on the shipping method
     * @return this request
     */
    public CreateInvoiceLink isFlexible(boolean isFlexible) {
        return addParameter("is_flexible", isFlexible);
    }

    /**
     * Set parameter max_tip_amount
     * @param maxTipAmount The maximum accepted amount for tips in the smallest units of
     *      the currency (integer, not float/double). For example, for a maximum tip
     *      of US$ 1.45 pass max_tip_amount = 145. See the exp parameter in
     *      <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>,
     *      it shows the number of digits past the decimal point for each currency
     *      (2 for the majority of currencies). Defaults to 0
     * @return this request
     */
    public CreateInvoiceLink maxTipAmount(int maxTipAmount) {
        return addParameter("max_tip_amount", maxTipAmount);
    }

    /**
     * Set parameter suggested_tip_amounts
     * @param suggestedTipAmounts List of suggested amounts of tips in the smallest units of the currency
     *                            (integer, not float/double). At most 4 suggested tip amounts can be specified.
     *                            The suggested tip amounts must be positive, passed in a strictly increased order
     *                            and must not exceed max_tip_amount.
     * @return this request
     */
    public CreateInvoiceLink suggestedTipAmounts(@NotNull List<Integer> suggestedTipAmounts) {
        return addParameter("suggested_tip_amounts", suggestedTipAmounts);
    }

    /**
     * Set parameter send_email_number_to_provider
     * @param sendEmailToProvider Pass True if the user's email number should be sent to provider
     * @return this request
     */
    public CreateInvoiceLink sendEmailToProvider(boolean sendEmailToProvider) {
        return addParameter("Pass True if the user's email address should be sent to provider", sendEmailToProvider);
    }

    /**
     * Set parameter send_phone_number_to_provider
     * @param sendPhoneNumberToProvider Pass True if the user's phone number should be sent to provider
     * @return this request
     */
    public CreateInvoiceLink sendPhoneNumberToProvider(boolean sendPhoneNumberToProvider) {
        return addParameter("send_phone_number_to_provider", sendPhoneNumberToProvider);
    }

    //endregion
}