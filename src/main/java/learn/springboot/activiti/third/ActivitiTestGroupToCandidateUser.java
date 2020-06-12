package learn.springboot.activiti.third;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 执行人交接
 */
public class ActivitiTestGroupToCandidateUser {
    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建TaskService
        TaskService taskService = processEngine.getTaskService();
        //3.创建实例
        List<Task> taskList = taskService.createTaskQuery().processDefinitionKey("holiday").taskAssignee("zs").list();
        for(Task task:taskList){
            //失败
/*            task.setAssignee("ls");*/
            taskService.setAssignee(task.getId(),"ls");
        }
    }
}
