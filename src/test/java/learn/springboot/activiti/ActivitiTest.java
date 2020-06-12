package learn.springboot.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngineConfiguration;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.junit.jupiter.api.Test;

/**
 * @author 邝明山
 * @Date 2020/5/30
 */
public class ActivitiTest {

    //自动创表
    @Test
    public void testGenTable() {
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = configuration.buildProcessEngine();
        System.out.println(processEngine);
    }

    @Test
    public void testAll() {
        //自动创表
        ProcessEngineConfiguration configuration = ProcessEngineConfiguration.createProcessEngineConfigurationFromResource("activiti.cfg.xml");
        ProcessEngine processEngine = configuration.buildProcessEngine();
        //3.进行部署
        RepositoryService repositoryService = processEngine.getRepositoryService();
        Deployment deployment = repositoryService.createDeployment().addClasspathResource("diagram/holiday.bpmn").addClasspathResource("diagram/holiday.png").name("请假单流程").deploy();
        //3.创建实例
        RuntimeService runtimeService=processEngine.getRuntimeService();
        ProcessInstance processInstance= runtimeService.startProcessInstanceByKey("holiday");

    }
}
