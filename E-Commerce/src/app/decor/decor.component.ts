import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { DecorDataService } from '../service/data/decor-data.service';

export class Cart {
  constructor(
    public userId: string,
    public productName: string,
    public productPrice: number
  ) {}
}

@Component({
  selector: 'app-decor',
  templateUrl: './decor.component.html',
  styleUrls: ['./decor.component.css']
})
export class DecorComponent implements OnInit {

  homeHomeAppliancesDecor: any[];

  userCart: Cart;
  userName: string;

  constructor(private service: DecorDataService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.userName=this.route.snapshot.params['userName'];
    this.service.executeHomeHomeAppliancesDecor().subscribe(response => this.homeHomeAppliancesDecor = response);
  }

  addToCart(productName, productPrice) {
    this.userCart = new Cart(this.userName, productName, productPrice);
    this.service.executeAddToCart(this.userCart).subscribe(response => console.log(this.userCart));
  }
}
