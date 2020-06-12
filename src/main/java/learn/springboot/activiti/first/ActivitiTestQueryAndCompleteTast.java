package learn.springboot.activiti.first;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 查找需要做的任务和完成任务
 */
public class ActivitiTestQueryAndCompleteTast {
    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建TaskService
        TaskService taskService = processEngine.getTaskService();
        //3.创建实例
        List<Task> taskList = taskService.createTaskQuery().processDefinitionKey("holiday").taskAssignee("王五").list();
        //如果返回值只有一个
        /*Task task=taskService.createTaskQuery().processDefinitionKey("holiday").singleResult();*/
        for(Task task:taskList){
            taskService.complete(task.getId());
        }
    }
}
