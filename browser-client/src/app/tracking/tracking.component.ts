import { Component, OnInit } from '@angular/core';
import { TrackingService } from './tracking.service';
import { Router } from '@angular/router';

@Component({
	selector: 'app-tracking',
	templateUrl: './tracking.component.html',
	styleUrls: ['./tracking.component.css']
})
export class TrackingComponent implements OnInit {

	deviceList = [];

	constructor(
		private _trackingService : TrackingService,
		private _router : Router
		) { }

	ngOnInit() {
		let response = this._trackingService.findAllDevices();
		if(response == null){
			window.alert("Local stoarage empty! Please to authenticate yourself again!");
			this._router.navigateByUrl("/login");
		}
		else{
			response.subscribe(
				data => { this.deviceList = JSON.parse(data.text()) },
				err => { console.log(err) }
				);
		} 
	}

	viewPositionsDevice(device){
		this._router.navigate(['/device-list/device/'+device.name+'/token/'+device.token]);
	}

	onSubmitDelete(token){
		this._trackingService.deleteDevice(token).subscribe(
			data => {
				window.alert("Device delete successfully");
				for (var i = this.deviceList.length - 1; i >= 0; i--) {
					if(this.deviceList[i].token == token){
						this.deviceList.splice(i,1);
						break;
					}
				}
			},
			err => {
				window.alert(err);
			}
			);
	}

}
