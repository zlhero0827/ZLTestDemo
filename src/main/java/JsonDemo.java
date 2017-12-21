import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.map.HashedMap;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhulei on 2017/12/21.
 */
public class JsonDemo {
    /**
     * 1 、使用Map创建json
     */
    public static void main(String[] args) {
        Map<String, Object> map = new LinkedHashMap<String, Object>();
        map.put("name", "老王");
        map.put("age", 35);
        map.put("height", 1.73);
        map.put("major", new String[] { "理发", "挖掘机" });
        map.put("hasGirlFriend", false);
        map.put("car", null);
        JSONObject json = new JSONObject(map);
        List<Map<String,String>> list=new ArrayList<Map<String,String>>();
        Map<String,String> hashmap = new HashedMap();
        hashmap.put("苹果","小明");
        hashmap.put("香蕉","小王");
        hashmap.put("梨","小李");
        list.add(hashmap);
        json.put("code",list);

        System.out.println("方法名:createJSONByMap()---" + json);
    }
}
