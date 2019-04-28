angular.module('taskDirectives', [])
  .directive('taskPanel', function () {

    const ddo = {};
    
    ddo.restrict = "AE";

    ddo.scope = {
      title: '@',
      description: '@',
      finished: '@'
    }

    ddo.transclude = true;
    ddo.templateUrl = 'js/directives/task-panel.html'
      
    return ddo;
});
