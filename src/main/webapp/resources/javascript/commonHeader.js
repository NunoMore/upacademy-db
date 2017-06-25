//
//
////mudar opacidade com scrolling
////var target = $('#header_bar');
////var targetHeight = target.outerHeight();
////
////$(document).scroll(function(e){
////    var scrollPercent = (targetHeight - window.scrollY) / targetHeight;
////    if(scrollPercent >= 0){
////        target.css('opacity', 1.7-scrollPercent);
////    }
////});
//
//
//
//
//$(function(){
//	  $('#header_bar').data('size','big');
//	});
//	
//	// on key press
//	$(document).ready(function(){
//	    $(document).keypress(function(){
//	    	$('#header_bar').data('size','small');
//	        $('#header_bar').stop().animate({
//	            height:'40px'
//	        },600);
//	        $('#upAcademyHeader').hide();
//	    });
//	});
//	
//	// scroll
//	$(window).scroll(function(){
//	  if($(document).scrollTop() > 0)
//	{
//	    if($('#header_bar').data('size') == 'big')
//	    {
//	        $('#header_bar').data('size','small');
//	        $('#header_bar').stop().animate({
//	            height:'40px'
//	        },600);
//	        $('#upAcademyHeader').hide();
//	    }
//	}
//	else
//	  {
//	    if($('#header_bar').data('size') == 'small')
//	      {
//	        $('#header_bar').data('size','big');
//	        $('#header_bar').stop().animate({
//	            height:'150px'
//	        },600);
//	        $('#upAcademyHeader').show();
//	      }  
//	  }
//	});
