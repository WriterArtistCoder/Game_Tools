package efcm.task_engine;

import java.util.ArrayList;

public class SlowTaskManager extends ArrayList<SlowTask> {
    public void doTasks() {
        for (int i = 0; i < this.size(); i++) {
            SlowTask st = this.get(i);
            if (st.hasNext()) {
                st.next();
            } else {
                this.remove(i);
            }
        }
    }
}
