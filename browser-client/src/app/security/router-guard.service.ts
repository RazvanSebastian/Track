import { Injectable} from '@angular/core';
import { CanActivate, Router, ActivatedRouteSnapshot, RouterStateSnapshot, CanActivateChild } from '@angular/router';
import { AccountService } from '../account/account.service';

@Injectable()
export class RouterGuardService implements CanActivate{

	constructor(
		private _accountService : AccountService
		) { }

	canActivate(){
		if(localStorage.getItem('access_token') == null)
			return false;
		return this._accountService.checkAuthorization()
		.map(res => {
				return res ? true : false
			}
		);
	}
}
