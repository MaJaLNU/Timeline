/**
 * Created by damma on 05.12.2016.
 */
$(document).ready(function () {
    var my_posts = $("[rel=tooltip]");

    var size = $(window).width();
    for (i = 0; i < my_posts.length; i++) {
        the_post = $(my_posts[i]);

        if (the_post.hasClass('invert') && size >= 767) {
            the_post.tooltip({placement: 'left'});
            the_post.css("cursor", "pointer");
        } else {
            the_post.tooltip({placement: 'rigth'});
            the_post.css("cursor", "pointer");
        }
    }
});

/* source: http://www.tutorialrepublic.com/codelab.php?topic=faq&file=play-youtube-video-in-bootstrap-modal */
$(document).ready(function () {
    /* Get iframe src attribute value i.e. YouTube video url and store it in a variable */
    var numberOfMovies = $(".row").length;
    var urls = [numberOfMovies];
    for (i = 0; i < numberOfMovies; i++) {
        urls[i] = $("#trailer-" + i).attr('src');
    }

    var myModals = [numberOfMovies];
    for (j = 0; j < numberOfMovies; j++) {
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