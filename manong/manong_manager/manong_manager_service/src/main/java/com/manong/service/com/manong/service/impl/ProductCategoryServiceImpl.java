package com.manong.service.com.manong.service.impl;

import com.manong.mapper.ProductCategoryMapper;
import com.manong.pojo.ProductCategory;
import com.manong.pojo.ProductCategoryExample;
import com.manong.service.ProductCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

    @Autowired
    ProductCategoryMapper productCategoryMapper;


    @Override
    public List<EasyUITree> findProductCategoryListByParentId(Short parentid) {

        ProductCategoryExample example = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(parentid);
        List<ProductCategory> categoryList = productCategoryMapper.selectByExample(example);

        List<EasyUITree> list = new ArrayList<>();

        for (ProductCategory productCategory : categoryList) {
            EasyUITree node = new EasyUITree();
            node.setId(productCategory.getId());
            node.setText(productCategory.getName());
            node.setState(productCategory.getParentid()==0?"closed":"open");

            node.setAttributes(productCategory.getParentid()+"");

            list.add(node);
        }

        return list;
    }

    @Override
    public ResponseJsonResult addCategory(Short parentid, String name) {

        ProductCategory productCategory = new ProductCategory();
        productCategory.setParentid(parentid);
        productCategory.setName(name);

        productCategoryMapper.insert(productCategory);

        ResponseJsonResult result = new ResponseJsonResult();

        result.setMsg(productCategory.getId()+"");

        return result;
    }

    @Override
    public ResponseJsonResult delCategory(Short parentid, Short id) {

        ProductCategoryExample example = new ProductCategoryExample();
        ProductCategoryExample.Criteria criteria = example.createCriteria();

        if(parentid==0){

            criteria.andIdEqualTo(id);
            ProductCategoryExample.Criteria criteria1 = example.createCriteria();
            criteria1.andParentidEqualTo(id);
            example.or(criteria1);

            /*addCriteria(example,id);*/

        }else{

            criteria.andIdEqualTo(id);

        }

        int i = productCategoryMapper.deleteByExample(example);

        ResponseJsonResult result = new ResponseJsonResult();

        if (i>0){
            result.setStatus(200);
            result.setMsg("success");
        }else{
            result.setStatus(-200);
            result.setMsg("failed");
        }

        return result;
    }

    /*public void addCriteria(ProductCategoryExample example,Short id){

        ProductCategoryExample.Criteria criteria = example.createCriteria();
        criteria.andParentidEqualTo(id);
        List<ProductCategory> list = productCategoryMapper.selectByExample(example);
        for (ProductCategory productCategory:list) {
            Short id1 = productCategory.getId();
            ProductCategoryExample.Criteria criteria1 = example.createCriteria();
            criteria1.andParentidEqualTo(id1);
            example.or(criteria1);
        }

    }*/
}
