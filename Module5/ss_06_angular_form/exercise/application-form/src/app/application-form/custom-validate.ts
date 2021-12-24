import {AbstractControl} from '@angular/forms';

export function passwordNotMatch(control: AbstractControl) {
const formControl = control.value;
return formControl.password === formControl.confirmPassword ? null : {passwordnotmatch: true};
}
