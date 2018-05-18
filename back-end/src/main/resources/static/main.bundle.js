webpackJsonp(["main"],{

/***/ "../../../../../src/$$_gendir lazy recursive":
/***/ (function(module, exports, __webpack_require__) {

var map = {
	"app/tracking/tracking.module": [
		"../../../../../src/app/tracking/tracking.module.ts",
		"tracking.module"
	]
};
function webpackAsyncContext(req) {
	var ids = map[req];
	if(!ids)
		return Promise.reject(new Error("Cannot find module '" + req + "'."));
	return __webpack_require__.e(ids[1]).then(function() {
		return __webpack_require__(ids[0]);
	});
};
webpackAsyncContext.keys = function webpackAsyncContextKeys() {
	return Object.keys(map);
};
module.exports = webpackAsyncContext;
webpackAsyncContext.id = "../../../../../src/$$_gendir lazy recursive";

/***/ }),

/***/ "../../../../../src/app/account/account.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "form{\r\n\tmargin: auto;\r\n\twidth: 550px;\r\n\tborder: solid;\r\n\tborder-radius: 10px;\r\n\tborder-color: darkgrey;\r\n\tmargin-top: 8%;\r\n\theight: auto;\r\n\tpadding-top: 2%;\r\n\tpadding-left: 3%;\r\n\tpadding-right: 3%;\r\n}\r\n\r\np{\r\n  color: red;\r\n  position: static;\r\n  margin-left: 12px;\r\n}\r\nh3{\r\n\tmargin: auto;\r\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/account/account.component.html":
/***/ (function(module, exports) {

module.exports = "<form [formGroup]=\"form\" (ngSubmit)=\"onSubmit()\">\r\n\t<div class=\"form-group row\">\r\n\t\t<h3>{{action}}</h3>\t\r\n\t</div>\r\n\t<div class=\"form-group row\">\r\n\t\t<label for=\"email\" class=\"col-sm-2 col-form-label\">Email</label>\r\n\t\t<div class=\"col-sm-10\">\r\n\t\t\t<input  [(ngModel)]=\"email\" type=\"email\" name=\"email\" class=\"form-control\" id=\"email\" placeholder=\"Email\" formControlName=\"email\">\r\n\t\t</div>\r\n\t\t<div *ngIf=\"form.controls['email'].hasError('pattern') && (form.controls['email'].touched || form.controls['email'].dirty)\">\r\n\t\t\t<p>Invalid email format!</p>\r\n\t\t</div>\r\n\t</div>\r\n\t<div class=\"form-group row\">\r\n\t\t<label for=\"password\" class=\"col-sm-2 col-form-label\">Password</label>\r\n\t\t<div class=\"col-sm-10\">\r\n\t\t\t<input  [(ngModel)]=\"password\" type=\"password\" name =\"password\" class=\"form-control\" id=\"password\" placeholder=\"Password\" formControlName=\"password\">\r\n\t\t</div>\r\n\t\t<div *ngIf=\"form.controls['password'].hasError('minlength') && (form.controls['password'].touched || form.controls['password'].dirty)\">\r\n\t\t\t<p style=\"text-colo: red\">Password must be at least 6 characters!</p>\r\n\t\t</div>\r\n\t</div>\r\n\t<div class=\"form-group row\">\r\n\t\t<div class=\"col-sm-3\">\r\n\t\t\t<button [disabled]=\"form.invalid\" type=\"submit\" class=\"btn btn-primary\">{{action}}</button>\r\n\t\t</div>\r\n\t\t<div class=\"col-sm-9\" *ngIf=\"isSuccess == false\">\r\n\t\t\t<p>{{message}}</p>\r\n\t\t</div>\r\n\t</div>\r\n</form>"

/***/ }),

/***/ "../../../../../src/app/account/account.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AccountComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__account_service__ = __webpack_require__("../../../../../src/app/account/account.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__shared_auth_response__ = __webpack_require__("../../../../../src/app/shared/auth-response.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};





var AccountComponent = (function () {
    function AccountComponent(_router, _formBuilder, _accountService) {
        this._router = _router;
        this._formBuilder = _formBuilder;
        this._accountService = _accountService;
        this.isSuccess = true;
        this.message = "";
    }
    AccountComponent.prototype.ngOnInit = function () {
        this.action = this._router.url.substring(1);
        this.action = this.action.charAt(0).toUpperCase() + this.action.slice(1);
        this.form = this._formBuilder.group({
            email: ["", [__WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* Validators */].required, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* Validators */].pattern("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$")]],
            password: ["", [__WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* Validators */].required, __WEBPACK_IMPORTED_MODULE_2__angular_forms__["d" /* Validators */].minLength(6)]]
        });
    };
    AccountComponent.prototype.onSubmit = function () {
        if (this.action == "Login")
            this.loginUser();
        if (this.action == "Register")
            this.registerUser();
    };
    AccountComponent.prototype.loginUser = function () {
        var _this = this;
        console.log("on login");
        var authResponse = new __WEBPACK_IMPORTED_MODULE_4__shared_auth_response__["a" /* AuthResponse */]();
        this._accountService.loginUser(this.email, this.password)
            .subscribe(function (data) {
            authResponse = JSON.parse(data.text());
            localStorage.setItem('username', authResponse.username);
            localStorage.setItem('access_token', authResponse.access_token);
            localStorage.setItem('refresh_token', authResponse.refresh_token);
            _this.isSuccess = true;
            _this._router.navigate(["device-list"]);
        }, function (err) {
            _this.isSuccess = false;
            _this.message = "Email and password are not matching!";
        });
    };
    AccountComponent.prototype.registerUser = function () {
        var _this = this;
        console.log("on register");
        this._accountService.registerUser(this.email, this.password)
            .subscribe(function (data) {
            _this.isSuccess = true;
            _this._router.navigateByUrl("/login");
        }, function (err) {
            console.log("Error register " + err.text());
            _this.message = err.text();
            _this.isSuccess = false;
        });
    };
    return AccountComponent;
}());
AccountComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-account',
        template: __webpack_require__("../../../../../src/app/account/account.component.html"),
        styles: [__webpack_require__("../../../../../src/app/account/account.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormBuilder */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__angular_forms__["a" /* FormBuilder */]) === "function" && _b || Object, typeof (_c = typeof __WEBPACK_IMPORTED_MODULE_3__account_service__["a" /* AccountService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_3__account_service__["a" /* AccountService */]) === "function" && _c || Object])
], AccountComponent);

var _a, _b, _c;
//# sourceMappingURL=account.component.js.map

/***/ }),

