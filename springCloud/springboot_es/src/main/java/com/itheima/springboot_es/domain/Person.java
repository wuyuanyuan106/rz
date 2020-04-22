package com.itheima.springboot_es.domain;

/**
 * @PackageName: com.itheima.springboot_es.domain
 * @ClassName: Person
 * @Author: zhangle @Date: 2020/3/6 10:51
 * @Description:
 */
public class Person {
    private String id;
    private String name;
    private int age;
    private String address;

    public Person() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
