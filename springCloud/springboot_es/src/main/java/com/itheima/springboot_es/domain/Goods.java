package com.itheima.springboot_es.domain;


import com.alibaba.fastjson.annotation.JSONField;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

/**
 * @PackageName: com.itheima.springboot_es.domain
 * @ClassName: Goods
 * @Author: zhangle @Date: 2020/3/6 18:16
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Goods {
    private Integer id;
    private String title;
	private long price;
	private double stock;
    private double saleNum;
    private Date createTime;
    private String categoryName;
	private String brandName;
	private Map specMap;
//	@JSONField(serialize = false)
	private String spec;
}
