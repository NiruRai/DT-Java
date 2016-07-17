angular.module('myApp', [])

.controller('mainController', function($scope) {
  $scope.sortType     = 'name'; // set the default sort type
  $scope.sortReverse  = false;  // set the default sort order
  $scope.searchtype   = '';     // set the default search/filter term
  
  // create the list of musical instrument 
  $scope.instrument = [
    { name: 'Classical Guitar C40', brand: 'YAMAHA', price: 1400, image:'logo' },
    { name: 'Classical Guitar HC02', brand: 'HOHNER', price: 1300 },
    { name: 'Mini Guitar GL1', brand: 'YAMAHA', price: 1350 },
    { name: 'Silent Guitar SLG110N', brand: 'YAMAHA', price: 3400 },
    { name: 'Classical Guitar SC12', brand: 'EKO', price: 1200 },
    { name: 'Acoustic Guitar', brand: 'FENDER', price: 12124 },
    { name: 'Ultimate Guru Student Tabla', brand: 'BAJAAO', price: 6300 },
    { name: 'Ultimate Guru Concert Grade Tabla', brand: 'BAJAAO', price: 19330 },
    { name: 'Guru Kharaj Pancham Sitar', brand: 'ULTIMATE', price: 25000 },
    { name: 'Guru Gandhar Pancham Sitar', brand: 'ULTIMATE', price: 30000 },
    { name: 'Guru Gandhar Pancham Concert Grade Sitar', brand: 'ULTIMATE', price: 33000 },
    { name: 'Silver Plated Flute', brand: 'PLUTO', price: 11000 },
    { name: 'Selmer Flute', brand: 'CONN', price: 21400 },
    { name: 'Student flute outfit', brand: 'NUAVA', price: 14000 },
    { name: 'Student Series flute', brand: 'ROY BENSON', price: 13000 },
    
  ];
  
});