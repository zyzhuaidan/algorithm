package y22m3w5;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName FutureDemo.java
 * @Description TODO
 * @createTime 2022年03月27日 19:53:00
 */
public class FutureDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<Integer> call = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println("waiting~~~~~~");
                Thread.sleep(3000);
                return 10086;
            }
        };
        FutureTask<Integer> futureTask = new FutureTask(call);
        Thread thread = new Thread(futureTask);
        thread.start();
        //do something
        System.out.println("other things");
        Integer o = futureTask.get();
        System.out.println(o);
    }
}
