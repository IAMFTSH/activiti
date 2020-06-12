package learn.springboot.activiti.first;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 邝明山
 * @Date 2020/5/30
 * 流程实例创建（开始节点以及第一个任务）
 *
 */
public class ActivitiStartInstance {
    public static void main(String[] args) {

        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建repositoryService
        RuntimeService runtimeService=processEngine.getRuntimeService();
        //3.创建map
        Map<String,Object> map=new HashMap<>(4);
        map.put("assignee0","z0");
        map.put("assignee1","z1");
        map.put("assignee2","z2");
        //4.创建实例
        /*ProcessInstance processInstance= runtimeService.startProcessInstanceByKey("holiday");     businessKey*/
        //第一个参数是流程Id，第二个参数是业务系统表中记录的Id，businessKey用于关联业务系统表
        ProcessInstance processInstance= runtimeService.startProcessInstanceByKey("holiday","1001",map);

        System.out.println("流程部署Id"+processInstance.getDeploymentId());
        System.out.println("流程定义Id"+processInstance.getProcessDefinitionId());
        System.out.println("流程实例Id"+processInstance.getId());
        System.out.println("活动Id"+processInstance.getActivityId());
        System.out.println("businessKey"+processInstance.getBusinessKey());
    }
}
