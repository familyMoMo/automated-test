package self.family.resolver;

import org.apache.http.HttpResponse;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2015/8/23.
 */
@Component("httpCodeResolver")
public class HttpCodeResolver  extends BaseResolver {
    @Override
    public String handle(HttpResponse httpResponse) {
        return httpResponse.getStatusLine().getStatusCode() + "";
    }
}
