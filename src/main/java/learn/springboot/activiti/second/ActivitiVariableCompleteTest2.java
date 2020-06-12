package learn.springboot.activiti.second;

import learn.springboot.activiti.pojo.Holiday;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 查找需要做的任务和完成任务（完成任务后赋值）
 * taskService.complete(task.getId());
 */
public class ActivitiVariableCompleteTest2 {
    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.创建TaskService
        TaskService taskService = processEngine.getTaskService();
        //3.创建实例
        Task task = taskService.createTaskQuery().processInstanceId("37501").taskAssignee("人事存档").singleResult();
        //如果返回值只有一个
        /*Task task=taskService.createTaskQuery().processDefinitionKey("holiday").singleResult();*/
        Map<String, Object> map = new HashMap<>(16);
        Holiday holiday = new Holiday();
        holiday.setNum(4F);
        map.put("holiday", holiday);
        taskService.complete(task.getId(),map);
    }
}
