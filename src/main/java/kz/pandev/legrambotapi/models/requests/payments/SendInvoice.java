package kz.pandev.legrambotapi.models.requests.payments;

import kz.pandev.legrambotapi.models.requests.AbstractSendRequest;
import kz.pandev.legrambotapi.models.types.payments.LabeledPrice;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

/**
 * Use this method to send invoices. On success, the sent Message is returned.
 * @author ezuykow
 */
@Getter
public class SendInvoice extends AbstractSendRequest<SendInvoice> {

    /**
     * Optional. Data about the invoice, which will be shared with the payment provider.
     * A detailed description of required fields should be provided by the payment provider.
     */
    @Nullable
    private String providerData;
    /**
     * Optional. URL of the product photo for the invoice. Can be a photo of the goods or a marketing
     * image for a service. People like it better when they see what they are paying for.
     */
    @Nullable
    private String photoUrl;
    /**
     * Optional. Photo size in bytes
     */
    @Nullable
    private Integer photoSize;
    /**
     * Optional. Photo width
     */
    @Nullable
    private Integer photoWidth;
    /**
     * Optional. Photo height
     */
    @Nullable
    private Integer photoHeight;
    /**
     * Optional. Pass True if you require the user's full name to complete the order
     */
    @Nullable
    private Boolean needName;
    /**
     * Optional. Pass True if you require the user's phone number to complete the order
     */
    @Nullable
    private Boolean needPhoneNumber;
    /**
     * Optional. Pass True if you require the user's email address to complete the order
     */
    @Nullable
    private Boolean needEmail;
    /**
     * Optional. Pass True if you require the user's shipping address to complete the order
     */
    @Nullable
    private Boolean needShippingAddress;
    /**
     * Optional. Pass True if the final price depends on the shipping method
     */
    @Nullable
    private Boolean isFlexible;
    /**
     * Optional. Unique deep-linking parameter. If left empty, forwarded copies of the sent
     * message will have a Pay button, allowing multiple users to pay directly from the forwarded
     * message, using the same invoice. If non-empty, forwarded copies of the sent message will
     * have a URL button with a deep link to the bot (instead of a Pay button), with the value
     * used as the start parameter
     */
    @Nullable
    private String startParameter;
    /**
     * Optional. The maximum accepted amount for tips in the smallest units of
     * the currency (integer, not float/double). For example, for a maximum tip
     * of US$ 1.45 pass max_tip_amount = 145. See the exp parameter in
     * <a href="https://core.telegram.org/bots/payments/currencies.json">currencies.json</a>,
     * it shows the number of digits past the decimal point for each currency
     * (2 for the majority of currencies). Defaults to 0
     */
    @Nullable
    private Integer maxTipAmount;
    /**
     * Optional. List of suggested amounts of tips in the smallest units
     * of the currency (integer, not float/double). At most 4 suggested
     * tip amounts can be specified. The suggested tip amounts must be positive,
     * passed in a strictly increased order and must not exceed max_tip_amount.
     */
    @Nullable
    private List<Integer> suggestedTipAmounts;
    /**
     * Optional. Pass True if the user's email address should be sent to provider
     */
    @Nullable
    private Boolean sendEmailToProvider;
    /**
     * Optional. Pass True if the user's phone number should be sent to provider
     */
    @Nullable
    private Boolean sendPhoneNumberToProvider;


    /**
     * @param chatId Unique identifier for the target chat or username of the target channel
     *               (in the format @channelusername)
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
    public SendInvoice(@NotNull Object chatId, @NotNull String title, @NotNull String description, @NotNull String payload,
                       @NotNull String providerToken, @NotNull String currency, @NotNull LabeledPrice... prices) {
        this(chatId, title, description, payload, providerToken, currency, Arrays.asList(prices));
    }

    /**
     * @param chatId Unique identifier for the target chat or username of the target channel
     *               (in the format @channelusername)
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
    public SendInvoice(@NotNull Object chatId, @NotNull String title, @NotNull String description,@NotNull  String payload,
                       @NotNull String providerToken, @NotNull String currency, @NotNull List<LabeledPrice> prices) {
        super(chatId);
        addParameter("title", title);
        addParameter("description", description);
        addParameter("payload", payload);
        addParameter("provider_token", providerToken);
        addParameter("currency", currency);
        addParameter("prices", prices);
    }

    //region API

    /**
     * Set parameter {@link SendInvoice#providerData}
     * @param providerData new parameter value
     * @return this request
     */
    public SendInvoice providerData(@NotNull String providerData) {
        this.providerData = providerData;
        return addParameter("provider_data", providerData);
    }

