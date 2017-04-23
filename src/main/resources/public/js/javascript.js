// JavaScript Document

/*
 * jQuery Easing v1.3 - http://gsgd.co.uk/sandbox/jquery/easing/
 *
 * Uses the built in easing capabilities added In jQuery 1.1
 * to offer multiple easing options
 *
 * TERMS OF USE - jQuery Easing
 * 
 * Open source under the BSD License. 
 * 
 * Copyright Â© 2008 George McGinley Smith
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without modification, 
 * are permitted provided that the following conditions are met:
 * 
 * Redistributions of source code must retain the above copyright notice, this list of 
 * conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright notice, this list 
 * of conditions and the following disclaimer in the documentation and/or other materials 
 * provided with the distribution.
 * 
 * Neither the name of the author nor the names of contributors may be used to endorse 
 * or promote products derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY 
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF
 * MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE
 *  COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL,
 *  EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE
 *  GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED 
 * AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING
 *  NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED 
 * OF THE POSSIBILITY OF SUCH DAMAGE. 
 *
*/

// t: current time, b: begInnIng value, c: change In value, d: duration
jQuery.easing['jswing'] = jQuery.easing['swing'];

jQuery.extend( jQuery.easing,
{
	def: 'easeOutQuad',
	swing: function (x, t, b, c, d) {
		//alert(jQuery.easing.default);
		return jQuery.easing[jQuery.easing.def](x, t, b, c, d);
	},
	easeInQuad: function (x, t, b, c, d) {
		return c*(t/=d)*t + b;
	},
	easeOutQuad: function (x, t, b, c, d) {
		return -c *(t/=d)*(t-2) + b;
	},
	easeInOutQuad: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t + b;
		return -c/2 * ((--t)*(t-2) - 1) + b;
	},
	easeInCubic: function (x, t, b, c, d) {
		return c*(t/=d)*t*t + b;
	},
	easeOutCubic: function (x, t, b, c, d) {
		return c*((t=t/d-1)*t*t + 1) + b;
	},
	easeInOutCubic: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t + b;
		return c/2*((t-=2)*t*t + 2) + b;
	},
	easeInQuart: function (x, t, b, c, d) {
		return c*(t/=d)*t*t*t + b;
	},
	easeOutQuart: function (x, t, b, c, d) {
		return -c * ((t=t/d-1)*t*t*t - 1) + b;
	},
	easeInOutQuart: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t*t + b;
		return -c/2 * ((t-=2)*t*t*t - 2) + b;
	},
	easeInQuint: function (x, t, b, c, d) {
		return c*(t/=d)*t*t*t*t + b;
	},
	easeOutQuint: function (x, t, b, c, d) {
		return c*((t=t/d-1)*t*t*t*t + 1) + b;
	},
	easeInOutQuint: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return c/2*t*t*t*t*t + b;
		return c/2*((t-=2)*t*t*t*t + 2) + b;
	},
	easeInSine: function (x, t, b, c, d) {
		return -c * Math.cos(t/d * (Math.PI/2)) + c + b;
	},
	easeOutSine: function (x, t, b, c, d) {
		return c * Math.sin(t/d * (Math.PI/2)) + b;
	},
	easeInOutSine: function (x, t, b, c, d) {
		return -c/2 * (Math.cos(Math.PI*t/d) - 1) + b;
	},
	easeInExpo: function (x, t, b, c, d) {
		return (t==0) ? b : c * Math.pow(2, 10 * (t/d - 1)) + b;
	},
	easeOutExpo: function (x, t, b, c, d) {
		return (t==d) ? b+c : c * (-Math.pow(2, -10 * t/d) + 1) + b;
	},
	easeInOutExpo: function (x, t, b, c, d) {
		if (t==0) return b;
		if (t==d) return b+c;
		if ((t/=d/2) < 1) return c/2 * Math.pow(2, 10 * (t - 1)) + b;
		return c/2 * (-Math.pow(2, -10 * --t) + 2) + b;
	},
	easeInCirc: function (x, t, b, c, d) {
		return -c * (Math.sqrt(1 - (t/=d)*t) - 1) + b;
	},
	easeOutCirc: function (x, t, b, c, d) {
		return c * Math.sqrt(1 - (t=t/d-1)*t) + b;
	},
	easeInOutCirc: function (x, t, b, c, d) {
		if ((t/=d/2) < 1) return -c/2 * (Math.sqrt(1 - t*t) - 1) + b;
		return c/2 * (Math.sqrt(1 - (t-=2)*t) + 1) + b;
	},
	easeInElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		return -(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
	},
	easeOutElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d)==1) return b+c;  if (!p) p=d*.3;
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		return a*Math.pow(2,-10*t) * Math.sin( (t*d-s)*(2*Math.PI)/p ) + c + b;
	},
	easeInOutElastic: function (x, t, b, c, d) {
		var s=1.70158;var p=0;var a=c;
		if (t==0) return b;  if ((t/=d/2)==2) return b+c;  if (!p) p=d*(.3*1.5);
		if (a < Math.abs(c)) { a=c; var s=p/4; }
		else var s = p/(2*Math.PI) * Math.asin (c/a);
		if (t < 1) return -.5*(a*Math.pow(2,10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )) + b;
		return a*Math.pow(2,-10*(t-=1)) * Math.sin( (t*d-s)*(2*Math.PI)/p )*.5 + c + b;
	},
	easeInBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158;
		return c*(t/=d)*t*((s+1)*t - s) + b;
	},
	easeOutBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158;
		return c*((t=t/d-1)*t*((s+1)*t + s) + 1) + b;
	},
	easeInOutBack: function (x, t, b, c, d, s) {
		if (s == undefined) s = 1.70158; 
		if ((t/=d/2) < 1) return c/2*(t*t*(((s*=(1.525))+1)*t - s)) + b;
		return c/2*((t-=2)*t*(((s*=(1.525))+1)*t + s) + 2) + b;
	},
	easeInBounce: function (x, t, b, c, d) {
		return c - jQuery.easing.easeOutBounce (x, d-t, 0, c, d) + b;
	},
	easeOutBounce: function (x, t, b, c, d) {
		if ((t/=d) < (1/2.75)) {
			return c*(7.5625*t*t) + b;
		} else if (t < (2/2.75)) {
			return c*(7.5625*(t-=(1.5/2.75))*t + .75) + b;
		} else if (t < (2.5/2.75)) {
			return c*(7.5625*(t-=(2.25/2.75))*t + .9375) + b;
		} else {
			return c*(7.5625*(t-=(2.625/2.75))*t + .984375) + b;
		}
	},
	easeInOutBounce: function (x, t, b, c, d) {
		if (t < d/2) return jQuery.easing.easeInBounce (x, t*2, 0, c, d) * .5 + b;
		return jQuery.easing.easeOutBounce (x, t*2-d, 0, c, d) * .5 + c*.5 + b;
	}
});
 
 /*
 * jQuery Infinite Carousel
 * @author admin@catchmyfame.com - http://www.catchmyfame.com
 * @version 3.0.3
 * @date January 24, 2013
 * @category jQuery plugin
 * @copyright (c) admin@catchmyfame.com (www.catchmyfame.com)
 * @license CC Attribution-Share Alike 3.0 - http://creativecommons.org/licenses/by-sa/3.0/
 */
