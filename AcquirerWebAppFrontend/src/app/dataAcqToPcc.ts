export interface DataAcqToPcc {
    acquirerOrderId: string,
    acquirerTimestamp: Date,
    pan: string,
    secuityCode: number,
    cardHolderName: string,
    validDate: Date,
    amount: number
}