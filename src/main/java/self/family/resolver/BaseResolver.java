package self.family.resolver;

import org.apache.http.HttpResponse;

/**
 * Created by Administrator on 2015/8/23.
 */
public abstract class BaseResolver {
    public abstract String handle(HttpResponse httpResponse);
}
