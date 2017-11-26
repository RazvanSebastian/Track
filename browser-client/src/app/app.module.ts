import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { TrackingComponent } from './tracking/tracking.component';

@NgModule({
	declarations: [
	AppComponent,
	TrackingComponent,
	],
	imports: [
	BrowserModule,
	HttpModule,
	RouterModule.forRoot([
		{ path: '', redirectTo: '', pathMatch: 'full' },
		{ path:'login', loadChildren:'app/account/account.module#AccountModule'},
		{ path:'register', loadChildren:'app/account/account.module#AccountModule'}
		])
	],
	providers: [],
	bootstrap: [AppComponent]
})
export class AppModule { }
