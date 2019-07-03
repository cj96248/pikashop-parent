app.controller('baseController', function ($scope) {
    var isreloaded = true;
    $scope.paginationConf = {
        currentPage: 1,
        totalItems: 10,
        itemsPerPage: 10,
        perPageOptions: [5, 10, 20, 30],
        onChange: function(){
            if(isreloaded){
                $scope.reloadList();
                isreloaded = false;
            }
            setTimeout(function () {
                isreloaded = true;
            },200);
        }
    };
    $scope.reloadList = function(){
        $scope.search($scope.paginationConf.currentPage, $scope.paginationConf.itemsPerPage);
    }
    $scope.selectIds = [];
    $scope.updateSelectId=function ($event, id) {
        if($event.target.checked){
            $scope.selectIds.push(id);
        }else{
            var index = $scope.selectIds.indexOf(id);
            $scope.selectIds.splice(index, 1);
        }
    }

    $scope.jsonToString=function (jsonStr, key) {
        var json = JSON.parse(jsonStr);
        var value = "";

        for(var i=0;i<json.length;i++){
            if(i>0){
                value+=",";
            }
            value += json[i][key];
        }
        return value;
    }
});