import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';

const  ROOMS: Room[] = [
  { 
    'id':'243234',
    'roomNumber':'343',
    'price':'50',
    'links':''
  },
  { 
    'id':'1123343234',
    'roomNumber':'2',
    'price':'120',
    'links':''
  },
  { 
    'id':'2424583234',
    'roomNumber':'11',
    'price':'75',
    'links':''
  }
  
 ]



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  public submitted: boolean;
  roomsearch: FormGroup;
  rooms: Room[];
  
  ngOnInit() {
    this.roomsearch = new FormGroup({
       checkin: new FormControl(''),
       checkout: new FormControl('')
    });
    
    this.rooms = ROOMS;
  }

    onSubmit( {value,valid}:  {value: Roomsearch, valid:boolean} ) {
      console.log(value);
  }
  
  reserveRoom(value: string) {
    console.log('Room id for reservation: ' + value);
  }
}

  export interface Roomsearch {
      checkin: string,
      checkout: string
  }

  export interface Room {
    id: string,
    roomNumber: string,
    price: string,
    links: string;
  }

