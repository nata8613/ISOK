import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, FormControl } from '@angular/forms';

@Directive({
  selector: '[jmbgLength][formControlName],[jmbgLength][formControl],[jmbgLength][ngModel]',
  providers: [{provide: NG_VALIDATORS, useExisting: JMBGDirective, multi: true}]
})
export class JMBGDirective implements Validator {
  @Input()
  jmbgLength: number;
  
  validate(c: FormControl): {[key: string]: any} {
      let v = c.value.toString();
      return ( v.length != this.jmbgLength)? {"jmbgLength": true} : null;
  }
} 