export class InsuranceCategory {
 
  id: number;
  categoryName: string;
  risk: any[];
  
 
  constructor(id: number, categoryName: string, risk: any[]){
    this.id = id;
    this.categoryName = categoryName;
    this.risk = risk;
  }
 
}