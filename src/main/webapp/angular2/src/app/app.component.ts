import {Component, OnInit} from '@angular/core';
import {FormControl, FormGroup} from '@angular/forms';
import {Headers, Http, RequestOptions, Response} from "@angular/http";
import {Observable} from "rxjs/Rx";
import "rxjs/add/operator/map";
import "rxjs/add/operator/catch";

/**
 * In this class we have defined the base URI as
 * http://localhost:8080 so we have a match with
 * our back end port.
 *
 */
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
  constructor(private http: Http) {
  }

  private baseUrl: string = 'http://localhost:8080';
  private getUrl: string = this.baseUrl + '/module/reservation/v1/';
  private postUrl: string = this.baseUrl + '/module/reservation/v1';

  /**
   * variable used to check if our form was submitted
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
   * checkin variable used for our POST method
   */
  currentCheckInVal: string;

  /**
   * checkout variable used for our POST method
   */
  currentCheckOutVal: string;

  request: ReserveModuleRequest;

  /**
   * Method used to initialize our form group
   */
  ngOnInit() {
    this.modulesearch = new FormGroup({
      checkin: new FormControl(''),
      checkout: new FormControl('')
    });

    const modulesearchValueChanges$ = this.modulesearch.valueChanges;

    // subscribe to the stream
    modulesearchValueChanges$.subscribe(valChange => {
      this.currentCheckInVal = valChange.checkin;
      this.currentCheckOutVal = valChange.checkout;
    });

  }

  /**
   * Method used to trigger the action when our form is submitted
   * Indicates if our form was submitted
   */
  onSubmit({value, valid}: { value: Modulesearch, valid: boolean }) {

    this.getAll()
      .subscribe(
        modules => this.modules = modules,
        err => {
          // Log errors if any
          console.log(err);
        });
  }

  reserveModule(value: string) {

    this.request = new ReserveModuleRequest(value, this.currentCheckInVal, this.currentCheckOutVal);
    this.createReservation(this.request);

  }

  getAll(): Observable<Module[]> {

    //noinspection TypeScriptValidateTypes
    return this.http
      .get(this.getUrl + '?checkin=' + this.currentCheckInVal + '&checkout=' + this.currentCheckOutVal)
      .map(this.mapModule);
  }

  createReservation(body: ReserveModuleRequest) {
    let bodyString = JSON.stringify(body); // Stringify payload
    let headers = new Headers({'Content-Type': 'application/json'}); // ... Set content type to JSON
    let options = new RequestOptions({headers: headers}); // Create a request option

    this.http.post(this.postUrl, body, options)
      .subscribe(res => console.log(res));
  }

  mapModule(response: Response): Module[] {
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

export class ReserveModuleRequest {
  moduleId: string;
  checkin: string;
  checkout: string;

  constructor(roomId: string, checkin: string, checkout: string) {

    this.moduleId = roomId;
    this.checkin = checkin;
    this.checkout = checkout;
  }
}

