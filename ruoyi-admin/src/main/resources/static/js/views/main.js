// 等待页面DOM加载完后自动加载
function onload() {
    // 广播加载
    flush_broad();
    //村务加载
    flush_village();
}

function flush_broad() {
    $.ajax({
        type: "GET",
        url: "/api/bcount/bindex",
        dataType: "json",
        success: function(data){
            $("#fls_cb_time").html(data.time);
            $("#count_dev").html(data.data.dev);
            $("#count_run").html(data.data.run);
            $("#count_stop").html(data.data.stop);
        }
    });
};

function flush_village() {
    $.ajax({
        type:"GET",
        url:"/api/count/p_m",
        dataType:"json",
        success:function (data) {
            $("#fls_cv_time").html(data.time);
            $("#count_ms").html(data.data[0].mwoman);
            $("#count_mm").html(data.data[0].msum);
            $("#count_mw").html(data.data[0].pwoman);
            $("#count_ps").html(data.data[0].mman);
            $("#count_p_m").html(data.data[0].pman);
            $("#count_pw").html(data.data[0].psum);
        }
    })

}