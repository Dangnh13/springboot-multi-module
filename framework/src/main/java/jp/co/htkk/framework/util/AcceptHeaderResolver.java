package jp.co.htkk.framework.util;

import org.springframework.http.HttpHeaders;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class AcceptHeaderResolver {

    private static final List<Locale> LOCALES = Arrays.asList(Locale.ENGLISH, Locale.JAPANESE);

    public static Locale resolveLocale(HttpServletRequest request) {
        String language = request.getHeader(HttpHeaders.ACCEPT_LANGUAGE);
        if (language == null || language.isEmpty()) {
            return null;
        }
        List<Locale.LanguageRange> list = Locale.LanguageRange.parse(language);
        Locale locale = Locale.lookup(list, LOCALES);
        return locale;
    }

}
