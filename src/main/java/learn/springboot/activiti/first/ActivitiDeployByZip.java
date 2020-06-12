package learn.springboot.activiti.first;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

import java.io.InputStream;
import java.util.zip.ZipInputStream;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 流程部署zip方便上传服务器
 */
public class ActivitiDeployByZip {
    private ProcessEngine processEngine;

    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine =ProcessEngines.getDefaultProcessEngine();
        //2.创建repositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();

        //3.zip变zip输入流
        InputStream inputStream = ActivitiDeploy.class.getClassLoader().getResourceAsStream("diagram/holiday.zip");
        ZipInputStream zipInputStream = new ZipInputStream(inputStream);
        //4.进行部署
        Deployment deployment = repositoryService.createDeployment().addZipInputStream(zipInputStream).name("请假单流程").deploy();

        System.out.println(deployment.getName());
        System.out.println(deployment.getId());

    }
}
