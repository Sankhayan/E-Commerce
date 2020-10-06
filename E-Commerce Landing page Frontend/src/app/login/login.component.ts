import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginDataService } from '../service/data/login-data.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName: string;

  constructor(private router: Router) { }

  ngOnInit(): void {
  }

  getUser(userName) {
    this.userName=userName;
  }

  getHome() {
    this.router.navigate(['home', this.userName]);
  }
}