/***/ "../../../../../src/app/account/account.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* unused harmony export User */
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AccountService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__shared_common__ = __webpack_require__("../../../../../src/app/shared/common.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__ = __webpack_require__("../../../../rxjs/add/operator/map.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_3_rxjs_add_operator_map__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_catch__ = __webpack_require__("../../../../rxjs/add/operator/catch.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_catch___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_4_rxjs_add_operator_catch__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_observable_throw__ = __webpack_require__("../../../../rxjs/add/observable/throw.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5_rxjs_add_observable_throw___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_5_rxjs_add_observable_throw__);
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_delay__ = __webpack_require__("../../../../rxjs/add/operator/delay.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_delay___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_6_rxjs_add_operator_delay__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};







var User = (function () {
    function User() {
    }
    return User;
}());

var AccountService = (function () {
    function AccountService(_http) {
        this._http = _http;
        this.hostURI = new __WEBPACK_IMPORTED_MODULE_2__shared_common__["a" /* HostURI */]();
        this.isLoggedIn = false;
    }
    AccountService.prototype.loginUser = function (username, password) {
        var headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Headers */]();
        headers.append("Content-Type", "application/x-www-form-urlencoded");
        headers.append("Authorization", "Basic " + btoa("client:clientsecret"));
        var options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["d" /* RequestOptions */]({ headers: headers });
        var params = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["e" /* URLSearchParams */]();
        params.set('grant_type', "password");
        params.set('client-id', 'client');
        params.set('username', username);
        params.set('password', password);
        return this._http.post(this.hostURI.adress + "/oauth/token", params, options);
    };
    AccountService.prototype.registerUser = function (username, password) {
        var headers = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Headers */]();
        headers.append("Content-Type", "application/json");
        var options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["d" /* RequestOptions */]({ headers: headers });
        var user = new User();
        user.email = username;
        user.password = password;
        return this._http.post(this.hostURI.adress + "/account/user-register", JSON.stringify(user), options);
    };
    AccountService.prototype.checkAuthorization = function () {
        var header = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Headers */]();
        header.append('Authorization', 'Bearer ' + localStorage.getItem('access_token'));
        var options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["d" /* RequestOptions */]({ headers: header });
        return this._http.get(this.hostURI.adress + '/account', options)
            .map(function (res) { return res.json(); });
    };
    AccountService.prototype.checkIsLoggedIn = function () {
        var _this = this;
        var header = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["a" /* Headers */]();
        header.append('Authorization', 'Bearer ' + localStorage.getItem('access_token'));
        var options = new __WEBPACK_IMPORTED_MODULE_1__angular_http__["d" /* RequestOptions */]({ headers: header });
        this._http.get(this.hostURI.adress + '/account', options)
            .subscribe(function (data) { _this.isLoggedIn = true; }, function (err) { _this.isLoggedIn = false; });
        return this.isLoggedIn;
    };
    return AccountService;
}());
AccountService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__angular_http__["b" /* Http */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_http__["b" /* Http */]) === "function" && _a || Object])
], AccountService);

