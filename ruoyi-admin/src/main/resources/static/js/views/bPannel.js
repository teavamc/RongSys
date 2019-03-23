/**
 * Created by MI on 2019/3/20.
 */

function bonLoad() {
    init_bd_mbygroup();
    init_bds_mbygroup();
    init_bt_mbygroup();
    init_ptp_mbygroup();
    /*统计故障终端，按时间分布*/
    init_bd_terminlgroup();
    /*统计在线终端数，下线终端数，及百分比*/
    init_bd_terminalstate();
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
            for (var i = 0; i < btygroup_data.length; i++) {
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
                tooltip: {
                    trigger: 'axis'
                },
                toolbox: {
                    show: true,
                    feature: {
                        magicType: {show: true, type: ['line', 'bar']},
                    }
                },
                calculable: true,
                grid: {
                    left: '3%',
                    right: '3%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: x_data,
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value}'
                        }
                    }
                ],
                series: [
                    {
                        type: 'line',
                        data: y_data,
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
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
            for (var i = 0; i < bdygroup_data.length; i++) {
                if (bdygroup_data[i].bcount == '') {
                    x_data.push('未知');
                } else {
                    y_data.push(parseInt(bdygroup_data[i].bcount));
                    x_data.push(bdygroup_data[i].broadDate);
                }
            }
            /*console.log(x_data);*/
            /*console.log(y_data);*/
            bd_option = {
                color: ['#00fc1a'],
                tooltip: {
                    trigger: 'axis'
                },
                toolbox: {
                    show: true,
                    feature: {
                        magicType: {show: true, type: ['line', 'bar']},
                    }
                },
                calculable: true,
                grid: {
                    left: '3%',
                    right: '3%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                xAxis: [
                    {
                        type: 'category',
                        boundaryGap: false,
                        data: x_data
                    }
                ],
                yAxis: [
                    {
                        type: 'value',
                        axisLabel: {
                            formatter: '{value}'
                        }
                    }
                ],
                series: [
                    {
                        type: 'line',
                        data: y_data,
                        markLine: {
                            data: [
                                {type: 'average', name: '平均值'}
                            ]
                        }
                    }
                ]
            };
            bd_mbygroup.setOption(bd_option);
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
            for (var i = 0; i < bdsygroup_data.length; i++) {
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
            bds_option = {
                tooltip: {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    x: 'left',
                    data: x_data
                },
                calculable: true,
                series: [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius: '55%',
                        center: ['50%', '60%'],
                        data: [
                            /*y_data*/
                            {value: y_data[0], name: x_data[0]},
                            {value: y_data[1], name: x_data[1]}
                        ]
                    }
                ]
            };
            bds_mbygroup.setOption(bds_option);
        }
    });
}

function init_ptp_mbygroup() {
    var ptp_mbygroup = echarts.init(document.getElementById('ptp_mbygroup'));
    $.ajax({
        type: "GET",
        url: "/api/bp/ptp",
        datatype: "JSON",
        success: function (data) {
            var ptpygroup_data = data.data;
            var x_data = new Array();
            var y_data = new Array();
            var sum = 0;
            for (var i = 0; i < ptpygroup_data.length; i++) {
                if (ptpygroup_data[i].ptp == '') {
                    x_data.push('未知');
                } else {
                    x_data.push(ptpygroup_data[i].ptp);
                    y_data.push(parseInt(ptpygroup_data[i].count));
                    sum = sum > y_data[i] ? sum : y_data[i];
                }
                sum /= 5;
            }
            console.log(sum);
            ptp_option =  {
                color: ['#6761c1'],
                grid: {
                    left: '3%',
                    right: '3%',
                    top: '5%',
                    bottom: '0%',
                    containLabel: true
                },
                tooltip : {
                    trigger: 'axis'
                },
                toolbox: {
                    show : true
                },
                polar : [
                    {
                        indicator : [
                            { text: x_data[0], max: sum+y_data[0]},
                            { text: x_data[1], max: sum+y_data[1]},
                            { text: x_data[2], max: sum+y_data[2]},
                            { text: x_data[3], max: sum+y_data[3]},
                            { text: x_data[4], max: sum+y_data[4]}
                        ]
                    }
                ],
                calculable : true,
                series : [
                    {
                        type: 'radar',
                        data : [
                            {
                                name: '操作记录',
                                value : y_data
                            }
                        ]
                    }
                ]
            };
            ptp_mbygroup.setOption(ptp_option);
        }
    });
}

