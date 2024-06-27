

(function () {
  Chart.defaults.global = {
    animation: true,
    animationSteps: 60,
    animationEasing: "easeOutIn",
    showScale: true,
    scaleOverride: false,
    scaleSteps: null,
    scaleStepWidth: null,
    scaleStartValue: null,
    scaleLineColor: "#eeeeee",
    scaleLineWidth: 1,
    scaleShowLabels: true,
    scaleLabel: "<%=value%>",
    scaleIntegersOnly: true,
    scaleBeginAtZero: false,
    scaleFontSize: 12,
    scaleFontStyle: "normal",
    scaleFontColor: "#717171",
    responsive: true,
    maintainAspectRatio: true,
    showTooltips: true,
    multiTooltipTemplate: "<%= value %>",
    tooltipFillColor: "#333333",
    tooltipEvents: ["mousemove", "touchstart", "touchmove"],
    tooltipTemplate: "<%if (label){%><%=label%>: <%}%><%= value %>",
    tooltipFontSize: 14,
    tooltipFontStyle: "normal",
    tooltipFontColor: "#fff",
    tooltipTitleFontSize: 16,
    TitleFontStyle: "Raleway",
    tooltipTitleFontStyle: "bold",
    tooltipTitleFontColor: "#ffffff",
    tooltipYPadding: 10,
    tooltipXPadding: 10,
    tooltipCaretSize: 8,
    tooltipCornerRadius: 6,
    tooltipXOffset: 5,
    onAnimationProgress: function () {
    },
    onAnimationComplete: function () {
    },
  };

  // var resultData = [[${resultData}]];

 // var chartDataElement = document.getElementsByClassName('my');
  //console.log("@@@@@@@@@@@@@@@2222 : ", chartDataElement);
  // var resultData = JSON.parse(chartDataElement.dataset.items);


  // labels와 data 배열 생성
  // var labels = [];
  // var finalData = [];

  // resultData.forEach(function(item) {
  //   labels.push(item.itemName);
  //   data.push(item.totalSales);
  // });

  // var itemName = [];
  // var totalSales = [];

  // console.log("@@@@@@:", labels);
  // console.log("@@@@@@@:", finalData);
  // var barData = {
  //   labels: [1, 2, 3, 4, 5, 6],
  //   datasets: [
  //     {
  //       label: "총매출",
        // fillColor: "rgba(0, 102, 102, 0.2)",
        // strokeColor: RihoAdminConfig.primary,
        // highlightFill: "rgba(0, 102, 102, 0.2)",
        // highlightStroke: RihoAdminConfig.primary,
        // data: [10, 10, 10, 10, 10, 10]
      // }]
  // };
  //
  // var barOptions = {
  //   scaleBeginAtZero: true,
  //   scaleShowGridLines: true,
  //   scaleGridLineColor: "rgba(0,0,0,0.1)",
  //   scaleGridLineWidth: 1,
  //   scaleShowHorizontalLines: true,
  //   scaleShowVerticalLines: true,
  //   barShowStroke: true,
  //   barStrokeWidth: 2,
  //   barValueSpacing: 5,
  //   barDatasetSpacing: 1,
  // };
  //
  // var barCtx = document.getElementById("myBarGraph").getContext("2d");
  // var myBarChart = new Chart(barCtx).Bar(barData, barOptions);
  // =================
  var polarData = [
    {
      value: 300,
      color: RihoAdminConfig.primary,
      highlight: RihoAdminConfig.primary,
      label: "Yellow",
    },
    {
      value: 50,
      color: "#f8d62b",
      highlight: "#f8d62b",
      label: "Sky",
    },
    {
      value: 100,
      color: "#51bb25",
      highlight: "#333",
      label: "Black",
    },
    {
      value: 40,
      color: "#173878",
      highlight: "#173878",
      label: "Grey",
    },
    {
      value: 120,
      color: RihoAdminConfig.secondary,
      highlight: RihoAdminConfig.secondary,
      label: "Dark Grey",
    },
  ];
  var polarOptions = {
    scaleShowLabelBackdrop: true,
    scaleBackdropColor: "rgba(255,255,255,0.75)",
    scaleBeginAtZero: true,
    scaleBackdropPaddingY: 2,
    scaleBackdropPaddingX: 2,
    scaleShowLine: true,
    segmentShowStroke: true,
    segmentStrokeColor: "#fff",
    segmentStrokeWidth: 2,
    animationSteps: 100,
    animationEasing: "easeOutBounce",
    animateRotate: true,
    animateScale: false,
    legendTemplate:
        '<ul class="<%=name.toLowerCase()%>-legend"><% for (var i=0; i<segments.length; i++){%><li><span style="background-color:<%=segments[i].fillColor%>"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>',
  };
  var polarCtx = document.getElementById("myPolarGraph").getContext("2d");
  var myPolarChart = new Chart(polarCtx).PolarArea(polarData, polarOptions);
  var lineGraphData = {
    labels: ["January", "February", "March", "April", "May", "June", "July"],
    datasets: [
      {
        label: "My First dataset",
        fillColor: "rgba(0, 102, 102, 0.2)",
        strokeColor: RihoAdminConfig.primary,
        pointColor: RihoAdminConfig.primary,
        pointStrokeColor: "#fff",
        pointHighlightFill: "#fff",
        pointHighlightStroke: "#000",
        data: [10, 59, 80, 81, 56, 55, 40],
      },
      {
        label: "My Second dataset",
        fillColor: "rgba(254, 106, 73, 0.3)",
        strokeColor: RihoAdminConfig.secondary,
        pointColor: RihoAdminConfig.secondary,
        pointStrokeColor: "#fff",
        pointHighlightFill: "#000",
        pointHighlightStroke: RihoAdminConfig.secondary,
        data: [28, 48, 40, 19, 86, 27, 90],
      },
    ],
  };
  var lineGraphOptions = {
    scaleShowGridLines: true,
    scaleGridLineColor: "rgba(0,0,0,.05)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: true,
    bezierCurve: true,
    bezierCurveTension: 0.4,
    pointDot: true,
    pointDotRadius: 4,
    pointDotStrokeWidth: 1,
    pointHitDetectionRadius: 20,
    datasetStroke: true,
    datasetStrokeWidth: 2,
    datasetFill: true,
    legendTemplate:
        '<ul class="<%=name.toLowerCase()%>-legend">' +
        '<% for (var i=0; i<datasets.length; i++){%><li><span style="background-color:<%=datasets[i].strokeColor%>">' +
        '</span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>',
  };
  var lineCtx = document.getElementById("myGraph").getContext("2d");
  var myLineCharts = new Chart(lineCtx).Line(lineGraphData, lineGraphOptions);
  var radarData = {
    labels: ["Ford", "Chevy", "Toyota", "Honda", "Mazda"],
    datasets: [
      {
        label: "My First dataset",
        fillColor: "rgba(0, 102, 102, 0.2)",
        strokeColor: RihoAdminConfig.primary,
        pointColor: RihoAdminConfig.primary,
        pointStrokeColor: RihoAdminConfig.primary,
        pointHighlightFill: RihoAdminConfig.primary,
        pointHighlightStroke: "rgba(0, 102, 102, 0.2)",
        data: [12, 3, 5, 18, 7],
      },
    ],
  };
  var radarOptions = {
    scaleShowGridLines: true,
    scaleGridLineColor: "rgba(0,0,0,.2)",
    scaleGridLineWidth: 1,
    scaleShowHorizontalLines: true,
    scaleShowVerticalLines: true,
    bezierCurve: true,
    bezierCurveTension: 0.4,
    pointDot: true,
    pointDotRadius: 3,
    pointDotStrokeWidth: 1,
    pointHitDetectionRadius: 20,
    datasetStroke: true,
    datasetStrokeWidth: 2,
    datasetFill: true,
    legendTemplate:
        '<ul class="<%=name.toLowerCase()%>-legend"><% for (var i=0; i<datasets.length; i++){%><li><span style="background-color:<%=datasets[i].strokeColor%>"></span><%if(datasets[i].label){%><%=datasets[i].label%><%}%></li><%}%></ul>',
  };
  var radarCtx = document.getElementById("myRadarGraph").getContext("2d");
  var myRadarChart = new Chart(radarCtx).Radar(radarData, radarOptions);
  var pieData = [
    {
      value: 300,
      color: "#ab8ce4",
      highlight: "#ab8ce4",
      label: "Primary",
    },
    {
      value: 50,
      color: "#ea2087",
      highlight: "#ea2087",
      label: "Secondary",
    },
    {
      value: 100,
      color: "#FF5370",
      highlight: "#FF5370",
      label: "Danger",
    },
  ];
  var pieOptions = {
    segmentShowStroke: true,
    segmentStrokeColor: "#fff",
    segmentStrokeWidth: 2,
    percentageInnerCutout: 0,
    animationSteps: 100,
    animationEasing: "easeOutBounce",
    animateRotate: true,
    animateScale: false,
    legendTemplate:
        '<ul class="<%=name.toLowerCase()%>-legend"><% for (var i=0; i<segments.length; i++){%><li><span style="background-color:<%=segments[i].fillColor%>"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>',
  };

  var doughnutData = [
    {
      value: 300,
      color: RihoAdminConfig.primary,
      highlight: RihoAdminConfig.primary,
      label: "Primary",
    },
    {
      value: 50,
      color: RihoAdminConfig.secondary,
      highlight: RihoAdminConfig.secondary,
      label: "Secondary",
    },
    {
      value: 100,
      color: "#51bb25",
      highlight: "#51bb25",
      label: "Success",
    },
  ];
  var doughnutOptions = {
    segmentShowStroke: true,
    segmentStrokeColor: "#fff",
    segmentStrokeWidth: 2,
    percentageInnerCutout: 50,
    animationSteps: 100,
    animationEasing: "easeOutBounce",
    animateRotate: true,
    animateScale: false,
    legendTemplate:
        '<ul class="<%=name.toLowerCase()%>-legend"><% for (var i=0; i<segments.length; i++){%><li><span style="background-color:<%=segments[i].fillColor%>"></span><%if(segments[i].label){%><%=segments[i].label%><%}%></li><%}%></ul>',
  };
  var doughnutCtx = document.getElementById("myDoughnutGraph").getContext("2d");
  var myDoughnutChart = new Chart(doughnutCtx).Doughnut(
      doughnutData,
      doughnutOptions
  );
  var myLineChart = {
    labels: ["", "10", "20", "30", "40", "50", "60", "70", "80"],
    datasets: [
      {
        fillColor: "rgba(81, 187, 37, 0.2)",
        strokeColor: "#51bb25",
        pointColor: "#51bb25",
        data: [10, 20, 40, 30, 0, 20, 10, 30, 10],
      },
      {
        fillColor: "rgba(254, 106, 73, 0.3)",
        strokeColor: RihoAdminConfig.secondary,
        pointColor: RihoAdminConfig.secondary,
        data: [20, 40, 10, 20, 40, 30, 40, 10, 20],
      },
      {
        fillColor: "rgba(0, 102, 102, 0.2)",
        strokeColor: RihoAdminConfig.primary,
        pointColor: RihoAdminConfig.primary,
        data: [60, 10, 40, 30, 80, 30, 20, 90, 0],
      },
    ],
  };
  var ctx = document.getElementById("myLineCharts").getContext("2d");
  var LineChartDemo = new Chart(ctx).Line(myLineChart, {
    pointDotRadius: 2,
    pointDotStrokeWidth: 5,
    pointDotStrokeColor: "#ffffff",
    bezierCurve: false,
    scaleShowVerticalLines: false,
    scaleGridLineColor: "#eeeeee",
  });


})();


