<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>部门管理</title>
<#-- freemark 是从自己出发，用相对路径取找的其他文件的-->
    <#include "../common/link.ftl">


    <script>
        $(function () {
            // 弹出模态框
            $('.btn-input').click(function () {
                $("#editForm input").val('')
                let data = $(this).data('json');
                if(data){
                    $('#editForm input[name=id]').val(data.id)
                    $('#editForm input[name=name]').val(data.name)
                    $('#editForm input[name=sn]').val(data.sn)
                }
                $('#editModal').modal('show');
            })
            // //保存按钮
            $('.btn-submit').click(function () {
                // 同步提交
                //$('#editForm').submit();
                //异步提交
                //$.post('')
                //异步提交方式2 插件jquery-from插件
                $('#editForm').ajaxSubmit(handlerMessage)
            })
        })
    </script>

</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
    <#include "../common/navbar.ftl">

    <!--菜单回显-->
<#--    <c:set var="currentMenu" value="department"/>-->
    <#assign currentMenu="department"/>
<#--    <%@include file="/WEB-INF/views/common/menu.jsp" %>-->
    <#include "../common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>部门管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/department/list" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                    <a href="#" class="btn btn-success btn-input" style="margin: 10px">
                        <span class="glyphicon glyphicon-plus"></span> 添加
                    </a>
                </form>
                <!--编写内容-->

<#--                <c:if test="${page}">-->
                    <div class="box-body table-responsive no-padding ">
                        <table class="table table-hover table-bordered">
                            <tr>
                                <th>编号</th>
                                <th>部门名称</th>
                                <th>部门编号</th>
                                <th>操作</th>
                            </tr>

<#--                            <c:forEach items="${result.list.ftl}" var="department" varStatus="vs">-->
                                <#list  result.list as department>
                                    <tr>
                                        <td>${department_index+1}</td>
                                        <td>${department.name}</td>
                                        <td>${department.sn}</td>
                                        <td>
                                            <a href="#"
                                               class="btn btn-info btn-xs btn-input" data-json='${(department.json) !}'>
                                                <span class="glyphicon glyphicon-pencil"></span> 编辑
                                            </a>
                                            <a data-url="/department/delete?id=${department.id}"
                                               class="btn btn-danger btn-xs btn-delete">
                                                <span class="glyphicon glyphicon-trash"></span> 删除
                                            </a>
                                        </td>
                                    </tr>
                                </#list>

<#--                            </c:forEach>-->


                        </table>
                        <!--分页-->
<#--                        <%@include file="/WEB-INF/views/common/page.jsp"%>-->
                        <#include "../common/page.ftl">

                    </div>
<#--                </c:if>-->
            </div>
        </section>
    </div>
<#--    <%@include file="/WEB-INF/views/common/footer.jsp" %>-->
    <#include "../common/footer.ftl">



    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增/编辑</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="/department/saveOrUpdate.do" method="post" id="editForm">
                        <input type="hidden" name="id">
                        <div class="form-group" style="margin-top: 10px;">
                            <label for="name" class="col-sm-3 control-label">名称：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="name" name="name"
                                       placeholder="请输入部门名">
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <label for="sn" class="col-sm-3 control-label">编码：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="sn" name="sn"
                                       placeholder="请输入部门编码">
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
</div>
</body>
</html>
