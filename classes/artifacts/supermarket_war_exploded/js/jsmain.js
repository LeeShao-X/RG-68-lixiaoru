function buttons_ulook1() {
    n=$(" input[ name='finds' ] ").val();
    if(n==""||n==null)
    {
        alert("输入不能为空！！！！");
    }
    $.ajax(
    {
        url:"/car/ufindServlet",
        type:"POST",
        data:{ values:n},
        success:function (){
            //  alert("000000");
            pages=1;
            window.location="ulook.jsp?pages=1";
        },
    });

};
$(document).ready(function(){
    $("#buttons_ulook2").click(function () {
        $.ajax(
            {
                url:"/car/ufindServlet",
                type:"POST",
                data:{ values:null},
                success:function (){
                    //  alert("000000");
                    pages=1;
                    window.location="ulook.jsp?pages=1";
                },
            });
    });
});
$(document).ready(function(){
    $("#th_button_ulook1").click(function () {
        //alert("333330");
        $.ajax(
            {
                url:"/car/uIncsortServlet",
                type:"POST",
                data:{key1:"0"},
                success:function (){
                  //  alert("000000");
                    window.location.reload();
                },
                //error:alert("111111")
            }
        )
    });
});
$(document).ready(function(){
    $("#th_button_ulook2").click(function () {
        $.ajax(
            {
                url:"/car/udecsort",
                type:"POST",
                data:{key1:"0"},
                success:function (){
                    //  alert("000000");
                   window.location.reload();
                },
                //error:alert("111111")
            }
        )
    });
});
$(document).ready(function(){
    $("#th_button_ulook3").click(function () {
        $.ajax(
            {
                url:"/car/uIncsortServlet",
                type:"POST",
                data:{key1:"1"},
                success:function (){
                    //  alert("000000");
                    window.location.reload();
                },
                //error:alert("111111")
            }
        )
    });
});
$(document).ready(function() {
    $("#th_button_ulook4").click(function () {
        $.ajax(
            {
                url: "/car/udecsort",
                type: "POST",
                data: {key1: "1"},
                success: function () {
                    //  alert("000000");
                    window.location.reload();
                }
                //error:alert("111111")
            }
        )
    });
});
$(document).ready(function() {
  var  str=window.location.search;
  var n;
  var spage = str.substr(str.lastIndexOf("=")+1);
  $("#ulook_page_"+spage).css({"color":"#ffffff","background-color":"aqua"})
});
//car
$(document).ready(function() {
    var  str=window.location.search;
    var n;
    var spage = str.substr(str.lastIndexOf("=")+1);
    $("#clook_page_"+spage).css({"color":"#ffffff","background-color":"aqua"})
});
$(document).ready(function(){
    $("#buttons_clook3").click(function () {
window.location="cadd.jsp";
});
});