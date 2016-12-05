/**
 * Created by Jan on 29.11.2016.
 */

var doScroll = function (e) {

    e = window.event || e;
    var delta = Math.max(-1, Math.min(1, (e.wheelDelta || -e.detail)));

    var widthOfOneFilm = $(".row")[0].clientWidth;
    window.scrollBy(-delta * widthOfOneFilm, 0);
    e.preventDefault();
};

if (window.addEventListener) {
    window.addEventListener("mousewheel", doScroll, false);
    window.addEventListener("DOMMouseScroll", doScroll, false);
} else {
    window.attachEvent("onmousewheel", doScroll);
}


// script for aligning the timeline elements vertically centered

$(document).ready(function () {
    resize();
});
function resize() {
    // set the height of content according to the navigation bar
    var navbarHeight = $(".navbar")[0].clientHeight;
    $(".test-wide")[0].style.height = (window.innerHeight - navbarHeight) + "px";

    $(".timeline")[0].style.paddingTop = navbarHeight + "px";

    // set the max height of the image and description according to the height of content
    var imageHeight = (window.innerHeight - navbarHeight) * 0.67;
    var maxImageWidth = $(".image-holder")[0].clientWidth;
    $(".thumbnail img").each(function () {
        $(this).css("max-height", imageHeight);
        $(this).css("max-width", maxImageWidth);
    });
    $(".caption").each(function () {
        $(this).css("height", imageHeight);
    });

    // set the max height of the table to not overflow the thumbnail
    var tableMaxHeight = $(".caption").height() - $("h3").outerHeight(true) - parseInt($("h3").css("margin-top"));
    $(".table-responsive").each(function () {
        $(this).css("max-height", tableMaxHeight);
    });
}
window.onresize = function () {
    resize();
};


/* source: http://www.tutorialrepublic.com/codelab.php?topic=faq&file=play-youtube-video-in-bootstrap-modal */
$(document).ready(function () {
    /* Get iframe src attribute value i.e. YouTube video url and store it in a variable */
    var numberOfMovies = $(".row").length;
    var urls = [numberOfMovies];
    for(i = 0; i < numberOfMovies; i++) {
        urls[i] = $("#trailer-" + i).attr('src');
    }

    var myModals = [numberOfMovies];
    for(j = 0; j < numberOfMovies; j++) {
        myModals[j] = $("#myModal-" + j);
    }

    $.each(myModals, function (index) {
        var idString = "#trailer-" + index;

        // Assign empty url value to the iframe src attribute when modal hide, which stop the video playing
        $(this).on('hide.bs.modal', function () {
            $(idString).attr('src', '');
        });

        // Assign stored url value to the iframe src attribute when modal shown
        $(this).on('show.bs.modal', function () {
            $(idString).attr('src', urls[index]);
        });
    });
});