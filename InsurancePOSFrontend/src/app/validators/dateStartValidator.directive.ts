import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, FormControl } from '@angular/forms';

@Directive({
  selector: '[customDateStart][formControlName],[customDateStart][formControl],[customDateStart][ngModel]',
  providers: [{provide: NG_VALIDATORS, useExisting: CustomDateStartDirective, multi: true}]
})
export class CustomDateStartDirective implements Validator {

  validate(c: FormControl): {[key: string]: any} {
      let v  = c.value;
      var dateStart = new Date(v);
      var dateNow = new Date();
      return ( dateStart < dateNow)? {"customDateStart": true} : null;
  }
} 