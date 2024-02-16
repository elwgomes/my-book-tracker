import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { MatDialog } from '@angular/material/dialog';
import { SignupComponent } from '../signup/signup.component';

@Component({
  selector: 'app-header',
  standalone: true,
  imports: [CommonModule],
  providers: [],
  templateUrl: './header.component.html',
  styleUrl: './header.component.scss'
})
export class HeaderComponent implements OnInit {
  constructor(private matDialog:MatDialog) { }
  isLoggedIn: boolean = false;
  ngOnInit(): void {

  }

  openDialog(): void {
    this.matDialog.open(SignupComponent, {
      width: "350px"
    });
  }

}
