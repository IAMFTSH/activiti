package learn.springboot.activiti.first;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.ibatis.io.ResolverUtil;

import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 查找需要做的任务
 */
public class ActivitiTestQuery {
    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建TaskService
        TaskService taskService = processEngine.getTaskService();
        //3.创建实例
        List<Task> taskList = taskService.createTaskQuery().processDefinitionKey("holiday").taskAssignee("张三").list();
        for(Task task:taskList){

            System.out.println("流程实例:"+task.getProcessInstanceId());
            System.out.println("任务Id:"+task.getId());
            System.out.println("任务负责人:"+task.getAssignee());
            System.out.println("任务名称:"+task.getName());
        }
    }
}
