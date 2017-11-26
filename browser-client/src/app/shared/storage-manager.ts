import { Headers } from "@angular/http";

export class StorageManager{

	public empty() : boolean{
		if(localStorage.getItem("username") == null || localStorage.getItem("access_token") == null || localStorage.getItem("refresh_token") == null)
			return true;
		return false;
	}

}