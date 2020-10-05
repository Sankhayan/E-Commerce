import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { CartDataService } from '../service/data/cart-data.service';

export class Cart {
  constructor(
    public userId: string,
    public productName: string,
    public productPrice: number
  ) {}
}

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  userCart: Cart[]; 
  viewCart: Cart;
  userName: string;

  constructor(private service: CartDataService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.userName=this.route.snapshot.params['userName'];
    this.viewCart = new Cart(this.userName,null,null);
    this.service.executeViewCart(this.viewCart).subscribe(response => this.userCart = response);
  }
}
