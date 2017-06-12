

//mudar opacidade com scrolling
var target = $('#header_bar');
var targetHeight = target.outerHeight();

$(document).scroll(function(e){
    var scrollPercent = (targetHeight - window.scrollY) / targetHeight;
    if(scrollPercent >= 0){
        target.css('opacity', 1.7-scrollPercent);
    }
});





