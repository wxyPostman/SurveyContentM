layui.use(['form', 'layer', 'upload', 'laydate', 'okLayer','okAddlink','okUtils'], function () {
    var form = layui.form;
    var $ = layui.jquery;
    var upload = layui.upload;
    let okLayer = layui.okLayer;
    let okUtils = layui.okUtils;

    // $("#myphoto").click(() => {
    //     console.log('a');
    // })

    $('#userPhotoInput').on('change', function (e) {
        uploadhead();
    })
    function uploadhead() {
        var file = document.getElementById('userPhotoInput').files[0];
        if (file.size > 20 * 1024 * 1024) {
            alert("图片大小不能超过20MB");
            return;
        }
        var user = sessionStorage.getItem("user");
        var uid = $.parseJSON(JSON.stringify(user));

        var form = new FormData();
        form.append('file', file);
        form.append('uid', uid);
        $.ajax({
            url: '../../../uploadhead',//上传地址
            async: true,//异步
            type: 'post',//post方式
            data: form,//FormData数据
            processData: false,//不处理数据流 !important
            contentType: false,//不设置http头 !important
            success: function (data) {//上传成功回调
                if (data == "1") {
                    layer.msg("上传失败", {
                        icon: "5",
                        anim: "6",
                    });
                } else {
                    parent.location.reload();
                    // console.log(data);parent.location.reload() ；
                    // $("#myphoto").empty();
                    // $("#myphoto").append(`
                    // <a class="img" title="我的头像">
                    //     <img id="demo1" src="${data}">
                    // </a>`);
                }
            }
        })
    }
    checkLogin();
    function checkLogin(){
        $.ajax({
            url: "../../../checkLogin",
            type: "get",
            success: function (data) {
                if (data != 400) {
                    sessionStorage.setItem("user", JSON.stringify(data.uid));
                    let initData = null;
                    let jsonString = JSON.stringify(data);
                    initData = JSON.parse(jsonString);
                    form.val("filter", initData);
                    $("#myphoto").empty();
                    $("#myphoto").append(`
                    <a class="img" title="我的头像">
                        <img id="demo1" src="${data.usrc}">
                    </a>`)
                } else {
                    // console.log(data);
                    window.location.href = "./pages/login.html"
                }
            }
        });
    }

    form.on("submit(changeUser)", function (data) {
        okUtils.ajax("updateUser", "put", data.field, true).done(function (response) {
            console.log(response);
            okLayer.greenTickMsg("编辑成功", function () {
                parent.layer.close(parent.layer.getFrameIndex(window.name));
            });
            checkLogin();
        }).fail(function (error) {
            console.log(error)
        });
        return false;
    });
});























