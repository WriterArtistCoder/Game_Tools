package efcm.task_engine;
import java.util.HashMap;
import java.util.function.Consumer;

public class Task {
    /** The Consumer that accepts the Task it is a field of. It accomplishes any work that is needed to happen in the SlowTask. */
    private Consumer<Task> task;

    /** A HashMap<String, Object> to manage simulated "variables" (simvars). */
    public HashMap<String, Object> svm;

    /**
     * Gets the Consumer<Task>.
     * @return The Consumer<Task>
    */
    public Consumer<Task> getTask() {
        return task;
    }

    /**
     * Sets the Consumer<Task>.
     * @param task The Consumer<Task>
    */
    public void setTask(Consumer<Task> task) {
        this.task = task;
    }

    /**
     * Gets the simvar manager.
     * @return The SVM, a HashMap<String, Object>
    */
    public HashMap<String, Object> getSVM() {
        return svm;
    }
}