package com.rongrong.service.transactionmanager;

import com.rongrong.dao.PrShareTbMapper;
import com.rongrong.model.PrShareTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PrShareTbTransactionManager {



    @Autowired
    private PrShareTbMapper prShareTbMapper;


    public void savePrShareTb(PrShareTb prShareTb) {

        prShareTbMapper.save(prShareTb);
    }

    public void savePrShareTbs(List<PrShareTb> prShareTbs) {

        if (prShareTbs == null) {
            return;
        }
        for (int i = 0; i < prShareTbs.size(); i++) {
            prShareTbMapper.save(prShareTbs.get(i));
        }
    }

    public void updatePrShareTb(PrShareTb prShareTb) {
        prShareTbMapper.update(prShareTb);

    }

    public void updatePrShareTbs(List<PrShareTb> prShareTbs) {
        if (prShareTbs == null) {
            return;
        }
        for (int i = 0; i < prShareTbs.size(); i++) {
            prShareTbMapper.update(prShareTbs.get(i));
        }
    }

    public PrShareTb getUniqueBy(PrShareTb prShareTb) {

        return prShareTbMapper.getUniqueBy(prShareTb);
    }

    public List<PrShareTb> getBy(PrShareTb prShareTb) {

        return prShareTbMapper.getBy(prShareTb);
    }

    public Integer count(PrShareTb prShareTb) {

        return prShareTbMapper.count(prShareTb);
    }

}
