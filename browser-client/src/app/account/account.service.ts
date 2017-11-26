import { Injectable } from '@angular/core';
import { Http, RequestOptions, Headers, URLSearchParams } from '@angular/http';
import { HostURI } from '../shared/common';
import { Observable } from 'rxjs/Observable'

export class User{
	public email:string;
	public password:string;

	constructor(){}
}

@Injectable()
export class AccountService {

	private hostURI = new HostURI(); 

	constructor(
		private _http : Http) 
	{ }

	loginUser(username,password){
		let headers = new Headers();
		headers.append("Content-Type", "application/x-www-form-urlencoded");
		headers.append("Authorization","Basic "+ btoa("client:clientsecret"));

		let options = new RequestOptions({headers:headers});
		let params = new URLSearchParams();
		params.set('grant_type' , "password");
		params.set('client-id' , 'client');
		params.set('username' , username);
		params.set('password', password);

		return this._http.post(this.hostURI.adress+"/oauth/token",params,options);
	}

	registerUser(username,password){
		let headers = new Headers();
		headers.append("Content-Type","application/json");
		let options = new RequestOptions({headers:headers});
		
		let user = new User();
		user.email=username;
		user.password=password;
		
		return this._http.post(this.hostURI.adress+"/account/user-register",JSON.stringify(user),options);
	}
}
