/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fit5042.holidayapp.validator;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

/**
 *
 * @author fengcilin
 */
@FacesValidator("compareDateValidator")
public class CompareDateValidator implements Validator{

    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        
        DateFormat dateFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
        try {
            String startDateString = value.toString();
            String endDateString = component.getAttributes().get("enddate")
                    .toString();
            
            Date startDate = dateFormat.parse(startDateString);
            Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(endDateString);
            
            
            if (startDate == null ||  endDate == null)
            {
                return;
            }
            
            if (startDate.compareTo(endDate) >= 0) {
                
                throw new ValidatorException(new FacesMessage(
                        "The End date of a holiday package must greate than the start date."));
            } } catch (ParseException ex) {
            Logger.getLogger(CompareDateValidator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
