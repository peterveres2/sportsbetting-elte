package com.epam.training.sportsbetting.web.transformers;

import com.epam.training.sportsbetting.domain.User;
import com.epam.training.sportsbetting.web.forms.RegistrationForm;

public class UserEntityTransformer extends AbstractTransformer<RegistrationForm, User> {

    @Override
    public User transform(RegistrationForm registrationForm) {
        User user = new User();
        user.setUsername(registrationForm.getUserName());
        user.setPassword(registrationForm.getPassword());
        return user;
    }

}
