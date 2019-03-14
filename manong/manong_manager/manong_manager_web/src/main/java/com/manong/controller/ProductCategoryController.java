package com.manong.controller;

import com.manong.service.ProductCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pojo.EasyUITree;
import pojo.ResponseJsonResult;

import java.util.List;

@Controller
@RequestMapping("/product_category")
public class ProductCategoryController {

    private static final Logger logger = LoggerFactory.getLogger(ProductCategoryController.class);

    @Autowired
    ProductCategoryService productCategoryService;

    /**
     * 根据parentid返回数据列表
     */
    @RequestMapping("/list")
    @ResponseBody
    public List<EasyUITree> getProductCategoryByParentId(@RequestParam(value = "id" ,defaultValue = "0")

                                                         Short parentId){

        List<EasyUITree> list = productCategoryService.findProductCategoryListByParentId(parentId);

        //logger.info("list值"+list.get(0).toString());

        return  list;

    }

    /**
     * 添加分类
     */
    @RequestMapping("/add")
    @ResponseBody
    public ResponseJsonResult addCategory(Short parentId,String name){

        ResponseJsonResult result = productCategoryService.addCategory(parentId, name);

        return result;

    }

    /**
     * 删除分类
     */
    @RequestMapping("/del")
    @ResponseBody
    public ResponseJsonResult delCategory(Short parentId,Short id){

        ResponseJsonResult result = productCategoryService.delCategory(parentId, id);

        logger.info("result值"+result.getStatus());

        return result;

    }
}
