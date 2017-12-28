package com.tiket.tix.train.integrator.entity.constant;

public interface ApiPath {
    /* Change base path to micro service name ex : payment, promotion, member, login, etc
        String BASE_PATH = {project_name};
        String SYSTEM_PARAMETER = BASE_PATH + "/systemParameter";
    */

  String BASE_PATH = "/train-integrator";
  String SYSTEM_PARAMETER = "/systemParameters";
  String SYSTEM_PARAMETER_VARIABLE = "/{variable}";
  String EXTERNAL_SYSTEM_PARAMETER = "/externalSystemParameters";
}
