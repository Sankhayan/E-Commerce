import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { LaptopDataService } from '../service/data/laptop-data.service';

export class Cart {
  constructor(
    public userId: string,
    public productName: string,
    public productPrice: number
  ) {}
}

@Component({
  selector: 'app-laptop',
  templateUrl: './laptop.component.html',
  styleUrls: ['./laptop.component.css']
})
export class LaptopComponent implements OnInit {

  homeElectronicsLaptop: any[];

  userCart: Cart;
  userName: string;
  cartStatus: any;


  constructor(private service: LaptopDataService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.userName=this.route.snapshot.params['userName'];
    this.service.executeHomeElectronicsLaptop().subscribe(response => this.homeElectronicsLaptop = response);
  }

  addToCart(productName, productPrice) {
    this.userCart = new Cart(this.userName, productName, productPrice);
    this.service.executeAddToCart(this.userCart).subscribe(response => this.cartStatus = response);
  }

  showAlert() {
    alert("Added To Cart");
  }
}
