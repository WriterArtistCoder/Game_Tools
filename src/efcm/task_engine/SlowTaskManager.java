package efcm.task_engine;

import java.util.ArrayList;

public class SlowTaskManager extends ArrayList<SlowTask> {
    public void doTasks() {
        this.forEach(st->{
            st.poll().run();
            if (st.isEmpty()) {
                this.remove(st);
            }
        });
    }
}
