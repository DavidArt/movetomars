import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup } from '@angular/forms';
import {Http, Response} from "@angular/http";
import {Observable} from "rxjs/Rx";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

  title = 'Visit Mars like you have never done it before';

  /**
   * JS constructor
   * @param {Http} http
   */
  constructor(private http:Http) {
  }

  private baseUrl:string = 'http://localhost:8080';

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

  }

  /**
   * Method used to trigger the action when our form is submitted
   * Indicates if our form was submitted
   */
  onSubmit({value, valid}: { value:Modulesearch, valid:boolean }) {

    this.getAll()
      .subscribe(
        modules => this.modules = modules,
        err => {
          // Log errors if any
          console.log(err);
        });
  }

  reserveModule(value:string) {
    console.log("Module id for reservation: " + value);
  }

  getAll():Observable<Module[]> {

    //noinspection TypeScriptValidateTypes
    return this.http
      .get(`${this.baseUrl}/module/reservation/v1/?checkin=2017-03-18&checkout=2017-03-25`)
      .map(this.mapModule);
  }

  mapModule(response:Response):Module[] {
    return response.json().content;
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

