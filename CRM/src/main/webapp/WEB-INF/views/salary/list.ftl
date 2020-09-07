<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>工资管理</title>
    <#include "../common/link.ftl" >
    <script>
        $(function () {
            
            // 弹出模态框
            $('.btn-input').click(function () {
                $("#salaryForm input ,#salaryForm select").val('')
                let data = $(this).data('json');
                if (data) {
                    $('#salaryForm input[name=id]').val(data.id)
                    $('#salaryForm input[name=year]').val(data.year)
                    $('#salaryForm input[name=month]').val(data.month)
                    $('#salaryForm input[name=money]').val(data.money)
                    $("#employeeId").val(data.employeeId)
                    $("#payoutId2").val(data.payoutId)

                }
                $('#salaryModal').modal('show');
            })
            // //保存按钮
            $('.salary-submit').click(function () {
                $('#salaryForm').ajaxSubmit(function (data) {
                    if (data.success) {
                        $.messager.popup("更新成功！")
                        window.location.href = "/salary/list"
                    } else {
                        $.messager.popup("更新失败！")
                    }
                })
            })
        })
    </script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <#include "../common/navbar.ftl" >
    <#assign currentMenu="salary"/>
    <#include "../common/menu.ftl" >
    <div class="content-wrapper">
        <section class="content-header">
            <h1>工资管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <div style="margin: 10px;">
                    <!--高级查询--->
                    <form class="form-inline" id="searchForm" action="/salary/list" method="post">
                        <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <div class="form-group">
                            <label for="keyword">员工姓名:</label>
                            <input type="text" class="form-control" id="keyword" name="keyword" value="${qo.keyword !}">
                        </div>

                        <div class="form-group">
                            <label for="status">发放方式:</label>
                            <select class="form-control" id="payoutId" name="payoutId">
                                <option value="">全部</option>
                                <option value="16">银行转账</option>
                                <option value="17">现金支付</option>
                                <option value="18">支付宝转账</option>
                                <option value="19">微信转账</option>
                            </select>
                            <script>
                                $('#payoutId').val("${qo.payoutId !}")
                            </script>
                        </div>


                        <div class="form-group">
                            <label>薪资范围:</label>
                         <input type="text" class="form-control" id="minSalary" name="minSalary" value="${((qo.minSalary)?c)!}">--
                         <input type="text" class="form-control" id="maxSalary" name="maxSalary" value="${((qo.maxSalary)?c) !}"></div>

                        <button id="btn_query" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>
                            查询
                        </button>
                        <a href="#" class="btn btn-success btn-input">
                            <span class="glyphicon glyphicon-plus"></span> 添加
                        </a>
                    </form>


                </div>
                <div class="box-body table-responsive no-padding ">
                    <table class="table table-hover table-bordered">
                        <tr>
                            <th>编号</th>
                            <th>年份</th>
                            <th>月份</th>
                            <th>员工</th>
                            <th>工资</th>
                            <th>发放方式</th>
                            <th>操作</th>

                        </tr>
                        <#list result.list as salary>
                            <tr>
                                <td>${salary_index+1}</td>
                                <td>${(salary.year)?c !}</td>
                                <td>${(salary.month) !}</td>
                                <td>${(salary.employee.name) !}</td>
                                <td>${(salary.money)?c !}</td>
                                <td>${(salary.payout.title) !}</td>
                                <td>  <a href="#"
                                         class="btn btn-info btn-xs btn-input" data-json='${(salary.json) !}'>
                                        <span class="glyphicon glyphicon-pencil"></span> 编辑
                                    </a></td>
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

<!-- Modal模态框 -->
<div id="salaryModal" class="modal fade" tabindex="-1" role="dialog">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                <h4 class="modal-title">工资管理新增/编辑</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="/salary/saveOrUpdate" method="post" id="salaryForm" style="margin: -3px 118px">
                    <div class="form-group" >
                        <label for="name" class="col-sm-4 control-label">年份：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"  name="year" >
                            <input type="hidden" class="form-control"  name="id">
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="sn" class="col-sm-4 control-label">月份：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"  name="month">

                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sn" class="col-sm-4 control-label">员工：</label>
                        <div class="col-sm-8">
                            <select name="employee.id" class="form-control" id="employeeId">
                                <#list employees as emp>
                                    <option value="${(emp.id)!}">${(emp.name)!}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sn" class="col-sm-4 control-label">工资：</label>
                        <div class="col-sm-8">
                            <input type="text" class="form-control"  name="money">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="sn" class="col-sm-4 control-label">发放方式：</label>
                        <div class="col-sm-8">
                            <select name="payout.id" class="form-control" id="payoutId2">
                                <#list systemDictionaryItem as sy>
                                    <option value="${(sy.id)!}">${(sy.title)!}</option>
                                </#list>
                            </select>
                        </div>
                    </div>

                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                <button type="button" class="btn btn-primary salary-submit" >保存</button>
            </div>
        </div>
    </div>
</div>
</div>
</body>
</html>