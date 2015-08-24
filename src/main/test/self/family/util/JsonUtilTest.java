package self.family.util;

import junit.framework.TestCase;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;
import self.family.entry.ResultVO;

import java.util.Map;

public class JsonUtilTest extends TestCase {

    @Test
    public void testFromJson() throws Exception {

        JsonUtil.fromJson(System.in, ResultVO.class);
    }
    @Test
    public void testFromJson1() throws Exception {
        String json = "{\"name\": \"family\", \"age\": 18}";
        String json1 = "{\"people\":{\"name\": \"family\", \"age\": 18}, \"code\": 100}";
        Map<String, Object> map = JsonUtil.fromJson(json1, Map.class);
        System.out.println(map.get("name"));
        System.out.println(map.get("code"));
        System.out.println(((Map)map.get("people")).get("name"));

        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map1 = mapper.readValue(json1, Map.class);
        System.out.println(((Map)map1.get("people")).get("name"));
    }

    public void testFromJson2() throws Exception {

    }

    public void testFromJson3() throws Exception {

    }

    public void testToJson() throws Exception {

    }

    public void testToJson1() throws Exception {

    }

    public void testToJson2() throws Exception {

    }

    public void testMapper() throws Exception {

    }
}