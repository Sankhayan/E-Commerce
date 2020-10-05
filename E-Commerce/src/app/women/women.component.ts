import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { WomenDataService } from '../service/data/women-data.service';

export class Cart {
  constructor(
    public userId: string,
    public productName: string,
    public productPrice: number
  ) {}
}

@Component({
  selector: 'app-women',
  templateUrl: './women.component.html',
  styleUrls: ['./women.component.css']
})
export class WomenComponent implements OnInit {

  homeFashionWomen: any[];

  userCart: Cart;
  userName: string;

  constructor(private service: WomenDataService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.userName=this.route.snapshot.params['userName'];
    this.service.executeHomeFashionWomen().subscribe(response => this.homeFashionWomen = response);
  }

  addToCart(productName, productPrice) {
    this.userCart = new Cart(this.userName, productName, productPrice);
    this.service.executeAddToCart(this.userCart).subscribe(response => console.log(this.userCart));
  }

}
