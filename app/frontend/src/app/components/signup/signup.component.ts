import { Component, ElementRef } from '@angular/core';

import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatButtonModule } from '@angular/material/button';
import { MatDialogModule } from '@angular/material/dialog';
import { FormsModule } from '@angular/forms';
import { AuthenticationService } from '../../services/authentication/authentication.service';

@Component({
  selector: 'app-signup',
  standalone: true,
  imports: [MatFormFieldModule, MatInputModule, MatButtonModule, MatDialogModule, FormsModule],
  templateUrl: './signup.component.html',
  styleUrl: './signup.component.scss'
})
export class SignupComponent {

  username: any;
  password: any;
  email: any;

  constructor(private elementRef: ElementRef, private authenticationService: AuthenticationService) {}

  private readonly ELEMENTS = {
    LOGIN: '#login',
    REGISTER: '#register',
    BTN: '#btn',
    LOG_PASSWORD: '#logPassword',
    REG_PASSWORD: '#regPassword',
    EYE: '#eye',
    EYE_SLASH: '#eye-slash',
    EYE_2: '#eye-2',
    EYE_SLASH_2: '#eye-slash-2'
};

registerUser() {
  const userData = {
    username: this.username,
    email: this.email,
    password: this.password
  };

  this.authenticationService.registerUser(userData)
    .subscribe(
      {
        next: (response) => {
          console.log(response);
        },
        error: (error) => {
          console.error(error);
        }
      }
      );
}

  private getElement(id: string): HTMLElement {
    return this.elementRef.nativeElement.querySelector(id);
  }

  private setStyle(element: HTMLElement, styles: Partial<CSSStyleDeclaration>): void {
    Object.assign(element.style, styles);
  }

  login(): void {
    const { LOGIN, REGISTER, BTN } = this.ELEMENTS;
    const loginElement = this.getElement(LOGIN);
    const registerElement = this.getElement(REGISTER);
    const btnElement = this.getElement(BTN);

    this.setStyle(loginElement, { left: '27px' });
    this.setStyle(registerElement, { right: '-350px' });
    this.setStyle(btnElement, { left: '0px' });
  }

  register(): void {
    const { LOGIN, REGISTER, BTN } = this.ELEMENTS;
    const loginElement = this.getElement(LOGIN);
    const registerElement = this.getElement(REGISTER);
    const btnElement = this.getElement(BTN);

    this.setStyle(loginElement, { left: '-350px' });
    this.setStyle(registerElement, { right: '25px' });
    this.setStyle(btnElement, { left: '150px' });
  }

  togglePasswordVisibility(passwordId: string, eyeId: string, eyeSlashId: string): void {
    const passwordElement = this.getElement(passwordId) as HTMLInputElement;
    const eyeElement = this.getElement(eyeId);
    const eyeSlashElement = this.getElement(eyeSlashId);

    if (passwordElement.type === 'password') {
      passwordElement.type = 'text';
      this.setStyle(eyeElement, { opacity: '0' });
      this.setStyle(eyeSlashElement, { opacity: '1' });
    } else {
      passwordElement.type = 'password';
      this.setStyle(eyeElement, { opacity: '1' });
      this.setStyle(eyeSlashElement, { opacity: '0' });
    }
  }

  myLogPassword(): void {
    this.togglePasswordVisibility(this.ELEMENTS.LOG_PASSWORD, this.ELEMENTS.EYE, this.ELEMENTS.EYE_SLASH);
  }

  myRegPassword(): void {
    this.togglePasswordVisibility(this.ELEMENTS.REG_PASSWORD, this.ELEMENTS.EYE_2, this.ELEMENTS.EYE_SLASH_2);
  }
}