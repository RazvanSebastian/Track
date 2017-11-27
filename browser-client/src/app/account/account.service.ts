import { Injectable,  } from '@angular/core';
import { Http, RequestOptions, Headers, URLSearchParams } from '@angular/http';
import { HostURI } from '../shared/common';
import { Observable } from 'rxjs/Observable';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import 'rxjs/add/observable/throw';
import 'rxjs/add/operator/delay';


export class User{
	public email:string;
	public password:string;

	constructor(){}
}

@Injectable()
export class AccountService {

	private hostURI = new HostURI(); 
	private isLoggedIn : boolean = false;

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

	checkAuthorization() {
		let header = new Headers();
		header.append('Authorization','Bearer '+localStorage.getItem('access_token'));
		let options = new RequestOptions({headers:header})

		return this._http.get(this.hostURI.adress+'/account',options)
		//.delay(1000)
		.map(res => res.json());
	}

	checkIsLoggedIn() : boolean{
		let header = new Headers();
		header.append('Authorization','Bearer '+localStorage.getItem('access_token'));
		let options = new RequestOptions({headers:header})
		this._http.get(this.hostURI.adress+'/account',options)
		.subscribe(
			data => {this.isLoggedIn = true},
			err => { this.isLoggedIn = false}
			);
		return this.isLoggedIn;
	}
}
