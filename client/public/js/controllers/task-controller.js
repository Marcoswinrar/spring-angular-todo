angular.module('todo-ui').controller('TaskController', function ($scope, $http) {

  const api = 'http://localhost:8080/api/v1/todo-item/';

  $scope.tasks = [];
  $scope.taskFilter = '';
  $scope.resultMessage = '';

  // init all data!
  $http.get(api)
    .success(tasks => $scope.tasks = tasks)
    .error(err => console.log('Server error: ', err));


  // remove task from list based on id!
  $scope.remove = function (task) {

    $http.delete(api + task.id)
      .success(() => {
        const indexOfTask = $scope.tasks.indexOf(task);
        $scope.tasks.splice(indexOfTask, 1);

        $scope.resultMessage = 'Task ' + task.title + ' removed!';
      })
      .error((err) => console.log(err));
  }
});