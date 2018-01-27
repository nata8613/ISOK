import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, FormControl } from '@angular/forms';

@Directive({
  selector: '[customDateEnd][formControlName],[customDateEnd][formControl],[customDateEnd][ngModel]',
  providers: [{provide: NG_VALIDATORS, useExisting: CustomDateEndDirective, multi: true}]
})
export class CustomDateEndDirective implements Validator {
  @Input()
  customDateEnd: Date;
  
  validate(c: FormControl): {[key: string]: any} {
      let v = c.value;
      var dateEnd = new Date(v);
      var dateStart = new Date(this.customDateEnd);
      return ( dateEnd < dateStart)? {"customDateEnd": true} : null;
  }
}  