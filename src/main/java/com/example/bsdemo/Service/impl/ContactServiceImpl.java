package com.example.bsdemo.Service.impl;

import com.example.bsdemo.Mapper.ContactMapper;
import com.example.bsdemo.Pojo.Contacts;
import com.example.bsdemo.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactMapper contactMapper;

    public boolean addContact(Contacts contact) {
        // 这里可以添加额外的业务逻辑，比如验证输入数据等
        int result = contactMapper.insert(contact);
        return result > 0;
    }

    public boolean deleteContact(Long id) {
        // 这里可以添加额外的业务逻辑，比如验证联系人是否存在等
        int result = contactMapper.deleteById(id);
        return result > 0;
    }

    public Contacts queryContact(Long id) {
        // 这里可以添加额外的业务逻辑，比如格式化输出等
        return contactMapper.selectById(id);
    }

    public boolean updateContact(Contacts contact) {
        // 这里可以添加额外的业务逻辑，比如验证联系人是否存在等
        int result = contactMapper.updateById(contact);
        return result > 0;
    }

    @Override
    public List<Contacts> getAllContacts() {
        // 使用MyBatis Plus的selectList方法获取所有联系人
        // 由于我们想要获取所有联系人，不需要任何查询条件，因此传递null
        return contactMapper.selectList(null);

    }

}
