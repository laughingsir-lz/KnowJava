<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>员工管理</title>

    <#include "../common/link.ftl"/>
    <script>
        function moveSelected(src, target) {
            $('.' + target).append($('.' + src + ' > option:selected'));
        }

        function moveAll(src, target) {
            $('.' + target).append($('.' + src + ' > option'));
        }

        $(function () {
            //根据复选框选中状态，来决定角色分配div的显示和隐藏；
            //超级管理员授权是角色分配的显示和隐藏
            if ($('#admin').prop('checked')) {
                $('#role').prop('hidden', true)
            }

            //var $roleDiv = $('#role');
            $('#admin').click(function () {

                //判断是否是勾选状态    
                var checked = $(this).prop('checked');
                if (checked) {
                    // 删除角色的 div        
                    //$('#role').attr('style', 'display:none');
                    $('#role').prop('hidden', true)
                } else {        //恢复角色 div，加到超管 div 元素的后面        
                    //$('#role').attr('style', 'display:block');
                    $('#role').prop('hidden', false)
                }
            });
        })


        $(function () {
            // 保存按钮提交事件
            $('#submitBtn').click(function () {
                //把右边的下拉框的option全部选择    
                $('.selfRoles > option').prop('selected', true);
                //提交表单    
                $('#editForm').submit(/*function (data) {
                    if (data.success){
                        $.messager.popup(data.msg)
                        window.location.href="/employee/list"
                    }else {
                        $.messager.popup(data.msg)
                    }
                } */);
            });
        })
        $(function () {
// 把已有的角色 id 放入一个数组中（右边 select）
            var ids = [];
            $('.selfRoles > option').each(function (i, ele) {
                ids.push($(ele).val());
            });
// 遍历所有的角色（左边 select）
            $('.allRoles > option').each(function (i, ele) {
                // 判断是否存在 ids 数组中, 若是就删除掉自己  
                var id = $(ele).val();
                if ($.inArray(id, ids) >= 0) {
                    $(ele).remove();
                }
            });
        })

        $(function () {
            $("#editForm").bootstrapValidator({

                feedbackIcons: { //图标
                    valid: 'glyphicon glyphicon-ok',
                    invalid: 'glyphicon glyphicon-remove',
                    validating: 'glyphicon glyphicon-refresh'
                },
                fields: { //配置要验证的字段
                    name: {
                        validators: { //验证的规则
                            remote: { //远程验证
                                type: 'POST', //请求方式

                                url: '/employee/checkName', //请求地址
                                data: function () {  //自定义提交参数，默认只会提交当前用户名input的参数
                                    return {
                                        id: $('[name="id"]').val(),
                                        name: $('[name="name"]').val()
                                    };
                                },
                                message: '用户名已经存在', //验证不通过时的提示信息
                                delay: 1000 //输入内容2秒后发请求
                            },
                            notEmpty: { //不能为空
                                message: "用户名必填" //错误时的提示信息
                            },
                            stringLength: { //字符串的长度范围
                                min: 1,
                                max: 5
                            }
                        }
                    },
                    password: {
                        validators: {
                            notEmpty: { //不能为空
                                message: "密码必填" //错误时的提示信息
                            },
                        }
                    },
                    repassword: {
                        validators: {
                            notEmpty: { //不能为空
                                message: "密码必填" //错误时的提示信息
                            },
                            identical: {//两个字段的值必须相同
                                field: 'password',
                                message: '两次输入的密码必须相同'
                            },
                        }
                    },
                    email: {
                        validators: {
                            emailAddress: {} //邮箱格式
                        }
                    },
                    age: {
                        validators: {
                            between: { //数字的范围
                                min: 18,
                                max: 60
                            }
                        }
                    }
                }
            }).on('success.form.bv', function () { //表单所有数据验证通过后执行里面的代码
                //提交异步表单
                $("#editForm").ajaxSubmit(function (data) {
                    if (data.success) {
                        $.messager.popup(data.msg);
                        window.location.href = "/employee/list"
                    } else {
                        $.messager.popup(data.msg);
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
            <h1>员工编辑</h1>
        </section>
        <section class="content">
            <div class="box">
                <form class="form-horizontal" action="/employee/saveOrUpdate" method="post" id="editForm">
                    <input type="hidden" value="${(employee.id)!}" name="id">
                    <div class="form-group" style="margin-top: 10px;">
                        <label for="name" class="col-sm-2 control-label">用户名：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="name" name="name" value="${(employee.name)!}"
                                   placeholder="请输入用户名">
                        </div>
                    </div>

                    <#--            ？？ 判断是否有值  有值就是true  没有值就是false-->
                    <#if !employee??>
                        <div class="form-group" id="passwordDiv">
                            <label for="password" class="col-sm-2 control-label">密码：</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="password" name="password"
                                       placeholder="请输入密码">
                            </div>
                        </div>
                        <div class="form-group" id="repasswordDiv">
                            <label for="repassword" class="col-sm-2 control-label">验证密码：</label>
                            <div class="col-sm-6">
                                <input type="password" class="form-control" id="repassword" name="repassword"
                                       placeholder="再输入一遍密码">
                            </div>
                        </div>


                    </#if>
                    <div class="form-group">
                        <label for="email" class="col-sm-2 control-label">电子邮箱：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="email" name="email" value="${(employee.email)!}"
                                   placeholder="请输入邮箱">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="age" class="col-sm-2 control-label">年龄：</label>
                        <div class="col-sm-6">
                            <input type="text" class="form-control" id="age" name="age" value="${(employee.age)!}"
                                   placeholder="请输入年龄">
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="dept" class="col-sm-2 control-label">部门：</label>
                        <div class="col-sm-6">
                            <select class="form-control" id="dept" name="dept.id">
                                <#list departments as department>
                                    <option value="${(department.id)!}"
                                            <#if (employee?? && employee.dept.id == department.id)?? >
                                                selected
                                            </#if>
                                    >
                                        ${department.name}</option>
                                </#list>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label for="admin" class="col-sm-2 control-label">超级管理员：</label>
                        <div class="col-sm-6" style="margin-left: 15px;">
                            <input type="checkbox" id="admin" name="admin" class="checkbox">
                            <#if employee?? && employee.admin>
                                <script>
                                    $("#admin").prop("checked", true);
                                </script>
                            </#if>
                        </div>
                    </div>
                    <div class="form-group " id="role">
                        <label for="role" class="col-sm-2 control-label">分配角色：</label><br/>
                        <div class="row" style="margin-top: 10px">
                            <div class="col-sm-2 col-sm-offset-2">
                                <select multiple class="form-control allRoles" size="15">

                                    <#list roles as role>
                                        <option value="${role.id}">${role.name}</option>
                                        <</#list>
                                </select>
                            </div>

                            <div class="col-sm-1" style="margin-top: 60px;" align="center">
                                <div type>

                                    <a type="button" class="btn btn-primary  " style="margin-top: 10px" title="右移动"
                                       onclick="moveSelected('allRoles', 'selfRoles')">
                                        <span class="glyphicon glyphicon-menu-right"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="左移动"
                                       onclick="moveSelected('selfRoles', 'allRoles')">
                                        <span class="glyphicon glyphicon-menu-left"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="全右移动"
                                       onclick="moveAll('allRoles', 'selfRoles')">
                                        <span class="glyphicon glyphicon-forward"></span>
                                    </a>
                                </div>
                                <div>
                                    <a type="button" class="btn btn-primary " style="margin-top: 10px" title="全左移动"
                                       onclick="moveAll('selfRoles', 'allRoles')">
                                        <span class="glyphicon glyphicon-backward"></span>
                                    </a>
                                </div>
                            </div>

                            <div class="col-sm-2">
                                <select multiple class="form-control selfRoles" size="15" name="ids">
                                    <#list (employee.roles)! as role>
                                        <option value="${role.id}">${role.name}</option>
                                    </#list>
                                </select>
                            </div>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-1 col-sm-6">
                            <button id="submitBtn" type="button" class="btn btn-primary">保存</button>
                            <button type="reset" class="btn btn-danger">重置</button>
                        </div>
                    </div>
                </form>
            </div>
        </section>
    </div>
    <#include "../common/footer.ftl"/>
</div>
</body>
</html>