var _a;
//# sourceMappingURL=account.service.js.map

/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<nav style=\"background: #DDDDDD\" class=\"navbar navbar-toggleable-md navbar-light bg-faded\">\r\n  <a class=\"navbar-brand\" [routerLink]=\"['']\">Home</a>\r\n  <div class=\"collapse navbar-collapse\" id=\"navbarText\">\r\n    <ul class=\"navbar-nav mr-auto\">\r\n      <li *ngIf = \"!isStorageClear()\" class=\"nav-item\">\r\n        <a class=\"nav-link\" class=\"nav-link\" [routerLink]=\"['/device-list']\">My devices</a>\r\n      </li>\r\n    </ul>\r\n  </div>\r\n\r\n  <div *ngIf = \"isStorageClear()\" class=\"row\">\r\n    <div  class=\"col-sm-4\"> <a class=\"nav-link\" [routerLink]=\"['/login']\" >Login</a></div>\r\n    <div class=\"col-sm-4\"><a class=\"nav-link\" [routerLink]=\"['/register']\" >Register</a></div>\r\n  </div>\r\n   <div class=\"row\">\r\n     <div class=\"col-sm-4\" (click)=\"clearLocalStorage()\" *ngIf=\"!isStorageClear()\"> <a class=\"nav-link\" [routerLink]=\"['/login']\" >Sign Out</a></div>\r\n  </div> \r\n</nav>\r\n\r\n\r\n<router-outlet></router-outlet>\r\n\r\n"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__account_account_service__ = __webpack_require__("../../../../../src/app/account/account.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};


var AppComponent = (function () {
    function AppComponent(_accountService) {
        this._accountService = _accountService;
    }
    AppComponent.prototype.isStorageClear = function () {
        if (localStorage.getItem("access_token") == null)
            return true;
        return false;
    };
    AppComponent.prototype.clearLocalStorage = function () {
        localStorage.removeItem("access_token");
        localStorage.removeItem("refresh_token");
        localStorage.removeItem("username");
    };
    return AppComponent;
}());
AppComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-root',
        template: __webpack_require__("../../../../../src/app/app.component.html"),
        styles: [__webpack_require__("../../../../../src/app/app.component.css")]
    }),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_1__account_account_service__["a" /* AccountService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__account_account_service__["a" /* AccountService */]) === "function" && _a || Object])
], AppComponent);

var _a;
//# sourceMappingURL=app.component.js.map

/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/@angular/platform-browser.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__angular_http__ = __webpack_require__("../../../http/@angular/http.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__angular_forms__ = __webpack_require__("../../../forms/@angular/forms.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__account_account_component__ = __webpack_require__("../../../../../src/app/account/account.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__security_router_guard_service__ = __webpack_require__("../../../../../src/app/security/router-guard.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__account_account_service__ = __webpack_require__("../../../../../src/app/account/account.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__shared_error_handler_service__ = __webpack_require__("../../../../../src/app/shared/error-handler.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10__home_component__ = __webpack_require__("../../../../../src/app/home.component.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};












var AppModule = (function () {
    function AppModule() {
    }
    return AppModule;
}());
AppModule = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["M" /* NgModule */])({
        declarations: [
            __WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */],
            __WEBPACK_IMPORTED_MODULE_10__home_component__["a" /* HomeComponent */],
            __WEBPACK_IMPORTED_MODULE_6__account_account_component__["a" /* AccountComponent */]
        ],
        imports: [
            __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
            __WEBPACK_IMPORTED_MODULE_4__angular_forms__["b" /* FormsModule */],
            __WEBPACK_IMPORTED_MODULE_4__angular_forms__["c" /* ReactiveFormsModule */],
            __WEBPACK_IMPORTED_MODULE_3__angular_http__["c" /* HttpModule */],
            __WEBPACK_IMPORTED_MODULE_2__angular_router__["c" /* RouterModule */].forRoot([
                {
                    path: 'home',
                    component: __WEBPACK_IMPORTED_MODULE_10__home_component__["a" /* HomeComponent */]
                },
                {
                    path: 'login',
                    component: __WEBPACK_IMPORTED_MODULE_6__account_account_component__["a" /* AccountComponent */]
                },
                {
                    path: 'register',
                    component: __WEBPACK_IMPORTED_MODULE_6__account_account_component__["a" /* AccountComponent */]
                },
                {
                    path: 'device-list',
                    loadChildren: 'app/tracking/tracking.module#TrackingModule',
                    canActivate: [__WEBPACK_IMPORTED_MODULE_7__security_router_guard_service__["a" /* RouterGuardService */]]
                },
                {
                    path: '',
                    redirectTo: 'home',
                    pathMatch: 'full'
                }
            ])
        ],
        providers: [
            __WEBPACK_IMPORTED_MODULE_7__security_router_guard_service__["a" /* RouterGuardService */],
            __WEBPACK_IMPORTED_MODULE_8__account_account_service__["a" /* AccountService */],
            [{ provide: __WEBPACK_IMPORTED_MODULE_1__angular_core__["w" /* ErrorHandler */], useClass: __WEBPACK_IMPORTED_MODULE_9__shared_error_handler_service__["a" /* ErrorHandlerService */] }]
        ],
        bootstrap: [__WEBPACK_IMPORTED_MODULE_5__app_component__["a" /* AppComponent */]]
    })
], AppModule);

