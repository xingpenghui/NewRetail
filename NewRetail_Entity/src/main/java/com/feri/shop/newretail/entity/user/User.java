package com.feri.shop.newretail.entity.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-12 15:07
 */
@Data
public class User {
    private Integer id;
    private String phone;
    @JsonIgnore //转换为json的时候忽略该字段
    private String password;
    private Short flag;

}
