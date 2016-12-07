package com.wl.resp;

import com.wl.entity.Registration;

/**
 * Created by shizhouyong on 2016/12/6.
 */
public class RegistrationResp extends Response {

    private Registration registration;

    public Registration getRegistration() {
        return registration;
    }

    public void setRegistration(Registration registration) {
        this.registration = registration;
    }
}
