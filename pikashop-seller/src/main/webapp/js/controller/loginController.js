app.controller('loginController', function ($scope, loginService) {
    $scope.loginSeller = function(){
        loginService.loginSeller().success(
            function (response) {
                $scope.seller = response.data;
            }
        )
    }
} )