package com.feri.shop.newretail.search.dao;

import com.feri.shop.newretail.search.entity.SearchGoods;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface SearchGoodsDao extends ElasticsearchRepository<SearchGoods,Integer> {

}
