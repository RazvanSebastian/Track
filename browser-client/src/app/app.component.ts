import { Component } from '@angular/core';
import { AccountService } from './account/account.service';

@Component({
	selector: 'app-root',
	templateUrl: './app.component.html',
	styleUrls: ['./app.component.css']
})
export class AppComponent {

	constructor(
		private _accountService : AccountService
		){
	}

	isStorageClear(){
		if(localStorage.getItem("access_token") == null)
			return true;
		return false;
	}

	clearLocalStorage(){
		localStorage.removeItem("access_token");
		localStorage.removeItem("refresh_token");
		localStorage.removeItem("username");	
	}

}
