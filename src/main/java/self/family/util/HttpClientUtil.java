package self.family.util;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import self.family.entry.TestCase;

import java.io.IOException;

/**
 * Created by Administrator on 2015/8/23.
 */
public class HttpClientUtil {

//    public static String getJsonFromResponse (HttpPost httpPost){
//        String json = "";
//        CloseableHttpClient httpClient = HttpClients.createDefault();
//        CloseableHttpResponse response = null;
//        try {
//            response = httpClient.execute(httpPost);
//            json = EntityUtils.toString(response.getEntity(), "utf8");
//        } catch (ClientProtocolException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } catch (IOException e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        } finally {
//            try {
//                if(response != null)
//                    response.close();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//        }
//        return json;
//    }
//
    public static HttpResponse execute(TestCase testCase) {
        if (testCase.getRequestMethod().equals("GET")) {
            return httpGetRequest(testCase);
        } else if(testCase.getRequestMethod().equalsIgnoreCase("POST")) {
            return httpPostRequest(testCase);
        }
        return null;
    }

    private static HttpResponse httpPostRequest(TestCase testCase) {
        return null;
    }

    private static HttpResponse httpGetRequest(TestCase testCase) {
        return null;
    }
}
