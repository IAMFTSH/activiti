package learn.springboot.activiti.second;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.TaskService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 查询流程定义信息
 */
public class QueryProcessDefinition {
    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建repositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.创建processDefinitionQuery
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //4.设置查询条件
        List<ProcessDefinition> processDefinitionList = processDefinitionQuery.processDefinitionKey("holiday").orderByProcessDefinitionVersion().desc().list();


        for(ProcessDefinition processDefinition:processDefinitionList){

            System.out.println("流程定义Id:"+processDefinition.getId());
            System.out.println("流程名称:"+processDefinition.getName());
            System.out.println("流程定义Key:"+processDefinition.getKey());
            System.out.println("流程版本号:"+processDefinition.getVersion());
            //删除部署
            repositoryService.deleteDeployment(processDefinition.getDeploymentId());
        }
    }
}
