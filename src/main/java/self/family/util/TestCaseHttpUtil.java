package self.family.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import self.family.entry.TestCase;

import java.io.IOException;

/**
 * Created by Administrator on 2015/8/23.
 */
public class TestCaseHttpUtil {

    public static HttpResponse execute(TestCase testCase) {
        try {
            if (testCase.getRequestMethod().equalsIgnoreCase("GET")) {
                return executeGetRequest(testCase);
            } else if (testCase.getRequestMethod().equalsIgnoreCase("POST")) {
                return executePostRequest(testCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static HttpResponse executePostRequest(TestCase testCase) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost(testCase.getUrl());
        httpPost.setEntity(new StringEntity(testCase.getRequestBody(), ContentType.create(testCase.getContentType(), testCase.getRequestEncoding())));
        return httpClient.execute(httpPost);
    }

    private static HttpResponse executeGetRequest(TestCase testCase) throws IOException {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(testCase.getUrl());
        return httpClient.execute(httpGet);
    }
}
