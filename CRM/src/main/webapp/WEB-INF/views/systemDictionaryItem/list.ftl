<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>字典明细</title>
    <#-- freemark 是从自己出发，用相对路径取找的其他文件的-->
    <#include "../common/link.ftl">
    <script>
        $(function () {
            //字典目录回显
            $("a[data-id=${qo.parentId}]").addClass('active');



            // 弹出模态框
            $('.btn-input').click(function () {
                $("#editForm input").val('')
                $("#systemDictionary").val($("a[data-id=${qo.parentId}]").text())
                $('#editForm input[name=parentId]').val(${qo.parentId})
                let data = $(this).data('json');
                if (data) {
                    $('#editForm input[name=id]').val(data.id)
                    $('#editForm input[name=title]').val(data.title)
                    $('#editForm input[name=sequence]').val(data.sequence)
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
                $('#editForm').ajaxSubmit(function (data) {
                    if (data.success) {
                        $.messager.popup("更新成功！")
                        window.location.href = "/systemDictionaryItem/list"
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
    <#include "../common/navbar.ftl">

    <!--菜单回显-->
    <#assign currentMenu="department"/>

    <#include "../common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>字典明细</h1>
        </section>
        <section class="content">
            <div class="box">

                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/systemDictionaryItem/list" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                    <input type="hidden" name="parentId" id="parentId" value="1">
                    <a href="#" class="btn btn-success btn-input" style="margin: 10px">
                        <span class="glyphicon glyphicon-plus"></span> 添加
                    </a>
                </form>
                <!--编写内容-->
                <div class="row" style="margin:20px">
                    <div class="col-xs-3">
                        <div class="panel panel-default">
                            <div class="panel-heading">字典目录</div>
                            <div class="panel-body">
                                <div class="list-group" id="dic">
                                    <#list systemDictionarys as systemDictionary>
                                    <a data-id="${systemDictionary.id}" href="/systemDictionaryItem/list?parentId=${systemDictionary.id}" class="list-group-item">${(systemDictionary.title)!}</a>
                                    </#list>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-xs-9">
                        <div class="box-body table-responsive no-padding ">
                            <table class="table table-hover table-bordered">
                                <tr>
                                    <th>编号</th>
                                    <th>标题</th>
                                    <th>序号</th>
                                    <th>操作</th>
                                </tr>


                                <#list  result.list as SystemDictionaryItem>
                                    <tr>
                                        <td>${(SystemDictionaryItem_index+1)!}</td>
                                        <td>${(SystemDictionaryItem.title)!}</td>
                                        <td>${(SystemDictionaryItem.sequence)!}</td>
                                        <td>
                                            <a href="#"
                                               class="btn btn-info btn-xs btn-input" data-json='${(SystemDictionaryItem.json) !}'>
                                                <span class="glyphicon glyphicon-pencil"></span> 编辑
                                            </a>
                                            <a data-url="/department/delete?id=${SystemDictionaryItem.id}"
                                               class="btn btn-danger btn-xs btn-delete">
                                                <span class="glyphicon glyphicon-trash"></span> 删除
                                            </a>
                                        </td>
                                    </tr>
                                </#list>
                        </table>
                            <!--分页-->
                            <#include "../common/page.ftl">
                        </div>
                    </div>
                </div>

            </div>
        </section>
    </div>
    <#include "../common/footer.ftl">


    <div class="modal fade" id="editModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog" role="document">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title" id="myModalLabel">新增/编辑</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="/systemDictionaryItem/saveOrUpdate" method="post"
                          id="editForm">
                        <input type="hidden" name="id">
                        <input type="hidden" name="parentId" >
                        <div class="form-group" style="margin-top: 10px;">
                            <label for="systemDictionary" class="col-sm-3 control-label">目录：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="systemDictionary" name="systemDictionary"
                                      readonly>
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <label for="title" class="col-sm-3 control-label">标题：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="title" name="title"
                                       placeholder="请输入标题">
                            </div>
                        </div>
                        <div class="form-group" style="margin-top: 10px;">
                            <label for="sequence" class="col-sm-3 control-label">序号：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" id="sequence" name="sequence"
                                       placeholder="请输入简介">
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
