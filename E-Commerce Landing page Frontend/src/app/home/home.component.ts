import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
// import { ConsoleReporter } from 'jasmine';
import { HomeDataService } from '../service/data/home-data.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  homeCatalog: any[];
  homeElectronics: any[];
  homeFashion: any[];
  homeHomeAppliances: any[];
  userName: string;

  constructor(private service: HomeDataService, private router: Router, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.userName=this.route.snapshot.params['userName'];
  }

  getCatalog() {
    this.service.executeHome().subscribe(response => this.homeCatalog = response);

    this.service.executeHomeElectronics().subscribe(response => this.homeElectronics = response);

    this.service.executeHomeFashion().subscribe(response => this.homeFashion = response);

    this.service.executeHomeHomeAppliances().subscribe(response => this.homeHomeAppliances = response);
  }

  getElectronics(product:string) {
    if(product=="Mobile") {
      this.router.navigate(['mobile', this.userName]);
    }
    else {
      this.router.navigate(['laptop', this.userName]);
    }
  }

  getFashion(product:string) {
    if(product=="Men") {
      this.router.navigate(['men', this.userName]);
    }
    else {
      this.router.navigate(['women', this.userName]);
    } 
  }

  getHomeAppliances(product:string) {
    if(product=="Furniture") {
      this.router.navigate(['furniture', this.userName]);
    }
    else {
      this.router.navigate(['decor', this.userName]);
    } 
  }
}
