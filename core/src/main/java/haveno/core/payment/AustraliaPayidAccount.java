/*
 * This file is part of Bisq.
 *
 * Bisq is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Affero General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or (at
 * your option) any later version.
 *
 * Bisq is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Affero General Public
 * License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with Bisq. If not, see <http://www.gnu.org/licenses/>.
 */

package haveno.core.payment;

import haveno.core.api.model.PaymentAccountFormField;
import haveno.core.locale.TraditionalCurrency;
import haveno.core.locale.TradeCurrency;
import haveno.core.payment.payload.AustraliaPayidAccountPayload;
import haveno.core.payment.payload.PaymentAccountPayload;
import haveno.core.payment.payload.PaymentMethod;
import lombok.NonNull;

import java.util.List;

public final class AustraliaPayidAccount extends PaymentAccount {

    public static final List<TradeCurrency> SUPPORTED_CURRENCIES = List.of(new TraditionalCurrency("AUD"));

    public AustraliaPayidAccount() {
        super(PaymentMethod.AUSTRALIA_PAYID);
        setSingleTradeCurrency(SUPPORTED_CURRENCIES.get(0));
    }

    private static final List<PaymentAccountFormField.FieldId> INPUT_FIELD_IDS = List.of(
        PaymentAccountFormField.FieldId.BANK_ACCOUNT_NAME,
        PaymentAccountFormField.FieldId.PAYID,
        PaymentAccountFormField.FieldId.EXTRA_INFO,
        PaymentAccountFormField.FieldId.ACCOUNT_NAME,
        PaymentAccountFormField.FieldId.SALT
    );

    @Override
    protected PaymentAccountPayload createPayload() {
        return new AustraliaPayidAccountPayload(paymentMethod.getId(), id);
    }

    @Override
    public @NonNull List<TradeCurrency> getSupportedCurrencies() {
        return SUPPORTED_CURRENCIES;
    }

    @Override
    public @NonNull List<PaymentAccountFormField.FieldId> getInputFieldIds() {
        return INPUT_FIELD_IDS;
    }

    public String getPayid() {
        return ((AustraliaPayidAccountPayload) paymentAccountPayload).getPayid();
    }

    public void setPayid(String payid) {
        if (payid == null) payid = "";
        ((AustraliaPayidAccountPayload) paymentAccountPayload).setPayid(payid);
    }

    public String getBankAccountName() {
        return ((AustraliaPayidAccountPayload) paymentAccountPayload).getBankAccountName();
    }

    public void setBankAccountName(String bankAccountName) {
        if (bankAccountName == null) bankAccountName = "";
        ((AustraliaPayidAccountPayload) paymentAccountPayload).setBankAccountName(bankAccountName);
    }

    public void setExtraInfo(String extraInfo) {
        ((AustraliaPayidAccountPayload) paymentAccountPayload).setExtraInfo(extraInfo);
    }

    public String getExtraInfo() {
        return ((AustraliaPayidAccountPayload) paymentAccountPayload).getExtraInfo();
    }
}
