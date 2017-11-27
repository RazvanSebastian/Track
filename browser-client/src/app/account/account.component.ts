import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { FormBuilder, FormGroup, Validators} from '@angular/forms';
import { AccountService } from './account.service';
import { AuthResponse } from '../shared/auth-response';

@Component({
	selector: 'app-account',
	templateUrl: './account.component.html',
	styleUrls: ['./account.component.css']
})
export class AccountComponent implements OnInit {

	isSuccess = true;
	message = "";

	action:string;
	form:FormGroup;

	email:string;
	password:string;

	constructor(
		private _router:Router,
		private _formBuilder:FormBuilder,
		private _accountService:AccountService
		) { }

	ngOnInit() {
		this.action = this._router.url.substring(1);
		this.action = this.action.charAt(0).toUpperCase()+this.action.slice(1);
		
		this.form = this._formBuilder.group({
			email : ["",[Validators.required,Validators.pattern("^([a-z0-9_\\.-]+)@([\\da-z\\.-]+)\\.([a-z\\.]{2,6})$")]],
			password : ["",[Validators.required,Validators.minLength(6)]]
		});
	}

	onSubmit(){
		if(this.action == "Login")
			this.loginUser();
		if(this.action == "Register")
			this.registerUser();
	}

	loginUser(){
		console.log("on login");
		let authResponse = new AuthResponse();
		this._accountService.loginUser(this.email,this.password)
		.subscribe(
			data => { 
				authResponse = JSON.parse(data.text());
				localStorage.setItem('username',authResponse.username);
				localStorage.setItem('access_token',authResponse.access_token);
				localStorage.setItem('refresh_token',authResponse.refresh_token);
				this.isSuccess = true;
				this._router.navigate(["device-list"]);
			},
			err => {
				this.isSuccess=false;
				this.message = "Email and password are not matching!";
			}
			);
	}

	registerUser(){
		console.log("on register");
		this._accountService.registerUser(this.email,this.password)
		.subscribe(
			data => {
				this.isSuccess = true;
				this._router.navigateByUrl("/login");
			},
			err => {
				console.log("Error register " +err.text());
				this.message = err.text();
				this.isSuccess = false;
			}
			);
	}

}
