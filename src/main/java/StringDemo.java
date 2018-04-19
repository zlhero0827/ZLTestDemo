/**
 * Created by zhulei on 2018/4/18.
 */
public class StringDemo {
    /***
     * 反转字符串方法
     * 1.遍历
     */

    public static String reverseBL(String str){
        String reverseStr="";
        //for循环遍历字符串并反转
        for(int i = str.length()-1;i>=0;i--){
            reverseStr = reverseStr + str.charAt(i);
        }
        return reverseStr;
    }

    /**
     * 2.递归方法
     */
    public static String reverseDG(String str){
        if(str.length()<=1){
            return str;
        }
        String right = str.substring(0,str.length()/2);
        String left = str.substring(str.length()/2,str.length());
        return reverseDG(left)+reverseDG(right);
    }

    /**
     *
     * 3.交换方法
     */
    public static String reverseJH(String str){
        char[] c = str.toCharArray();
        char temp;
        int n = c.length-1;
        String newStr;
        for(int i = 0; i<=n/2; i++){
            temp = c[n-i];
            c[n-i] = c[i];
            c[i] = temp;
        }
        return new String(c);
    }

    public static void main(String[] args) {
        String phone = "13426001552";
        /**
         * 1.遍历方法
         */
        String newStr1;
        newStr1 = reverseBL(phone);
        System.out.println("1.遍历方法："+newStr1);
        /**
         * 2.递归方法
         */
        String newStr2;
        newStr2 = reverseDG(phone);
        System.out.println("2.递归方法："+newStr2);
        /**
         * 3.交换方法
         */
        String newStr3;
        newStr3 = reverseJH(phone);
        System.out.println("3.交换方法："+newStr3);
    }
}
