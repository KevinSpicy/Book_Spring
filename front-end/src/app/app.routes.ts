import { Routes } from '@angular/router';

import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RecentsComponent } from './recents/recents.component';
import { SpecialsComponent } from './specials/specials.component';
import { LocationsComponent } from './locations/locations.component';
import { CartComponent } from './cart/cart.component';
import { DesignComponent } from './design/design.component';

export const routes: Routes = [
    {
        path: 'home',
        component: HomeComponent
    },
    {
        path: 'login',
        component: LoginComponent
    },
    {
        path: 'recents',
        component: RecentsComponent
    },
    {
        path: 'cart',
        component: CartComponent
    },
    {
        path: 'design',
        component: DesignComponent
    },
    {
        path: 'specials',
        component: SpecialsComponent
    },
    {
        path: 'locations',
        component: LocationsComponent
    },
    {
        path: '**',
        redirectTo: 'home',
        pathMatch: 'full'
    }
];