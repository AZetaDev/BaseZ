import { Injectable } from "@angular/core";
import { HttpHandler, HttpInterceptor, HttpRequest } from "@angular/common/http";

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    intercept(request: HttpRequest<any>, next: HttpHandler) {
        const token = localStorage.getItem('access_token');

        if(token) {
            request = request.clone({
                setHeaders: {
                    Authorization: `Bearer ${token}`
                }
            });
        }

        return next.handle(request);
    }
}