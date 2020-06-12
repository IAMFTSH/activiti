package learn.springboot.activiti.second;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 挂起流程实例
 * 如果被挂起，该流程实例暂停执行
 */
public class StopProcessInstance {
    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建service
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //3.创建processDefinitionQuery
        ProcessInstance processInstance=runtimeService.createProcessInstanceQuery().processInstanceId("15001").singleResult();
        //4.进行挂起或激活   如果状态是挂起，则激活  反之则反之
        boolean Suspend=processInstance.isSuspended();
        if(Suspend==true){
            runtimeService.activateProcessInstanceById(processInstance.getId());
            System.out.println("实例："+processInstance.getProcessInstanceId()+"被激活");
        }else if(Suspend==false) {
            runtimeService.suspendProcessInstanceById(processInstance.getId());
            System.out.println("实例："+processInstance.getProcessInstanceId()+"被挂起");
        }
    }
}
