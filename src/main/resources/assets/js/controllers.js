var controllers = angular.module('controllers', []);

controllers
    .controller('NotificationController', ['$scope', '$state', 'NotificationService', function ($scope, $state, Notification) {
        $scope.orderProp = "eventType";
        $scope.notifications = Notification.query();
        $scope.getTemplate = function (notification) {
            return 'display';
        };
        $scope.deleteNotification = function (id) {
            Notification.remove({notId: id}, function () {
                $scope.notifications = Notification.query();
            });
        };
    }]);