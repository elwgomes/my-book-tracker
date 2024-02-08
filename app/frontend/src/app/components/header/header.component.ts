import { Component } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { SignupComponent } from '../signup/signup.component';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent {

  constructor(private matDialog:MatDialog) { }

  openDialog(): void {
    this.matDialog.open(SignupComponent, {
      width: "350px"
    });
  }

}
