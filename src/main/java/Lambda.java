import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by zhulei on 2019/1/5.
 */
public class Lambda {

    /**
     * 1.8之前排序写法
     */
    public static void sort(){
        List<String> list = Arrays.asList("aaa","fsa","ser","eere");
        Collections.sort(list, new Comparator<String>() {
                    public int compare(String o1, String o2) {
                        return o2.compareTo(o1);
                    }
                }
        );
        for(String str:list){
            System.out.print(str+" ");
        }
    }

    /**
     * lambda写法
     */
    public static void lambdaSort(){
        List<String> list = Arrays.asList("aaa","fsa","ser","eere");
        Collections.sort(list,(a,b)->b.compareTo(a));
        for(String str:list){
            System.out.print(str+" ");
        }
    }

    public static void main(String[] args) {
//        sort();
        lambdaSort();
    }
}
