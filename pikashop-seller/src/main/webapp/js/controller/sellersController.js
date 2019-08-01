app.config(['$locationProvider', function ($locationProvider) {
    $locationProvider.html5Mode({
        enabled: true,
        requireBase: false//必须配置为false，否则<base href=''>这种格式带base链接的地址不能解析
    });
}]);
app.controller('sellerController', function ($scope,$location,sellerService) {
    $scope.sellerId = $location.search()['id'];
    $scope.showDetail = function () {
        sellerService.findOne($scope.sellerId).success(
            function (response) {
                $scope.seller = response;
            }
        )
    }
    $scope.save = function () {
        sellerService.save($scope.seller).success(
            function (response) {
                if(response.status){
                    parent.location.reload();
                }else {
                    alert(response.message);
                }
            }
        )
    }
    $scope.changePassword = function () {
         if($scope.newPassword === $scope.confirmPassword){
             sellerService.changePassword($scope.sellerId, $scope.oldPassword, $scope.newPassword).success(
                 function (response) {
                     if(response.status){
                         parent.location.reload();
                     }
                 }
             )
        }else {
             alert("两次输入不一致");
         }
    }
})