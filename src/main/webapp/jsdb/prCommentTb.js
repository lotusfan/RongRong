$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.projectId=$currentel.find(".ooprojectId").val();
        oo.userId=$currentel.find(".oouserId").val();
        oo.content=$currentel.find(".oocontent").val();
        oo.relationUserId=$currentel.find(".oorelationUserId").val();
        oo.createId=$currentel.find(".oocreateId").val();
        $.ajax({
            url: "/db/prCommentTb/update.do",
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