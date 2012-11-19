$(function() {
  $('a[rel=tooltip]').tooltip();//tooltip

// fix sub nav on scroll
  var $win = $(window)
    , $nav = $('#main-navbar')
    , navTop = $nav.length && $nav.offset().top
    , isFixed = 0;

  processScroll();

  // hack sad times - holdover until rewrite for 2.1
  $nav.on('click', function () {
    if (!isFixed) setTimeout(function () {  $win.scrollTop($win.scrollTop() - 47); }, 10);
  });

  $win.on('scroll', processScroll);

  function processScroll() {
    var scrollTop = $win.scrollTop();
    if (scrollTop >= navTop && !isFixed) {
      isFixed = 1;
      $nav.addClass('navbar-fixed-top');
    } else if (scrollTop <= navTop && isFixed) {
      isFixed = 0;
      $nav.removeClass('navbar-fixed-top');
    }
  }
//  $("#loginHref").click(function(e) {
//	  window.location.href = addParamToUrl($(this).attr("href"), "from=" + window.location.href);
//	  return false;
//  });
});
function addParamToUrl(url, paramStr) {
	if (url.indexOf("?") > 0) {
		return url + "&" + paramStr;
	} else {
		return url + "?" + paramStr;
	}
}
if (!Cookie) {
    /**
     * @description Cookie 相关操作
     * @static
     */
    var Cookie = {
        /**
         * @description 读取 cookie
         * @param {String} name cookie key
         * @returns {String} 对应 key 的值，如 key 不存在则返回 ""
         */
        readCookie: function (name) {
            var nameEQ = name + "=";
            var ca = document.cookie.split(';');
            for(var i=0;i < ca.length;i++) {
                var c = ca[i];
                while (c.charAt(0)==' ') c = c.substring(1,c.length);
                if (c.indexOf(nameEQ) == 0) return decodeURIComponent(c.substring(nameEQ.length,c.length));
            }
            return "";
        },
        
        /**
         * @description 清除 Cookie
         * @param {String} name 清除 key 为 name 的该条 Cookie
         */
        eraseCookie: function (name) {
            this.createCookie(name,"",-1);
        },

        /**
         * @description 创建 Cookie
         * @param {String} name 每条 Cookie 唯一的 key
         * @param {String} value 每条 Cookie 对应的值，将被 UTF-8 编码
         * @param {Int} days Cookie 保存时间
         */
        createCookie: function (name, value, days) {
            var expires = "";
            if (days) {
                var date = new Date();
                date.setTime(date.getTime()+(days*24*60*60*1000));
                expires = "; expires="+date.toGMTString();
            }
            document.cookie = name+"="+encodeURIComponent(value)+expires+"; path=/";
        }
    };
}