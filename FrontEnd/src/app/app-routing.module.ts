import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { UserHomeComponent } from './user-home/user-home.component';
import { RegistrationComponent } from './registration/registration.component';
import { AddMovieComponent } from './add-movie/add-movie.component';
import { MovieListComponent } from './movie-list/movie-list.component'


const routes: Routes = [
  {path:"",component:AppComponent},
  {path:"userHome",component:UserHomeComponent},
  {path:"registerUser", component:RegistrationComponent},
  {path:"addMovie", component:AddMovieComponent},
  {path:"movies", component:MovieListComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
