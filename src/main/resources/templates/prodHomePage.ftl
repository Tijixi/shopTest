<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>商品详情页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<table class="table table-striped">
    <caption><h1 align="center">商品详情</h1></caption>
    <thead>
    <tr>
        <th>商品id</th>
        <th>名称</th>
        <th>价格</th>
    </tr>
    </thead>

    <tbody>
    <#list 0..(prodList!?size-1) as i>
    <tr>
        <td><input type="checkbox" onclick="selectItem()"/>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp${prodList[i].productId!}</td>
        <td>${prodList[i].productName!}</td>
        <td>${prodList[i].productPrice!}</td>
    </tr>
    </#list>
    </tbody>
</table>
<#--声明一个list-->
<#--选中项的监听函数-->

<script>
    var selectArray=[];
    function selectItem() {
        selectArray.add()
    }
</script>
<button type="button" class="btn btn-outline-secondary" data-toggle="collapse"
        data-target="#addForm">增加商品</button>
<button type="button" class="btn btn-outline-secondary"data-toggle="collapse"
        data-target="#addForm">删除商品</button>
<button type="button" class="btn btn-outline-secondary" data-toggle="collapse"
        data-target="#updateForm">修改商品</button>
<button type="button" class="btn btn-outline-secondary" data-toggle="collapse"
        data-target="#selectForm">查找商品</button>

<#--折叠的增加商品表单-->
<div id="addForm" class="collapse out">
    <form action="/controller/addFormctrl">
        <div class="form-group">
            <label for="exampleInputEmail1">商品id</label>
            <input type="text" class="form-control" name="prodId" placeholder="请输入商品id">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">名称</label>
            <input type="text" class="form-control" name="prodName" placeholder="请输入商品名称">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">商品价格</label>
            <input type="text" class="form-control" name="prodPrice" placeholder="请输入商品价格">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>


<#--折叠的修改商品表单-->
<div id="updateForm" class="collapse out">
    <form action="/controller/updateFormctrl">
        <div class="form-group" >
            <label for="exampleInputEmail1">商品id</label>
            <input type="text" class="form-control" name="prodId" placeholder="请输入商品id">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">名称</label>
            <input type="text" class="form-control" name="prodName" placeholder="请输入商品名称">
        </div>
        <div class="form-group">
            <label for="exampleInputPassword1">商品价格</label>
            <input type="text" class="form-control" name="prodPrice" placeholder="请输入商品价格">
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

<#--折叠的查找商品表单-->
<div id="selectForm" class="collapse out">
    <form  action="/controller/selectFormctrl">
        <div class="form-group">
            <label for="exampleInputEmail1">商品id</label>
            <input type="text" class="form-control" name="prodId" aria-describedby="emailHelp" placeholder="请输入商品id">
        </div>
        <button type="submit" class="btn btn-primary">确定</button>
    </form>
</div>

</body>
</html>
