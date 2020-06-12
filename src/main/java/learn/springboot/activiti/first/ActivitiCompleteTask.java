package learn.springboot.activiti.first;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 完成任务
 */
public class ActivitiCompleteTask {
    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建TaskService
        TaskService taskService = processEngine.getTaskService();
        //3.完成任务
        taskService.complete("2505");
    }
}
