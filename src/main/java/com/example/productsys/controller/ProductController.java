package com.example.productsys.controller;


import com.example.productsys.entity.Orders;
import com.example.productsys.entity.Product;
import com.example.productsys.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@Controller
@RequestMapping("/controller")
public class ProductController {


    @Autowired
    private ProductService productService;

    //商品详情主页
    @RequestMapping(value = "/prodHomePagectrl")
    public String orderHomepageftl(Map<String, Object> map, HttpServletRequest request) {
        List<Product> results = productService.selectAll();
        map.put("prodList", results);
        return "prodHomePage";
    }

    //增加商品提交后处理
    @RequestMapping(value = "/addFormctrl")
    public void addForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取表单中商品的信息数据
        int prodId = Integer.parseInt(request.getParameter("prodId"));
        String prodName = request.getParameter("prodName");
        double prodPrice = Double.parseDouble(request.getParameter("prodPrice"));

        //插入数据到数据库
        productService.insertProduct(prodId, prodName, prodPrice);

        //重定向到主页面，显示所有商品信息
        //这里重定向的时候，不要+“/”，否则报错哟
        response.sendRedirect("prodHomePagectrl");
        // return "prodHomePage";
    }


    //修改商品后提交处理
    @RequestMapping(value = "/updateFormctrl")
    public void updateForm(HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取表单中商品的信息数据
        int prodId = Integer.parseInt(request.getParameter("prodId"));
        String prodName = request.getParameter("prodName");
        double prodPrice = Double.parseDouble(request.getParameter("prodPrice"));

        //插入数据到数据库
        productService.updateByProductId(prodId, prodName, prodPrice);

        //重定向到主页面，显示所有商品信息
        //这里重定向的时候，不要+“/”，否则报错哟
        response.sendRedirect("prodHomePagectrl");
    }

    //查找商品后提交处理
    @RequestMapping(value = "/selectFormctrl")
    public String selectForm(Map<String, Object> map, HttpServletRequest request, HttpServletResponse response) throws IOException {
        //获取表单中商品的信息数据
        int prodId = Integer.parseInt(request.getParameter("prodId"));

        Product product = productService.getByProductId(prodId);
        //通过id查找后显示商品信息
        //为了和前端显示详情用的list保持一致的类型，所以新建一个list，然后将对象添加进list对象中
        List<Product> l = null;
        l.add(product);
        List<Product> results = new ArrayList<Product>();
        results.add(product);
        System.out.println(results);
      //  results.add(product);

        map.put("prodList", results);
        return "prodHomePage";
    }


    @RequestMapping(value = "/prodctrl", method = RequestMethod.GET)
    public String say() {
        Product product = productService.getByProductId(1);
        System.out.println(product);

        //insert方法已成功
        System.out.println(productService.getByProductId(productService.insertProduct(6, "添加商品a", 8)));

        //删除
        productService.deleteByProductId(2);

        //更新方法已实现，待会儿使用select all来实现输出
        productService.updateByProductId(1, "更新后商品a", 4);

        //select all的方法调用
        List<Product> results = productService.selectAll();
        for (Product item : results)            //打印输出list集合，该方法适用于所有collection集合
        {
            System.out.println(item);
        }

        return null;
/*
        该return返回到页面，System.out.print输出在控制台
        return  product.toString();
*/
    }
}
