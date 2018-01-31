import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, FormControl } from '@angular/forms';

@Directive({
  selector: '[panLength][formControlName],[panLength][formControl],[panLength][ngModel]',
  providers: [{provide: NG_VALIDATORS, useExisting: PANDirective, multi: true}]
})
export class PANDirective implements Validator {
  @Input()
  panLength: number;
  
  validate(c: FormControl): {[key: string]: any} {
      let v = c.value.toString();
      if(v.length != this.panLength){
        return {"panLength": true};
      }
      if(!v.match(/^-{0,1}\d+$/)){
        return {"panNumber":true}
      }
      return null;
  }
} 