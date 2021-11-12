<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/1.12.4/jquery.min.js"/>
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