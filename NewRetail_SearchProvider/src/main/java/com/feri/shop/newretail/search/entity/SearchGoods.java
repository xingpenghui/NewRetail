package com.feri.shop.newretail.search.entity;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * @program: NewRetail
 * @description:
 * @author: Feri
 * @create: 2019-08-21 16:07
 */
@Document(indexName = "goodssearch ",type = "searchgoods")
@Data
public class SearchGoods {
    private int id;
    private String name;//商品名称
    private String typeName;//类型名称

    public SearchGoods() {
    }

    public SearchGoods(int id) {
        this.id = id;
    }
}
