import { Company } from "./Company";
import { StockExchange } from "./StockExchange";

export interface IPODetail{
    id ?:number;
    pricePerShare ?: number;
    totalNumberOfShares ?: number;
    openDateTime ?: Date;
    remarks ?: string;
    company ?: Company
    stockExchanges ?: [StockExchange];

}