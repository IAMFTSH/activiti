package learn.springboot.activiti.second;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.impl.util.IoUtil;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 方法1：通过activiti的api获取
 * 方法2：通过jdbc的方法获取
 *
 */
public class QueryBpmn {
    public static void main(String[] args) throws IOException {
        //1.创建processEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.创建repositoryService
        RepositoryService repositoryService = processEngine.getRepositoryService();
        //3.创建processDefinitionQuery
        ProcessDefinitionQuery processDefinitionQuery = repositoryService.createProcessDefinitionQuery();
        //4.设置查询条件
        ProcessDefinition processDefinition = processDefinitionQuery.processDefinitionKey("holiday").singleResult();
        //5.获取部署Id
        String deploymentId=processDefinition.getDeploymentId();
        //6.通过repositoryService的方法，实现读取图片和BPMN（输入流）
            //processDefinition.getDiagramResourceName()获取图片名字
        InputStream PngInputStream=repositoryService.getResourceAsStream(deploymentId,processDefinition.getDiagramResourceName());
            //processDefinition.getDiagramResourceName()获取图片名字
        InputStream BPMNInputStream=repositoryService.getResourceAsStream(deploymentId,processDefinition.getResourceName());
        //7.构建输出流
        OutputStream PngOutputStream=new FileOutputStream("/home/ftsh/IdeaProjects/activiti/src/main/resources/OutPut/"+processDefinition.getDiagramResourceName());
        OutputStream BPMNOutputStream=new FileOutputStream("/home/ftsh/IdeaProjects/activiti/src/main/resources/OutPut/"+processDefinition.getResourceName());
        //8.导入入commons-io包
        IOUtils.copy(PngInputStream,PngOutputStream);
        IOUtils.copy(BPMNInputStream,BPMNOutputStream);
        PngInputStream.close();
        BPMNInputStream.close();
        PngOutputStream.close();
        BPMNOutputStream.close();
    }
}
