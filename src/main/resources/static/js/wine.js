$(document).ready(function () {
    var table = $('#wineTable').DataTable({
        bPaginate: false,
        serverSide: false,
        fixedHeader: true,
        bInfo: false,
        dom: '<"pull-left"f><"pull-right"l>tip',
        ajax: {
            "url": "http://localhost:8081/wines",
            "type": "GET"
        },
        columns: [
            {
                title: "와인이름",
                data: "name",
                render: function (data) {
                    return data == null ? "" : data;
                }
            },
            {
                title: "생산년도",
                data: "vintage",
                render: function (data) {
                    return data == null ? "" : data;
                }
            },
            {
                title: "시음적기 시작연도",
                data: "startDrink",
                render: function (data) {
                    return data == null ? "" : data;
                }
            },
            {
                title: "시음적기 마지막연도",
                data: "endDrink",
                render: function (data) {
                    return data == null ? "" : data;
                }
            },
            {
                title: "생산지역",
                data: "region",
                render: function (data) {
                    return data == null ? "" : data;
                }
            },
            {
                title: "비비노점수",
                data: "vivino",
                render: function (data) {
                    return data == null ? "" : data;
                }
            },
            {
                title: "세계랭킹",
                data: "rankingWorld",
                render: function (data) {
                    return data == null ? "" : data;
                }
            },
            {
                title: "생산지역 랭킹",
                data: "rankingRegion",
                render: function (data) {
                    return data == null ? "" : data;
                }
            },
            {
                title: "추천 페어링",
                data: "pairing",
                render: function (data) {
                    return data == null ? "" : data;
                }
            },
            {
                title: "이미지",
                data: "image",
                render: function (data) {
                    return '<img src="/file/' + data + '" height="50" width="50"/>';
                }
            },
            {
                title: "등록일",
                data: "registrationDate",
                render: function (data) {
                    return data == null ? "" : data;
                }
            },
            {
                title: "수정일",
                data: "updateDate",
                render: function (data) {
                    return data == null ? "" : data;
                }
            }
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

});

function add() {
    $("#save").val("추가");
    $("#del").hide();
    popupOpen();
}

function popupOpen(data) {
    if (data) {
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
    } else {
        $(".add").val("");
    }

    $(".layer_wrap").fadeIn();
    $(".layer_bg").fadeIn();
    layer_position();
    //레이어 영역 외 바탕화면 클릭시 화면 닫기
    $(".layer_bg").click(function (e) {
        if (!$(".layer_wrap").has(e.target).length) {
            layer_close();
        }
    });
}

function saveWine() {
    $.ajax({
        url: 'http://localhost:8081/wine',
        type: 'POST',
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