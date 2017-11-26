import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';



@NgModule({
	declarations: [
	AppComponent
	],
	imports: [
	BrowserModule,
	HttpModule,
	
	RouterModule.forRoot([
		{ path: '', redirectTo: '', pathMatch: 'full' },
		{ path:'login', loadChildren:'app/account/account.module#AccountModule'},
		{ path:'register', loadChildren:'app/account/account.module#AccountModule'},
		{ path:'device-list', loadChildren:'app/tracking/tracking.module#TrackingModule'}
		])
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule { }
