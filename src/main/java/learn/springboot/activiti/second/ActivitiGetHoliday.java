package learn.springboot.activiti.second;

import learn.springboot.activiti.pojo.Holiday;
import org.activiti.engine.*;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.apache.commons.io.IOUtils;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 获取假期信息
 * 方法1：通过activiti的api获取
 * 方法2：通过jdbc的方法获取
 */
public class ActivitiGetHoliday {
    public static void main(String[] args) throws IOException {
        //1.创建processEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.创建taskService
        TaskService taskService = processEngine.getTaskService();
        //3.查询
        Task task = taskService.createTaskQuery().processInstanceId(("52501"))
                .taskAssignee("填写请假单的人")
                .singleResult();
        //4.反序列化是api做好了
        System.out.println(task.getId());
        Holiday holiday = (Holiday) taskService.getVariable(task.getId(), "holiday");
        System.out.println(holiday);
    }
}
