/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package md.autoservice.serviceauto.gui.models;

import java.util.Calendar;
import java.util.Locale;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author iucosoft5
 */
public class YearSpinnerModel extends SpinnerNumberModel {

   
    static int maxValue = 2014;
    int curentValue = 2005;

    static {
        Calendar calendar = Calendar.getInstance(Locale.ENGLISH);
        maxValue = calendar.get(Calendar.YEAR);
    }

    public YearSpinnerModel() {
    
        super(maxValue-8, 1950, maxValue, 1);
    }

    @Override
    public Object getValue() {

        return super.getValue();
    }

    @Override
    public void setValue(Object value) {

        super.setValue(value);
    }

    @Override
    public Object getNextValue() {

        return super.getNextValue();
    }

    @Override
    public Object getPreviousValue() {

        return super.getPreviousValue();
    }

 
}
