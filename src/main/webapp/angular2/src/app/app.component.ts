import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms"

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'Visit Mars like you have never done it before';

  /**
   * variable used to check if our form was submited
   */
  public submitted: boolean;

  /**
   * variable used for our FormGroup
   */
  modulesearch: FormGroup;

  /**
   * an array of modules
   */
  modules: Module[];

  /**
   * Method used to initialize our form group
   */
  ngOnInit() {
    this.modulesearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });

    this.modules = MODULES;
  }

  /**
   * Method used to trigger the action when our form is submitted
   * Indicates if our form was submitted
   */
  onSubmit({value, valid}: { value: Modulesearch, valid: boolean }) {
    console.log(value);
  }

}

/**
 * Interface used for searching a module
 */
export interface Modulesearch {
  checkin: string;
  checkout: string;
}

/**
 * Interface representing a contract for a Module component
 */
export interface Module {
  id: string;
  moduleNumber: string;
  price: string;
  links: string;
}

/**
 * hardcoded Json for testing
 * @type {[{}]}
 */
var MODULES:Module[] = [
  {
    "id" : "325656",
    "moduleNumber" : "587",
    "price" : "200",
    "links" : ""
  },
  {
    "id" : "5766772",
    "moduleNumber" : "588",
    "price" : "250",
    "links" : ""
  },
  {
    "id" : "2525337",
    "moduleNumber" : "589",
    "price" : "300",
    "links" : ""
  }
];
