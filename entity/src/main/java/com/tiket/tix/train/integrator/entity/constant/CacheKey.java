package com.tiket.tix.train.integrator.entity.constant;

public interface CacheKey {
    /* Change {microservice-name} to micro service name ex : payment, promotion, member, login, etc
        String PREFIX = "com.tiket.tix.{microservice-name}";
        String SYSTEM_PARAMETER = PREFIX + "system-parameter";
    */

  String PREFIX = "com.tiket.tix.train-integrator-";
  String SYSTEM_PARAMETER = PREFIX + "system-parameter";
}
