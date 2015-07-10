package com.rongrong.service.transactionmanager;

import com.rongrong.dao.PictureTbMapper;
import com.rongrong.model.PictureTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PictureTbTransactionManager {



    @Autowired
    private PictureTbMapper pictureTbMapper;


    public void savePictureTb(PictureTb pictureTb) {

        pictureTbMapper.save(pictureTb);
    }

    public void savePictureTbs(List<PictureTb> pictureTbs) {

        if (pictureTbs == null) {
            return;
        }
        for (int i = 0; i < pictureTbs.size(); i++) {
            pictureTbMapper.save(pictureTbs.get(i));
        }
    }

    public void updatePictureTb(PictureTb pictureTb) {
        pictureTbMapper.update(pictureTb);

    }

    public void updatePictureTbs(List<PictureTb> pictureTbs) {
        if (pictureTbs == null) {
            return;
        }
        for (int i = 0; i < pictureTbs.size(); i++) {
            pictureTbMapper.update(pictureTbs.get(i));
        }
    }

    public PictureTb getUniqueBy(PictureTb pictureTb) {

        return pictureTbMapper.getUniqueBy(pictureTb);
    }

    public List<PictureTb> getBy(PictureTb pictureTb) {

        return pictureTbMapper.getBy(pictureTb);
    }

    public Integer count(PictureTb pictureTb) {

        return pictureTbMapper.count(pictureTb);
    }

}
