package com.rongrong.dao.transactionmanager;

import com.rongrong.dao.PrPraiseTbMapper;
import com.rongrong.model.PrPraiseTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrPraiseTbTransactionManager {



    @Autowired
    private PrPraiseTbMapper prPraiseTbMapper;


    public void savePrPraiseTb(PrPraiseTb prPraiseTb) {

        prPraiseTbMapper.save(prPraiseTb);
    }

    public void savePrPraiseTbs(List<PrPraiseTb> prPraiseTbs) {

        if (prPraiseTbs == null) {
            return;
        }
        for (int i = 0; i < prPraiseTbs.size(); i++) {
            prPraiseTbMapper.save(prPraiseTbs.get(i));
        }
    }

    public void updatePrPraiseTb(PrPraiseTb prPraiseTb) {
        prPraiseTbMapper.update(prPraiseTb);

    }

    public void updatePrPraiseTbs(List<PrPraiseTb> prPraiseTbs) {
        if (prPraiseTbs == null) {
            return;
        }
        for (int i = 0; i < prPraiseTbs.size(); i++) {
            prPraiseTbMapper.update(prPraiseTbs.get(i));
        }
    }

    public PrPraiseTb getUniqueBy(PrPraiseTb prPraiseTb) {

        return prPraiseTbMapper.getUniqueBy(prPraiseTb);
    }

    public List<PrPraiseTb> getConditionBy(PrPraiseTb prPraiseTb) {

        return prPraiseTbMapper.getConditionBy(prPraiseTb);
    }

    public List<PrPraiseTb> getBy(PrPraiseTb prPraiseTb) {

        return prPraiseTbMapper.getBy(prPraiseTb);
    }

    public Integer count(PrPraiseTb prPraiseTb) {

        return prPraiseTbMapper.count(prPraiseTb);
    }

}
