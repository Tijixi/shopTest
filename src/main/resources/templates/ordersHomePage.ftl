<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://cdn.bootcss.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://cdn.bootcss.com/jquery/2.1.1/jquery.min.js"></script>
    <script src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <title>订单详情页面</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<table class="table table-striped">
    <caption>订单详情</caption>
    <thead>
    <tr>
        <th>订单id</th>
        <th>买家id</th>
        <th>商品id</th>
        <th>总计消费</th>
        <th>支付状态</th>
    </tr>
    </thead>

    <tbody>
    <#list 0..(ordersList!?size-1) as i>
    <tr>
        <td>${ordersList[i].orderId!}</td>
        <td>${ordersList[i].orderBuyerId!}</td>
        <td>${ordersList[i].orderProductId!}</td>
        <td>${ordersList[i].orderConsumption!}</td>
        <td>${ordersList[i].orderPayStatus!}</td>
    </tr>
    </#list>
    </tbody>

</table>
</body>
</html>