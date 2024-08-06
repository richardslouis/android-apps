(function ($) {
 "use strict";
 

/*
	SCROLLUP
================================ */	

	$.scrollUp({
        scrollText: '<i class="zmdi zmdi-chevron-up"></i>',
        easingType: 'linear',
        scrollSpeed: 900,
        animation: 'fade'
    });
	

})(jQuery);


/*
	LODING BAR
================================ */	

jQuery(window).on().load(function(){
	var preeLoad = $('#loading');
	preeLoad.fadeOut(1000);
});
