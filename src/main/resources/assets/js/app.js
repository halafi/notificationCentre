var notificationCentreApp = angular.module('notificationCentreApp', ['ui.router', 'services', 'controllers']);

notificationCentreApp.config(function ($stateProvider) {
    $stateProvider
        .state('index', {
            url: '/'
        });
}).run(function ($state) {
    $state.go('index');
});