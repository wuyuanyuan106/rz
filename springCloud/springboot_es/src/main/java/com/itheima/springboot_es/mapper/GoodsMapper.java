package com.itheima.springboot_es.mapper;

import com.itheima.springboot_es.domain.Goods;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @PackageName: com.itheima.springboot_es.mapper
 * @ClassName: GoodsMapper
 * @Author: zhangle @Date: 2020/3/6 20:16
 * @Description:
 */
@Mapper
public interface GoodsMapper {
    List<Goods> findAll();
}
