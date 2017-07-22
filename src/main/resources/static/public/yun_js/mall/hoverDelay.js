/**
 * Created by Administrator on 2017/7/10 0010.
 */
(function ($) {
    $.fn.hoverDelay = function (hoverEvent, outEvent) {
        var hoverTimer, outTimer;
        return $(this).each(function () {
            $(this).hover(function () {
                var t = this;
                clearTimeout(outTimer);
                hoverTimer = setTimeout(function () {
                    hoverEvent.call(t);
                }, 200);
            }, function () {
                var t = this;
                clearTimeout(hoverTimer);
                outTimer = setTimeout(function () {
                    outEvent.call(t);
                }, 200);
            });
        });
    }
})(jQuery);