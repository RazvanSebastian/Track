import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TrackingService, Position } from '../tracking.service';

@Component({
  selector: 'app-positions',
  templateUrl: './positions.component.html',
  styleUrls: ['./positions.component.css']
})
export class PositionsComponent implements OnInit {

	deviceName:string;
	deviceToken:string;

  startdate:any;
  enddate:any;

  positions : any;

  constructor(
  	private _router : ActivatedRoute,
    private _trackingService : TrackingService
    ) { }

  ngOnInit() {

  	this._router.params
  	.subscribe( params => {
  		this.deviceToken = params['token'];
  		this.deviceName = params['name']
  	}
  	);
  }

  onCheckPositions(){
    console.log(this.startdate);
    this._trackingService.findDevicePositions(this.deviceToken,this.startdate,this.enddate)
    .subscribe(
      data => { 
         this.parseToNumbers(data)
      },
      err => { window.alert(err) }
      );
  }

  private parseToNumbers(data){
    let items = JSON.parse(data.text());
    this.positions = new Array<Position>(items.length);
    for(let i=0; i< items.length; i++ ){
     this.positions[i] = new Position(+items[i].latitude,+items[i].longitude);
    }
  }
}
