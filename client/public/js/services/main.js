angular.module('todo-ui', ['taskDirectives', 'ngRoute'])
  .config(function ($routeProvider) {

    $routeProvider.when('/tasks', {
      templateUrl: './partials/main.html',
      controller: 'TaskController'
    })

    $routeProvider.when('/tasks/new', {
      templateUrl: './partials/task.html',
      controller: 'NewTaskController'
    });

    $routeProvider.when('/task/edit/:id', {
      templateUrl: './partials/task.html',
      controller: 'NewTaskController'
    });

    $routeProvider.otherwise({ redirectTo: '/tasks' });
  });