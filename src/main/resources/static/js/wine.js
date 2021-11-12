function add() {
    $.ajax({
        url: '/wine',
        type: 'POST',
        data: $(".add").serialize(),
        success: function onData (data) {
            console.log(data);
        },
        error: function onError (error) {
            console.error(error);
        }
    });
}

function reset() {
    $("table tbody tr").first().children().find("input:text").val("");
}