package be.abis.sos.enumeration;

import java.util.Locale;

public enum Language {
    LANGUAGE_DUTCH("nl", Locale.forLanguageTag("nl-BE")),
    LANGUAGE_FRENCH("fr", Locale.forLanguageTag("fr"));

    private String language;
    Locale locale;

    Language(String language, Locale locale) {
        this.language = language;
        this.locale = locale;
    }

    public Locale getLocale() {
        return locale;
    }
}
