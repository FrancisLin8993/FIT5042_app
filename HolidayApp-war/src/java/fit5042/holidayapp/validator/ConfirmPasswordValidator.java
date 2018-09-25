/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author fengcilin
 */
@FacesValidator("confirmPasswordValidator")
public class ConfirmPasswordValidator implements Validator{
    
    @Override
    public void validate(FacesContext context, UIComponent component,
            Object value) throws ValidatorException {

      String password = value.toString();
      

      
      String confirmPassword = component.getAttributes().get("confirmPassword")
            .toString();
        

      
      if (password == null ||  confirmPassword == null) 
      {
            return;
      }

      if (!password.equals(confirmPassword)) {
            
            throw new ValidatorException(new FacesMessage(
                    "Password must match confirm password."));
      }

    }
}
