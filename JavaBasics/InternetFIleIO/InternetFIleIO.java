package JavaBasics.InternetFIleIO;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class InternetFIleIO {
    private static final String Follower_feed = "http://services.hanselandpetal.com/photos/";

    public static void main(String[] args) throws IOException {
        InputStream inputStream = null;

        BufferedInputStream bufferedInputStream = null;
        try {
            URL url = new URL(Follower_feed);

            inputStream = url.openStream();
            bufferedInputStream = new BufferedInputStream(inputStream);
            StringBuilder sb = new StringBuilder();
            while (true) {
                int data = bufferedInputStream.read();
                if (data == -1) {
                    break;
                } else {
                    sb.append((char) data);
                }
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
            bufferedInputStream.close();
        }
    }
}
