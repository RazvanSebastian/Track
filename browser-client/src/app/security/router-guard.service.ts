import { Injectable} from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivateChild } from '@angular/router';
import { AccountService } from '../account/account.service';


@Injectable()
export class RouterGuardService implements CanActivate{

	constructor(
		private _accountService : AccountService,
		private _router : Router
		) { }

	canActivate(){
		if(localStorage.getItem('access_token') == null){
			window.alert("You must to be authenticate to access this page!")
			this._router.navigateByUrl('/login');
			return false;
		}
		return this._accountService.checkAuthorization()
		.map(res => {
				return res ? true : false
			}
		);
	}
}
