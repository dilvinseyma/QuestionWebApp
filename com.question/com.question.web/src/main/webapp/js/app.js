var QuestionListController = function($http) {

	var self = this;
	this.question = {
		header : 'Please enter',
		content : '',
		questionPoint: ''
	};
	
	$http({
		method : 'GET',
		url : '/questions/all'

	}).then(function(response) {
		self.questions = response.data;
	});
	
	this.ask = function() {
		$http({
			method : 'POST',
			url : '/questions',
		    data: self.question

		}).then(function(response) {
			self.questions.push(self.question);
			self.question={};
			console.log(response.data);
		});
	};
};


var QuestionDetailsController= function($http,$routeParams){
	var self=this;
	self.selectedQuestion = {};
	var id=$routeParams.questionId;
	this.answer = {
			content : ''
		};
	
	$http({
		method : 'GET',
		url : '/question/'+id

	}).then(function(response) {
		self.selectedQuestion = response.data;
		console.log(response.data);
	});
	//
	$http({
		method : 'GET',
		url : '/question/'+id+'/answers'

	}).then(function(response) {
		self.answers = response.data;
		console.log(self.answer);
	});
	
	this.reply = function() {
		$http({
			method : 'POST',
			url : '/question/'+id+'/answers',
		    data: self.answer

		}).then(function(response) {
			self.answers.push(self.answer);
			self.answer={};
			
		});
	};
};


var demoApp = angular.module('QApp', ["ngRoute"]).controller('QuestionListController',	QuestionListController)
.controller('QuestionDetailsController',	QuestionDetailsController);

demoApp.config(['$routeProvider',function($routeProvider) {
    $routeProvider.
    when('/list', {
        templateUrl : 'templates/main.html',
        controller : 'QuestionListController',
        controllerAs : 'qlc'
        
    }).
    when('/askingForm', {
        templateUrl : 'templates/askingForm.html',
        controller: 'QuestionListController',
        controllerAs : 'qlc'
    }).
    when('/questions', {
        templateUrl : 'templates/questionList.html',
        controller: 'QuestionListController',
        controllerAs : 'qlc'
    }).
    when('/question/:questionId', {
        templateUrl : 'templates/reply.html',
        controller: 'QuestionDetailsController',
        controllerAs : 'qdc'
    })
    .otherwise({redirectTo: '/list'});

}]);

