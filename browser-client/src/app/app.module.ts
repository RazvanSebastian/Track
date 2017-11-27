import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';

import { RouterGuardService } from './security/router-guard.service';
import { AccountService } from './account/account.service';
import { ErrorHandlerService } from './shared/error-handler.service';

import { ErrorHandler } from '@angular/core';
import { HomeComponent } from './home.component';


@NgModule({
	declarations: [
	AppComponent,
	HomeComponent,
	],
	imports: [
	BrowserModule,
	HttpModule,
	
	RouterModule.forRoot([
		// { 
		// 	path: '', 
		// 	redirectTo: '', 
		// 	pathMatch: 'full' 
		// },
		{ 
			path:'',
			component:HomeComponent
		},
		{ 
			path:'login', 
			loadChildren:'app/account/account.module#AccountModule'
		},
		{ 
			path:'register', 
			loadChildren:'app/account/account.module#AccountModule'
		},
		{ 
			path:'device-list', 
			loadChildren:'app/tracking/tracking.module#TrackingModule',
			canActivate: [RouterGuardService]
		}
		])
	],
	providers: [
		RouterGuardService, 
		AccountService,
		[{provide: ErrorHandler, useClass: ErrorHandlerService}]
	],
	bootstrap: [AppComponent]
})
export class AppModule { }
