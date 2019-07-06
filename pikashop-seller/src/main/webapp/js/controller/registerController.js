app.controller('registerController',function ($scope,registerService) {
    $scope.register=function(){
        registerService.register($scope.seller).success(
            function (response) {
                if(response.status){
                    location.href = 'login.html';
                }else{
                    alert(response.message);
                }
            }
        )
    }
})