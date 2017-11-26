import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

import {TrackingComponent} from './tracking.component';

import { TrackingService } from './tracking.service';

@NgModule({
  imports: [
    CommonModule,
    RouterModule.forChild([
    	{path: "", component: TrackingComponent}
    ])
  ],
  declarations: [
  	TrackingComponent
  ],
  providers: [
  	TrackingService
  ]
})
export class TrackingModule { }
