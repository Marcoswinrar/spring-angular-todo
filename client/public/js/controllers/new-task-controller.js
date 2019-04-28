angular.module('todo-ui').controller('NewTaskController', function ($scope, $http, $routeParams) {

  const api = 'http://localhost:8080/api/v1/todo-item/';

  $scope.task = {};
  $scope.resultMessage = '';

  // Check if route has params and init data to update!
  if ($routeParams.id) {
    $http.get(api + $routeParams.id)
      .success((task) => $scope.task = task)
      .error(err => console.log(err))
  }

  // Add task!
  $scope.addTask = function () {

    if ($scope.form.$valid) {

      if ($scope.task.id) {

        // Set modified date for updated items !
        const modifiedDate = new Date();
        $scope.task.modifiedDate = modifiedDate;

        $http.put(api + $scope.task.id, $scope.task)
          .success(() => {
            $scope.resultMessage = 'Task ' + $scope.task.title + ' has updated!';
            $scope.task = {}
          })
          .error(err => console.log(err));
      } else {

        // Set creation date for new tasks !
        const creationDate = new Date();
        $scope.task.creationDate = creationDate;

        $http.post(api, $scope.task)
          .success(() => {
            $scope.resultMessage = 'Task inserted successfully!';
            $scope.task = {}
          })
          .error(err => console.log(err));
      }
    }
  }
});