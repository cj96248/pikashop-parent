app.service('sellerService', function ($http) {
    this.findOne = function (id) {
        return $http.get('/biz/seller/findOne?id='+id);
    }
    this.save = function (seller) {
        return $http.post('/biz/seller/update', seller)
    }
    this.changePassword=function (id, oldPassword, newPassword) {
        return $http.get('/biz/seller/changePassword?id='+id+'&oldPassword='+oldPassword+"&newPassword="+newPassword);
    }
})