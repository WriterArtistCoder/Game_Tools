package efcm.task_engine;

import java.util.ArrayList;

public class SlowTaskList extends ArrayList<SlowTask> {
    public SlowTaskList() {
        
    }

    public void doTasks() {
        this.forEach(st->{
            st.poll().run();
        });
    }
}
