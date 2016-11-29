/**
 * Created by Jan on 29.11.2016.
 */
$(document).ready(function () {
    resize();
});
function resize() {
    var navbarHeight = $(".navbar")[0].clientHeight;
    $(".dashboard")[0].style.paddingTop = navbarHeight + "px";
}
