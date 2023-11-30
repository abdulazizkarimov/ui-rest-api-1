import com.google.api.services.gmail.Gmail;
import com.google.api.services.gmail.model.ListMessagesResponse;
import com.google.api.services.gmail.model.Message;
import util.EmailUtil;
import java.io.IOException;

public class MyCondition {
    public boolean isThereEuronewsMessage() {
        Gmail service = MyGmail.getService();

        Gmail.Users.Messages.List request = null;
        try {
            request = service.users().messages().list("me");
        } catch (IOException e) {
            e.printStackTrace();
        }

        ListMessagesResponse messagesResponse = null;
        try {
            messagesResponse = request.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }

        request.setPageToken(messagesResponse.getNextPageToken());

        String id = messagesResponse.getMessages().get(0).getId();

        Message message = null;
        try {
            message = service.users().messages().get("me", id).execute();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String result = EmailUtil.getSender(message.getPayload().getHeaders());

        if(result.equals("newsletters@account.euronews.com")) {
            return true;
        } else {
            return false;
        }
    }
}
