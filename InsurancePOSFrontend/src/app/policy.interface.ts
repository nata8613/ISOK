import {TravelInsurance} from './travelInsurance.interface';
import {Person} from './person.interface';
import {HomeInsurance} from './homeInsurance.interface';
import {CarInsurance} from './carInsurance.interface';

export interface Policy {
    travelInsurance: TravelInsurance,
    people: Person[],
    homeInsurance: HomeInsurance,
    carInsurance: CarInsurance,
    priceTravel: number,
    priceHome: number,
    priceCar: number
}