// 等待页面DOM加载完后自动加载
function main_onload() {
    //系统注意弹窗注意
    info_pop();
    // 广播加载
    init_broad();
    //村务加载
    init_village();
    //物联网和山洪数据统计
    init_iotdatacount();
    init_rivisdatacount();
    init_riotdevcount();
    //系统监控
    init_sys_mon();
    //系统访问记录
    init_sys_loginlog();
    //广播时间分布可视化
    init_bt_mbygroup();
    init_bd_mbygroup();
    init_bds_mbygroup();
    //每15秒刷新系统监控数据
    setInterval(init_sys_mon, 15000);
    //每300秒刷新系统监控数据
    setInterval(init_sys_loginlog, 300000);
}

function info_pop() {
    $('#pop').html('<div class="modal-dialog">' +
        '<div class="modal-content animated flipInY">' +
        '<div class="modal-header">' +
        '<button type="button" class="close" data-dismiss="modal"><span aria-hidden="true">&times;</span><span class="sr-only">Close</span></button>' +
        '<h4 class="modal-title">网站声明</h4>' +
        '</div>' +
        '<div class="modal-body">' +
        '<p>' +
        '您现在访问的是《融媒体综合数据平台的后台管理系统》，此网站正处于开发阶段，所有功能均处于测试期。' +
        '所有用户操作已进行行为记录，勿使用擅自进行任何增删改操作，若对系统的造成不良影响则会追究到个人，谢谢配合。'+
        '</p>' +
        '</div>' +
        '<div class="modal-footer">' +
        '<button type="button" class="btn btn-primary" data-dismiss="modal">知道了</button>' +
        '</div>' +
        '</div>' +
        '</div>')
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

function init_iotdatacount() {
    $.ajax({
        type: "GET",
        url: "/api/iot/countall",
        dataType: "json",
        success: function(data){
            $("#iotcount").html(data.data);
        }
    });
}

function init_rivisdatacount() {
    $.ajax({
        type: "GET",
        url: "/api/rivervis/countall",
        dataType: "json",
        success: function(data){
            $("#riverviscount").html(data.data);
        }
    });
}

function init_riotdevcount() {
    $.ajax({
        type: "GET",
        url: "/api/iot/devicecount",
        dataType: "json",
        success: function(data){
            $("#iotdevcount").html(data.data);
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
            $("#mon_flush_time").html('<span>'+ '最后更新:  ' + data.time +
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
            $("#llog_flush_time").html('<span>'+ '最后更新:  ' + data.time +
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

function init_bt_mbygroup() {
    var bt_mbygroup = echarts.init(document.getElementById('bt_mbygroup'));
    $.ajax({
        type: "GET",
        url: "/api/btime/bt",
        datatype: "JSON",
        success: function (data) {
            var btygroup_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for(var i = 0; i < btygroup_data.length; i++) {
                if (btygroup_data[i].bcount == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseInt(btygroup_data[i].bcount));
                    x_data.push(btygroup_data[i].broadDate);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            option = {
                color: ['#06edfc'],
                tooltip : {
                    trigger: 'axis'
                },
                toolbox: {
                    show : true,
                    feature : {
                        magicType : {show: true, type: ['line', 'bar']},
                    }
                },
                calculable : true,
                grid: {
                    left: '3%',
                    right: '3%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : x_data,
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        axisLabel : {
                            formatter: '{value}'
                        }
                    }
                ],
                series : [
                    {
                        type:'line',
                        data: y_data,
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
                            ]
                        }
                    },
                ]
            };
            bt_mbygroup.setOption(option);
        }
    });
}

function init_bd_mbygroup() {
    var bd_mbygroup = echarts.init(document.getElementById('bd_mbygroup'));
    $.ajax({
        type: "GET",
        url: "/api/btime/bd",
        datatype: "JSON",
        success: function (data) {
            var bdygroup_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for(var i = 0; i < bdygroup_data.length; i++) {
                if (bdygroup_data[i].bcount == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseInt(bdygroup_data[i].bcount));
                    x_data.push(bdygroup_data[i].broadDate);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            option = {
                color: ['#00fc1a'],
                tooltip : {
                    trigger: 'axis'
                },
                toolbox: {
                    show : true,
                    feature : {
                        magicType : {show: true, type: ['line', 'bar']},
                    }
                },
                calculable : true,
                grid: {
                    left: '3%',
                    right: '3%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        data : x_data,
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        axisLabel : {
                            formatter: '{value}'
                        }
                    }
                ],
                series : [
                    {
                        type:'line',
                        data: y_data,
                        markLine : {
                            data : [
                                {type : 'average', name: '平均值'}
                            ]
                        }
                    },
                ]
            };
            bd_mbygroup.setOption(option);
        }
    });
}

function init_bds_mbygroup() {
    var bds_mbygroup = echarts.init(document.getElementById('bds_mbygroup'));
    $.ajax({
        type: "GET",
        url: "/api/btime/bds",
        datatype: "JSON",
        success: function (data) {
            var bdsygroup_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for(var i = 0; i < bdsygroup_data.length; i++) {
                if (bdsygroup_data[i].marea == '') {
                    x_data.push('未知');
                } else {
                    x_data.push(bdsygroup_data[i].scategory);
                    y_data.push(parseInt(bdsygroup_data[i].bcount));
                    /*var y = new Object();
                     y.name = bdsygroup_data[i].scategory;
                     y.value = parseInt(bdsygroup_data[i].bcount);
                     y_data.push(y);*/
                }
            }
            /*console.log(bdsygroup_data);*/
            /*console.log(x_data);
             console.log(y_data);*/
            option = {
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient : 'vertical',
                    x : 'left',
                    data: x_data
                },
                calculable : true,
                series : [
                    {
                        name:'访问来源',
                        type:'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:[
                            /*y_data*/
                            {value:y_data[0], name: x_data[0]},
                            {value:y_data[1], name: x_data[1]}
                        ]
                    }
                ]
            };

            bds_mbygroup.setOption(option);
        }
    });
}

//找到包含value的值 在arr数组中的下标
function arrIndex(arr, value) {
    var i = arr.length;
    while (i--) {
        if (arr[i] === value) {
            return i;
        }
    }
    return false;
}