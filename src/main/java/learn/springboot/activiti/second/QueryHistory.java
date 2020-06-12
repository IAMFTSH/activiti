package learn.springboot.activiti.second;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;

import java.util.List;

/**
 * @author 邝明山
 * @Date 2020/5/31
 * 查询历史的实例
 */
public class QueryHistory {
    public static void main(String[] args) {
        //1.创建processEngine
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        //2.创建historyService
        HistoryService historyService = processEngine.getHistoryService();
        //3.得到HistoricActivityInstanceQuery对象
        HistoricActivityInstanceQuery historicActivityInstanceQuery=historyService.createHistoricActivityInstanceQuery();
        //4.执行查询
        historicActivityInstanceQuery.processInstanceId("5001");
        List<HistoricActivityInstance> historicActivityInstanceList = historicActivityInstanceQuery.orderByHistoricActivityInstanceStartTime().desc().list();

        for(HistoricActivityInstance historicActivityInstance:historicActivityInstanceList){
            System.out.println("活动id"+historicActivityInstance.getActivityId());
            System.out.println("活动名称："+historicActivityInstance.getActivityName());
            System.out.println("流程定义ID："+historicActivityInstance.getProcessDefinitionId());
            System.out.println("流程实例ID："+historicActivityInstance.getProcessInstanceId());
            System.out.println("--------------------------------");
        }
    }
}
