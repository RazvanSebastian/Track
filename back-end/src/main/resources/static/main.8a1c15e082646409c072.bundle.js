webpackJsonp([5],{0:function(n,l,t){n.exports=t("cDNt")},Ayol:function(n,l,t){"use strict";t.d(l,"a",function(){return u});var u=function(){function n(){this.adress="http://localhost:8085"}return n}()},HcN1:function(n,l,t){"use strict";t.d(l,"a",function(){return s});var u=t("CPp0"),e=t("Ayol"),r=t("5v8a"),o=(t.n(r),t("xpf9")),c=(t.n(o),t("S7im")),a=(t.n(c),t("l3Q+")),i=(t.n(a),function(){function n(){}return n}()),s=function(){function n(n){this._http=n,this.hostURI=new e.a,this.isLoggedIn=!1}return n.prototype.loginUser=function(n,l){var t=new u.d;t.append("Content-Type","application/x-www-form-urlencoded"),t.append("Authorization","Basic "+btoa("client:clientsecret"));var e=new u.g({headers:t}),r=new u.i;return r.set("grant_type","password"),r.set("client-id","client"),r.set("username",n),r.set("password",l),this._http.post(this.hostURI.adress+"/oauth/token",r,e)},n.prototype.registerUser=function(n,l){var t=new u.d;t.append("Content-Type","application/json");var e=new u.g({headers:t}),r=new i;return r.email=n,r.password=l,this._http.post(this.hostURI.adress+"/account/user-register",JSON.stringify(r),e)},n.prototype.checkAuthorization=function(){var n=new u.d;n.append("Authorization","Bearer "+localStorage.getItem("access_token"));var l=new u.g({headers:n});return this._http.get(this.hostURI.adress+"/account",l).map(function(n){return n.json()})},n.prototype.checkIsLoggedIn=function(){var n=this,l=new u.d;l.append("Authorization","Bearer "+localStorage.getItem("access_token"));var t=new u.g({headers:l});return this._http.get(this.hostURI.adress+"/account",t).subscribe(function(l){n.isLoggedIn=!0},function(l){n.isLoggedIn=!1}),this.isLoggedIn},n.ctorParameters=function(){return[{type:u.e}]},n}()},cDNt:function(n,l,t){"use strict";function u(n){return d._41(0,[(n()(),d._19(0,0,null,null,0,"img",[["src","http://www.mobiespy.com/wp-content/uploads/2013/12/Cell-Phone-Tracking-Software.png"]],null,null,null,null,null))],null,null)}function e(n){return d._41(0,[(n()(),d._19(0,0,null,null,1,"app-home",[],null,null,null,u,m)),d._17(1,114688,null,0,h,[],null,null)],function(n,l){n(l,1,0)},null)}function r(n){return b._41(0,[(n()(),b._19(0,0,null,null,6,"li",[["class","nav-item"]],null,null,null,null,null)),(n()(),b._39(-1,null,["\n        "])),(n()(),b._19(2,0,null,null,3,"a",[["class","nav-link"]],[[1,"target",0],[8,"href",4]],[[null,"click"]],function(n,l,t){var u=!0;if("click"===l){u=!1!==b._32(n,3).onClick(t.button,t.ctrlKey,t.metaKey,t.shiftKey)&&u}return u},null,null)),b._17(3,671744,null,0,w.l,[w.k,w.a,I.h],{routerLink:[0,"routerLink"]},null),b._33(4,1),(n()(),b._39(-1,null,["My devices"])),(n()(),b._39(-1,null,["\n      "]))],function(n,l){n(l,3,0,n(l,4,0,"/device-list"))},function(n,l){n(l,2,0,b._32(l,3).target,b._32(l,3).href)})}function o(n){return b._41(0,[(n()(),b._19(0,0,null,null,14,"div",[["class","row"]],null,null,null,null,null)),(n()(),b._39(-1,null,["\n    "])),(n()(),b._19(2,0,null,null,5,"div",[["class","col-sm-4"]],null,null,null,null,null)),(n()(),b._39(-1,null,[" "])),(n()(),b._19(4,0,null,null,3,"a",[["class","nav-link"]],[[1,"target",0],[8,"href",4]],[[null,"click"]],function(n,l,t){var u=!0;if("click"===l){u=!1!==b._32(n,5).onClick(t.button,t.ctrlKey,t.metaKey,t.shiftKey)&&u}return u},null,null)),b._17(5,671744,null,0,w.l,[w.k,w.a,I.h],{routerLink:[0,"routerLink"]},null),b._33(6,1),(n()(),b._39(-1,null,["Login"])),(n()(),b._39(-1,null,["\n    "])),(n()(),b._19(9,0,null,null,4,"div",[["class","col-sm-4"]],null,null,null,null,null)),(n()(),b._19(10,0,null,null,3,"a",[["class","nav-link"]],[[1,"target",0],[8,"href",4]],[[null,"click"]],function(n,l,t){var u=!0;if("click"===l){u=!1!==b._32(n,11).onClick(t.button,t.ctrlKey,t.metaKey,t.shiftKey)&&u}return u},null,null)),b._17(11,671744,null,0,w.l,[w.k,w.a,I.h],{routerLink:[0,"routerLink"]},null),b._33(12,1),(n()(),b._39(-1,null,["Register"])),(n()(),b._39(-1,null,["\n  "]))],function(n,l){n(l,5,0,n(l,6,0,"/login")),n(l,11,0,n(l,12,0,"/register"))},function(n,l){n(l,4,0,b._32(l,5).target,b._32(l,5).href),n(l,10,0,b._32(l,11).target,b._32(l,11).href)})}function c(n){return b._41(0,[(n()(),b._19(0,0,null,null,5,"div",[["class","col-sm-4"]],null,[[null,"click"]],function(n,l,t){var u=!0,e=n.component;if("click"===l){u=!1!==e.clearLocalStorage()&&u}return u},null,null)),(n()(),b._39(-1,null,[" "])),(n()(),b._19(2,0,null,null,3,"a",[["class","nav-link"]],[[1,"target",0],[8,"href",4]],[[null,"click"]],function(n,l,t){var u=!0;if("click"===l){u=!1!==b._32(n,3).onClick(t.button,t.ctrlKey,t.metaKey,t.shiftKey)&&u}return u},null,null)),b._17(3,671744,null,0,w.l,[w.k,w.a,I.h],{routerLink:[0,"routerLink"]},null),b._33(4,1),(n()(),b._39(-1,null,["Sign Out"]))],function(n,l){n(l,3,0,n(l,4,0,"/login"))},function(n,l){n(l,2,0,b._32(l,3).target,b._32(l,3).href)})}function a(n){return b._41(0,[(n()(),b._19(0,0,null,null,24,"nav",[["class","navbar navbar-toggleable-md navbar-light bg-faded"],["style","background: #DDDDDD"]],null,null,null,null,null)),(n()(),b._39(-1,null,["\n  "])),(n()(),b._19(2,0,null,null,3,"a",[["class","navbar-brand"]],[[1,"target",0],[8,"href",4]],[[null,"click"]],function(n,l,t){var u=!0;if("click"===l){u=!1!==b._32(n,3).onClick(t.button,t.ctrlKey,t.metaKey,t.shiftKey)&&u}return u},null,null)),b._17(3,671744,null,0,w.l,[w.k,w.a,I.h],{routerLink:[0,"routerLink"]},null),b._33(4,1),(n()(),b._39(-1,null,["Home"])),(n()(),b._39(-1,null,["\n  "])),(n()(),b._19(7,0,null,null,7,"div",[["class","collapse navbar-collapse"],["id","navbarText"]],null,null,null,null,null)),(n()(),b._39(-1,null,["\n    "])),(n()(),b._19(9,0,null,null,4,"ul",[["class","navbar-nav mr-auto"]],null,null,null,null,null)),(n()(),b._39(-1,null,["\n      "])),(n()(),b._13(16777216,null,null,1,null,r)),b._17(12,16384,null,0,I.j,[b._1,b.Y],{ngIf:[0,"ngIf"]},null),(n()(),b._39(-1,null,["\n    "])),(n()(),b._39(-1,null,["\n  "])),(n()(),b._39(-1,null,["\n\n  "])),(n()(),b._13(16777216,null,null,1,null,o)),b._17(17,16384,null,0,I.j,[b._1,b.Y],{ngIf:[0,"ngIf"]},null),(n()(),b._39(-1,null,["\n   "])),(n()(),b._19(19,0,null,null,4,"div",[["class","row"]],null,null,null,null,null)),(n()(),b._39(-1,null,["\n     "])),(n()(),b._13(16777216,null,null,1,null,c)),b._17(22,16384,null,0,I.j,[b._1,b.Y],{ngIf:[0,"ngIf"]},null),(n()(),b._39(-1,null,["\n  "])),(n()(),b._39(-1,null,[" \n"])),(n()(),b._39(-1,null,["\n\n\n"])),(n()(),b._19(26,16777216,null,null,1,"router-outlet",[],null,null,null,null,null)),b._17(27,212992,null,0,w.n,[w.b,b._1,b.l,[8,null],b.i],null,null),(n()(),b._39(-1,null,["\n\n"]))],function(n,l){var t=l.component;n(l,3,0,n(l,4,0,"")),n(l,12,0,!t.isStorageClear()),n(l,17,0,t.isStorageClear()),n(l,22,0,!t.isStorageClear()),n(l,27,0)},function(n,l){n(l,2,0,b._32(l,3).target,b._32(l,3).href)})}function i(n){return b._41(0,[(n()(),b._19(0,0,null,null,1,"app-root",[],null,null,null,a,j)),b._17(1,49152,null,0,g,[L.a],null,null)],null,null)}Object.defineProperty(l,"__esModule",{value:!0});var s={production:!0},_=function(){function n(){}return n}(),f=t("HcN1"),g=function(){function n(n){this._accountService=n}return n.prototype.isStorageClear=function(){return null==localStorage.getItem("access_token")},n.prototype.clearLocalStorage=function(){localStorage.removeItem("access_token"),localStorage.removeItem("refresh_token"),localStorage.removeItem("username")},n.ctorParameters=function(){return[{type:f.a}]},n}(),p=["img[_ngcontent-%COMP%]{width:100%;height:100%}"],h=function(){function n(){}return n.prototype.ngOnInit=function(){},n.ctorParameters=function(){return[]},n}(),d=t("/oeL"),k=[p],m=d._16({encapsulation:0,styles:k,data:{}}),v=d._14("app-home",h,e,{},{},[]),y=[""],b=t("/oeL"),w=t("BkNc"),I=t("qbdv"),L=t("HcN1"),S=[y],j=b._16({encapsulation:0,styles:S,data:{}}),C=b._14("app-root",g,i,{},{},[]),x=t("BkNc"),K=t("HcN1"),A=function(){function n(n,l){this._accountService=n,this._router=l}return n.prototype.canActivate=function(){return null==localStorage.getItem("access_token")?(window.alert("You must to be authenticate to access this page!"),this._router.navigateByUrl("/login"),!1):this._accountService.checkAuthorization().map(function(n){return!!n})},n.ctorParameters=function(){return[{type:K.a},{type:x.k}]},n}(),P=function(){function n(){}return n.prototype.handleError=function(n){console.log(n.message);var l=+n.message.substring(n.message.indexOf("status:")).split(" ")[1];console.log(l),401==l&&window.alert("You must login again or your session has expired!")},n.ctorParameters=function(){return[]},n}(),N=t("/oeL"),B=t("qbdv"),H=t("fc+i"),O=t("CPp0"),D=t("BkNc"),M=t("HcN1"),U=N._15(_,[g],function(n){return N._29([N._30(512,N.l,N._11,[[8,[v,C]],[3,N.l],N.F]),N._30(5120,N.B,N._28,[[3,N.B]]),N._30(4608,B.l,B.k,[N.B]),N._30(5120,N.c,N._20,[]),N._30(5120,N.z,N._25,[]),N._30(5120,N.A,N._26,[]),N._30(4608,H.b,H.r,[B.c]),N._30(6144,N.S,null,[H.b]),N._30(4608,H.e,H.f,[]),N._30(5120,H.c,function(n,l,t,u){return[new H.k(n),new H.o(l),new H.n(t,u)]},[B.c,B.c,B.c,H.e]),N._30(4608,H.d,H.d,[H.c,N.H]),N._30(135680,H.m,H.m,[B.c]),N._30(4608,H.l,H.l,[H.d,H.m]),N._30(6144,N.Q,null,[H.l]),N._30(6144,H.p,null,[H.m]),N._30(4608,N.Z,N.Z,[N.H]),N._30(4608,H.g,H.g,[B.c]),N._30(4608,H.i,H.i,[B.c]),N._30(4608,O.c,O.c,[]),N._30(4608,O.h,O.b,[]),N._30(5120,O.k,O.l,[]),N._30(4608,O.j,O.j,[O.c,O.h,O.k]),N._30(4608,O.g,O.a,[]),N._30(5120,O.e,O.m,[O.j,O.g]),N._30(5120,D.a,D.w,[D.k]),N._30(4608,D.d,D.d,[]),N._30(6144,D.f,null,[D.d]),N._30(135680,D.o,D.o,[D.k,N.E,N.j,N.x,D.f]),N._30(4608,D.e,D.e,[]),N._30(5120,D.h,D.z,[D.x]),N._30(5120,N.b,function(n){return[n]},[D.h]),N._30(4608,M.a,M.a,[O.e]),N._30(4608,A,A,[M.a,D.k]),N._30(512,B.b,B.b,[]),N._30(512,N.p,P,[]),N._30(1024,N.G,function(){return[D.s()]},[]),N._30(512,D.x,D.x,[N.x]),N._30(1024,N.d,function(n,l,t){return[H.q(n,l),D.y(t)]},[[2,H.h],[2,N.G],D.x]),N._30(512,N.e,N.e,[[2,N.d]]),N._30(131584,N._18,N._18,[N.H,N._12,N.x,N.p,N.l,N.e]),N._30(2048,N.g,null,[N._18]),N._30(512,N.f,N.f,[N.g]),N._30(512,H.a,H.a,[[3,H.a]]),N._30(512,O.f,O.f,[]),N._30(1024,D.r,D.u,[[3,D.k]]),N._30(512,D.q,D.c,[]),N._30(512,D.b,D.b,[]),N._30(256,D.g,{},[]),N._30(1024,B.h,D.t,[B.n,[2,B.a],D.g]),N._30(512,B.g,B.g,[B.h]),N._30(512,N.j,N.j,[]),N._30(512,N.E,N.W,[N.j,[2,N.X]]),N._30(1024,D.i,function(){return[[{path:"",component:h},{path:"login",loadChildren:"app/account/account.module#AccountModule"},{path:"register",loadChildren:"app/account/account.module#AccountModule"},{path:"device-list",loadChildren:"app/tracking/tracking.module#TrackingModule",canActivate:[A]}]]},[]),N._30(1024,D.k,D.v,[N.g,D.q,D.b,B.g,N.x,N.E,N.j,D.i,D.g,[2,D.p],[2,D.j]]),N._30(512,D.m,D.m,[[2,D.r],[2,D.k]]),N._30(512,_,_,[])])}),z=t("/oeL"),R=t("fc+i");s.production&&Object(z._5)(),Object(R.j)().bootstrapModuleFactory(U)},gFIY:function(n,l,t){function u(n){var l=e[n];return l?Promise.all(l.slice(1).map(t.e)).then(function(){return t(l[0])}):Promise.reject(new Error("Cannot find module '"+n+"'."))}var e={"app/account/account.module.ngfactory":["vgR6",0,2],"app/tracking/tracking.module.ngfactory":["50rM",0,1]};u.keys=function(){return Object.keys(e)},n.exports=u,u.id="gFIY"}},[0]);