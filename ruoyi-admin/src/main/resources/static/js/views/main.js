// 等待页面DOM加载完后自动加载
function onload() {
    // 广播加载
    init_broad();
    //村务加载
    init_village();
    //系统监控数据加载
    init_sys_mon();
    //系统访问记录
    init_sys_loginlog();
    //每15秒刷新系统监控数据
    setInterval(init_sys_mon, 15000);
    //每300秒刷新系统监控数据
    setInterval(init_sys_loginlog, 300000);
}

function init_broad() {
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
}

function init_village() {
    $.ajax({
        type:"GET",
        url:"/api/count/p_m",
        dataType:"json",
        success:function (data) {
            $("#fls_cv_time").html(data.time);
            $("#count_ms").html(data.data[0].msum);
            $("#count_mm").html(data.data[0].mman);
            $("#count_mw").html(data.data[0].mwoman);
            $("#count_ps").html(data.data[0].psum);
            $("#count_p_m").html(data.data[0].pman);
            $("#count_pw").html(data.data[0].pwoman);
        }
    });
}

function init_sys_mon() {
    $.ajax({
        type:"GET",
        url:"/api/sys_mon/mi",
        dataType:"json",
        success:function (data) {
            $("#mon_flush_time").html('<span>' + data.time +
                '</span>');

            $("#sys_mon_cpu").html('<table class="table table-hover">\n' +
                '<thead>' +
                '<tr>' +
                '<th>处理器参数</th>' +
                '<th>参考值</th>' +
                '</tr>' +
                '</thead>' +
                '<tbody>' +
                '<tr>' +
                '</td>' +
                '<td>核心数</td>' +
                '<td id="" class="text-warning">' + data.data.cpu.cpuNum + " 线程" +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '</td>' +
                '<td>用户使用率</td>' +
                '<td id="" class="text-navy">' + data.data.cpu.used + "%" +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '</td>' +
                '<td>系统使用率</td>' +
                '<td id="" class="text-warning">' + data.data.cpu.sys + "%" +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '</td>' +
                '<td>当前空闲率</td>' +
                '<td id="" class="text-navy">' + data.data.cpu.free + "%" +
                '</td>' +
                '</tr>' +
                '</tbody>' +
                '</table>'
            );

            $("#sys_mon_line").html(' <table class="table table-hover">' +
                '<h2>' + "内存:" + data.data.mem.usage + "%" +
                '</h2>' +
                '<div class="progress progress-mini">' +
                '<div style="width:' +  data.data.mem.usage + "%" +
                '" class="progress-bar"></div>' +
                '</div>' +
                '<br>' +
                '<h2>' + "JVM:" + data.data.jvm.usage + "%" +
                '</h2>' +
                '<div class="progress progress-mini">' +
                '<div style="width:' + data.data.jvm.usage + "%" +
                '" class="progress-bar"></div>' +
                '</div>' +
                '<br>' +
                '<h2>' + "CPU:" + data.data.cpu.used + "%" +
                '</h2>' +
                '<div class="progress progress-mini">' +
                '<div style="width:' + data.data.cpu.used + "%" +
                '" class="progress-bar"></div>' +
                '</div>' +
                '</table>'
            );

            var disk_data = data.data.sysFiles;
            var diskinfo = '';
            for(diskname in disk_data){
                diskinfo += '<tr>' +
                    '<td>' + disk_data[diskname].dirName  +
                    '</td>' +
                    '<td>' + disk_data[diskname].usage + '%' +
                    '</td>' +
                    '</tr>';
            }

            $("#sys_mon_disk").html('<table class="table table-hover margin bottom">\n' +
                '<thead>' +
                '<tr>' +
                '<th>磁盘类型</th>' +
                '<th>已用百分比</th>' +
                '</tr>' +
                '</thead>' +
                '<tbody>' + diskinfo +
                '</tbody>' +
                '</table>')

        }
    })
}

function init_sys_loginlog() {
    $.ajax({
        type: "GET",
        url: "/api/sys_log/l_log",
        dataType: "json",
        success: function (data) {
            $("#llog_flush_time").html('<span>' + data.time +
                '</span>');

            var l_log = data.data;
            var log_info = '';
            for (log in l_log){
                log_info += '<tr>' +
                    '<td>' + l_log[log].user_name +
                    '</td>' +
                    '<td>' + l_log[log].ipaddr +
                    '</td>' +
                    '<td>' + l_log[log].loginTime +
                    '</td>' +
                    '<td>' + l_log[log].loginLocation +
                    '</td>' +
                    '</tr>';
            }

            $("#sys_login_log").html('<table class="table table-hover">' +
                '<thead>' +
                '<tr>' +
                '<th>用户</th>' +
                '<th>IP地址</th>' +
                '<th>登陆时间</th>' +
                '<th>登陆地点</th>' +
                '</tr>' +
                '</thead>' +
                '<tbody>' + log_info +
                '</tbody>' +
                '</table>');
        }
    })

}

