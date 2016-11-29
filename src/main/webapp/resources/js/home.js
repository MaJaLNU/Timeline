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
    var navbarHeight = $(".navbar")[0].clientHeight;
    $(".test-wide")[0].style.height = (window.innerHeight - navbarHeight) + "px";

    $(".timeline")[0].style.paddingTop = navbarHeight + "px";
}
window.onresize = function () {
    resize();
};


/* source: http://www.tutorialrepublic.com/codelab.php?topic=faq&file=play-youtube-video-in-bootstrap-modal
 TODO: needs to be adjusted to handle multiple videos!
 */


$(document).ready(function () {
    /* Get iframe src attribute value i.e. YouTube video url
     and store it in a variable */
    //var url = $("#trailer-1").attr('src');

    var numberOfMovies = $(".row").length;
    var urls = [numberOfMovies];
    for(i = 0; i < numberOfMovies; i++) {
        urls[i] = $("#trailer-" + i).attr('src');
    }

    /* Assign empty url value to the iframe src attribute when
     modal hide, which stop the video playing */
    //var myModal = $("#myModal");

    var myModals = [numberOfMovies];
    for(j = 0; j < numberOfMovies; j++) {
        myModals[j] = $("#myModal-" + j);
        window.console&&console.log("modal: " + j);
    }

    for(k = 0; k < numberOfMovies; k++) {
        myModals[k].on('hide.bs.modal', function () {
            $("#trailer-" + k).attr('src', '');
        });
        window.console&&console.log("set hide modal: " + k);
        myModals[k].on('show.bs.modal', function () {
            $("#trailer-" + k).attr('src', urls[k]);
        });
        window.console&&console.log("set show modal: " + k);
    }
    /*
    myModal.on('hide.bs.modal', function () {
        $("#trailer-1").attr('src', '');
    });
*/


    /* Assign the initially stored url back to the iframe src
     attribute when modal is displayed again */
    /*
    myModal.on('show.bs.modal', function () {
        $("#trailer-1").attr('src', url);
    });
    */
});