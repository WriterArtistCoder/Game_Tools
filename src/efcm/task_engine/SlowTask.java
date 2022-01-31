package efcm.task_engine;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Consumer;


public class SlowTask {
    private ArrayList<Task> tasks;
    private Task resources;

    /**
     * Initializes the SlowTask with no tasks.
    */
    public SlowTask(Task resources) {
        tasks = new ArrayList<>();
    }

    /**
     * Does the next task in the SlowTask.
    */
    public void next() throws IndexOutOfBoundsException {
        Consumer<Task> task = tasks.get(0).getTask();
        tasks.remove(0);

        task.accept(resources);
    }

    /**
     * Checks if there is another task left in the SlowTask.
     * 
     * @return <code>true</code> if the SlowTask is not yet done
    */
    public boolean hasNext() {
        return !tasks.isEmpty();
    }

    /**
     * Inserts the specified element at the tail of this queue. As the queue is
     * unbounded, this method will
     * never throw IllegalStateException or return <code>false</code>.
     * 
     * @param e the element to add
     * @return <code>true</code> (as specified by Collection.add)
     * @throws NullPointerException if the specified element is null
     */
    public void add(Task e) {
        tasks.add(e);
    }

    /**
     * Appends all of the elements in the specified collection to the end of this
     * queue, in the order that
     * they are returned by the specified collection's iterator. Attempts to
     * <code>addAll</code> of a queue to
     * itself result in IllegalArgumentException.
     * 
     * @param c the elements to be inserted into this queue
     * @return <code>true</code> if this queue changed as a result of the call
     * @throws NullPointerException if the specified element is null
     * 
     */
    public void addAll(Collection<? extends Task> c) {
        tasks.addAll(c);
    }
}
