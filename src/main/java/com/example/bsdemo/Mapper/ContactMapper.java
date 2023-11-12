package com.example.bsdemo.Mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.bsdemo.Pojo.Contacts;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ContactMapper extends BaseMapper<Contacts> {
    // MyBatis Plus 会提供大量的默认方法。
    // 根据需要添加自定义查询。
}