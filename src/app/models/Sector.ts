import { Company } from "./Company";

export interface Sector{
    id ?: number;
    sectorName?:string;
    brief?:string;
    companies ?: Array<Company>

}