package com.itheima.es;

import com.alibaba.fastjson.JSON;
import com.itheima.springboot_es.EsApplication;

import com.itheima.springboot_es.domain.Goods;
import com.itheima.springboot_es.domain.Person;
import com.itheima.springboot_es.mapper.GoodsMapper;
import org.elasticsearch.action.DocWriteRequest;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.IndicesClient;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.client.indices.GetIndexResponse;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.itheima.es
 * @ClassName: Estest
 * @Author: zhangle @Date: 2020/3/5 9:51
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = EsApplication.class)
public class Estest {

    @Autowired
    private RestHighLevelClient restHighLevelClient;
    @Autowired
    private GoodsMapper goodsMapper;
//创建索引
    @Test
    public void test1() throws IOException {
        //获取索引对象
        IndicesClient indices = restHighLevelClient.indices();

        CreateIndexRequest cresteIndexRequest = new CreateIndexRequest("itheima");
        //具体操作,获取返回值
        CreateIndexResponse createIndexResponse = indices.create(cresteIndexRequest, RequestOptions.DEFAULT);
        boolean acknowledged = createIndexResponse.isAcknowledged();
        System.out.println(acknowledged);
    }
    //创建索引,(添加映射)
    @Test
    public void test2() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        CreateIndexRequest createIndexRequest = new CreateIndexRequest("itcast");
        String mapping = "{\n" +
                "      \"properties\" : {\n" +
                "        \"address\" : {\n" +
                "          \"type\" : \"text\",\n" +
                "          \"analyzer\" : \"ik_max_word\"\n" +
                "        },\n" +
                "        \"age\" : {\n" +
                "          \"type\" : \"long\"\n" +
                "        },\n" +
                "        \"name\" : {\n" +
                "          \"type\" : \"keyword\"\n" +
                "        }\n" +
                "      }\n" +
                "    }";
        createIndexRequest.mapping(mapping, XContentType.JSON);
        CreateIndexResponse createIndexResponse = indices.create(createIndexRequest, RequestOptions.DEFAULT);
        System.out.println(createIndexResponse.isAcknowledged());
    }

    //查询索引
    @Test
    public void test3() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        GetIndexRequest getIndexRequest = new GetIndexRequest("itcast");
        GetIndexResponse getIndexResponse = indices.get(getIndexRequest, RequestOptions.DEFAULT);
        Map<String, MappingMetaData> mappings = getIndexResponse.getMappings();
        for (String key : mappings.keySet()) {
            System.out.println(key+"   "+mappings.get(key).sourceAsMap());
        }
    }
    @Test
    public void test4() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();

        DeleteIndexRequest deleteIndexRequest  = new DeleteIndexRequest("itheima");
        AcknowledgedResponse delete = indices.delete(deleteIndexRequest, RequestOptions.DEFAULT);

        System.out.println(delete.isAcknowledged());
    }

    @Test
    public void test5() throws IOException {
        IndicesClient indices = restHighLevelClient.indices();
        GetIndexRequest getIndexRequest = new GetIndexRequest("itheima");
        boolean exists = indices.exists(getIndexRequest, RequestOptions.DEFAULT);
        System.out.println(exists);
    }

    //添加文档(map方式)
    @Test
    public void  test6() throws IOException{
        Map data = new HashMap();
        data.put("address","北京昌平");
        data.put("name","大胖");
        data.put("age",20);
        IndexRequest indexRequest = new IndexRequest("itcast").id("1").source(data);
        IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        RestStatus status = index.status();
        System.out.println(status);
    }
    //添加文档json字符串
    @Test
    public void test7() throws IOException {
        Person p = new Person();
        p.setId("2");
        p.setName("小胖2222");
        p.setAge(30);
        p.setAddress("陕西西安");
        String s = JSON.toJSONString(p);
        IndexRequest indexRequest = new IndexRequest("itcast").id(p.getId()).source(s,XContentType.JSON);
        IndexResponse index = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        RestStatus status = index.status();
        System.out.println(status);
    }
    //查询文档(根据id)
    @Test
    public void test8() throws IOException {
        GetRequest getRequest = new GetRequest("itcast","2");
        GetResponse documentFields = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
        System.out.println(documentFields.getSourceAsString());
    }

    //根据id删除文档
    @Test
    public void test9() throws IOException {
        DeleteRequest deleteRequest = new DeleteRequest("itcast","2");
        DeleteResponse delete = restHighLevelClient.delete(deleteRequest, RequestOptions.DEFAULT);
        System.out.println(delete.status());
    }
    @Test
    public void test10() throws IOException {

        BulkRequest bulkRequest = new BulkRequest();
        List<Goods> goodsList = goodsMapper.findAll();
        for (Goods goods : goodsList) {
            goods.setSpecMap(JSON.parseObject(goods.getSpec(),Map.class));

            IndexRequest indexRequest = new IndexRequest("goods").id(goods.getId()+"").source(JSON.toJSONString(goods), XContentType.JSON);
            bulkRequest.add(indexRequest);
        }
        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
        System.out.println(bulkResponse.status());
    }
}
