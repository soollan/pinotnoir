$(document).ready(function () {
    var as = $('#userTable').DataTable({
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
                id:"와인이름",
                header:["와인이름", {content: "textFilter"}],
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
                    return data == null ? "" : data;
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
});


function add() {
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

function reset() {
    $("table tbody tr").first().children().find("input:text").val("");
}
