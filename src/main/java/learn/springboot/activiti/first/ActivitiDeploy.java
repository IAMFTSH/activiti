package learn.springboot.activiti.first;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * @author 邝明山
 * @Date 2020/5/30
 * 流程部署
 */
public class ActivitiDeploy {
    public static void main(String[] args) {
        //注意，快速创建一定要按着约定创建activiti.cfg.xml和定义里面的processEngineConfiguration的Id
        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建repositoryService
        RepositoryService repositoryService=processEngine.getRepositoryService();
        //3.进行部署
        Deployment deployment= repositoryService.createDeployment().addClasspathResource("diagram/IncludingGateway.bpmn").addClasspathResource("diagram/holiday2.png").name("请假单流程之流程变量测试").deploy();

        System.out.println(deployment.getName());
        System.out.println(deployment.getId());

    }
}
