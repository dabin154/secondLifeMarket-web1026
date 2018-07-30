import com.thread.test.NewThreadExtendsThread;

import java.util.HashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {

//		Thread thread1 = new Thread(new NewThreadExtendsThread("dabin1"));
//		Thread thread2 = new Thread(new NewThreadExtendsThread("dabin2"));
//		Thread thread3 = new Thread(new NewThreadExtendsThread("dabin3"));
//		thread1.start();
//		thread2.start();
//		thread3.start();
//		try {
//			thread1.join();
//			thread2.join();
//			thread3.join();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}

//		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
//
//		for (int i = 1; i <= 10; i++) {
//			final int index = i;
//			fixedThreadPool.execute(new Runnable() {
//
//				@Override
//				public void run() {
//					try {
//						String threadName = Thread.currentThread().getName();
//						System.out.println("执行：" + index + "，线程名称：" + threadName);
//						Thread.sleep(2000);
//					} catch (InterruptedException e) {
//
//						e.printStackTrace();
//					}
//				}
//			});
//		}
		HashMap<String, String> map = new HashMap<String, String>();
		for(int i = 0; i<100; i++){
//          map.entrySet();
//          map.keySet();
//          map.values();
			map.put(String.valueOf(i), String.valueOf(i));
		}
		for(String key:map.keySet()){
			System.out.println(key+"**"+map.get(key));
		}
	}
//
	}


