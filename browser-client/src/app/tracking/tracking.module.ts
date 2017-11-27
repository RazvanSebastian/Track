import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';
import { FormsModule } from '@angular/forms'; 

import {TrackingComponent} from './tracking.component';

import { TrackingService } from './tracking.service';
import { PositionsComponent } from './positions/positions.component';
import { AgmCoreModule } from '@agm/core';


@NgModule({
	imports: [
		CommonModule,
		FormsModule,
		AgmCoreModule.forRoot({
			apiKey: 'AIzaSyAP4UIiu5gRhOf1Yd02LwvjcolhgIJ8YS0'
		}),
		RouterModule.forChild([
		{
			path: "", 
			component: TrackingComponent
		},
		{ 
			path: 'device/:name/token/:token', 
			component:PositionsComponent 
		}
		])
	],
	declarations: [
		TrackingComponent,
		PositionsComponent
	],
	providers: [
		TrackingService
	]
})
export class TrackingModule { }
