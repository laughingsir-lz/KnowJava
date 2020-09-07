<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>跟进历史管理</title>
    <#-- freemark 是从自己出发，用相对路径取找的其他文件的-->
    <#include "../common/link.ftl">
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <#include "../common/navbar.ftl">

    <!--菜单回显-->
    <#assign currentMenu="customerTraceHistory"/>
    <#include "../common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>跟进历史管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/customerTraceHistory/list" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                    <div class="form-group">
                        <label for="keyword">关键字:</label>
                        <input type="text" class="form-control" id="keyword" name="keyword"
                               value="${(qo.keyword)!}" placeholder="请输入姓名/电话">
                    </div>


                    <@shiro.hasAnyRoles name="Market_Manager,ADMIN">
                        <div class="form-group">
                            <label for="dept"> 销售人员:</label>
                            <select class="form-control" id="seller" name="sellerId">
                                <option value="">全部</option>

                                <#list sellers as seller>
                                    <option value="${(seller.id)!}">${(seller.name)!}</option>
                                </#list>
                            </select>
                            <script>
                                $("#seller").val(${(qo.sellerId)!})
                            </script>
                        </div>
                    </@shiro.hasAnyRoles>


                    <button id="btn_query" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>
                        查询
                    </button>

                </form>
                <!--编写内容-->

                <div class="box-body table-responsive no-padding ">
                    <table class="table table-hover table-bordered">
                        <tr>
                            <th>编号</th>
                            <th>姓名</th>
                            <th>跟进日期</th>
                            <th>跟进内容</th>
                            <th>跟进方式</th>
                            <th>跟进结果</th>
                            <th>录入人</th>
                        </tr>

                        <#list  (result.list) ! as customerTraceHistory>
                            <tr>
                                <td>${customerTraceHistory_index+1}</td>
                                <td>${(customerTraceHistory.customer.name) !}</td>
                                <td>${(customerTraceHistory.traceTime)! ?datetime}</td>
                                <td>${customerTraceHistory.traceDetails!}</td>
                                <td>${(customerTraceHistory.traceType.title) !}</td>
                                <td>
                                    <#switch customerTraceHistory.traceResult>
                                        <#case 1>
                                            差
                                        <#break>
                                        <#case 2>
                                            中
                                        <#break>
                                        <#case 3>
                                            优
                                        <#break>
                                    </#switch>

                                </td>
                                <td>${(customerTraceHistory.inputUser.name) !}</td>
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
