package com.company;

import java.util.concurrent.*;

@SuppressWarnings("ALL")
public class NetworkService {

    private final long ZERO = 0;
    private final ExecutorService pool;
    private String url;

    public NetworkService(int poolSize, String url) {

        pool = new ThreadPoolExecutor(
                poolSize, poolSize, ZERO, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100));;

        this.url = url;
    }

    public void submitTask() throws ExecutionException, InterruptedException {

        Callable<String> returnTask = () -> {

           for (long i = 0; i < 999999999999999999L; ++i){
               pool.execute(new ConnectionEstablisher(url));
           }

            return "Result";
        };

        Future<String> returnFutur = pool.submit(returnTask);
        System.out.println(returnFutur.get());

        System.out.println("continute");

        pool.shutdown();
    }

}
