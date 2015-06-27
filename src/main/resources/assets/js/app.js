var notificationCentreApp = angular.module('notificationCentreApp', ['angular.filter', 'ui.router', 'services', 'controllers']);

notificationCentreApp.config(function () {

});

var services = angular.module('services', ['ngResource']).factory('NotificationService', ['$resource', function ($resource) {
    return $resource('notificationCentre/notification/:notId', {notId: '@id'}, {
        query: {
            method: 'GET', isArray: true, interceptor: {responseError: handleResponseError}
        },
        save: {
            method: 'POST', interceptor: {responseError: handleResponseError}
        },
        update: {
            method: 'PUT', interceptor: {responseError: handleResponseError}
        },
        get: {
            method: 'GET', interceptor: {responseError: handleResponseError}
        },
        remove: {
            method: 'DELETE', interceptor: {responseError: handleResponseError}
        }
    });
}]);

function handleResponseError() {
    alert("Internal server error.");
}

var controllers = angular.module('controllers', [])
    .controller('NotificationController', ['$scope', '$state', 'NotificationService', function ($scope, $state, Notification) {
        //$scope.orderProp = "eventType";
        $scope.notifications = Notification.query();
        $scope.selectedNotification = null;
        $scope.getTemplate = function (notification) {
            return 'display';
        };
        $scope.deleteNotification = function (notification) {
            Notification.remove({notId: notification.notificationGuid}, function () {
                $scope.notifications = Notification.query();
            });
        };
        $scope.viewNotification = function (notification) {
            $scope.selectedNotification = angular.copy(notification);
        };
    }]);