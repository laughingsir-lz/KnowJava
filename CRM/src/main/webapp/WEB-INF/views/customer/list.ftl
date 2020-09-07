<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>潜在客户管理</title>
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
<#--    <c:set var="currentMenu" value="customer"/>-->
    <#assign currentMenu="customer"/>
<#--    <%@include file="/WEB-INF/views/common/menu.jsp" %>-->
    <#include "../common/menu.ftl">
    <div class="content-wrapper">
        <section class="content-header">
            <h1>潜在客户管理</h1>
        </section>
        <section class="content">
            <div class="box">
                <!--高级查询--->
                <form class="form-inline" id="searchForm" action="/customer/list" method="post">
                    <input type="hidden" name="currentPage" id="currentPage" value="1">
                    <div class="form-group">
                        <label for="keyword">关键字:</label>
                        <input type="text" class="form-control" id="keyword" name="keyword"
                               value="${(qo.keyword)!}" placeholder="请输入姓名/电话">
                    </div>


                    <#-- shiro 标签实现页面显示-->
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
                    <button id="btn_query" class="btn btn-primary"><span class="glyphicon glyphicon-search"></span>
                        查询
                    </button>
                    </@shiro.hasAnyRoles>

                    <a href="#" class="btn btn-success btn-input" style="margin: 10px">
                        <span class="glyphicon glyphicon-plus"></span> 添加
                    </a>
                </form>
                <!--编写内容-->

                    <div class="box-body table-responsive no-padding ">
                        <table class="table table-hover table-bordered">
                            <tr>
                                <th>编号</th>
                                <th>姓名</th>
                                <th>跟进</th>
                                <th>电话</th>
                                <th>QQ</th>
                                <th>职业</th>
                                <th>来源</th>
                                <th>销售员</th>
                                <th>状态</th>
                                <th>录入时间</th>
                                <th>操作</th>
                            </tr>

                                <#list  result.list as customer>
                                    <tr>
                                        <td>${customer_index+1}</td>
                                        <td>${customer.name !}</td>
                                        <td>${customer.count !}</td>
                                        <td>${customer.tel !}</td>
                                        <td>${customer.qq !}</td>
                                        <td>${(customer.job.title) !}</td>
                                        <td>${(customer.source.title) !}</td>
                                        <td>${(customer.seller.name) !}</td>
                                        <td>${customer.statusName !}</td>
                                        <td>${customer.inputTime!?string('yyyy-MM-dd HH:mm:ss')}</td>
                                        <td>
                                            <a href="#"
                                               class="btn btn-info btn-xs btn-input" data-json='${(customer.json) !}'>
                                                <span class="glyphicon glyphicon-pencil"></span> 编辑
                                            </a>
                                            <a data-url="/customer/delete?id=${customer.id}"
                                               class="btn btn-danger btn-xs btn-delete">
                                                <span class="glyphicon glyphicon-trash"></span> 删除
                                            </a>
                                            <a href="#" class="btn btn-danger btn-xs btn-trace">
                                                <span class="glyphicon glyphicon-phone"></span> 跟进
                                            </a>
                                        </td>
                                    </tr>
                                </#list>
                        </table>

                        <#include "../common/page.ftl">

                    </div>

            </div>
        </section>
    </div>

    <#include "../common/footer.ftl">


<#-- 编辑模态框-->
    <div class="modal fade" id="editModal">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
                    <h4 class="modal-title inputTitle">客户编辑</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="/customer/saveOrUpdate" method="post" id="editForm">
                        <input type="hidden" name="id">
                        <div class="form-group" >
                            <label  class="col-sm-3 control-label">客户名称：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="name"
                                       placeholder="请输入客户姓名"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">客户年龄：</label>
                            <div class="col-sm-6">
                                <input type="number" class="form-control" name="age"
                                       placeholder="请输入客户年龄"/>
                            </div>
                        </div>
                        <div class="form-group" >
                            <label  class="col-sm-3 control-label">客户性别：</label>
                            <div class="col-sm-6">
                                <select class="form-control" name="gender">
                                    <option value="1">男</option>
                                    <option value="0">女</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">客户电话：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="tel"
                                       placeholder="请输入客户电话"/>
                            </div>
                        </div>
                        <div class="form-group" >
                            <label  class="col-sm-3 control-label">客户QQ：</label>
                            <div class="col-sm-6">
                                <input type="text" class="form-control" name="qq"
                                       placeholder="请输入客户QQ"/>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">客户工作：</label>
                            <div class="col-sm-6">
                                <select class="form-control" name="job.id">
                                    <#list jobs as j>
                                        <option value="${j.id}">${j.title}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label  class="col-sm-3 control-label">客户来源：</label>
                            <div class="col-sm-6">
                                <select class="form-control" name="source.id">
                                    <#list sources as s>
                                        <option value="${s.id}">${s.title}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary btn-submit" >保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal" >取消</button>
                </div>
            </div>
        </div>
    </div>
<#--    跟进模态框-->

    <div class="modal fade" id="traceModal" tabindex="-1" role="dialog" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                    <h4 class="modal-title">跟进</h4>
                </div>
                <div class="modal-body">
                    <form class="form-horizontal" action="/customerTraceHistory/saveOrUpdate.do" method="post" id="traceForm">
                        <div class="form-group" >
                            <label class="col-lg-4 control-label">客户姓名：</label>
                            <div class="col-lg-6">
<#--                                提交到后台的-->
                                <input type="hidden" name="customer.id"/>
<#--                                给用户看的-->
                                <input type="text" class="form-control" readonly name="customer.name"/>
                            </div>
                        </div>
                        <div class="form-group" >
                            <label class="col-lg-4 control-label">跟进时间：</label>
                            <div class="col-lg-6 ">
                                <input type="text" class="form-control"  name="traceTime"  placeholder="请输入跟进时间">
                            </div>
                        </div>

                        <div class="form-group">
                            <label class="col-lg-4 control-label">交流方式：</label>
                            <div class="col-lg-6">
                                <select class="form-control" name="traceType.id">
                                    <#list ccts as c>
                                        <option value="${c.id}">${c.title}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                        <div class="form-group">
                            <label class="col-lg-4 control-label">跟进结果：</label>
                            <div class="col-lg-6">
                                <select class="form-control" name="traceResult">
                                    <option value="3">优</option>
                                    <option value="2">中</option>
                                    <option value="1">差</option>
                                </select>
                            </div>
                        </div>
                        <div class="form-group" >
                            <label class="col-lg-4 control-label">跟进记录：</label>
                            <div class="col-lg-6">
                            <textarea type="text" class="form-control" name="traceDetails"
                                      placeholder="请输入跟进记录" ></textarea>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary trace-submit">保存</button>
                    <button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>
