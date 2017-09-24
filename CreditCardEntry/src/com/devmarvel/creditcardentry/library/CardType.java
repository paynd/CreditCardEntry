package com.devmarvel.creditcardentry.library;

import android.support.annotation.DrawableRes;

import com.devmarvel.creditcardentry.R;

import java.io.Serializable;

class CardRegex {
    // See: http://www.regular-expressions.info/creditcard.html
    static final String REGX_VISA = "^4[0-9]{15}?"; // VISA 16
    static final String REGX_MC = "^5[1-5][0-9]{14}$"; // MC 16
    static final String REGX_AMEX = "^3[47][0-9]{13}$"; // AMEX 15
    static final String REGX_DISCOVER = "^6(?:011|5[0-9]{2})[0-9]{12}$"; // Discover 16
    static final String REGX_DINERS_CLUB = "^3(?:0[0-5]|[68][0-9])[0-9]{11}$"; // DinersClub 14
    static final String REGX_JCB = "^35[0-9]{14}$"; // JCB 16

    static final String REGX_VISA_TYPE = "^4[0-9]{3}?"; // VISA 16
    static final String REGX_MC_TYPE = "^5[1-5][0-9]{2}$"; // MC 16
    static final String REGX_AMEX_TYPE = "^3[47][0-9]{2}$"; // AMEX 15
    static final String REGX_DISCOVER_TYPE = "^6(?:011|5[0-9]{2})$"; // Discover 16
    static final String REGX_DINERS_CLUB_TYPE = "^3(?:0[0-5]|[68][0-9])[0-9]$"; // DinersClub 14
    static final String REGX_JCB_TYPE = "^35[0-9]{2}$"; // JCB 15

}

/**
 * represents the type of card the user used
 */
public enum CardType implements Serializable {
    VISA("Visa", R.drawable.ic_card_visa, CardRegex.REGX_VISA, CardRegex.REGX_VISA_TYPE),
    MASTERCARD("MasterCard", R.drawable.ic_card_mastercard, CardRegex.REGX_MC, CardRegex.REGX_MC_TYPE),
    AMEX("American Express", R.drawable.ic_card_amex, CardRegex.REGX_AMEX, CardRegex.REGX_AMEX_TYPE),
    DISCOVER("Discover", R.drawable.ic_card_discover, CardRegex.REGX_DISCOVER, CardRegex.REGX_DISCOVER_TYPE),
    DINERS("Diners Club", R.drawable.ic_card_diners, CardRegex.REGX_DINERS_CLUB, CardRegex.REGX_DINERS_CLUB_TYPE),
    JCB("JCB",R.drawable.ic_card_jcb,CardRegex.REGX_JCB,CardRegex.REGX_JCB_TYPE),
    INVALID("Unknown", R.drawable.ic_card_placeholder, null, null);

  /** name for humans */
    public final String name;

  /** regex that matches the entire card number */
    public final String fullRegex;

  /** regex that will match when there is enough of the card to determine type */
    public final String typeRegex;

  /** drawable for the front of the card */
    public final int frontResource;

  /** drawable for the back of the card */
    public final int backResource = R.drawable.ic_card_placeholder;

    CardType(String name, @DrawableRes int imageResource, String fullRegex, String typeRegex) {
        this.name = name;
        this.frontResource = imageResource;
        this.fullRegex = fullRegex;
        this.typeRegex = typeRegex;
    }

	public static CardType from(String name) {
		for (CardType creditCardType : values()) {
			if (creditCardType.name.equals(name)) {
				return creditCardType;
			}
		}
		return INVALID;
	}

    @Override
    public String toString() {
        return name;
    }
}
