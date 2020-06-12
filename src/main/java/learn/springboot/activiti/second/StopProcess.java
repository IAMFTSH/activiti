package learn.springboot.activiti.second;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 挂起流程定义
 * 如果被挂起，该流程定义则不能再创建实例，未完成状态的流程暂停执行
 */
public class StopProcess {
    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建repositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.创建processDefinitionQuery
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //4.设置查询条件
        ProcessDefinition processDefinition = processDefinitionQuery.processDefinitionId("holiday:1:2504").singleResult();
        //或者
        /*ProcessDefinition processDefinition = processDefinitionQuery.processDefinitionId("holiday").singleResult();*/
        //5.进行挂起或激活   如果状态是挂起，则激活  反之则反之
        boolean suspend=processDefinition.isSuspended();
        if(suspend==true){
            repositoryService.activateProcessDefinitionById(processDefinition.getId(),true,null);
            System.out.println("流程："+processDefinition.getName()+"被激活");
        }else if(suspend==false) {
            repositoryService.suspendProcessDefinitionById(processDefinition.getId(),false,null);
            System.out.println("流程："+processDefinition.getName()+"被挂起");
        }
    }
}
