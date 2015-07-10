package com.rongrong.service.transactionmanager;

import com.rongrong.dao.PrCommentTbMapper;
import com.rongrong.model.PrCommentTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrCommentTbTransactionManager {



    @Autowired
    private PrCommentTbMapper prCommentTbMapper;


    public void savePrCommentTb(PrCommentTb prCommentTb) {

        prCommentTbMapper.save(prCommentTb);
    }

    public void savePrCommentTbs(List<PrCommentTb> prCommentTbs) {

        if (prCommentTbs == null) {
            return;
        }
        for (int i = 0; i < prCommentTbs.size(); i++) {
            prCommentTbMapper.save(prCommentTbs.get(i));
        }
    }

    public void updatePrCommentTb(PrCommentTb prCommentTb) {
        prCommentTbMapper.update(prCommentTb);

    }

    public void updatePrCommentTbs(List<PrCommentTb> prCommentTbs) {
        if (prCommentTbs == null) {
            return;
        }
        for (int i = 0; i < prCommentTbs.size(); i++) {
            prCommentTbMapper.update(prCommentTbs.get(i));
        }
    }

    public PrCommentTb getUniqueBy(PrCommentTb prCommentTb) {

        return prCommentTbMapper.getUniqueBy(prCommentTb);
    }

    public List<PrCommentTb> getBy(PrCommentTb prCommentTb) {

        return prCommentTbMapper.getBy(prCommentTb);
    }

    public Integer count(PrCommentTb prCommentTb) {

        return prCommentTbMapper.count(prCommentTb);
    }

}
