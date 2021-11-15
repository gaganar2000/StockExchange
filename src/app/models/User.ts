export interface User {
    id ?: number;
    name ?: string;
    password ?: string;
    email ?: string;
    confirmed ?: boolean;
    admin?: boolean;
    role ?: string;
    mobile ?:string;
}