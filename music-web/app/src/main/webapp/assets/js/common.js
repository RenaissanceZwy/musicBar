var music =  {};
music.modal = { alert: function alert(msg,cancel_func) {
    $.alert({
        title: '提示',
        content: msg,
        autoClose: 'cancel|3000',
        buttons: {
            cancel:{
                text:"确认",
                action: cancel_func
            },
        }
    });

}, confirm: function confirm(msg,confirm_func) {
    $.confirm({
        title: '警告',
        content: msg,
        autoClose: 'cancel|3000',
        buttons: {
            confirm: {
                text:"确认",
                action:confirm_func
            },
            cancel:{
                text:"取消",
                action: function () {

                }
            },
        }
    });
},error: function error(msg,cancel_func) {
    $.alert({
        title: '错误',
        content: msg,
        buttons: {
            cancel:{
                text:"确认",
                action: cancel_func
            },
        }
    });

}}

Array.prototype.remove = function (dx) {
    if (isNaN(dx) || dx > this.length) {
        return false;
    }
    for (var i = 0, n = 0; i < this.length; i++) {
        if (this[i] != this[dx]) {
            this[n++] = this[i]
        }
    }
    this.length -= 1
}

$('select:not([multiple])').select2({
    minimumResultsForSearch: Infinity
});

$("input[type=date]").attr("type", "text").attr("data-date-format", "yyyy-mm-dd").datepicker({
    autoclose: true,
    language: 'zh-CN'
});

$('.btn-group > .btn[disabled]').click(function() { return false; })