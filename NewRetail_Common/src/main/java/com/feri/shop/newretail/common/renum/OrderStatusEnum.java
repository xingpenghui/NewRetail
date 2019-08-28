package com.feri.shop.newretail.common.renum;

public enum OrderStatusEnum {
    CREATEORDER(1,"生成订单，未付款"),PAYINGORDER(2,"付款中，生成支付二维码"),PAYEDORDER(3,"付款成功，未发货");
    private int code;
    private String msg;

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    private OrderStatusEnum(int code, String m){
        this.code=code;
        this.msg=m;
    }


}
