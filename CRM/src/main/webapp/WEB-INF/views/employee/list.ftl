<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>员工管理</title>

    <#include "../common/link.ftl"/>
    <script>
        $(function () {
            //全选框的点击事件
            $('#allCb').click(function () {
                //获取当前复选框的状态
                $('.cb').prop('checked', $(this).prop('checked'));
            });

            // 复选框的点击事件
            $('.cb').click(function () {
                //判断是否全部选中，如果是就选中全选框
                //判断所有复选框的数量是否和被选中的复选框数量相同 （相同就意味着全被选中了 反之 就没有）
                $('#allCb').prop('checked', $('.cb').length === $('.cb:checked').length);
            });
            //批量删除的点击事件
            $('.btn-batchDelete').click(function () {
                //首先获取选中的数据
                var cbs = $('.cb:checked');
                if (cbs.length === 0) {
                    $.messager.popup("警告: 请选中数据！")
                    return;
                }
                $.messager.confirm("警告", "请确认是否进行删除？", function () {
                    //把选中的员工id 存到ids中
                    var ids = [];
                    $.each(cbs, function (index, element) {
                        ids.push($(element).data('id'))
                    });
                    console.log(ids);
                    //提交时，是不用加[]的，全局禁用 ；
                    jQuery.ajaxSettings.traditional = true;
                    $.post('/employee/batchDelete', {ids: ids}, handlerMessage);
                })
            });
            //导入按钮点击事件
            $(".btn-import").click(function () {
                $("#importModal").modal('show');
            })


            //提交文件上传表单
            $(".btn-submit").click(function () {
                $("#importForm").ajaxSubmit(function (data) {
                    if (data.success) {
                        $.messager.popup(data.msg);
                        window.location.href = "/employee/list"
                    } else {
                        $.messager.popup(data.msg);
                    }
                });
            })

            // $(".btn-start").click(function () {
            //     let employeeId = $(this).data('id');
            //     $.post("/employee/xxx", {id: employeeId}, function (data) {
            //         if (data.success) {
            //             $.messager.popup(data.msg)
            //             setTimeout(function () {
            //                 window.location.reload();
            //             },2000)
            //         }
            //     })
            // });
            //
            // $(".btn-disable").click(function () {
            //     let employeeId = $(this).data('id');
            //     $.post("/employee/disable", {id: employeeId}, function (data) {
            //         if (data.success) {
            //             $.messager.popup(data.msg)
            //             setTimeout(function () {
            //                 window.location.reload();
            //             },2000)
            //         }
            //     })
            // });

            $(".btn-status").click(function () {
                let employeeId = $(this).data('id');
                let status  = $(this).data('status');
                $.post("/employee/checkStatus", {id: employeeId}, function (data) {
                    if (data.success) {
                             status?$.messager.popup("账号已成功禁用！") : $.messager.popup(data.msg);
                        setTimeout(function () {
                            window.location.reload();
                        },2000)
                    }
                })
            });

        });
    </script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <#include "../common/navbar.ftl"/>
    <!--菜单回显-->

    <#assign currentMenu="employee"/>
    <#include "../common/menu.ftl"/>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>员工管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <div style="margin: 10px;">
                    <form class="form-inline" id="searchForm" action="/employee/list" method="post">
                        <input type="hidden" name="currentPage" id="currentPage" value="1">
                        <div class="form-group">
                            <label for="keyword">关键字:</label>
                            <input type="text" class="form-control" id="keyword" name="keyword"
                                   value="${(qo.keyword) !}" placeholder="请输入姓名/邮箱">
                        </div>
                        <div class="form-group">
                            <label for="dept"> 部门:</label>
                            <select class="form-control" id="dept" name="deptId">
                                <option value="-1">全部</option>

                                <#list depts as d>
                                    <option value="${(d.id)!}">${(d.name)!}</option>
                                </#list>
                            </select>
                            <script>
                                $("#dept").val(${(qo.deptId)!})
                            </script>
                        </div>
                        <button id="btn_query" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>
                            查询
                        </button>
                        <a href="/employee/input" class="btn btn-success btn_redirect">
                            <span class="glyphicon glyphicon-plus"></span> 添加
                        </a>
                        <a href="#" class="btn btn-danger btn-batchDelete">
                            <span class="glyphicon glyphicon-trash"></span> 批量删除
                        </a>
                        <a href="/employee/exportXls" class="btn btn-warning">
                            <span class="glyphicon glyphicon-download"></span> 导出
                        </a>
                        <a href="#" class="btn btn-warning btn-import">
                            <span class="glyphicon glyphicon-upload"></span> 导入
                        </a>
                        <@shiro.hasAnyRoles name="Market_Manager,ADMIN">
                        <a href="/salary/list" class="btn btn-success btn_redirect">
                            <span class="glyphicon glyphicon-plus"></span> 员工工资
                        </a>
                        </@shiro.hasAnyRoles>
                    </form>

                </div>
                <table class="table table-hover table-bordered" id="tab">
                    <thead>
                    <tr>
                        <th><input type="checkbox" id="allCb"></th>
                        <th>编号</th>
                        <th>名称</th>
                        <th>email</th>
                        <th>年龄</th>
                        <th>部门</th>
                        <th>状态</th>
                        <th>操作</th>
                    </tr>
                    </thead>
                    <#list (result.list) ! as employee>
                        <tr>
                            <td><input type="checkbox" class="cb" data-id="${employee.id}"></td>
                            <td>${employee_index+1}</td>
                            <td>${(employee.name)!}</td>
                            <td>${(employee.email)!}</td>
                            <td>${(employee.age)!}</td>
                            <td>${(employee.dept.name) !}</td>
                            <td>${(employee.status)! ? string("正常","禁用")}</td>
                            <td>
                                <a href="/employee/input?id=${employee.id}" class="btn btn-info btn-xs btn_redirect">
                                    <span class="glyphicon glyphicon-pencil"></span> 编辑
                                </a>
                                <a data-url="/employee/delete?id=${employee.id}"
                                   class="btn btn-danger btn-xs btn-delete"
                                   info="${(employee.name)!},${(employee.email)!},${(employee.age)!},${(employee.dept.name)!}">
                                    <span class="glyphicon glyphicon-trash"></span> 删除
                                </a>
                                <#--                                <a href="#" data-id="${employee.id}"-->
                                <#--                                   class="btn  btn-success btn-xs btn-start"-->
                                <#--                                   style="${(employee.status)! ? string("display: none","")}">-->
                                <#--                                    <span class="glyphicon glyphicon-ok"></span> 启用-->
                                <#--                                </a>-->
                                <#--                                <a href="#" data-id="${employee.id}"-->
                                <#--                                   class="btn btn-danger btn-xs btn-disable"-->
                                <#--                                   style="${(employee.status)! ? string("","display: none")}">-->
                                <#--                                    <span class="glyphicon glyphicon-remove"></span> 禁用-->
                                <#--                                </a>-->
                                <a href="#" data-id="${employee.id}" data-status="${(employee.status)!?string('true', 'false')}"
                                   class="btn ${(employee.status)! ? string("btn-danger btn-xs","btn-success btn-xs")} btn-status">
                                    <span class="${(employee.status)! ? string("glyphicon glyphicon-remove","glyphicon glyphicon-ok")}"></span>
                                    ${(employee.status)! ? string("禁用","启用")}
                                </a>
                            </td>
                        </tr>
                    </#list>
                </table>
                <!--分页-->

                <#include "../common/page.ftl"/>
            </div>
        </section>
    </div>
    <#include "../common/footer.ftl"/>
</div>

<#-- 导入文件的模态框-->
<div class="modal fade" id="importModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
                </button>
                <h4 class="modal-title" id="myModalLabel">导入</h4>
            </div>
            <div class="modal-body">
                <form class="form-horizontal" action="/employee/importXls.do" method="post" id="importForm">
                    <input type="hidden" name="id">
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="name" class="col-sm-3 control-label"></label>
                        <div class="col-sm-6">
                            <input type="file" name="file">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <div class="col-sm-3"></div>
                        <div class="col-sm-6">
                            <a href="/xlstemplates/employee_import.xlsx" class="btn btn-success">
                                <span class="glyphicon glyphicon-download"></span> 下载模板
                            </a>
                        </div>
                    </div>
                </form>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
                <button type="button" class="btn btn-primary btn-submit">保存</button>
            </div>
        </div>
    </div>
</div>


</body>
</html>
