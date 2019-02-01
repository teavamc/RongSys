// 等待页面DOM加载完后自动加载
function onload() {
    //系统注意弹窗注意
    info_pop();
    // 广播加载
    init_broad();
    //村务加载
    init_village();
    //系统监控数据加载
    init_sys_mon();
    //系统访问记录
    init_sys_loginlog();
    //首页图表 村镇村民人口地域分布可视化
    init_ec_mbygroup();
    //首页图表 村镇党员地域分布可视化
    init_ec_pbygroup();
    //首页图表 三维村镇人口可视化
    init_3d_v_pm();
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

function init_ec_mbygroup() {
    $.ajax({
        type: "GET",
        url: "/api/count/m",
        dataType: "json",
        success: function (data) {
            var mbygroup_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for( x in mbygroup_data){
                if(mbygroup_data[x].marea == ''){
                    x_data.push('未知');
                }else {
                    x_data.push(mbygroup_data[x].marea);
                }
            }
            for (y in mbygroup_data){
                y_data.push(mbygroup_data[y].msum);
            }
            var ec_mbygroup = echarts.init(document.getElementById('ec_mbygroup'));
            ec_mbygroup_option = {
                color: ['#66fccc'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '0%',
                    right: '0%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        data : x_data,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'人口数量',
                        type:'bar',
                        barWidth: '60%',
                        data:y_data
                    }
                ]
            };
            ec_mbygroup.setOption(ec_mbygroup_option);
        }
    })
}

function init_ec_pbygroup() {
    $.ajax({
        type: "GET",
        url: "/api/count/pm",
        dataType: "json",
        success: function (data) {
            var mbygroup_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            for( x in mbygroup_data){
                if(mbygroup_data[x].parea == ''){
                    x_data.push('未知');
                }else {
                    x_data.push(mbygroup_data[x].parea);
                }
            }
            for (y in mbygroup_data){
                y_data.push(mbygroup_data[y].psum);
            }

            var ec_pbygroup = echarts.init(document.getElementById('ec_pbygroup'));
            ec_pbygroup_option = {
                color: ['#ff3399'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'shadow'        // 默认为直线，可选为：'line' | 'shadow'
                    }
                },
                grid: {
                    left: '0%',
                    right: '0%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis : [
                    {
                        type : 'category',
                        data : x_data,
                        axisTick: {
                            alignWithLabel: true
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'人口数量',
                        type:'bar',
                        barWidth: '60%',
                        data:y_data
                    }
                ]
            };
            ec_pbygroup.setOption(ec_pbygroup_option);

        }
    })
}

