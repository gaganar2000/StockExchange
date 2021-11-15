import { Time } from "@angular/common";
import { Company } from "./Company";
import { StockExchange } from "./StockExchange";

export interface StockPrice{
    id ?: number;
    companycode ?: string;
    shareprice ?: number
    datee ?: Date;
    time ?: string;
    company ?: Company;
    stockexchange ?: StockExchange;
}