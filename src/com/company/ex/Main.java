package com.company.ex;

import java.util.ArrayList;
import java.util.concurrent.*;

public class Main {

    public static void main(String[] args) {

        int counter = 0;
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        FileCreater fileCreater = new FileCreater();
        ArrayList<String> strings = fileCreater.stringMaker();
        ArrayList<Future<ArrayList<String>>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int finalCounter = counter;
            Future<ArrayList<String>> future = executorService.submit(new Callable<ArrayList<String>>() {
                @Override
                public ArrayList<String> call() throws Exception {
                    ArrayList<String> result = new ArrayList<>();
                    for (int j = finalCounter *100; j < finalCounter *100 +100; j++) {

//                        System.out.println(strings.size());

                        result.add(strings.get(j));

                        Thread.sleep(10);
                    }

                    return result;
                }
            });


            try {
                ArrayList<String> strings1 = future.get();
                System.out.println(strings1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            counter++;

        }


        executorService.shutdown();

    }
}
