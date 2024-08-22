import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthserviceService {

   URL = "http://localhost:8080"

   datax : any;

  constructor(private http : HttpClient) { }

  register(data : any) : Observable<any>{
    this.http.post(this.URL+"/user/signup",data).subscribe((res)=>{
    console.log(res);
    this.datax = res;
    })
    return this.datax;
  }

  getdata() {
    this.http.get(this.URL+"/user").subscribe((res)=>
    {
      console.log(res);
    })
  }
}
