package i18n;

import org.junit.jupiter.api.Test;

import java.text.MessageFormat;
import java.util.Locale;
import java.util.ResourceBundle;

public class MessageFormatTest {
    @Test
    void testMessageFormat() {
        var pattern = "Hi {0}, Anda bisa mencari data Anda dengan mengetikkan \"{0}\" di pencarian.";
        var messageFormat = new MessageFormat(pattern);

        var format = messageFormat.format(new Object[]{"Budi"});
        System.out.println(format);
    }

    @Test
    void testMessageFormatResourceBundle() {
        var locale = new Locale("id", "ID");
        var resourceBundle = ResourceBundle.getBundle("message", locale);

        var pattern = resourceBundle.getString("welcome.message");
        var messageFormat = new MessageFormat(pattern);

        var format = messageFormat.format(new Object[]{"Budi", "Java I18N"});
        System.out.println(format);
    }
}