(function(a){a.fn.extend({infiniteCarousel:function(b){var c={transitionSpeed:800,displayTime:6000,displayProgressRing:true,progressRingColorOpacity:"0,0,0,.5",progressRingBackgroundOn:true,progressRingBackgroundColorOpacity:"255,255,255,.5",thumbnailType:"none",easeLeft:"linear",easeRight:"linear",imagePath:"/js/infinitecarousel/images/",inView:1,margin:0,advance:1,customClass:null,showControls:true,autoHideCaptions:false,autoPilot:false,prevNextInternal:true,internalThumbnails:false,enableKeyboardNav:true,onSlideStart:function(){},onSlideEnd:function(){},onPauseClick:function(){},onPlayClick:function(){}};var b=a.extend(c,b);return this.each(function(){var w=b;var r=a(this);var H=Math.round(Math.random()*100000000);var s=a("li",r).length;var e=[];var g=[];var D=[];var G=[];var v,F;var A,I;var h;var q,p=0;var k="HTMLCanvasElement" in window;a("li",r).each(function(i){e.push(a("p",this).html());g.push(a("a",this).attr("href"));G.push(a(this).find("iframe").attr("longdesc"));D.push(a(this).find("img, iframe").attr("src"))});if(w.inView>s){w.inView=s}if(w.advance>w.inView){w.advance=w.inView}v=a(this).find("img, iframe").width();F=a(this).find("img, iframe").height();a(r).replaceWith('<div class="infiniteCarousel" id="ic_'+H+'">');r=a("#ic_"+H);a(r).height(F).width(v*w.inView).css({overflow:"hidden",position:"relative"});a(r).append('<div class="ic_tray" style="position:relative;width:'+(s*2)*v+"px;left:-"+v+'px">');for(var C=0;C<s;C++){a("div.ic_tray",r).append('<div style="overflow:hidden;background:url('+w.imagePath+"wait.gif) no-repeat scroll 50% 50% #ddd;float:left;position:relative;width:"+v+"px;height:"+F+'px;" class="infiniteCarousel_item">')}a(".infiniteCarousel_item",r).each(function(o){if(D[o].indexOf("youtube.com")>0||D[o].indexOf("vimeo.com")>0||D[o].indexOf("funnyordie.com")>0){var i=D[o].split("?");a(this).append('<iframe src="'+i[0]+"?wmode=opaque&"+i[1]+'" frameborder="0" allowfullscreen="" style="width: '+v+"px; height: "+F+'px">" />');if(g[o]!=undefined){a("iframe",this).wrap('<a class="ic_link" href="'+g[o]+'"></a>')}}else{a(this).append('<img src="'+D[o]+'" />');if(g[o]!=undefined){a("img",this).wrap('<a class="ic_link" href="'+g[o]+'"></a>')}}if(e[o]!=undefined){a(this).append('<div class="ic_caption" style="position:absolute;bottom:0;">'+e[o]+"</div>")}});a(".infiniteCarousel_item",r).clone().appendTo(a("div.ic_tray",r));a(".infiniteCarousel_item",r).each(function(i){a(this).attr("id","ic_"+H+"_"+i)});a(".ic_tray",r).prepend(a(".infiniteCarousel_item:last",r).remove());if(w.margin!=0){a(r).width(a(r).width()+(w.inView+1)*w.margin).height(a(r).height()+2*w.margin);a(".infiniteCarousel_item",r).css("margin",w.margin+"px 0px "+w.margin+"px "+w.margin+"px");a(".ic_tray",r).css("left",parseInt(a(".ic_tray",r).css("left"))-w.margin+"px").width(a(".ic_tray",r).width()+w.margin*(s*2))}a(r).append('<div class="ic_left_nav" style="position:absolute;left:0;width:32px;top:'+(F/2-16)+'px;">').append('<div class="ic_right_nav" style="position:absolute;width:32px;right:0;top:'+(F/2-16)+'px;">');a(".ic_left_nav",r).append('');a(".ic_right_nav",r).append('');if(!w.prevNextInternal&&(parseInt(a(r).css("border-left-width"))+parseInt(a(r).css("border-right-width")))>0){a(".ic_right_nav",r).css("right","-"+(parseInt(a(r).css("border-left-width"))+parseInt(a(r).css("border-right-width")))+"px")}a(".ic_left_nav img",r).on("click",function(i){if(!a(".ic_tray",r).is(":animated")){y();j(w.advance)}});a(".ic_right_nav img",r).on("click",function(i){if(!a(".ic_tray",r).is(":animated")){y();d(w.advance)}});if(w.inView==s){w.displayProgressRing=false;w.thumbnailType="none";w.showControls=false;w.autoPilot=false;w.enableKeyboardNav=false;a(".ic_left_nav,.ic_right_nav",r).hide()}if(!w.prevNextInternal){a(r).wrap('<div id="ic_'+H+'_wrapper" class="ic_wrapper" style="padding:0 32px;position:relative;">');a("#ic_"+H+"_wrapper").width(a(r).width());a("#ic_"+H+"_wrapper").prepend(a(".ic_left_nav",r).detach());a("#ic_"+H+"_wrapper").prepend(a(".ic_right_nav",r).detach())}else{a(r).hover(function(){a(".ic_left_nav",r).stop().animate({opacity:1,left:"0px"},300);a(".ic_right_nav",r).stop().animate({opacity:1,right:"0px"},300)},function(){a(".ic_left_nav",r).stop().animate({opacity:0,left:"-32px"},500);a(".ic_right_nav",r).stop().animate({opacity:0,right:"-32px"},500)})}a("#ic_"+H).addClass("ic_peek_padding");a("#ic_"+H+"_wrapper").width(a(r).width()+parseInt(a("#ic_"+H).css("padding-left"))+parseInt(a("#ic_"+H).css("padding-right")));if(w.thumbnailType!="none"){a(r).append('<div id="ic_'+H+'_thumbnail_tray" class="ic_thumbnail_tray" style="position:absolute;bottom:0;padding:5px 0;width:100%;text-align:center;">');a("#ic_"+H+"_thumbnail_tray").append('<div class="ic_thumbnails">');for(var C=0;C<s;C++){a(".ic_thumbnails",r).append('<div class="ic_button" style="cursor:pointer">')}for(var C=0;C<w.inView;C++){a(".ic_button:eq("+C+")",r).addClass("ic_active")}a(".ic_button").hover(function(){if(!a(this).hasClass("ic_active")){a(this).css("background","#699")}},function(){a(this).css("background","")});if(w.thumbnailType=="images"){a(".ic_button",r).each(function(i){if(D[i]!=undefined){thumbImage=D[i]}if(G[i]!=undefined){thumbImage=G[i]}a(this).append('<img width="100%" height="100%" src="'+thumbImage+'" />')})}if(w.thumbnailType=="numbers"){a(".ic_button",r).each(function(i){a(this).html(i+1)})}if(w.thumbnailType=="count"){a(".ic_button",r).remove();a(".ic_thumbnails",r).html("<span>1</span> of "+s);B()}if(!w.internalThumbnails){if(!a("#ic_"+H+"_wrapper").length){a(r).wrap('<div id="ic_'+H+'_wrapper" class="ic_wrapper" style="position:relative;">');a("#ic_"+H+"_wrapper").width(a(r).width())}a("#ic_"+H+"_thumbnail_tray").css({bottom:"",position:"relative"}).appendTo(a("#ic_"+H+"_wrapper"))}var x=(a("#ic_"+H+"_wrapper").length)?a("#ic_"+H+"_wrapper"):r;a(".ic_button",x).on("click",function(){if(!a(".ic_tray",r).is(":animated")){y();var K=parseInt(a(".infiniteCarousel_item:eq(1)",r).attr("id").split("_").pop());var J=a(this).index();if(K>(s-1)){K-=s}var o=Math.abs(K-J);var i=s-o;var u=Math.min(o,i);if(K<J){if(o<i||o==i){d(u)}if(o>i){j(u)}}if(K>J){if(o<i){j(u)}if(o>i||o==i){d(u)}}}})}if((!w.prevNextInternal||!w.internalThumbnails)&&w.customClass!==null){a("#ic_"+H+"_wrapper").addClass("ic_"+w.customClass)}else{if(w.customClass!==null){a(r).addClass("ic_"+w.customClass)}}if(w.enableKeyboardNav){a(document).keydown(function(i){if(i.keyCode==39){if(!a(".ic_tray",r).is(":animated")){y();d(w.advance)}}if(i.keyCode==37){if(!a(".ic_tray",r).is(":animated")){y();j(w.advance)}}if(i.keyCode==80||i.keyCode==111){if(!a(".ic_tray",r).is(":animated")){if(w.autoPilot){l()}}}if(i.keyCode==83||i.keyCode==115){if(!a(".ic_tray",r).is(":animated")){E()}}})}if(w.showControls){a(r).append('<div id="ic_controls_'+H+'" class="ic_controls" style="background:url('+w.imagePath+'controls.png) no-repeat -12px 0;opacity:.5;cursor:pointer;height:10px;position:absolute;right:9px;top:10px;width:10px;z-index:1">');if(!w.autoPilot){a("#ic_controls_"+H).css("background-position","1px 0")}a(".ic_controls",r).on("click",function(){if(!a(".ic_tray",r).is(":animated")){if(w.autoPilot){l()}else{E()}}})}if(k){a(r).append('<canvas id="ic_canvas_'+H+'" width="30" height="30" style="position:absolute;top:0;right:0;"></canvas>');var z=a("#ic_canvas_"+H)[0].getContext("2d");z.lineWidth=3;z.strokeStyle="rgba("+w.progressRingColorOpacity+")";z.shadowOffsetX=0;z.shadowOffsetY=0;z.shadowBlur=3;z.shadowColor="#fff";if(!w.displayProgressRing){a("#ic_canvas_"+H).hide()}}else{a(r).append('<div id="ic_ie_timer_'+H+'" style="width:100%;height:6px;position:absolute;bottom:0;left:0;background:#ccc"></div>');a("#ic_ie_timer_"+H).css("opacity",".25")}function t(){if(w.autoHideCaptions){a(".ic_caption",r).stop().animate({bottom:-F+"px"})}}function n(){if(w.autoHideCaptions){a(".ic_caption",r).stop().animate({bottom:"0px"})}}function B(){thumbButtonStart=parseInt(a(".infiniteCarousel_item",r).attr("id").split("_").pop())+1;if(thumbButtonStart>(s-1)){thumbButtonStart-=s}if(w.thumbnailType=="count"){var J=[];for(var u=thumbButtonStart;u<thumbButtonStart+w.inView;u++){J.push(((u+1)>s)?(u+1)-s:(u+1))}var K=J.pop();var o=(w.inView>1)?" & ":"";a(".ic_thumbnails span",x).text(J.join(", ")+o+K)}for(var u=thumbButtonStart;u<thumbButtonStart+w.inView;u++){(u>s-1)?a(".ic_button:eq("+Math.abs(s-u)+")",x).addClass("ic_active"):a(".ic_button:eq("+u+")",x).addClass("ic_active")}}function j(i){w.onSlideStart.call(this);a(".ic_button",x).removeClass("ic_active");a(".infiniteCarousel_item",r).slice(-i).prependTo("#ic_"+H+" .ic_tray",r);a(".ic_tray",r).css({left:"-="+(v*i)+"px"});a(".ic_tray",r).stop().animate({left:"+="+v*i+"px"},w.transitionSpeed,w.easeRight,function(){n();B();w.onSlideEnd.call(this)});t()}function d(i){w.onSlideStart.call(this);a(".ic_button",x).removeClass("ic_active");a(".ic_tray",r).stop().animate({left:"-="+(v+w.margin)*i+"px"},w.transitionSpeed,w.easeLeft,function(){a(".infiniteCarousel_item",r).slice(0,i).appendTo("#ic_"+H+" .ic_tray",r);a(".ic_tray",r).css({left:"-"+(v+w.margin)+"px"});n();B();w.onSlideEnd.call(this);if(w.autoPilot){m(w.displayTime)}});t()}function l(){w.onPauseClick.call(this);w.autoPilot=false;a("#ic_controls_"+H).css("background-position","1px 0");clearInterval(h);p=q}function E(){w.autoPilot=true;if(w.autoPilot&&!a(".ic_tray",r).is(":animated")){m(w.displayTime)}a("#ic_controls_"+H).css("background-position","-12px 0")}function y(){w.onPlayClick.call(this);w.autoPilot=false;f();a("#ic_controls_"+H).css("background-position","1px 0");clearInterval(h)}function m(i){var o=new Date().getTime(),u,J=0;h=setInterval(function(){if(J<359){u=new Date().getTime();q=(u-o)+p;J=Math.floor(q/i*360);if(J>359){J=359}if(k){z.clearRect(0,0,30,30);z.save();z.translate(15,15);z.rotate(-Math.PI/2);if(w.progressRingBackgroundOn){z.strokeStyle="rgba("+w.progressRingBackgroundColorOpacity+")";z.beginPath();z.arc(0,0,10,0,(360*(Math.PI/180)),true);z.stroke();z.strokeStyle="rgba("+w.progressRingColorOpacity+")"}z.beginPath();z.arc(0,0,10,0,(J*(Math.PI/180)),true);z.stroke();z.restore()}else{a("#ic_ie_timer_"+H,r).css("width",99-Math.floor((q/i)*100)+"%")}}else{p=0;clearInterval(h);d(w.advance)}},20)}function f(){p=0;if(k){z.clearRect(0,0,30,30);z.save();z.translate(15,15);z.rotate(-Math.PI/2);z.beginPath();z.arc(0,0,10,0,(360*(Math.PI/180)),true);z.stroke();z.restore()}}if(w.autoPilot&&!a(".ic_tray",r).is(":animated")){m(w.displayTime)}else{f()}})}})})(jQuery);





      function validateForm(orderform){
        var x = /^[A-Za-z ]+$/
            var y =/^[A-Za-z0-9_]([\.-]?[A-Za-z0-9_])*@[A-Za-z0-9_]([\.-]?[A-Za-z0-9_])*(\.[A-Za-z]{2,3})+$/
        
        if (x.test(orderform.custname.value)){
          if(y.test(orderform.custemail.value)){
            getorder(orderform);
          return false;
          }
          else{
            alert("Invalid email!");
        return false;
          }
            } 
        else{alert("Invalid user name!");
        return false;
            } 
            
      
	result = document.getElementById('orderinfo');
      output = "Thanks " + orderform.custname.value;
	
	result.innerHTML = output;
	return false;					
}

