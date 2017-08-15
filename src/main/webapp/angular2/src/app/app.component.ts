import {Component, OnInit} from '@angular/core';
import { FormControl, FormGroup} from "@angular/forms"

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  title = 'Visit Mars like you have never done it before';

  /**
   * variable used to check if our form was submited
   */
  public submitted:boolean;

  /**
   * variable used for our FormGroup
   */
  roomsearch : FormGroup;

  /**
   * Method used to initialize our form group
   */
  ngOnInit() {
    this.roomsearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });
  }

  /**
   * Method used to trigger the action when our form is submitted
   * Indicates if our form was submitted
   */
  onSubmit({value,valid}: {value:Roomsearch, valid:boolean}) {
    console.log(value);
  }

}

export interface Roomsearch {
  checkin:string;
  checkout:string;
}
