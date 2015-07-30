import com.alibaba.fastjson.JSON;
import com.rongrong.model.UserTb;
import com.rongrong.model.requestview.RequestModel;

/**
 * Created by zhangfan on 2015/7/17.
 */
public class GenerateRequestJsonString {
    public static void main(String[] args) {
        UserTb o = new UserTb();
        o.setLoginName("zhangfan");
        o.setLoginPs("123456789");

        RequestModel requestModel = new RequestModel();
        requestModel.setO(o);
        System.out.println(JSON.toJSONString(requestModel));
    }
}
