package com.zt.seatadmin.service.impl;

import com.zt.seatadmin.service.TestServiceI;
import com.zt.seatcommon.component.RabbitComponent;
import com.zt.seatcommon.component.RedisComponent;
import com.zt.seatcommon.param.MessageParam;
import com.zt.seatcommon.utils.Constant;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.helper.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TestServiceImpl implements TestServiceI {

    @Autowired
    private RabbitComponent rabbitComponent;

    @Autowired
    private RedisComponent component;


    @Override
    public void getAndSend() {
        String result = component.get("test");
        if (!StringUtil.isBlank(result)){
            MessageParam param = new MessageParam();
            param.setMessage(result);
            param.setRoutingKey(Constant.ROUTINGKEY);
            rabbitComponent.send(param);
            log.info("进去了");
        }
    }
}
