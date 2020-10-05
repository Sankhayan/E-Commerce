import { Component, Injectable, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MobileDataService } from '../service/data/mobile-data.service';

export class Cart {
  constructor(
    public userId: string,
    public productName: string,
    public productPrice: number
  ) {}
}

@Component({
  selector: 'app-mobile',
  templateUrl: './mobile.component.html',
  styleUrls: ['./mobile.component.css']
})

export class MobileComponent implements OnInit {

  homeElectronicsMobile: any[];

  userCart: Cart; 
  userName: string;

  constructor(private service: MobileDataService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.userName=this.route.snapshot.params['userName'];
    this.service.executeHomeElectronicsMobile().subscribe(response => this.homeElectronicsMobile = response);
  }

  addToCart(productName, productPrice) {
    this.userCart = new Cart(this.userName, productName, productPrice);
    this.service.executeAddToCart(this.userCart).subscribe(response => console.log(this.userCart));
  }

}
