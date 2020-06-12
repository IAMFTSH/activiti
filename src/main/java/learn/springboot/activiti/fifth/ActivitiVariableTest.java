package learn.springboot.activiti.fifth;

import learn.springboot.activiti.pojo.Holiday;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 邝明山
 * @Date 2020/5/30
 * 流程实例创建（开始节点以及第一个任务），并创建时赋值
 *
 */
public class ActivitiVariableTest {
    public static void main(String[] args) {

        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建repositoryService
        RuntimeService runtimeService=processEngine.getRuntimeService();
        //3.创建map   12个的时候自动扩容
        Map<String,Object> map=new HashMap<>(16);
        map.put("assignee0","填写请假单的人");
        map.put("assignee1","部门经理");
        map.put("assignee2","总经理");
        map.put("assignee3","人事存档");
        Holiday holiday=new Holiday();
        holiday.setNum(4F);
        holiday.setReason("阿斯大赛大赛的");
        map.put("holiday",holiday);
        //4.创建实例
        /*ProcessInstance processInstance= runtimeService.startProcessInstanceByKey("holiday");     businessKey*/
        //第一个参数是流程Id，第二个参数是业务系统表中记录的Id，businessKey用于关联业务系统表
        ProcessInstance processInstance= runtimeService.startProcessInstanceByKey("holiday2","1001",map);

        System.out.println("流程部署Id"+processInstance.getDeploymentId());
        System.out.println("流程定义Id"+processInstance.getProcessDefinitionId());
        System.out.println("流程实例Id"+processInstance.getId());
        System.out.println("活动Id"+processInstance.getActivityId());
        System.out.println("businessKey"+processInstance.getBusinessKey());
    }
}
