import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.*;


public class ArrayListDemo {
    private static final Logger LOG = LoggerFactory.getLogger(ArrayListDemo.class);

    public static void main(String[] args) {
        //创建一个空的数组链表对象list，list用来存放String类型数据
        ArrayList<String> list = new ArrayList<String>();

        //1.增加元素到list中
        list.add("apple");
        list.add("banana");
        //2.将元素增加到list第3个位置
        list.add(2,"pear");
        list.add("cherry");
        LOG.info("ArrayList Testing|The arraylist contains the following elements: " + list);

        //3.检查元素位置
        int pos = list.indexOf("banana");
        LOG.info("The index of banana is: " + pos);

        //4.检查数组链表是否为空
        boolean check = list.isEmpty();
        LOG.info("Checking if the arraylist is empty: " + check);

        //5.获取链表大小
        int size = list.size();
        LOG.info("The size of arraylist is: " + size);

        //6.检查链表中是否包含某元素
        boolean element = list.contains("item5");
        LOG.info("Checking if the arraylist contains the object Item5:" + element);

        //7.获取指定位置元素
        String item = list.get(0);
        LOG.info("The item is the index 0 is:" + item);

        //8.遍历arraylist中的元素
        //8.1 第1种方法: 循环使用元素的索引和链表的大小
        LOG.info("Retrieving items with loop using index and size list");
        for (int i=0; i<list.size();i++){
            LOG.info("Index: " + i + " - Item: " +list.get(i));
        }

        //8.2 第2种方法:使用foreach循环
        LOG.info("Retrieving items using foreach loop");
        for (String str:list){
            LOG.info("Item is " + str);
        }

        //8.3 第三种方法:使用迭代器
        // hasNext(): 返回true表示链表链表中还有元素
        // next(): 返回下一个元素
        LOG.info("Retrieving items using iterator");
        for (Iterator<String> it = list.iterator(); it.hasNext();){
            LOG.info("Item is: " + it.next());
        }

        //9.替换元素
        list.set(1,"watermolen");
        LOG.info("The arraylist after the replacement is:" + list);

        //10.移除元素
        // 移除第0个位置上的元素
        list.remove(0);

        //11.移除第一次找到的 "pear"元素
        list.remove("pear");
        LOG.info("The final contents of the arraylist are: " + list);

        //12.转换 ArrayList 为 Array
        String[] simpleArray = list.toArray(new String[list.size()]);
        LOG.info("The array created after the conversion of our arraylist is: " + Arrays.toString(simpleArray));
    }
}
