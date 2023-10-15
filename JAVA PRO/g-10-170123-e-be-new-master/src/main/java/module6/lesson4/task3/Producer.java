package module6.lesson4.task3;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private final BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        // produce messages
        for (int idx = 0; idx < 35; idx++) {
            Message msg = new Message("" + idx, idx);
            try {
                Thread.sleep(idx * 200);
                queue.put(msg);
                System.out.println("Produced " + msg.getMsg());
                System.out.println("Queue size - " + queue.size());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // adding exit message
        Message msg = new Message("exit", 0);
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
