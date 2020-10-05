import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { MenDataService } from '../service/data/men-data.service';

export class Cart {
  constructor(
    public userId: string,
    public productName: string,
    public productPrice: number
  ) {}
}

@Component({
  selector: 'app-men',
  templateUrl: './men.component.html',
  styleUrls: ['./men.component.css']
})
export class MenComponent implements OnInit {

  homeFashionMen: any[];

  userCart: Cart;
  userName: string; 

  constructor(private service: MenDataService, private route: ActivatedRoute) { }

  ngOnInit(): void {
    this.userName=this.route.snapshot.params['userName'];
    this.service.executeHomeFashionMen().subscribe(response => this.homeFashionMen = response);
  }

  addToCart(productName, productPrice) {
    this.userCart = new Cart(this.userName, productName, productPrice);
    this.service.executeAddToCart(this.userCart).subscribe(response => console.log(this.userCart));
  }

}
