var cartApp = angular.module ("cartApp", []);

cartApp.controller("cartCtrl", function($scope, $http){

    $scope.refreshCart = function(){
       $http.get('http://localhost:9002/musicstorefront/rest/cart/' + $scope.cartId).success(function (data){
           $scope.cart = data;
       });
    };

    $scope.clearCart = function(){
        $http,delete('http://localhost:9002/musicstorefront/rest/cart/' + $scope.cartId).success($scope.refreshCart());
    };

    $scope.initCartId = function(cartId){
        $scope.cartId = cartId;
        $scope.refreshCart(cartId);
    };

    $scope.addToCart = function(pid){
        $http.put('http://localhost:9002/musicstorefront/rest/cart/add/' + pid).success(function (){
            alert('Product successfully added to the cart!');
        });
    };

    $scope.removeFromCart = function(pid){
        $http.put('http://localhost:9002/musicstorefront/rest/cart/remove/' + pid).success(function(data){
           $scope.refreshCart();
        });
    };

    $scope.calGrandTotal = function(){
        var grandTotal = 0;

        for (var i = 0; i < $scope.cart.cartItems.length; i++){
            grandTotal += $scope.cart.cartItems[i].totalPrice;
        }

        return grandTotal;
    }
});