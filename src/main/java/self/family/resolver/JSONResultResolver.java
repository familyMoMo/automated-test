package self.family.resolver;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Created by Administrator on 2015/8/23.
 */
@Component("jSONResultResolver")
public class JSONResultResolver extends BaseResolver{
    public String handle(HttpResponse httpResponse) {
        try {
            return EntityUtils.toString(httpResponse.getEntity(), "utf8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