    /**
     * Set parameter {@link SendInvoice#photoUrl}
     * @param photoUrl new parameter value
     * @return this request
     */
    public SendInvoice photoUrl(@NotNull String photoUrl) {
        this.photoUrl = photoUrl;
        return addParameter("photo_url", photoUrl);
    }

    /**
     * Set parameter {@link SendInvoice#photoSize}
     * @param photoSize new parameter value
     * @return this request
     */
    public SendInvoice photoSize(int photoSize) {
        this.photoSize = photoSize;
        return addParameter("photo_size", photoSize);
    }

    /**
     * Set parameter {@link SendInvoice#photoWidth}
     * @param photoWidth new parameter value
     * @return this request
     */
    public SendInvoice photoWidth(int photoWidth) {
        this.photoWidth = photoWidth;
        return addParameter("photo_width", photoWidth);
    }

    /**
     * Set parameter {@link SendInvoice#photoHeight}
     * @param photoHeight new parameter value
     * @return this request
     */
    public SendInvoice photoHeight(int photoHeight) {
        this.photoHeight = photoHeight;
        return addParameter("photo_height", photoHeight);
    }

    /**
     * Set parameter {@link SendInvoice#needName}
     * @param needName new parameter value
     * @return this request
     */
    public SendInvoice needName(boolean needName) {
        this.needName = needName;
        return addParameter("need_name", needName);
    }

    /**
     * Set parameter {@link SendInvoice#needPhoneNumber}
     * @param needPhoneNumber new parameter value
     * @return this request
     */
    public SendInvoice needPhoneNumber(boolean needPhoneNumber) {
        this.needPhoneNumber = needPhoneNumber;
        return addParameter("need_phone_number", needPhoneNumber);
    }

    /**
     * Set parameter {@link SendInvoice#needEmail}
     * @param needEmail new parameter value
     * @return this request
     */
    public SendInvoice needEmail(boolean needEmail) {
        this.needEmail = needEmail;
        return addParameter("need_email", needEmail);
    }

    /**
     * Set parameter {@link SendInvoice#needShippingAddress}
     * @param needShippingAddress new parameter value
     * @return this request
     */
    public SendInvoice needShippingAddress(boolean needShippingAddress) {
        this.needShippingAddress = needShippingAddress;
        return addParameter("need_shipping_address", needShippingAddress);
    }

    /**
     * Set parameter {@link SendInvoice#isFlexible}
     * @param isFlexible new parameter value
     * @return this request
     */
    public SendInvoice isFlexible(boolean isFlexible) {
        this.isFlexible = isFlexible;
        return addParameter("is_flexible", isFlexible);
    }

    /**
     * Set parameter {@link SendInvoice#startParameter}
     * @param startParameter new parameter value
     * @return this request
     */
    public SendInvoice startParameter(@NotNull String startParameter) {
        this.startParameter = startParameter;
        return addParameter("start_parameter", startParameter);
    }

    /**
     * Set parameter {@link SendInvoice#maxTipAmount}
     * @param maxTipAmount new parameter value
     * @return this request
     */
    public SendInvoice maxTipAmount(int maxTipAmount) {
        this.maxTipAmount = maxTipAmount;
        return addParameter("max_tip_amount", maxTipAmount);
    }

    /**
     * Set parameter {@link SendInvoice#suggestedTipAmounts}
     * @param suggestedTipAmounts new parameter value
     * @return this request
     */
    public SendInvoice suggestedTipAmounts(@NotNull List<Integer> suggestedTipAmounts) {
        this.suggestedTipAmounts = suggestedTipAmounts;
        return addParameter("suggested_tip_amounts", suggestedTipAmounts);
    }

    /**
     * Set parameter {@link SendInvoice#sendEmailToProvider}
     * @param sendEmailToProvider new parameter value
     * @return this request
     */
    public SendInvoice sendEmailToProvider(boolean sendEmailToProvider) {
        this.sendEmailToProvider = sendEmailToProvider;
        return addParameter("send_email_to_provider", sendEmailToProvider);
    }

    /**
     * Set parameter {@link SendInvoice#sendPhoneNumberToProvider}
     * @param sendPhoneNumberToProvider new parameter value
     * @return this request
     */
    public SendInvoice sendPhoneNumberToProvider(boolean sendPhoneNumberToProvider) {
        this.sendPhoneNumberToProvider = sendPhoneNumberToProvider;
        return addParameter("send_phone_number_to_provider", sendPhoneNumberToProvider);
    }

    //endregion
}