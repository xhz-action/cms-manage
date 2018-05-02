package hz.cms.controller;

import hz.cms.model.thread.DealEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

/**
 * Created by xhz on 2018/1/21.
 * 线程测试
 */
@Component
public class ThreadDemo {

    @Autowired
    ThreadPoolTaskExecutor taskExecutor;

    public ThreadDemo(){
    }

    public void ex(){
        DealEntity dealEntity = new DealEntity();
        Thread thread1 = new Thread(dealEntity);
        Thread thread2 = new Thread(dealEntity);
        taskExecutor.submit(thread1);
        taskExecutor.submit(thread2);
    }

    public static void main(String[] args) {
      new ThreadDemo();
    }
}
