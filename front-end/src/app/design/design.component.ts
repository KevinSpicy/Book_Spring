import { Component, OnInit } from '@angular/core';
import { DesignService } from '../services/design.service';
import { CartService } from '../services/cart.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-design',
  templateUrl: './design.component.html',
  styleUrls: ['./design.component.css']
})
export class DesignComponent implements OnInit {

  model = {
    name: '',
    ingredients: []
  };

  allIngredients: any;
  wraps: Array<string> = [];
  proteins: Array<string> = [];
  veggies: Array<string> = [];
  cheeses: Array<string> = [];
  sauces: Array<string> = [];

  constructor(private designService: DesignService, private cartService: CartService, private router: Router) { }

  ngOnInit(): void {
    this.designService.getIngredients().subscribe(data => {
                    this.allIngredients = data;
                    this.wraps = this.allIngredients.filter(w => w.type === 'WRAP');
                    this.proteins = this.allIngredients.filter(p => p.type === 'PROTEIN');
                    this.veggies = this.allIngredients.filter(p => p.type === 'VEGGIES');
                    this.cheeses = this.allIngredients.filter(p => p.type === 'CHEESE');
                    this.sauces = this.allIngredients.filter(p => p.type === 'SAUCE');
                  });
  }

  updateIngredients(ingredient, event): void {
    if (event.target.checked) {
      this.model.ingredients.push(ingredient);
    } else {
      this.model.ingredients.splice(this.model.ingredients.findIndex(i => i === ingredient), 1);
    }
  }


  createTacoAndNavigateToCart(): void {
    this.designService.postTaco(this.model);
    this.cartService.addToCart(this.model);
    this.router.navigate(['/cart']);
  }
}
