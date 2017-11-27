import { Injectable } from '@angular/core';
import { ErrorHandler } from '@angular/core';

@Injectable()
export class ErrorHandlerService implements ErrorHandler {

	constructor() { }

	handleError(error : Error) {
		let statusCode = +error.message.substring(error.message.indexOf("status:")).split(" ")[1];
		if(statusCode == 401)
			window.alert("You must login again or your session has expired!");
	}
}
