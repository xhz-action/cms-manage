package hz.cms.model.thread;

/**
 * Created by xhz on 2018/1/21.
 */
public class DealEntity implements Runnable{
    private int count =10;

    @Override
    public void run() {
        synchronized (this) {
            while (count > 0) {
                count--;
                System.out.println(Thread.currentThread().getName() + "--当前总数:" + count);
            }
        }
    }
}
