package com.rongrong.service.transactionmanager;

import com.rongrong.dao.MessageTbMapper;
import com.rongrong.model.MessageTb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageTbTransactionManager {



    @Autowired
    private MessageTbMapper messageTbMapper;


    public void saveMessageTb(MessageTb messageTb) {

        messageTbMapper.save(messageTb);
    }

    public void saveMessageTbs(List<MessageTb> messageTbs) {

        if (messageTbs == null) {
            return;
        }
        for (int i = 0; i < messageTbs.size(); i++) {
            messageTbMapper.save(messageTbs.get(i));
        }
    }

    public void updateMessageTb(MessageTb messageTb) {
        messageTbMapper.update(messageTb);

    }

    public void updateMessageTbs(List<MessageTb> messageTbs) {
        if (messageTbs == null) {
            return;
        }
        for (int i = 0; i < messageTbs.size(); i++) {
            messageTbMapper.update(messageTbs.get(i));
        }
    }

    public MessageTb getUniqueBy(MessageTb messageTb) {

        return messageTbMapper.getUniqueBy(messageTb);
    }

    public List<MessageTb> getBy(MessageTb messageTb) {

        return messageTbMapper.getBy(messageTb);
    }

    public Integer count(MessageTb messageTb) {

        return messageTbMapper.count(messageTb);
    }

}