function flush_broad() {
    $.ajax({
        type: "GET",
        url: "/api/bcount/bindex",
        dataType: "json",
        success: function(data){
            alert("已完成手动刷新");
            $("#fls_cb_time").html(data.time);
            $("#count_dev").html(data.data.dev);
            $("#count_run").html(data.data.run);
            $("#count_stop").html(data.data.stop);
        }
    });
}

function flush_village() {
    $.ajax({
        type:"GET",
        url:"/api/count/p_m",
        dataType:"json",
        success:function (data) {
            alert("已完成手动刷新");
            $("#fls_cv_time").html(data.time);
            $("#count_ms").html(data.data[0].msum);
            $("#count_mm").html(data.data[0].mman);
            $("#count_mw").html(data.data[0].mwoman);
            $("#count_ps").html(data.data[0].psum);
            $("#count_p_m").html(data.data[0].pman);
            $("#count_pw").html(data.data[0].pwoman);
        }
    });
}

function flush_sys_mon() {
    $.ajax({
        type: "GET",
        url: "/api/sys_mon/mi",
        dataType: "json",
        success: function (data) {
            alert("已完成手动刷新");

            $("#mon_flush_time").html('<span>' + data.time +
                '</span>');

            $("#sys_mon_cpu").html('<table class="table table-hover">\n' +
                '<thead>' +
                '<tr>' +
                '<th>处理器参数</th>' +
                '<th>参考值</th>' +
                '</tr>' +
                '</thead>' +
                '<tbody>' +
                '<tr>' +
                '</td>' +
                '<td>核心数</td>' +
                '<td id="" class="text-warning">' + data.data.cpu.cpuNum + " 线程" +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '</td>' +
                '<td>用户使用率</td>' +
                '<td id="" class="text-navy">' + data.data.cpu.used + "%" +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '</td>' +
                '<td>系统使用率</td>' +
                '<td id="" class="text-warning">' + data.data.cpu.sys + "%" +
                '</td>' +
                '</tr>' +
                '<tr>' +
                '</td>' +
                '<td>当前空闲率</td>' +
                '<td id="" class="text-navy">' + data.data.cpu.free + "%" +
                '</td>' +
                '</tr>' +
                '</tbody>' +
                '</table>'
            );

            $("#sys_mon_line").html(' <table class="table table-hover">' +
                '<h2>' + "内存:" + data.data.mem.usage + "%" +
                '</h2>' +
                '<div class="progress progress-mini">' +
                '<div style="width:' +  data.data.mem.usage + "%" +
                '" class="progress-bar"></div>' +
                '</div>' +
                '<br>' +
                '<h2>' + "JVM:" + data.data.jvm.usage + "%" +
                '</h2>' +
                '<div class="progress progress-mini">' +
                '<div style="width:' + data.data.jvm.usage + "%" +
                '" class="progress-bar"></div>' +
                '</div>' +
                '<br>' +
                '<h2>' + "CPU:" + data.data.cpu.used + "%" +
                '</h2>' +
                '<div class="progress progress-mini">' +
                '<div style="width:' + data.data.cpu.used + "%" +
                '" class="progress-bar"></div>' +
                '</div>' +
                '</table>'
            );

            var disk_data = data.data.sysFiles;
            var diskinfo = '';
            for(diskname in disk_data){
                diskinfo += '<tr>' +
                    '<td>' + disk_data[diskname].dirName  +
                    '</td>' +
                    '<td>' + disk_data[diskname].usage + '%' +
                    '</td>' +
                    '</tr>';
            }

            $("#sys_mon_disk").html('<table class="table table-hover margin bottom">\n' +
                '<thead>' +
                '<tr>' +
                '<th>磁盘类型</th>' +
                '<th>已用百分比</th>' +
                '</tr>' +
                '</thead>' +
                '<tbody>' + diskinfo +
                '</tbody>' +
                '</table>')

            //     $("#fls_sm_time").html(data.time);
            //
            //     $("#cpu_num").html(data.data.cpu.cpuNum + " 线程");
            //     $("#cpu_free").html(data.data.cpu.free + "%");
            //     $("#cpu_sys").html(data.data.cpu.sys + "%");
            //     $("#cpu_used").html(data.data.cpu.used + "%");
            //     $("#cpu_used_line").html("CPU:" + data.data.cpu.used + "%");
            //
            //     $("#jvm_total").html(data.data.jvm.total + "M");
            //     $("#jvm_max").html(data.data.jvm.max + "M");
            //     $("#jvm_free").html(data.data.jvm.free + "M");
            //     $("#jvm_used").html(data.data.jvm.used + "M");
            //     $("#jvm_usage").html("JVM:" + data.data.jvm.usage + "%");
            //     $("#jvm_runtime").html(data.data.jvm.runTime);
            //
            //     $("#mem_free").html(data.data.mem.free + "M");
            //     $("#mem_total").html(data.data.mem.total + "M");
            //     $("#mem_usage").html("内存:" + data.data.mem.usage + "%");
            //     $("#mem_used").html(data.data.mem.used + "M");
            //
            //     $("#sys_cip").html(data.data.sys.computerIp);
            //     $("#sys_cname").html(data.data.sys.computerName);
            //     $("#sys_osname").html(data.data.sys.osName);

        }
    })
}