function init_bd_terminlgroup() {
    var bd_terminlgroup = echarts.init(document.getElementById('bd_terminlgroup'));
    $.ajax({
        type: "GET",
        url: "/api/terminal/bt",
        datatype: "JSON",
        success: function (data) {
            var bd_data = data.data;
            var x_data = new Array;
            var y_data = new Array;
            for(i in bd_data){
                if(bd_data[i] == null){
                    x_data.push('未知');
                }else {
                    x_data.push(bd_data[i].tmid);
                    y_data.push(bd_data[i].time);
                }
            }
            option = {

                grid: {
                    left: '5%',
                    right: '5%',
                    bottom: 80
                },
                toolbox: {
                    feature: {
                        dataZoom: {
                            yAxisIndex: 'none'
                        },
                        restore: {},
                        saveAsImage: {}
                    }
                },
                tooltip : {
                    trigger: 'axis',
                    axisPointer: {
                        type: 'cross',
                        animation: false,
                        label: {
                            backgroundColor: '#505765'
                        }
                    }
                },
                legend: {
                    data:['流量','降雨量'],
                    x: 'left'
                },
                dataZoom: [
                    {
                        show: true,
                        realtime: true,
                        start: 65,
                        end: 85
                    },
                    {
                        type: 'inside',
                        realtime: true,
                        start: 65,
                        end: 85
                    }
                ],
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : false,
                        axisLine: {onZero: false},
                        data : y_data.map(function (str) {
                            return str.replace(' ', '\n')
                        })
                    }
                ],
                yAxis: [
                    {
                        name: '',
                        type: 'value',
                        max: 80
                    },
                    {
                        name: '',
                        nameLocation: 'start',
                        max: 80,
                        type: 'value',
                    }
                ],
                series: [
                    {
                        name:'终端维护量',
                        type:'line',
                        yAxisIndex:1,
                        animation: false,
                        areaStyle: {
                        },
                        lineStyle: {
                            width: 1
                        },
                        markArea: {
                            silent: true,
                            data: [[{
                                xAxis: '2009/9/10\n7:00'
                            }, {
                                xAxis: '2009/9/20\n7:00'
                            }]]
                        },
                        data: x_data
                    }
                ]
            };

            bd_terminlgroup.setOption(option);
        }
    });

}

function init_bd_terminalstate() {
    var bd_terminalstate = echarts.init(document.getElementById('bd_terminalstate'));
    $.ajax({
        type: "GET",
        url: "/api/bcount/bindex",
        datatype: "JSON",
        success: function (data) {
            var bd_device = data.data.dev;
            var bd_run = data.data.run;
            var bd_stop = data.data.stop;
            option = {
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient: 'vertical',
                    left: 'left',
                    data: ['终端总数','在线终端数','离线终端数']
                },
                series : [
                    {
                        name: '访问来源',
                        type: 'pie',
                        radius : '55%',
                        center: ['50%', '60%'],
                        data:[
                            {value:bd_device, name:'终端总数'},
                            {value:bd_run, name:'在线终端数'},
                            {value:bd_stop, name:'离线终端数'},
                        ],
                        itemStyle: {
                            emphasis: {
                                shadowBlur: 10,
                                shadowOffsetX: 0,
                                shadowColor: 'rgba(0, 0, 0, 0.5)'
                            }
                        }
                    }
                ]
            };

            bd_terminalstate.setOption(option);
        }

    });

}
