package learn.springboot.activiti.second;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 删除流程
 * 普通删除：删除流程不会删除实例信息，如果存在实例没有走完，那么删除就会失败，因为没有了流程定义信息，实例就没办法走下一步
 * 级联删除：会删除没有走完的实例信息repositoryService.deleteDeployment("1",true);
 */
public class DeleteProcess {
    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine= ProcessEngines.getDefaultProcessEngine();
        //2.创建repositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        /*输入部署表中的Id*/
        repositoryService.deleteDeployment("47501",true);
    }
}
