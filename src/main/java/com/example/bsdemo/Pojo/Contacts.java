package com.example.bsdemo.Pojo;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("contacts") // 确保这里的表名与数据库中的表名一致
public class Contacts {
    @TableId(type = IdType.AUTO)
    private Long id; // 假设id为Long类型


    // 其他字段
    private String name;
    private String address; // 字段名小写开头

    // 如果您希望继续使用 double 类型来存储电话号码
    private double tel; // 确保这与数据库中的字段类型一致

    public Contacts() {
    }

    public Contacts(Long id, String name, String address, double tel) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public Contacts(String name, String address, double tel) {
        this.name = name;
        this.address = address;
        this.tel = tel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getTel() {
        return tel;
    }

    public void setTel(double tel) {
        this.tel = tel;
    }
}
