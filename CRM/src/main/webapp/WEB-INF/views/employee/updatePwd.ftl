
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>修改密码</title>
    <#include "../common/link.ftl" >
<script>
    // $(function () {
    //     $('#submitBtn').click(function () {
    //       $.post('/employee/checkPassword',{oldPassword:$('#oldPassword').val(),newPassword:$('#newPassword').val()},function (data) {
    //         if(data.success){
    //             window.location.href="/logout"
    //         }else {
    //             $.messager.popup("修改失败");
    //             window.location.reload;
    //         }
    //       })
    //     })
    // });
    $(function () {
        $("#editForm").bootstrapValidator({

            feedbackIcons: { //图标
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: { //配置要验证的字段
                oldPassword: {
                    validators: {
                        remote: { //远程验证
                            type: 'POST', //请求方式
                            url: '/employee/checkPassword', //请求地址
                            data: function () {  //自定义提交参数，默认只会提交当前用户名input的参数
                                return {
                                    oldPassword: $('[name="oldPassword"]').val(),
                                };
                            },

                            message: "原密码错误！" //错误时的提示信息
                        },
                        notEmpty: { //不能为空
                            message: "密码必填" //错误时的提示信息
                        },
                    }
                },

                newPassword: {
                    validators: {
                        notEmpty: { //不能为空
                            message: "密码必填" //错误时的提示信息
                        },
                    }
                },

            }
        }).on('success.form.bv', function () { //表单所有数据验证通过后执行里面的代码
            //提交异步表单
            $("#editForm").ajaxSubmit(function (data) {
                if (data.success) {
                    // $.messager.popup(data.msg);
                    alert("通知 ： 修改成功,请使用新密码重新登录！");

                   // setTimeout(function () {
                        window.location.href="/logout"
                   // },3000)
                   // window.location.href = "/logout"

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
    <#include "../common/navbar.ftl" >
    <!--菜单回显-->
    
    <#include "../common/menu.ftl" >
    <div class="content-wrapper">
        <section class="content-header">
            <h1>修改密码</h1>
        </section>
        <section class="content">
            <div class="box" style="padding: 30px;" >
                <!--高级查询--->
                <form class="form-horizontal" action="/employee/updatePassword" method="post" id="editForm" >
                    <input type="hidden"  name="id">
                    <div class="form-group" style="margin-top: 10px;">
                        <label  class="col-sm-3 control-label">原密码：</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control"  name="oldPassword" id="oldPassword"
                                   placeholder="请输入原密码">
                        </div>
                    </div>
                    <div class="form-group" style="margin-top: 10px;">
                        <label  class="col-sm-3 control-label">新密码：</label>
                        <div class="col-sm-6">
                            <input type="password" class="form-control"  name="newPassword" id="newPassword"
                                   placeholder="请输入新密码">
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="col-sm-offset-3 col-sm-6">
                            <button id="submitBtn" type="submit" class="btn btn-primary">确定修改</button>
                        </div>
                    </div>
                </form>

            </div>
        </section>
    </div>
    <#include "../common/footer.ftl" >
</div>
</body>
</html>
