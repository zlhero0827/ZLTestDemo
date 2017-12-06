import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.Map.Entry;

/**
 * Created by zhulei on 2017/12/4.
 */
public class HashMapDemo {
    private static final Logger LOG = LoggerFactory.getLogger(HashMapDemo.class);

    @Test
    public void testHashMapBasic(){
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

    //    @Test
//    public void testAssignment(){
    public static void main(String[] args) {
//      定义保存学生信息的List，元素类型为HashMap
        List<HashMap<String,Object>> list= new ArrayList<HashMap<String,Object>>();
        Scanner input = new Scanner(System.in);

        System.out.println("请输入学生的信息,y表示继续，n表示退出");
        while ("y".equals(input.next())){
            HashMap<String, Object> map = new HashMap<String, Object>();
            System.out.println("请输入学号");
            map.put("studentNO",input.next());
            System.out.println("请输入姓名");
            map.put("name",input.next());
            System.out.println("请输入年龄");
            map.put("age",input.next());
            list.add(map);
            System.out.println("请继续输入学生的信息,y表示继续，n表示退出");
        }
        System.out.println("输入的学生信息为:");
        System.out.println("学生数量为:" + list.size());

        Iterator<HashMap<String, Object>> it = list.iterator();
        int i = 1;
        while(it.hasNext()){
            HashMap<String, Object> stuMap = it.next();
            System.out.print("第" + i + "个学生的信息为");
            System.out.println("学号："+stuMap.get("studentNO")+ " ,姓名: "+stuMap.get("name")+" ,年龄: "+stuMap.get("age"));
            i++;
        }

    }
}
