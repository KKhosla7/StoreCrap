/**
 * Created by karan.khosla on 3/10/14.
 */


'use strict';


var EmpCtrl = function ($scope, $http) {

    $scope.store = {};
    $scope.editMode = false;

    $scope.fetchAllEmployees = function () {
        $http.get('api/employee/employeelist.json').success(function (empList) {
            $scope.employees = empList;
        })
    };

    $scope.addEmployee = function (store) {
        $http.post('api/employee/addEmployee', store).success(function () {
            $scope.fetchAllEmployees();
            $scope.store.firstName = '';
            $scope.store.middleName = '';
            $scope.store.lastName = '';
            $scope.store.age = '';
            $scope.store.contact = '';
            $scope.store.emailId = '';
            $scope.store.designation = '';
            $scope.store.project = '';
        }).error(function () {
            $scope.setError('Could not add a new Employee to Records.');
        });

    };

    $scope.editEmployeeDetails = function (store) {
        $scope.resetError();

        $scope.store = store;
        $scope.editMode = true;
    };

    $scope.updateEamployeeDetails = function (store) {
        $scope.resetError();

        $http.put('api/employee/updateEmployeeDetails', store).success(function () {
            $scope.fetchAllEmployees();
            $scope.store.firstName = '';
            $scope.store.middleName = '';
            $scope.store.lastName = '';
            $scope.store.age = '';
            $scope.store.contact = '';
            $scope.store.emailId = '';
            $scope.store.designation = '';
            $scope.store.project = '';
            $scope.editMode = false;
        }).error(function () {
            $scope.setError('Could not update the existing Employee Record.');
        });
    };

    $scope.deleteEmployee = function (employeeId) {
        $http.delete('api/employee/removeEmployee/' + employeeId).success(function () {
            $scope.fetchAllEmployees();
        }).error(function () {
            $scope.setError('Could not delete an existing Employee Record.');
        });
    };

    $scope.deleteAllEmployee = function () {
        $http.delete('api/employee/removeAllEmployees').success(function () {
            $scope.fetchAllEmployees();
        }).error(function () {
            $scope.setError('Failed to remove all Employees Record.');
        });
        $scope.fetchAllEmployees();
    };

    $scope.fltr = function() {

    };

    $scope.resetError = function () {
        $scope.error = false;
        $scope.errorMessage = '';
    };

    $scope.setError = function (message) {
        $scope.error = true;
        $scope.errorMessage = message;
    };

    $scope.fetchAllEmployees();

    $scope.predicate = 'id';
};

