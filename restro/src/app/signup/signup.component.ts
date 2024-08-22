import { Component, NgModule } from '@angular/core';
import { FormsModule, NgModel } from '@angular/forms';
import { AuthserviceService } from '../services/authservice.service';


@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [FormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.css'
})
export class SignupComponent {

  constructor(
    private auth : AuthserviceService
  ){}

  signup(data : any)
  {
    this.auth.getdata();
  }

}
