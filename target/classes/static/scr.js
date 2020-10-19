$(function(){
    $("#login-form").submit(function(event) {
        event.preventDefault();

        var formData = new FormData(document.getElementById('login-form'));

        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/login');
        xhr.send(formData);

        xhr.onload = function() {
            if (xhr.status != 200) {
                $("#login-failure").removeClass("d-none");
                $("#login-failure").html("Incorrect email or password. Try again");
            } else {
                location.reload();
            }
        };
    });
});

$(function(){
    $("#signUp-form").submit(function(event) {
        event.preventDefault();

        var formData = new FormData(document.getElementById('signUp-form'));

        var xhr = new XMLHttpRequest();
        xhr.open('POST', '/signUp');
        xhr.send(formData);

        xhr.onload = function() {
            if (xhr.status != 200) {
                $("#signUp-failure").removeClass("d-none");
                $("#signUp-failure").html("This email address has already been registered");
            } else {
                location.reload();
            }
        };
    });
});

var el = document.getElementById('carousel');

if (el != null) {
    Hammer(el).on('swiperight', function() {
        $(el).carousel('prev');
      }).on('swipeleft', function() {
        $(el).carousel('next');
      })
}

$(function(){
    $( window ).resize(function() {
        if($(window).height() < $(document).height()) {
            $(".modal-dialog").removeClass("modal-dialog-centered");
        } else {
            $(".modal-dialog").addClass("modal-dialog-centered");
        }
      });
    
})

$( document ).ready(function() {
    if($(window).height() < $(document).height()) {
        $(".modal-dialog").removeClass("modal-dialog-centered");
    } else {
        $(".modal-dialog").addClass("modal-dialog-centered");
    }
    
    if($(window).width() < 760) {
        $("#navbarDropdown").css('display', 'none');
        $("#iconicDropdown").css('display', 'block');
    } else {
        $("#navbarDropdown").css('display', 'block');
        $("#iconicDropdown").css('display', 'none');
    }
});

$(function(){
    $(window).resize(function() {
        if($(window).width() < 760) {
            $("#navbarDropdown").css('display', 'none');
            $("#iconicDropdown").css('display', 'block');
        } else {
            $("#navbarDropdown").css('display', 'block');
            $("#iconicDropdown").css('display', 'none');
        }
    })
})

$(function(){
    if ($("#communityBody") != null) {

        $('div[id=post-rate]').each(function(){
            var rate = +$(this).text();
            for (var i = 1; i <= rate; i++) {
                $('#rate-star' + i, $(this).siblings()).addClass('active');
            } 
        });
    }
})






