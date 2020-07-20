import { Component, OnInit } from '@angular/core';
import { CartService, OrderInfo } from '../services/cart.service';

@Component({
  selector: 'taco-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})

export class CartComponent implements OnInit {

  model: OrderInfo;

  constructor(private cartService: CartService) { }

  ngOnInit(): void {
  }

  get cartItems() {
    return this.cartService.getItemsInCart();
  }

  get cartTotal() {
    return this.cartService.getCartTotal();
  }

  onSubmit() {
    this.cartService.fillOrderByTacos(this.model);
    this.cartService.submitOrder(this.model);
  }

}
