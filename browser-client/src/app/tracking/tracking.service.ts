import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, URLSearchParams } from '@angular/http';

import { HostURI } from '../shared/common';
import { StorageManager } from '../shared/storage-manager';

import { Observable } from 'rxjs/Observable'

export class Device{
	public token:string;
	public registrationDate:Date;
}

@Injectable()
export class TrackingService {

	private hostURI = new HostURI(); 
	private storageManager = new StorageManager();

	constructor(
		private _http : Http) 
	{ }

	findAllDevices(){
		if(this.storageManager.empty())
			return null;
		let headers = new Headers();
		headers.append("username",localStorage.getItem("username"));
		headers.append("Authorization","Bearer "+localStorage.getItem("access_token"));

		let options = new RequestOptions({headers:headers});

		return this._http.get(this.hostURI.adress+"/device/all",options);
	}
}
