package learn.springboot.activiti.third;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;
import org.apache.ibatis.jdbc.Null;

import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 拾取与归还
 */
public class ActivitiTestGroupChaimAndReturn {
    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建TaskService
        TaskService taskService = processEngine.getTaskService();
        //3.创建实例
        List<Task> taskList = taskService.createTaskQuery().processDefinitionKey("holiday").taskCandidateUser("zs").list();
        for(Task task:taskList){
            System.out.println("流程实例:"+task.getProcessInstanceId());
            System.out.println("任务Id:"+task.getId());
            System.out.println("任务负责人:"+task.getAssignee());
            System.out.println("任务名称:"+task.getName());
            System.out.println("拾取------------------------------:"+task.getName());
            taskService.claim(task.getId(),"zs");
            System.out.println("归还------------------------------:"+task.getName());
            taskService.setAssignee(task.getId(),null);
        }
    }
}
