import { Company } from "./Company";
import { IPODetail } from "./IPODetail";
import { StockPrice } from "./StockPrice";

export interface StockExchange{

    id ?: number;
    name ?: string;
    address ?: string;
    city ?: string;
    country ?: string;
    remarks ?: string;
    brief ?: string;
    company ?: [Company];
    ipoDetail ?: [IPODetail];
    stockprice ?: [StockPrice];

}