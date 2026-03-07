package com.example.duplicate_orders;

import com.example.duplicate_orders.util.Counter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableAsync
public class DuplicateOrdersApplication {

	public static void main(String[] args) {
		SpringApplication.run(DuplicateOrdersApplication.class, args);

		Counter counter = new Counter();
//
//		Thread t1 = new Thread(() -> {
//			for(int i =0;i< 1000;i++){
//				counter.increment();
//			}
//		});
//
//		Thread t2 = new Thread(() -> {
//
//			for(int i =0;i<1000;i++){
//				counter.increment();
//			}
//		});
//
//		Thread t3 = new Thread(() -> {
//			for(int i =0;i<1000;i++){
//				counter.increment();
//			}
//		});
//
//		t1.start();
//		t2.start();
//		t3.start();
//        try {
//			t1.join();
//            t2.join();
//			t3.join();
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//
//		System.out.println(counter.getCount());



		ExecutorService executor = Executors.newFixedThreadPool(3);

		for (int i = 0; i < 3; i++) {
			executor.submit(() -> {
				for (int j = 0; j < 1000; j++) {
					counter.increment();
				}
			});
		}

		executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

		System.out.println(counter.getCount());

    }

}
