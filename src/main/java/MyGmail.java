import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.services.gmail.Gmail;
import java.io.InputStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.FileNotFoundException;
import java.security.GeneralSecurityException;

public class MyGmail {
    private static final String APPLICATION_NAME = "Gmail Api Euronews 3";
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    private static Gmail service = null;
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    private static Credential getCredential()
            throws IOException {
        InputStream in = MyGmail.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        Credential authorize = null;
        try {
            authorize = new GoogleCredential.Builder().setTransport(GoogleNetHttpTransport.newTrustedTransport())
                    .setJsonFactory(JSON_FACTORY)
                    .setClientSecrets(clientSecrets.getDetails().getClientId().toString(),
                            clientSecrets.getDetails().getClientSecret().toString())
                    .build()
                    .setAccessToken("ya29.a0AfB_byDOF4pMM0iFjJ1YEBaYzGiQThdjLzBFQlfG3CEAvskrxCgC1sPjTSz13zsQvIo6DvdhBKBMeCNxWcItSStOuVLPdXRWMnAkLmzkeeHcwfmB0A222CAgGOih_n0fvLUXACyscBBufGE9nd_pc90dJQa7IdCl8ObugQaCgYKAewSARESFQGOcNnCfunOiRupWyEiBM_Qahka2w0173")
                    .setRefreshToken("1//0di2XFbdVfcRjCgYIARAAGA0SNwF-L9IrtRS13GT_7pCyYDn--bD2W_8Tljqv5d79WBOAgNxCYhesK7esbJ2dZITCopHvDGtCZcw");
        } catch (GeneralSecurityException e) {
            e.printStackTrace();
        }

        return authorize;
    }

    public static Gmail getService() {
        if (service == null) {
            NetHttpTransport HTTP_TRANSPORT = null;
            try {
                HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
            } catch (GeneralSecurityException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                service = new Gmail.Builder(HTTP_TRANSPORT, JSON_FACTORY, MyGmail.getCredential())
                        .setApplicationName(APPLICATION_NAME)
                        .build();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return service;
    }
}