function init_3d_v_pm() {
    var pre_data;
    var x_axis_name = new Array();
    var y_axis_name = new Array();
    var z_axis_data = new Array();
    var ec_3d_v_pm = echarts.init(document.getElementById('3d_v_pm'));
    $.ajax({
        type: "GET",
        url: "/api/count/g_cPM",
        dataType: "json",
        success: function (data_pm) {
            pre_data = data_pm.data;
            //确定Z轴的数值

            // Y坐标的数据类别
            // 获得key值,包括area
            var y_TEMP = Object.keys(pre_data[0]);
            // X坐标的地名
            for ( x_name in pre_data){
                x_axis_name.push(pre_data[x_name].area);
            }
            // 外循环确定每次按地区遍历，按照x轴添加数据
            for( z_data in pre_data){
                //本次遍历的数据集X轴统一
                var temp_areaGourp = x_axis_name.indexOf(pre_data[z_data]);
                //去掉key为area 的map
                pre_data[z_data].splice(0,1);
                //内循环确定Y和Z的值
                var i = pre_data[z_data].length;
                while (i--){

                }
            }
            // 删除area之后的地域分类
            y_TEMP.splice(arrIndex(y_TEMP,'area'),1);
            //替换成中文名称
            for ( item in y_TEMP){
                if(y_TEMP[item].indexOf('p') == 0 ){
                    y_TEMP[item] = y_TEMP[item].replace('p','党员');
                    if(y_TEMP[item].indexOf('sum') >= 0){
                        y_TEMP[item] = y_TEMP[item].replace('sum','总数');
                    }else if(y_TEMP[item].indexOf('man') >= 0 && y_TEMP[item].indexOf('wo') < 0){
                        y_TEMP[item] = y_TEMP[item].replace('man','男性');
                    }else if(y_TEMP[item].indexOf('woman') >= 0 && y_TEMP[item].indexOf('wo') >= 0){
                        y_TEMP[item] = y_TEMP[item].replace('woman','女性');
                    }
                }
                if(y_TEMP[item].indexOf('m') == 0 ){
                    y_TEMP[item] = y_TEMP[item].replace('m','村民');
                    if(y_TEMP[item].indexOf('sum') >= 0){
                        y_TEMP[item] = y_TEMP[item].replace('sum','总数');
                    }else if(y_TEMP[item].indexOf('man') && y_TEMP[item].indexOf('wo') < 0){
                        y_TEMP[item] = y_TEMP[item].replace('man','男性');
                    }else if(y_TEMP[item].indexOf('woman') >= 0 && y_TEMP[item].indexOf('wo') >= 0){
                        y_TEMP[item] = y_TEMP[item].replace('woman','女性');
                    }
                }
                y_axis_name = y_TEMP;
            }
            console.log(x_axis_name);
            console.log(y_axis_name);
        }
    });

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
    
    function f() {
        
    }


    var hours = ['12a', '1a', '2a', '3a', '4a', '5a', '6a',
                '7a', '8a', '9a','10a','11a',
                '12p', '1p', '2p', '3p', '4p', '5p',
                '6p', '7p', '8p', '9p', '10p', '11p'];
    var days = ['Saturday', 'Friday', 'Thursday',
        'Wednesday', 'Tuesday', 'Monday', 'Sunday'];

    var data = [[0,0,5],[0,1,1],[0,2,0],[0,3,0],[0,4,0],[0,5,0],[0,6,0],[0,7,0],[0,8,0],[0,9,0],[0,10,0],[0,11,2],[0,12,4],[0,13,1],[0,14,1],[0,15,3],[0,16,4],[0,17,6],[0,18,4],[0,19,4],[0,20,3],[0,21,3],[0,22,2],[0,23,5],
                [1,0,7],[1,1,0],[1,2,0],[1,3,0],[1,4,0],[1,5,0],[1,6,0],[1,7,0],[1,8,0],[1,9,0],[1,10,5],[1,11,2],[1,12,2],[1,13,6],[1,14,9],[1,15,11],[1,16,6],[1,17,7],[1,18,8],[1,19,12],[1,20,5],[1,21,5],[1,22,7],[1,23,2],
                [2,0,1],[2,1,1],[2,2,0],[2,3,0],[2,4,0],[2,5,0],[2,6,0],[2,7,0],[2,8,0],[2,9,0],[2,10,3],[2,11,2],[2,12,1],[2,13,9],[2,14,8],[2,15,10],[2,16,6],[2,17,5],[2,18,5],[2,19,5],[2,20,7],[2,21,4],[2,22,2],[2,23,4],
                [3,0,7],[3,1,3],[3,2,0],[3,3,0],[3,4,0],[3,5,0],[3,6,0],[3,7,0],[3,8,1],[3,9,0],[3,10,5],[3,11,4],[3,12,7],[3,13,14],[3,14,13],[3,15,12],[3,16,9],[3,17,5],[3,18,5],[3,19,10],[3,20,6],[3,21,4],[3,22,4],[3,23,1],
                [4,0,1],[4,1,3],[4,2,0],[4,3,0],[4,4,0],[4,5,1],[4,6,0],[4,7,0],[4,8,0],[4,9,2],[4,10,4],[4,11,4],[4,12,2],[4,13,4],[4,14,4],[4,15,14],[4,16,12],[4,17,1],[4,18,8],[4,19,5],[4,20,3],[4,21,7],[4,22,3],[4,23,0],
                [5,0,2],[5,1,1],[5,2,0],[5,3,3],[5,4,0],[5,5,0],[5,6,0],[5,7,0],[5,8,2],[5,9,0],[5,10,4],[5,11,1],[5,12,5],[5,13,10],[5,14,5],[5,15,7],[5,16,11],[5,17,6],[5,18,0],[5,19,5],[5,20,3],[5,21,4],[5,22,2],[5,23,0],
                [6,0,1],[6,1,0],[6,2,0],[6,3,0],[6,4,0],[6,5,0],[6,6,0],[6,7,0],[6,8,0],[6,9,0],[6,10,1],[6,11,0],[6,12,2],[6,13,1],[6,14,3],[6,15,4],[6,16,0],[6,17,0],[6,18,0],[6,19,0],[6,20,1],[6,21,2],[6,22,2],[6,23,6]];
    ec_3d_v_pm_option = {
        tooltip: {},
        visualMap: {
            max: 20,
            inRange: {
                color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026']
            }
        },
        xAxis3D: {
            type: 'category',
            data: hours
        },
        yAxis3D: {
            type: 'category',
            data: days
        },
        zAxis3D: {
            type: 'value'
        },
        grid3D: {
            boxWidth: 200,
            boxDepth: 80,
            viewControl: {
                // projection: 'orthographic'
            },
            light: {
                main: {
                    intensity: 1.2,
                    shadow: true
                },
                ambient: {
                    intensity: 0.3
                }
            }
        },
        series: [{
            type: 'bar3D',
            data: data.map(function (item) {
                return {
                    value: [item[1], item[0], item[2]],
                }
            }),
            shading: 'lambert',

            label: {
                textStyle: {
                    fontSize: 16,
                    borderWidth: 1
                }
            },

            emphasis: {
                label: {
                    textStyle: {
                        fontSize: 20,
                        color: '#900'
                    }
                },
                itemStyle: {
                    color: '#900'
                }
            }
        }]
    };
    ec_3d_v_pm.setOption(ec_3d_v_pm_option);
}