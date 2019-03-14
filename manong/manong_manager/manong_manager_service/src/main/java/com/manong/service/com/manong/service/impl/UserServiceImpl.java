package com.manong.service.com.manong.service.impl;

import com.manong.mapper.TbUserMapper;
import com.manong.pojo.TbUser;
import com.manong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    TbUserMapper tbUserMapper;


    @Override
    public TbUser getUserById(Integer id) {

        /*TbUser tbUser = tbUserMapper.selectByPrimaryKey(id);*/
        /*TbUserExample example=new TbUserExample();
        TbUserExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);

        List<TbUser> userList = tbUserMapper.selectByExample(example);

        if (userList!=null){

            return userList.get(0);
        }*/

        TbUser user = tbUserMapper.selectByPrimaryKey(id);
        return user;
        //return null;
    }
}
