package com.tiket.tix.train.integrator.rest.web.model.response;

import javax.annotation.Generated;

@Generated("PojoBuilder")
public class ExternalSystemParameterResponseBuilder
    implements Cloneable {
  protected ExternalSystemParameterResponseBuilder self;
  protected String value$variable$java$lang$String;
  protected boolean isSet$variable$java$lang$String;
  protected String value$value$java$lang$String;
  protected boolean isSet$value$java$lang$String;
  protected String value$description$java$lang$String;
  protected boolean isSet$description$java$lang$String;

  /**
   * Creates a new {@link ExternalSystemParameterResponseBuilder}.
   */
  public ExternalSystemParameterResponseBuilder() {
    self = (ExternalSystemParameterResponseBuilder)this;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameterResponse#variable} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterResponseBuilder withVariable(String value) {
    this.value$variable$java$lang$String = value;
    this.isSet$variable$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameterResponse#value} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterResponseBuilder withValue(String value) {
    this.value$value$java$lang$String = value;
    this.isSet$value$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameterResponse#description} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterResponseBuilder withDescription(String value) {
    this.value$description$java$lang$String = value;
    this.isSet$description$java$lang$String = true;
    return self;
  }

  /**
   * Returns a clone of this builder.
   *
   * @return the clone
   */
  @Override
  public Object clone() {
    try {
      ExternalSystemParameterResponseBuilder result = (ExternalSystemParameterResponseBuilder)super.clone();
      result.self = result;
      return result;
    } catch (CloneNotSupportedException e) {
      throw new InternalError(e.getMessage());
    }
  }

  /**
   * Returns a clone of this builder.
   *
   * @return the clone
   */
  public ExternalSystemParameterResponseBuilder but() {
    return (ExternalSystemParameterResponseBuilder)clone();
  }

  /**
   * Creates a new {@link ExternalSystemParameterResponse} based on this builder's settings.
   *
   * @return the created ExternalSystemParameterResponse
   */
  public ExternalSystemParameterResponse build() {
    try {
      ExternalSystemParameterResponse result = new ExternalSystemParameterResponse();
      if (isSet$variable$java$lang$String) {
        result.setVariable(value$variable$java$lang$String);
      }
      if (isSet$value$java$lang$String) {
        result.setValue(value$value$java$lang$String);
      }
      if (isSet$description$java$lang$String) {
        result.setDescription(value$description$java$lang$String);
      }
      return result;
    } catch (RuntimeException ex) {
      throw ex;
    } catch (Exception ex) {
      throw new java.lang.reflect.UndeclaredThrowableException(ex);
    }
  }
}
