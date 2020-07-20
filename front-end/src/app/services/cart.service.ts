import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

export class OrderInfo {

  deliveryName: string;
  deliveryStreet: string;
  deliveryState: string;
  deliveryCity: string;
  deliveryZip: string;
  ccNumber: string;
  ccExpiration: string;
  ccCVV: string;
  tacos: Array<any>;

  constructor() {
    this.tacos = [];
  }
}

export class CartItem {
  
  quantity: number = 1;
  taco: any;

  constructor(taco: any) {
    this.taco = taco;
    this.quantity = 1;
  }

  get lineTotal() {
    return this.quantity * 4.99;
  }
}

@Injectable()
export class CartService {

  items: CartItem[] = [];

  constructor(private httpClient: HttpClient) {}

  addToCart(taco: any) {
    this.items.push(new CartItem(taco));
  } 

  getItemsInCart() {
    return this.items;
  }

  getCartTotal() {
    let total = 0;
    this.items.forEach(item => {
      total += item.lineTotal;
    });
    return total;
  }

  emptyCart() {
    this.items = [];
  }

  fillOrderByTacos(orderInfo: OrderInfo) {
    this.items.forEach(cartItem => {
      for (let i = 0; i < cartItem.quantity; ++i) {
        orderInfo.tacos.push(cartItem.taco);
      }
    });
  }

  submitOrder(orderInfo: OrderInfo) {
    this.httpClient.post('http://localhost:8080/orders', orderInfo, {
      headers: new HttpHeaders().set('Content-type', 'application/json').set('Accept', 'application/json'),
    }).subscribe(r => this.emptyCart());
  }
}
