var services = angular.module('services', ['ngResource']);

services.factory('NotificationService', ['$resource', function ($resource) {
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