$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.userId=$currentel.find(".oouserId").val();
        oo.ip=$currentel.find(".ooip").val();
        oo.longitude=$currentel.find(".oolongitude").val();
        oo.latitude=$currentel.find(".oolatitude").val();
        oo.type=$currentel.find(".ootype").val();
        oo.uuid=$currentel.find(".oouuid").val();
        oo.createTime=$currentel.find(".oocreateTime").val();
        $.ajax({
            url: "/db/logInfo/update.do",
            type: "POST",
            data: $.toJSON(oo),
            dataType: "json",
            contentType:"application/json",
            success: function (data) {
                alert(data.msg);
            },
            error: function () {
                alert("请求失败");
            }
        });
    });
});