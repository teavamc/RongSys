// 等待页面DOM加载完后自动加载
function onload() {
    //系统注意弹窗注意
    info_pop();
    // 广播加载
    init_broad();
    //村务加载
    init_village();
    //首页图表 山洪全部可视化
    init_rvis();
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
    //首页图表 三维广播分布可视化
    init_3d_bt();
    //首页图表 二维广播分布可视化
    init_ec_bt();
    //首页图表 服务器性能可视化
    // init_3d_s_c();

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

            $("#mon_flush_time").html('<span>' + '最后更新' +  data.time +
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

function init_rvis() {
    $.ajax({
        type: "GET",
        url: "/api/rivervis/commentCount",
        dataType: "json",
        success: function (data_bt) {
            var pre_data = data_bt.data;
            var rain = new Array();
            var flow = new Array();
            var wlevel = new Array();
            var ph = new Array();
            var pm = new Array();
            var temp = new Array();
            var hum = new Array();
            var common_time = new Array();
            for (i in pre_data){
                rain.push(pre_data[i].rain);
                flow.push(pre_data[i].flow);
                wlevel.push(pre_data[i].wlevel);
                ph.push(pre_data[i].ph);
                pm.push(pre_data[i].pm);
                temp.push(pre_data[i].temp);
                hum.push(pre_data[i].hum);
                common_time.push(pre_data[i].common_time);
            }

            var ec_rvis_rain = echarts.init(document.getElementById('rvis-rain'));
            var ec_rvis_flow = echarts.init(document.getElementById('rvis-flow'));
            var ec_rvis_wlevel = echarts.init(document.getElementById('rvis-wlevel'));
            var ec_rvis_ph = echarts.init(document.getElementById('rvis-ph'));
            var ec_rvis_pm = echarts.init(document.getElementById('rvis-pm'));
            var ec_rvis_temp = echarts.init(document.getElementById('rvis-temp'));
            var ec_rvis_hum = echarts.init(document.getElementById('rvis-hum'));

            ec_rvis_rain_option = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
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
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'雨量走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#cbd672"
                                }
                            },
                            emphasis: {
                                color: '#cbd672',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#cbd672" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:rain
                    }
                ]
            };
            ec_rvis_rain.setOption(ec_rvis_rain_option);

            ec_rvis_flow_option = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
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
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'河水流量走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#D61A15"
                                }
                            },
                            emphasis: {
                                color: '#D61A15',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#d61a15" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:flow
                    }
                ]
            };
            ec_rvis_flow.setOption(ec_rvis_flow_option);

            ec_rvis_wlevel_option = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
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
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'河流水位走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#d636d3"
                                }
                            },
                            emphasis: {
                                color: '#d636d3',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#d636d3" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:wlevel
                    }
                ]
            };
            ec_rvis_wlevel.setOption(ec_rvis_wlevel_option);

            ec_rvis_ph_option = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
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
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'河流酸碱度走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#d6742e"
                                }
                            },
                            emphasis: {
                                color: '#d6742e',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#d6742e" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:ph
                    }
                ]
            };
            ec_rvis_ph.setOption(ec_rvis_ph_option);

            ec_rvis_pm_option = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
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
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'PM2.5走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#6DD623"
                                }
                            },
                            emphasis: {
                                color: '#6DD623',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#6dd623" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:pm
                    }
                ]
            };
            ec_rvis_pm.setOption(ec_rvis_pm_option);

            ec_rvis_temp_option = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
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
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'温度走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#4fd6d2"
                                }
                            },
                            emphasis: {
                                color: '#4fd6d2',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#4fd6d2" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:temp
                    }
                ]
            };
            ec_rvis_temp.setOption(ec_rvis_temp_option);

            ec_rvis_hum_option = {
                tooltip : {
                    trigger: 'axis'
                },
                calculable : true,
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
                        boundaryGap : false,
                        data : common_time
                    }
                ],
                yAxis : [
                    {
                        type : 'value'
                    }
                ],
                series : [
                    {
                        name:'湿度走势',
                        type:'line',
                        smooth:true,
                        itemStyle: {
                            normal: {   //颜色渐变函数 前四个参数分别表示四个位置依次为左、下、右、上
                                color: new echarts.graphic.LinearGradient(0, 0, 0, 1,[{
                                        offset: 0, color: '#d7f4f8' // 0% 处的颜色
                                    }, {
                                        offset: 0.5, color: '#eefcfd' // 100% 处的颜色
                                    }, {
                                        offset: 1, color: '#fff' // 100% 处的颜色
                                    }]
                                ),  //背景渐变色
                                lineStyle: {        // 系列级个性化折线样式
                                    width: 3,
                                    type: 'solid',
                                    color: "#4fd6d2"
                                }
                            },
                            emphasis: {
                                color: '#4fd6d2',
                                lineStyle: {        // 系列级个性化折线样式
                                    width:2,
                                    type: 'dotted',
                                    color: "#4fd6d2" //折线的颜色
                                }
                            }
                        },//线条样式
                        symbolSize:5, //折线点的大小
                        areaStyle: {normal: {}},
                        data:hum
                    }
                ]
            };
            ec_rvis_hum.setOption(ec_rvis_hum_option);



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

