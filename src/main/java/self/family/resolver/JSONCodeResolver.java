package self.family.resolver;

import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

/**
 * Created by fanmingli on 2015/8/24.
 */
@Component("jSONCodeResolver")
public class JSONCodeResolver extends BaseResolver {
    @Override
    public String handle(HttpResponse httpResponse) {
//        ת��Ϊjson��ʽ��������codeֵ
//        EntityUtils.toString(httpResponse.getEntity(), "utf8")
        return null;
    }
}
