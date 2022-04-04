package com.xingzhou.algorithm.y22m3w5;

import com.google.common.util.concurrent.FutureCallback;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import org.checkerframework.checker.nullness.qual.Nullable;

import java.util.concurrent.Executors;

/**
 * @author xingzhou
 * @version 1.0.0
 * @ClassName ListenableFutureTest.java
 * @Description TODO
 * @createTime 2022年03月27日 21:11:00
 */
public class ListenableFutureTest {
    public static void main(String[] args) {

    }
    public static void testListenFuture() throws InterruptedException {
        ListenableFuture<String> submit = MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(1))
                .submit(() -> {
                    Thread.sleep(2000L);
                    return "aync result";
                });
        Futures.addCallback(submit, new FutureCallback<String>() {
            @Override
            public void onSuccess(@Nullable String result) {
                System.out.println("succeed, result: {}" + result);
            }

            @Override
            public void onFailure(Throwable t) {
                System.out.println("failed, t: {}" + t);
            }
        }, Executors.newSingleThreadExecutor());
        Thread.sleep(100000);
    }
}
