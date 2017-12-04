import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Created by zhulei on 2017/12/4.
 */
public class HashMapDemo {
    private static final Logger LOG = LoggerFactory.getLogger(HashMapDemo.class);

    public static void main(String[] args) {
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("cn","中国");
        hashMap.put("jp","日本");
        hashMap.put("kr","韩国");
        LOG.info("Print the HashMap: " + hashMap);
        LOG.info("Print the value of cn key: "+hashMap.get("cn"));
        LOG.info("There are contains key of 'cn': " + hashMap.containsKey("cn"));
        LOG.info("Print the HashMap's key: " + hashMap.keySet());
        LOG.info("If the HashMap's empty: " + hashMap.isEmpty());
        //移除key为cn的item
        hashMap.remove("cn");
        LOG.info("There are contains key of 'cn' after removed: " + hashMap.containsKey("cn"));
        //采用Iterator遍历HashMap
        Iterator it = hashMap.keySet().iterator();
        while (it.hasNext()){
            String key = (String) it.next();
            LOG.info("key: " + key);
            LOG.info("value: " + hashMap.get(key));
        }
        //遍历HashMap的另一个方法
        Set<Entry<String,String>> sets = hashMap.entrySet();
        for (Entry<String, String> entry :
                sets) {
            LOG.info(entry.getKey()+", ");
            LOG.info(entry.getValue());
        }
    }
}
