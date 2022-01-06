package efcm.task_engine;

import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * A SlowTask is a class that extends a ConcurrentLinkedQueue<Runnable>.
 * It is a task that is spread out over time. For example,
 * it does one part, waits until called again, does the next part, etc.
 * until the task is finished.
 * 
 * To initialize it and add task parts, do the same as you would
 * do with its superclass. Each task part is a Runnable.
 * 
 * To see example code, go to the class definition.
 */
public class SlowTask extends ConcurrentLinkedQueue<Runnable> {
    /*
    public static void main(String[] args) {
        // Create a SlowTask with three parts
        SlowTask st = new SlowTask();
        st.add(()->{System.out.println("Part 1");});
        st.add(()->{System.out.println("Part 2");});
        st.add(()->{System.out.println("Part 3");});

        // Run Part 1
        st.poll().run();

        // Run Part 2
        st.poll().run();

        // Run Part 3
        st.poll().run();
    }
    */
}
