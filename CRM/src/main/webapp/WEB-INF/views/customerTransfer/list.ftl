<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>移交历史管理</title>
    <#-- freemark 是从自己出发，用相对路径取找的其他文件的-->
    <#include "../common/link.ftl">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <#include "../common/navbar.ftl">

    <!--菜单回显-->
    <#assign currentMenu="customerTransfer"/>
    <#include "../common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>移交历史管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/customerTransfer/list" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                    <div class="form-group">
                        <label for="keyword">关键字:</label>
                        <input type="text" class="form-control" id="keyword" name="keyword"
                               value="${(qo.keyword)!}" placeholder="请输入姓名/电话">
                    </div>
                    <button id="btn_query" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>
                        查询
                    </button>

                </form>
                <!--编写内容-->

                <div class="box-body table-responsive no-padding ">
                    <table class="table table-hover table-bordered">
                        <tr>
                            <th>编号</th>
                            <th>客户姓名</th>
                            <th>移交日期</th>
                            <th>操作人员</th>
                            <th>旧营销人员</th>
                            <th>新营销人员</th>
                            <th>移交原因</th>
                        </tr>

                        <#list  (result.list) ! as CustomerTransfer>
                            <tr>
                                <td>${CustomerTransfer_index+1}</td>
                                <td>${(CustomerTransfer.customer.name) !}</td>
                                <td>${CustomerTransfer.operateTime !?string('yyyy-MM-dd HH:mm:ss')}</td>
                                <td>${CustomerTransfer.operator.name!}</td>
                                <td>${(CustomerTransfer.oldSeller.name) !}</td>
                                <td>${(CustomerTransfer.newSeller.name) !}</td>
                                <td>${(CustomerTransfer.reason) !}</td>
                            </tr>
                        </#list>
                    </table>

                    <#include "../common/page.ftl">

                </div>

            </div>
        </section>
    </div>

    <#include "../common/footer.ftl">

</div>
</body>
</html>
