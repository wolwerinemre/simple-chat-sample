/* Directives */
angular.module('simpleChatSample.directives', [])
	.directive('printMessage', function () {
	    return {
	    	restrict: 'A',
	        template: '<span ng-show="message.priv">[private] </span><strong>{{message.username}}<span ng-show="message.to"> -> {{message.to}}</span>:</strong> {{message.message}}<br/>'
	       
	    };
}).directive('printHistoryMessage', function () {
    return {
    	restrict: 'A',
        template: '<span  style="color:green"><small>({{message.messageDate | date : "dd/MM/yyyy HH:mm:ss" }}</small></span>) <strong>{{message.username}}<span ng-show="message.to"> --> {{message.to}}</span>:</strong style="colur:red;"> {{message.message}}<br/>'
       
    };
});

