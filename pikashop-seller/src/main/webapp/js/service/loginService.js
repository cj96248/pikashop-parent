app.service('loginService', function ($http) {
    this.loginSeller = function () {
        return $http.get("/biz/login/sellerInfo");
    }
})