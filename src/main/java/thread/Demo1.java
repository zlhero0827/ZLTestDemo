package thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;


import static java.util.concurrent.TimeUnit.SECONDS;

public class Demo1 {
    public static void main(String[] args) {
        ArrayBlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(10);
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.AbortPolicy();
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardPolicy();
//        RejectedExecutionHandler handler = new ThreadPoolExecutor.DiscardOldestPolicy();
        RejectedExecutionHandler handler = new ThreadPoolExecutor.CallerRunsPolicy();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(3,3,0, SECONDS, queue, handler);
        for (int i = 0; i< 20; i++){
            final int temp = i;
            pool.execute(()->{
                System.out.println("客户"+temp+"来了.......");
                try{
                    Thread.sleep(10);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            });
        }
        pool.shutdown();
    }
}
