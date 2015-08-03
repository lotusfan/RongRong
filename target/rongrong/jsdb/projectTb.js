$(document).ready(function () {

    $(".alb").click(function(){
        var $currentel = $(this).parent().parent();

        var oo = new Object();
        oo.id=$currentel.find(".ooid").val();
        oo.title=$currentel.find(".ootitle").val();
        oo.acceptCost=$currentel.find(".ooacceptCost").val();
        oo.mainBody=$currentel.find(".oomainBody").val();
        oo.ammount=$currentel.find(".ooammount").val();
        oo.timeLimit=$currentel.find(".ootimeLimit").val();
        oo.measure=$currentel.find(".oomeasure").val();
        oo.define=$currentel.find(".oodefine").val();
        oo.summary=$currentel.find(".oosummary").val();
        oo.createTime=$currentel.find(".oocreateTime").val();
        oo.updateTime=$currentel.find(".ooupdateTime").val();
        $.ajax({
            url: "/db/projectTb/update.do",
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