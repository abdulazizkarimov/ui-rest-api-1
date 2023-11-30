package util;

import com.google.api.services.gmail.model.MessagePartHeader;
import java.util.List;

public class EmailUtil {
    public static String getSender(List<MessagePartHeader> headers) {
        String from = "";
        for (MessagePartHeader header : headers) {
            if (header.getName().equals("From")) {
                from = header.getValue();
                break;
            }
        }
        int a = from.indexOf('<');
        int b = from.indexOf('>');
        String email = from.substring(a + 1, b);

        return email;
    }
}
