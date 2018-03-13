import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ForEachDemo {
    private static final Logger LOG = LoggerFactory.getLogger(ForEachDemo.class);

    /**
     * forEach遍历Map
     */
    @Test
    public void testForEachFunc(){
        Map<String, Integer> items = new HashMap<String, Integer>();
        items.put("A",10);
        items.put("B",20);
        items.put("C",30);
        items.put("D",40);
        items.put("E",50);
        items.put("F",60);
        //forEach循环
        for(Map.Entry<String,Integer> entry:items.entrySet()){
            System.out.println("Item : " +entry.getKey()+" Count : "+ entry.getValue());

        }
    }

    /**
     * 在java8中你可以使用  foreach  + 拉姆达表达式遍历
     */
    @Test
    public void testForEachLambda(){
        Map<String, Integer> items = new HashMap<String, Integer>();
        items.put("A",10);
        items.put("B",20);
        items.put("C",30);
        items.put("D",40);
        items.put("E",50);
        items.put("F",60);
        //lambda表达式
        items.forEach((k,v)->System.out.println("Item : " +k+" Count : "+ v));

        items.forEach((k,v)->{
            System.out.println("Item : " +k+" Count : "+ v);
            if("E".equals(k)){
                LOG.info("Hello E");
            }
        });
    }

    /**
     * forEach遍历Map
     */
    @Test
    public void testForEachList(){
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

        //forEach循环
        for (String item : items){
            LOG.info(item);
        }
    }

    /**
     * 在java8中你可以使用  foreach  + 拉姆达表达式遍历
     */
    @Test
    public void testForEachLambdaList(){
        List<String> items = new ArrayList<>();
        items.add("A");
        items.add("B");
        items.add("C");
        items.add("D");
        items.add("E");

        //lambda
        items.forEach(item->LOG.info(item));

        items.forEach(item->{
            if("C".equals(item)){
                LOG.info(item);
            }
        });
        //method reference
        //Output : A,B,C,D,E
        items.forEach(System.out::println);
        //Stream and filter
        //Output : B
        items.stream()
                .filter(s -> s.contains("B"))
                .forEach(System.out::println);
    }
}