function sort_ec_mbygroup() {
    $.ajax({
        type: "GET",
        url: "/api/count/mSort",
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

function sort_ec_pbygroup() {
    $.ajax({
        type: "GET",
        url: "/api/count/pmSort",
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
    var area_group = new Array();
    var people_group = new Array();
    var xyz_data = new Array();
    var ec_3d_v_pm = echarts.init(document.getElementById('3d_v_pm'));

    $.ajax({
        type: "GET",
        url: "/api/count/g_cPM",
        dataType: "json",
        success: function (data_pm) {
            pre_data = data_pm.data;
            var pg_temp = Object.keys(pre_data[0]);
            pg_temp.splice(arrIndex(pg_temp,'area'),1);
            //重新确定人员分组的顺序(暂时写死）
            pg_temp = ['pwoman','pman','psum','mwoman','mman','msum'];


            //确定area_group
            for ( area_name in pre_data){
                area_group.push(pre_data[area_name].area);
            }
            //确定xyz_data
            for( pg_name in pre_data){
                var ag = area_group.indexOf(pre_data[pg_name].area);
                var temp_data = pre_data[pg_name];
                delete temp_data["area"];
                var temp_keys = Object.keys(temp_data);
                for(i=0;i<temp_keys.length;i++){
                    var this_key = temp_keys[i];
                    var pg = pg_temp.indexOf(temp_keys[i]);
                    var z_value = temp_data[this_key];
                    xyz_data.push([pg,ag,z_value])
                }
            }
            //确定people_group
            // 英文 - 中文替换
            for ( item in pg_temp){
                if(pg_temp[item].indexOf('p') == 0 ){
                    pg_temp[item] = pg_temp[item].replace('p','党员');
                    if(pg_temp[item].indexOf('sum') >= 0){
                        pg_temp[item] = pg_temp[item].replace('sum','总数');
                    }else if(pg_temp[item].indexOf('man') >= 0 && pg_temp[item].indexOf('wo') < 0){
                        pg_temp[item] = pg_temp[item].replace('man','男性');
                    }else if(pg_temp[item].indexOf('woman') >= 0 && pg_temp[item].indexOf('wo') >= 0){
                        pg_temp[item] = pg_temp[item].replace('woman','女性');
                    }
                }
                if(pg_temp[item].indexOf('m') == 0 ){
                    pg_temp[item] = pg_temp[item].replace('m','村民');
                    if(pg_temp[item].indexOf('sum') >= 0){
                        pg_temp[item] = pg_temp[item].replace('sum','总数');
                    }else if(pg_temp[item].indexOf('man') && pg_temp[item].indexOf('wo') < 0){
                        pg_temp[item] = pg_temp[item].replace('man','男性');
                    }else if(pg_temp[item].indexOf('woman') >= 0 && pg_temp[item].indexOf('wo') >= 0){
                        pg_temp[item] = pg_temp[item].replace('woman','女性');
                    }
                }
                people_group = pg_temp;
            }
            //确定3D_EC 坐标系与数据
            var g_cg =area_group;
            var p_cg = people_group;
            var data = xyz_data;
            ec_3d_v_pm_option = {
                tooltip: {
                    axisPointer :{
                        label:{
                            show: true
                        }
                    }
                },
                visualMap: {
                    max: 260,
                    inRange: {
                        color: ['#CD3333','#FF3030', '#FF7F50', '#FFB90F','#FFF68F','#FFFF00']
                    }
                },
                xAxis3D: {
                    type: 'category',
                    data: g_cg
                },
                yAxis3D: {
                    type: 'category',
                    data: p_cg
                },
                zAxis3D: {
                    type: 'value'
                },
                grid3D: {
                    boxWidth: 200,
                    boxDepth: 80,
                    axisLabel: {
                        interval: 0
                    },
                    viewControl: {
                        // projection: 'orthographic'
                        autoRotate: true
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
                            fontSize: 12,
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
    });
}

// function sort_3d_v_pm() {
//     var pre_data;
//     var area_group = new Array();
//     var people_group = new Array();
//     var xyz_data = new Array();
//     var ec_3d_v_pm = echarts.init(document.getElementById('3d_v_pm'));
//
//     $.ajax({
//         type: "GET",
//         url: "/api/count/g_cPMSort",
//         dataType: "json",
//         success: function (data_pm) {
//             pre_data = data_pm.data;
//             var pg_temp = Object.keys(pre_data[0]);
//             pg_temp.splice(arrIndex(pg_temp,'area'),1);
//             //重新确定人员分组的顺序(暂时写死）
//             pg_temp = ['pwoman','pman','psum','mwoman','mman','msum'];
//
//
//             //确定area_group
//             for ( area_name in pre_data){
//                 area_group.push(pre_data[area_name].area);
//             }
//             //确定xyz_data
//             for( pg_name in pre_data){
//                 var ag = area_group.indexOf(pre_data[pg_name].area);
//                 var temp_data = pre_data[pg_name];
//                 delete temp_data["area"];
//                 var temp_keys = Object.keys(temp_data);
//                 for(i=0;i<temp_keys.length;i++){
//                     var this_key = temp_keys[i];
//                     var pg = pg_temp.indexOf(temp_keys[i]);
//                     var z_value = temp_data[this_key];
//                     xyz_data.push([pg,ag,z_value])
//                 }
//             }
//             //确定people_group
//             // 英文 - 中文替换
//             for ( item in pg_temp){
//                 if(pg_temp[item].indexOf('p') == 0 ){
//                     pg_temp[item] = pg_temp[item].replace('p','党员');
//                     if(pg_temp[item].indexOf('sum') >= 0){
//                         pg_temp[item] = pg_temp[item].replace('sum','总数');
//                     }else if(pg_temp[item].indexOf('man') >= 0 && pg_temp[item].indexOf('wo') < 0){
//                         pg_temp[item] = pg_temp[item].replace('man','男性');
//                     }else if(pg_temp[item].indexOf('woman') >= 0 && pg_temp[item].indexOf('wo') >= 0){
//                         pg_temp[item] = pg_temp[item].replace('woman','女性');
//                     }
//                 }
//                 if(pg_temp[item].indexOf('m') == 0 ){
//                     pg_temp[item] = pg_temp[item].replace('m','村民');
//                     if(pg_temp[item].indexOf('sum') >= 0){
//                         pg_temp[item] = pg_temp[item].replace('sum','总数');
//                     }else if(pg_temp[item].indexOf('man') && pg_temp[item].indexOf('wo') < 0){
//                         pg_temp[item] = pg_temp[item].replace('man','男性');
//                     }else if(pg_temp[item].indexOf('woman') >= 0 && pg_temp[item].indexOf('wo') >= 0){
//                         pg_temp[item] = pg_temp[item].replace('woman','女性');
//                     }
//                 }
//                 people_group = pg_temp;
//             }
//             //确定3D_EC 坐标系与数据
//             var g_cg =area_group;
//             var p_cg = people_group;
//             var data = xyz_data;
//             ec_3d_v_pm_option = {
//                 tooltip: {
//                     axisPointer :{
//                         label:{
//                             show: true
//                         }
//                     }
//                 },
//                 visualMap: {
//                     max: 260,
//                     inRange: {
//                         color: ['#CD3333','#FF3030', '#FF7F50', '#FFB90F','#FFF68F','#FFFF00']
//                     }
//                 },
//                 xAxis3D: {
//                     type: 'category',
//                     data: g_cg
//                 },
//                 yAxis3D: {
//                     type: 'category',
//                     data: p_cg
//                 },
//                 zAxis3D: {
//                     type: 'value'
//                 },
//                 grid3D: {
//                     boxWidth: 200,
//                     boxDepth: 80,
//                     axisLabel: {
//                         interval: 0
//                     },
//                     viewControl: {
//                         // projection: 'orthographic'
//                         autoRotate: true
//                     },
//                     light: {
//                         main: {
//                             intensity: 1.2,
//                             shadow: true
//                         },
//                         ambient: {
//                             intensity: 0.3
//                         }
//                     }
//                 },
//                 series: [{
//                     type: 'bar3D',
//                     data: data.map(function (item) {
//                         return {
//                             value: [item[1], item[0], item[2]],
//                         }
//                     }),
//                     shading: 'lambert',
//
//                     label: {
//                         textStyle: {
//                             fontSize: 12,
//                             borderWidth: 1
//                         }
//                     },
//
//                     emphasis: {
//                         label: {
//                             textStyle: {
//                                 fontSize: 20,
//                                 color: '#900'
//                             }
//                         },
//                         itemStyle: {
//                             color: '#900'
//                         }
//                     }
//                 }]
//             };
//             ec_3d_v_pm.setOption(ec_3d_v_pm_option);
//
//         }
//     });
// }

function init_3d_s_c() {
    var ec_3d_s_c = echarts.init(document.getElementById('3d_s_c'));

    var data = [];
// Parametric curve
    for (var t = 0; t < 25; t += 0.001) {
        var x = (1 + 0.25 * Math.cos(75 * t)) * Math.cos(t);
        var y = (1 + 0.25 * Math.cos(75 * t)) * Math.sin(t);
        var z = t + 2.0 * Math.sin(75 * t);
        data.push([x, y, z]);
    }
    console.log(data.length);

    ec_3d_s_c_option = {
        tooltip: {},
        backgroundColor: '#fff',
        visualMap: {
            show: false,
            dimension: 2,
            min: 0,
            max: 30,
            inRange: {
                color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026']
            }
        },
        xAxis3D: {
            type: 'value'
        },
        yAxis3D: {
            type: 'value'
        },
        zAxis3D: {
            type: 'value'
        },
        grid3D: {
            viewControl: {
                projection: 'orthographic',
                autoRotate: true
            }
        },
        series: [{
            type: 'line3D',
            data: data,
            lineStyle: {
                width: 4
            }
        }]
    };
    ec_3d_s_c.setOption(ec_3d_s_c_option);
}

function init_3d_bt() {

    var pre_data;
    var area_group = new Array();
    var data_group = new Array();
    var xyz_data = new Array();
    var ec_3d_bt= echarts.init(document.getElementById('3d_bt'));

    $.ajax({
        type: "GET",
        url: "/api/device/sumterm",
        dataType: "json",
        success: function (data_bt) {
            pre_data = data_bt.data;
            var dp_temp = ['down','req','run','sum'];
            //确定area_group
            for ( area_name in pre_data){
                area_group.push(pre_data[area_name].aname);
            }
            //确定xyz_data
            for( pg_name in pre_data){
                var ag = area_group.indexOf(pre_data[pg_name].aname);
                var temp_data = pre_data[pg_name];
                delete temp_data["aname"];
                var temp_keys = Object.keys(temp_data);
                for(i=0;i<temp_keys.length;i++){
                    var this_key = temp_keys[i];
                    var pg = dp_temp.indexOf(temp_keys[i]);
                    var z_value = temp_data[this_key];
                    xyz_data.push([pg,ag,z_value])
                }
            }

            // 英文 - 中文替换
            for ( item in dp_temp){
                if(dp_temp[item].indexOf('sum') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('sum','设备总数');
                }else if(dp_temp[item].indexOf('run') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('run','运行数');
                }else if (dp_temp[item].indexOf('down') >= 0 ) {
                    dp_temp[item] = dp_temp[item].replace('down','停止数');
                }else if(dp_temp[item].indexOf('req') >= 0){
                    dp_temp[item] = dp_temp[item].replace('req','维修数');
                }
                data_group = dp_temp;
            }

            //确定3D_EC 坐标系与数据
            var a_cg =area_group;
            var data_cg = data_group;
            var data = xyz_data;
            ec_3d_bt_option = {
                tooltip: {
                    axisPointer :{
                        label:{
                            show: true
                        }
                    }
                },
                visualMap: {
                    max: 260,
                    inRange: {
                        color: ['#00868B','#00CD00', '#00FA9A', '#00CED1','#00F5FF','#00FFFF']
                    }
                },
                xAxis3D: {
                    type: 'category',
                    data: a_cg
                },
                yAxis3D: {
                    type: 'category',
                    data: data_cg
                },
                zAxis3D: {
                    type: 'value'
                },
                grid3D: {
                    boxWidth: 300,
                    boxDepth: 80,
                    axisLabel: {
                        interval: 0
                    },
                    viewControl: {
                        // projection: 'orthographic'
                        autoRotate: true
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
                            fontSize: 12,
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
            ec_3d_bt.setOption(ec_3d_bt_option);
        }
    })

}

function init_ec_bt() {
    var pre_data;
    var area_group = new Array();
    var ec_bt_sum = echarts.init(document.getElementById('bt_sum'));

    $.ajax({
        type: "GET",
        url: "/api/device/sumterm",
        dataType: "json",
        success: function (data_bt) {
            pre_data = data_bt.data;
            //确定area_group
            for ( area_name in pre_data){
                area_group.push(pre_data[area_name].aname);
            }

            // 二维图表 广播地域分布可视化
            var x_data = area_group;
            var y_data = new Array();

            for (y in pre_data){
                y_data.push(pre_data[y].sum);
            }
            ec_bt_sum_option = {
                color: ['#9B30FF'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'cross'        // 默认为直线，可选为：'line' | 'shadow'
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
                        name:'终端数量',
                        type:'bar',
                        barWidth: '60%',
                        data:y_data
                    }
                ]
            };
            ec_bt_sum.setOption(ec_bt_sum_option);

        }
    })
}

function sort_3d_bt() {

    var pre_data;
    var area_group = new Array();
    var data_group = new Array();
    var xyz_data = new Array();
    var ec_3d_bt= echarts.init(document.getElementById('3d_bt'));

    $.ajax({
        type: "GET",
        url: "/api/device/sumtermSort",
        dataType: "json",
        success: function (data_bt) {
            pre_data = data_bt.data;
            var dp_temp = ['down','req','run','sum'];
            //确定area_group
            for ( area_name in pre_data){
                area_group.push(pre_data[area_name].aname);
            }
            //确定xyz_data
            for( pg_name in pre_data){
                var ag = area_group.indexOf(pre_data[pg_name].aname);
                var temp_data = pre_data[pg_name];
                delete temp_data["aname"];
                var temp_keys = Object.keys(temp_data);
                for(i=0;i<temp_keys.length;i++){
                    var this_key = temp_keys[i];
                    var pg = dp_temp.indexOf(temp_keys[i]);
                    var z_value = temp_data[this_key];
                    xyz_data.push([pg,ag,z_value])
                }
            }

            // 英文 - 中文替换
            for ( item in dp_temp){
                if(dp_temp[item].indexOf('sum') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('sum','设备总数');
                }else if(dp_temp[item].indexOf('run') >= 0 ){
                    dp_temp[item] = dp_temp[item].replace('run','运行数');
                }else if (dp_temp[item].indexOf('down') >= 0 ) {
                    dp_temp[item] = dp_temp[item].replace('down','停止数');
                }else if(dp_temp[item].indexOf('req') >= 0){
                    dp_temp[item] = dp_temp[item].replace('req','维修数');
                }
                data_group = dp_temp;
            }

            //确定3D_EC 坐标系与数据
            var a_cg =area_group;
            var data_cg = data_group;
            var data = xyz_data;
            ec_3d_bt_option = {
                tooltip: {
                    axisPointer :{
                        label:{
                            show: true
                        }
                    }
                },
                visualMap: {
                    max: 260,
                    inRange: {
                        color: ['#00868B','#00CD00', '#00FA9A', '#00CED1','#00F5FF','#00FFFF']
                    }
                },
                xAxis3D: {
                    type: 'category',
                    data: a_cg
                },
                yAxis3D: {
                    type: 'category',
                    data: data_cg
                },
                zAxis3D: {
                    type: 'value'
                },
                grid3D: {
                    boxWidth: 300,
                    boxDepth: 80,
                    axisLabel: {
                        interval: 0
                    },
                    viewControl: {
                        // projection: 'orthographic'
                        autoRotate: true
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
                            fontSize: 12,
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
            ec_3d_bt.setOption(ec_3d_bt_option);
        }
    })

}

function sort_ec_bt() {
    var pre_data;
    var area_group = new Array();
    var ec_bt_sum = echarts.init(document.getElementById('bt_sum'));

    $.ajax({
        type: "GET",
        url: "/api/device/sumtermSort",
        dataType: "json",
        success: function (data_bt) {
            pre_data = data_bt.data;
            //确定area_group
            for ( area_name in pre_data){
                area_group.push(pre_data[area_name].aname);
            }

            // 二维图表 广播地域分布可视化
            var x_data = area_group;
            var y_data = new Array();

            for (y in pre_data){
                y_data.push(pre_data[y].sum);
            }
            ec_bt_sum_option = {
                color: ['#9B30FF'],
                tooltip : {
                    trigger: 'axis',
                    axisPointer : {            // 坐标轴指示器，坐标轴触发有效
                        type : 'cross'        // 默认为直线，可选为：'line' | 'shadow'
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
                        name:'终端数量',
                        type:'bar',
                        barWidth: '60%',
                        data:y_data
                    }
                ]
            };
            ec_bt_sum.setOption(ec_bt_sum_option);

        }
    })
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