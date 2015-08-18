import com.alibaba.fastjson.JSON;
import com.rongrong.model.ProjectTb;
import com.rongrong.model.UserTb;
import com.rongrong.model.requestview.RequestModel;

import java.math.BigDecimal;

/**
 * Created by zhangfan on 2015/7/17.
 */
public class GenerateRequestJsonString {
    public static void main(String[] args) {
//        UserTb o = new UserTb();
//        o.setLoginName("zhangfan");
//        o.setLoginPs("123456789");


        ProjectTb o = new ProjectTb();
        o.setAmmount(new BigDecimal("10.3"));
        o.setAcceptCost(100.3F);
        o.setMainBody("结构体");
        o.setMeasure("风控措施");
        o.setSummary("产品简介");
        o.setTitle("项目标题");
        o.setTimeLimit("时间期限");
        o.setType(2);
        RequestModel requestModel = new RequestModel();
        requestModel.setO(o);
        requestModel.setVersion("1.1.0");
        requestModel.setUserName("zhangfan");
        requestModel.setClientType("IOS");

        System.out.println(JSON.toJSONString(requestModel));
    }
}
