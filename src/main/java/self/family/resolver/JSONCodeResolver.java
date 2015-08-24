package self.family.resolver;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;
import self.family.util.JsonUtil;

import java.io.IOException;
import java.util.Map;

/**
 * Created by fanmingli on 2015/8/24.
 * JSON Code 处理
 */
@Component("jSONCodeResolver")
public class JSONCodeResolver extends BaseResolver {
    @Override
    public String handle(HttpResponse httpResponse) {
        Map<String, Object> map = null;
        try {
            map = JsonUtil.fromJson(EntityUtils.toString(httpResponse.getEntity(), "utf8"), Map.class);
            return (String)map.get("code");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