//# sourceMappingURL=app.module.js.map

/***/ }),

/***/ "../../../../../src/app/home.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "img{\r\n\twidth: 100%;\r\n\theight: 100%;\r\n}", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/home.component.html":
/***/ (function(module, exports) {

module.exports = "<img src=\"http://www.mobiespy.com/wp-content/uploads/2013/12/Cell-Phone-Tracking-Software.png\">"

/***/ }),

/***/ "../../../../../src/app/home.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HomeComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var HomeComponent = (function () {
    function HomeComponent() {
    }
    HomeComponent.prototype.ngOnInit = function () {
    };
    return HomeComponent;
}());
HomeComponent = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["o" /* Component */])({
        selector: 'app-home',
        template: __webpack_require__("../../../../../src/app/home.component.html"),
        styles: [__webpack_require__("../../../../../src/app/home.component.css")]
    }),
    __metadata("design:paramtypes", [])
], HomeComponent);

//# sourceMappingURL=home.component.js.map

/***/ }),

/***/ "../../../../../src/app/security/router-guard.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return RouterGuardService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_router__ = __webpack_require__("../../../router/@angular/router.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__account_account_service__ = __webpack_require__("../../../../../src/app/account/account.service.ts");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var RouterGuardService = (function () {
    function RouterGuardService(_accountService, _router) {
        this._accountService = _accountService;
        this._router = _router;
    }
    RouterGuardService.prototype.canActivate = function () {
        if (localStorage.getItem('access_token') == null) {
            window.alert("You must to be authenticate to access this page!");
            this._router.navigateByUrl('/login');
            return false;
        }
        return this._accountService.checkAuthorization()
            .map(function (res) {
            return res ? true : false;
        });
    };
    return RouterGuardService;
}());
RouterGuardService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
    __metadata("design:paramtypes", [typeof (_a = typeof __WEBPACK_IMPORTED_MODULE_2__account_account_service__["a" /* AccountService */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_2__account_account_service__["a" /* AccountService */]) === "function" && _a || Object, typeof (_b = typeof __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */] !== "undefined" && __WEBPACK_IMPORTED_MODULE_1__angular_router__["b" /* Router */]) === "function" && _b || Object])
], RouterGuardService);

var _a, _b;
//# sourceMappingURL=router-guard.service.js.map

/***/ }),

/***/ "../../../../../src/app/shared/auth-response.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AuthResponse; });
var AuthResponse = (function () {
    function AuthResponse() {
    }
    return AuthResponse;
}());

//# sourceMappingURL=auth-response.js.map

/***/ }),

/***/ "../../../../../src/app/shared/common.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return HostURI; });
var HostURI = (function () {
    //public adress = "https://track-school.herokuapp.com";
    function HostURI() {
        this.adress = "http://localhost:8085";
    }
    return HostURI;
}());

;
//# sourceMappingURL=common.js.map

/***/ }),

/***/ "../../../../../src/app/shared/error-handler.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return ErrorHandlerService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};

var ErrorHandlerService = (function () {
    function ErrorHandlerService() {
    }
    ErrorHandlerService.prototype.handleError = function (error) {
        console.log(error.message);
        var statusCode = +error.message.substring(error.message.indexOf("status:")).split(" ")[1];
        console.log(statusCode);
        if (statusCode == 401)
            window.alert("You must login again or your session has expired!");
    };
    return ErrorHandlerService;
}());
ErrorHandlerService = __decorate([
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["C" /* Injectable */])(),
    __metadata("design:paramtypes", [])
], ErrorHandlerService);

//# sourceMappingURL=error-handler.service.js.map

/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
// The file contents for the current environment will overwrite these during build.
var environment = {
    production: false
};
//# sourceMappingURL=environment.js.map

/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/@angular/core.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/@angular/platform-browser-dynamic.es5.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["_23" /* enableProdMode */])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */]);
//# sourceMappingURL=main.js.map

/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map