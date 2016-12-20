/**
 * Created by Jan on 29.11.2016.
 */
$(document).ready(function () {
    resize();
    setActiveListMember();
});
function resize() {
    var navbarHeight = $(".navbar")[0].clientHeight;
    $(".dashboard")[0].style.paddingTop = navbarHeight + "px";
}

function setActiveListMember() {
    var idOfCurrentMovie = window.location.pathname.replace(/.*\D(?=\d)|\D+$/g, "");
    if(idOfCurrentMovie == 0) idOfCurrentMovie = "";
    $(".list-group-item").each(function (i, obj) {
        if(obj.id == idOfCurrentMovie) {
            $(this).addClass("active");
        }
        else {
            $(this).removeClass("active");
        }
    });
}