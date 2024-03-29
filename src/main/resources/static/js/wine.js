$(document).ready(function () {
    console.log("ready!!");
    var table = $('#wineTable').DataTable({
        bPaginate: false,
        serverSide: false,
        fixedHeader: true,
        bInfo: false,
        dom: '<"pull-left"f><"pull-right"l>tip',
        ajax: {
            "url": "http://localhost:8081/wines",
            "type": "GET",
            "error": function (req, textStatus, errorThrown) {
                alert('Ooops, something happened: ' + req + ' : ' + textStatus + ' : ' + errorThrown);
            }
        },
        columns: [
            {
                title: "id",
                data: "id",
                visible: false,
                render: function (data) {
                    return data;
                }
            },
            {
                title: "와인이름",
                data: "name",
                className: 'dt-head-center',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "생산<br>년도",
                data: "vintage",
                className: 'dt-head-center dt-body-center',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "시음적기<br>시작연도",
                data: "startDrink",
                className: 'dt-head-center dt-body-center',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "시음적기<br>마지막연도",
                data: "endDrink",
                className: 'dt-head-center dt-body-center',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "생산<br>지역",
                data: "region",
                className: 'dt-head-center dt-body-center',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "비비노<br>점수",
                data: "vivino",
                className: 'dt-head-center dt-body-center',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "추천<br>페어링",
                data: "pairing",
                className: 'dt-head-center',
                width: '10%',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "이미지",
                data: "image",
                className: 'dt-head-center dt-body-center',
                className: 'image',
                render: function (data) {
                    return '<img src=/image/' + data + ' height="50" width="50"/>';
                }
            },
            {
                title: "개수",
                data: "count",
                className: 'dt-head-center dt-body-center',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "최저구매가격",
                data: "price",
                className: 'dt-head-center dt-body-right',
                render: function (data) {
                    if(data == null) alert("dddd");
                    // return data;
                    return $.fn.dataTable.render.number(',', '.', 0, '', ' ₩').display(data);
                }
            },
            {
                title: "구매장소",
                data: "place",
                className: 'dt-head-center',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "메모",
                data: "memo",
                className: 'dt-head-center dt-body-left',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "구매일",
                data: "buyDate",
                className: 'dt-head-center',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "세계<br>랭킹",
                data: "rankingWorld",
                className: 'dt-head-center dt-body-center',
                render: function (data) {
                    return data;
                }
            },
            {
                title: "생산지역<br>랭킹",
                data: "rankingRegion",
                className: 'dt-head-center dt-body-center',
                render: function (data) {
                    return data;
                }
            },
        ],
        "language": {
            "emptyTable": "No Data"
        }
    });

    $('#wineTable tbody').on('dblclick', 'tr', function () {
        var data = table.row(this).data();
        $("#save").val("수정");
        $("#del").show();
        popupOpen(data);
    });

    $('#wineTable tbody').on('click', 'td.image', function () {
        var data = table.cell(this).data();
        imageOpen(data);
    });

});

function add() {
    $("#save").val("추가");
    $("#del").hide();
    popupOpen();
}

function imageOpen(data) {
    console.log(data)
    $("#imageContent").attr("src", "file/"+ data);
    $("#imageLayer").fadeIn();
    // $(".layer_bg").fadeIn();
    layer_position();
    //레이어 영역 외 바탕화면 클릭시 화면 닫기
    // $(".layer_bg").click(function (e) {
    //     if (!$(".layer_wrap").has(e.target).length) {
    //         popupClose();
    //     }
    // });
}

function popupOpen(data) {
    if (data) {
        $("[name='id']").val(data.id);
        $("[name='name']").val(data.name);
        $("[name='vintage']").val(data.vintage);
        $("[name='startDrink']").val(data.startDrink);
        $("[name='endDrink']").val(data.endDrink);
        $("[name='region']").val(data.region);
        $("[name='vivino']").val(data.vivino);
        $("[name='rankingWorld']").val(data.rankingWorld);
        $("[name='rankingRegion']").val(data.rankingRegion);
        $("[name='pairing']").val(data.pairing);
        $("[name='image']").val(data.image);
        $("[name='count']").val(data.count);
        $("[name='place']").val(data.place);
        $("[name='price']").val(data.price);
        $("[name='buyDate']").val(data.buyDate);
        $("[name='memo']").val(data.memo);
    } else {
        $(".add").val("");
    }

    $(".layer_wrap").fadeIn();
    $(".layer_bg").fadeIn();
    layer_position();
    //레이어 영역 외 바탕화면 클릭시 화면 닫기
    $(".layer_bg").click(function (e) {
        if (!$(".layer_wrap").has(e.target).length) {
            popupClose();
        }
    });
}

function saveWine() {
    $.ajax({
        url: 'http://localhost:8081/wine',
        type: 'POST',
        data: $(".add").serialize(),
        success: function onData(data) {
            location.reload();
        },
        error: function onError(error) {
            alert(error.responseJSON.message);
        }
    });
}

function deleteWine() {
    $.ajax({
        url: 'http://localhost:8081/wine',
        type: 'DELETE',
        data: $(".add").serialize(),
        success: function onData(data) {
            console.log(data);
            location.reload();
        },
        error: function onError(error) {
            alert(error.responseJSON.message);
        }
    });
}

function popupClose() {
    $(".layer_wrap, .layer_bg").fadeOut();
}

function layer_position() {
    $(".layer_wrap").css({'left': '30%', 'top': '15%'});
}