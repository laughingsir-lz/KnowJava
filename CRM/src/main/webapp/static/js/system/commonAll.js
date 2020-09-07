handlerMessage = function (data) {
    // if (data.success) {
    //     $.messager.confirm('温馨提示', data.msg, function () {
    //         window.location.reload();
    //     });
    // } else {
    //     $.messager.alert('温馨提示', data.msg);
    // }
    if (data.success) {
        $.messager.popup(data.msg);
        setTimeout(function () {
            window.location.reload();
        }, 1000)

    } else {
        //$.messager.alert('温馨提示', "权限不足");
        $.messager.popup(data.msg);
    }
}

$(function () {
    $.messager.model = {ok: {text: "确定", classed: 'btn-primary'}, cancel: {text: "取消", classed: 'btn-default'}};
    $('.btn-delete').click(function () {
        var url = $(this).attr('data-url');
        var info = $(this).attr('info')
        $.messager.confirm('温馨提示', '确定要删除 [' + info + ' ]吗？', function () {
            $.get(url, handlerMessage)
        });
    });
});