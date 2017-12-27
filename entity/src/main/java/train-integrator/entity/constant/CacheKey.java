package train-integrator.entity.constant;

public interface CacheKey {
    /* Change {microservice-name} to micro service name ex : payment, promotion, member, login, etc
        String PREFIX = "train-integrator.{microservice-name}";
        String SYSTEM_PARAMETER = PREFIX + "system-parameter";
    */

  String PREFIX = "train-integrator.train-integrator-";
  String SYSTEM_PARAMETER = PREFIX + "system-parameter";
}
