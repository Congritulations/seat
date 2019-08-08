package com.zt.seatcommon.param;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MessageParam {

    private String routingKey;
    private Object message;
}
