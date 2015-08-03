$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.nameReal=$currentel.find(".oonameReal").val();
        oo.rrId=$currentel.find(".oorrId").val();
        oo.sex=$currentel.find(".oosex").val();
        oo.loginName=$currentel.find(".oologinName").val();
        oo.loginPs=$currentel.find(".oologinPs").val();
        oo.job=$currentel.find(".oojob").val();
        oo.position=$currentel.find(".ooposition").val();
        oo.company=$currentel.find(".oocompany").val();
        oo.companyAddress=$currentel.find(".oocompanyAddress").val();
        oo.eMail=$currentel.find(".ooeMail").val();
        oo.qq=$currentel.find(".ooqq").val();
        oo.weixin=$currentel.find(".ooweixin").val();
        oo.createTime=$currentel.find(".oocreateTime").val();
        oo.updateTime=$currentel.find(".ooupdateTime").val();
        $.ajax({
            url: "/db/userTb/update.do",
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