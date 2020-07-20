import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { routes } from './app.routes';

import { AppComponent } from './app.component';
import { CloudTitleComponent } from './cloud-title/cloud-title.component';
import { HomeComponent } from './home/home.component';
import { HeaderComponent } from './header/header.component';
import { FooterComponent } from './footer/footer.component';
import { GroupBoxComponent } from './group-box/group-box.component';
import { BigButtonComponent } from './big-button/big-button.component';
import { LittleButtonComponent } from './little-button/little-button.component';
import { LocationsComponent } from './locations/locations.component';
import { SpecialsComponent } from './specials/specials.component';
import { LoginComponent } from './login/login.component';
import { RecentsComponent } from './recents/recents.component';

import { RecentTacosService } from './services/recent-tacos.service';
import { CartService } from './services/cart.service';
import { DesignService } from './services/design.service';

import { DesignComponent } from './design/design.component';
import { CartComponent } from './cart/cart.component';

@NgModule({
  declarations: [
    AppComponent,
    CloudTitleComponent,
    HomeComponent,
    HeaderComponent,
    FooterComponent,
    GroupBoxComponent,
    BigButtonComponent,
    LittleButtonComponent,
    LocationsComponent,
    SpecialsComponent,
    LoginComponent,
    RecentsComponent,
    DesignComponent,
    CartComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [RecentTacosService, CartService, DesignService],
  bootstrap: [AppComponent]
})
export class AppModule { }
