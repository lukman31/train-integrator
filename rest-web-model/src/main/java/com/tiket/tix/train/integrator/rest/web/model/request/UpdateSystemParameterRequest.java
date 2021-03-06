package com.tiket.tix.train.integrator.rest.web.model.request;

import com.tiket.tix.common.entity.CommonModel;
import org.hibernate.validator.constraints.NotBlank;

public class UpdateSystemParameterRequest extends CommonModel {

  private static final long serialVersionUID = 1L;

  @NotBlank
  private String value;

  @NotBlank
  private String description;

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public String toString() {
    return "UpdateSystemParameterRequest{" +
        "value='" + value + '\'' +
        ", description='" + description + '\'' +
        "} " + super.toString();
  }
}
