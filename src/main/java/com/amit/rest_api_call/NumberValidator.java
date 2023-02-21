package com.amit.rest_api_call;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;
import java.util.List;

public class NumberValidator implements ConstraintValidator<PositiveInt, String>
{
    public boolean isValid(String colorName, ConstraintValidatorContext cxt) {
        System.out.println("color name is "+colorName);
        List list = Arrays.asList(new String[]{"RED","GREEN","BLUE"});
        return list.contains(colorName);
    }
}
