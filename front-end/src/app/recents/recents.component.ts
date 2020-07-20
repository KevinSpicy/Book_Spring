import { Component, OnInit, Injectable } from '@angular/core';
import { RecentTacosService, ITaco, IIngredient } from '../services/recent-tacos.service';
import { CartService } from '../services/cart.service';


@Component({
  selector: 'recent-tacos',
  templateUrl: './recents.component.html',
  styleUrls: ['./recents.component.css']
})


export class RecentsComponent implements OnInit {

  recentTacos: Array<ITaco>;

  constructor(private recentTacosService: RecentTacosService, private cartService: CartService) { }
  
  ngOnInit(): void {
    this.recentTacosService.getRecentTacos().subscribe(data => this.recentTacos = data._embedded.tacos);
  }

  addTacoToCart(taco: ITaco) {
    this.cartService.addToCart(taco);
  }

}
