import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { FurnitureDataService } from '../service/data/furniture-data.service';

export class Cart {
  constructor(
    public userId: string,
    public productName: string,
    public productPrice: number
  ) {}
}

@Component({
  selector: 'app-furniture',
  templateUrl: './furniture.component.html',
  styleUrls: ['./furniture.component.css']
})
export class FurnitureComponent implements OnInit {

  homeHomeAppliancesFurniture: any[];

  userCart: Cart;
  userName: string;
  cartStatus: any;

  constructor(private service: FurnitureDataService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.userName=this.route.snapshot.params['userName'];
    this.service.executeHomeHomeAppliancesFurniture().subscribe(response => this.homeHomeAppliancesFurniture = response);
  }

  addToCart(productName, productPrice) {
    this.userCart = new Cart(this.userName, productName, productPrice);
    this.service.executeAddToCart(this.userCart).subscribe(response => this.cartStatus = response);
  }

  showAlert() {
    alert("Added To Cart");
  }
}
