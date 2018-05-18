import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { AccountComponent } from './account/account.component';

import { RouterGuardService } from './security/router-guard.service';
import { AccountService } from './account/account.service';
import { ErrorHandlerService } from './shared/error-handler.service';

import { ErrorHandler } from '@angular/core';
import { HomeComponent } from './home.component';



@NgModule({
	declarations: [
	AppComponent,
	HomeComponent,
	AccountComponent
	],
	imports: [
	BrowserModule,
	FormsModule,
	ReactiveFormsModule,
	HttpModule,
	
	RouterModule.forRoot([
		{ 
			path:'home',
			component:HomeComponent
		},
		{ 
			path:'login', 
			component : AccountComponent
		},
		{ 
			path:'register', 
			component : AccountComponent
		},
		{ 
			path:'device-list', 
			loadChildren:'app/tracking/tracking.module#TrackingModule',
			canActivate: [RouterGuardService]
		},
		{ 
			path: '', 
			redirectTo: 'home', 
			pathMatch: 'full' 
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
