/**
 * @author liyufei
 * @version 1.0.0
 * @ClassName test.java
 * @createTime 2021年03月31日 10:16:00
 */
public class test {
    public static void main(String[] args) {
        Count c = new Count(0);

        new Thread(()->{
            c.even();
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            c.odd();
        }).start();
    }
}

class Count{
    private int count;
    public Count(int count){
        this.count = count;
    }

    //打印奇数
    public void odd(){
        synchronized (this){
            while(count<100){
                System.out.println(count++);
                this.notify();

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //打印偶数
    public void even(){
        synchronized (this){
            while (count<=100){
                System.out.println(count++);
                this.notify();

                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
