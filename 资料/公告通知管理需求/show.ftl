<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>公告通知管理</title>
    <!--相对路径-->
    <#include "../common/link.ftl" >
    <script>
        $(function(){

        })
    </script>
</head>
<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">
     <#include "../common/navbar.ftl" >
    <!--声明变量 用来做菜单回显-->
    <#assign currentMenu="notice"/>
    <#include "../common/menu.ftl" >
    <div class="content-wrapper">
        <section class="content-header">
            <h1>公告查看</h1>
        </section>
        <section class="content">
                <div class="box box-primary">
                    <div class="box-header with-border">
                        <div class="user-block">
                            <img class="img-circle" src="/js/adminlte/img/user2-160x160.jpg" alt="User Image">
                            <span class="username"><a href="#">admin</a></span>
                            <span class="description">2020-05-20 16:03:14</span>
                        </div>
                        <div class="box-tools">
                            <button type="button" class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            <button type="button" class="btn btn-box-tool" onclick="javascript:window.location.href='/notice/list.do';" ><i class="fa fa-times"></i></button>
                        </div>
                    </div>
                    <div class="box-body no-padding">
                        <div class="mailbox-read-message" style="height: 500px" >
                            为了加强公司卫生管理情况，下周要做卫生安全抽检，请各部门配合。
                        </div>
                    </div>
            </div>
        </section>
    </div>
     <#include "../common/footer.ftl"/>
</div>


</body>
</html>
