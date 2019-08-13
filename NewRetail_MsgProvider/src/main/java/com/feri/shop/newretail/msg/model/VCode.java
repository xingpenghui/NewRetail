package com.feri.shop.newretail.msg.model;

import lombok.Data;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-13 14:54
 */
@Data
public class VCode {
    private int code;
    private String phone;

    public VCode() {
    }

    public VCode(int code, String phone) {
        this.code = code;
        this.phone = phone;
    }
}
