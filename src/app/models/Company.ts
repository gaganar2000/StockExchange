import { IPODetail } from "./IPODetail";
import { Sector } from "./Sector";
import { StockExchange } from "./StockExchange";
import { StockPrice } from "./StockPrice";

export interface Company{
    id ?: number;
    companyName ?: string;
    turnover ?: number;
    ceo ?: string;
    boardOfDirectors ?: string;
    companyBrief ?: string;
    ipo ?: IPODetail;
    stockprice ?:[StockPrice];
    stockexchange ?: [StockExchange];
    sector ?: Sector;

}