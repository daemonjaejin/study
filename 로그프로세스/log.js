/**
 * Created by jin on 15. 10. 13..
 */
var ip = ip();
var referer = parent.document.referrer;
var url = document.location.href;
var platform = navigator.platform;
var browserName = navigator.appName;
var browserCodeName = navigator.appCodeName;
var browserVersion = navigator.appVersion;
var browserLanguage = navigator.language;
var browserOnline = navigator.onLine;
var cookiesEnabled = navigator.cookieEnabled;

$.ajax({
    type: 'POST',
    url: '/common/log',
    data: {
        "ip":ip,
        "referer":referer,
        "url":url,
        "platform":platform,
        "browserName":browserName,
        "browserCodeName":browserCodeName,
        "browserVersion":browserVersion,
        "browserLanguage":browserLanguage,
        "browserOnline":browserOnline,
        "cookiesEnabled":cookiesEnabled
    },
    success:function(data){

    },
    error: function (errormessage) {

    }
});