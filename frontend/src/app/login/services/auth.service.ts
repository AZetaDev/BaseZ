import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";

import { tap } from "rxjs/operators";

@Injectable({
    providedIn: 'root'
})
export class AuthService {
    
    constructor(private http: HttpClient) {}

    login(username: string, password: string) {
        return this.http
        .post<any>('http://localhost:8080/jwt', { username, password })
        .pipe(
            tap(response => {
                localStorage.setItem('access_token', response.token);
            })
        );
    }

    isLoggedIn() {
        return localStorage.getItem('access_token') !== null;
    }

    logout() {
        localStorage.removeItem('access_token');
    }
}