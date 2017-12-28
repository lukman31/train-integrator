package com.tiket.tix.train.integrator.entity.outbound;

import java.util.Date;
import javax.annotation.Generated;

@Generated("PojoBuilder")
public class ExternalSystemParameterBuilder
    implements Cloneable {
  protected ExternalSystemParameterBuilder self;
  protected String value$id$java$lang$String;
  protected boolean isSet$id$java$lang$String;
  protected Long value$version$java$lang$Long;
  protected boolean isSet$version$java$lang$Long;
  protected Date value$createdDate$java$util$Date;
  protected boolean isSet$createdDate$java$util$Date;
  protected String value$createdBy$java$lang$String;
  protected boolean isSet$createdBy$java$lang$String;
  protected Date value$updatedDate$java$util$Date;
  protected boolean isSet$updatedDate$java$util$Date;
  protected String value$updatedBy$java$lang$String;
  protected boolean isSet$updatedBy$java$lang$String;
  protected String value$storeId$java$lang$String;
  protected boolean isSet$storeId$java$lang$String;
  protected Integer value$isDeleted$java$lang$Integer;
  protected boolean isSet$isDeleted$java$lang$Integer;
  protected String value$variable$java$lang$String;
  protected boolean isSet$variable$java$lang$String;
  protected String value$value$java$lang$String;
  protected boolean isSet$value$java$lang$String;
  protected String value$description$java$lang$String;
  protected boolean isSet$description$java$lang$String;

  /**
   * Creates a new {@link ExternalSystemParameterBuilder}.
   */
  public ExternalSystemParameterBuilder() {
    self = (ExternalSystemParameterBuilder)this;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameter#id} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterBuilder withId(String value) {
    this.value$id$java$lang$String = value;
    this.isSet$id$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameter#version} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterBuilder withVersion(Long value) {
    this.value$version$java$lang$Long = value;
    this.isSet$version$java$lang$Long = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameter#createdDate} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterBuilder withCreatedDate(Date value) {
    this.value$createdDate$java$util$Date = value;
    this.isSet$createdDate$java$util$Date = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameter#createdBy} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterBuilder withCreatedBy(String value) {
    this.value$createdBy$java$lang$String = value;
    this.isSet$createdBy$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameter#updatedDate} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterBuilder withUpdatedDate(Date value) {
    this.value$updatedDate$java$util$Date = value;
    this.isSet$updatedDate$java$util$Date = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameter#updatedBy} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterBuilder withUpdatedBy(String value) {
    this.value$updatedBy$java$lang$String = value;
    this.isSet$updatedBy$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameter#storeId} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterBuilder withStoreId(String value) {
    this.value$storeId$java$lang$String = value;
    this.isSet$storeId$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameter#isDeleted} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterBuilder withIsDeleted(Integer value) {
    this.value$isDeleted$java$lang$Integer = value;
    this.isSet$isDeleted$java$lang$Integer = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameter#variable} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterBuilder withVariable(String value) {
    this.value$variable$java$lang$String = value;
    this.isSet$variable$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameter#value} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterBuilder withValue(String value) {
    this.value$value$java$lang$String = value;
    this.isSet$value$java$lang$String = true;
    return self;
  }

  /**
   * Sets the default value for the {@link ExternalSystemParameter#description} property.
   *
   * @param value the default value
   * @return this builder
   */
  public ExternalSystemParameterBuilder withDescription(String value) {
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
      ExternalSystemParameterBuilder result = (ExternalSystemParameterBuilder)super.clone();
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
  public ExternalSystemParameterBuilder but() {
    return (ExternalSystemParameterBuilder)clone();
  }

  /**
   * Creates a new {@link ExternalSystemParameter} based on this builder's settings.
   *
   * @return the created ExternalSystemParameter
   */
  public ExternalSystemParameter build() {
    try {
      ExternalSystemParameter result = new ExternalSystemParameter();
      if (isSet$id$java$lang$String) {
        result.setId(value$id$java$lang$String);
      }
      if (isSet$version$java$lang$Long) {
        result.setVersion(value$version$java$lang$Long);
      }
      if (isSet$createdDate$java$util$Date) {
        result.setCreatedDate(value$createdDate$java$util$Date);
      }
      if (isSet$createdBy$java$lang$String) {
        result.setCreatedBy(value$createdBy$java$lang$String);
      }
      if (isSet$updatedDate$java$util$Date) {
        result.setUpdatedDate(value$updatedDate$java$util$Date);
      }
      if (isSet$updatedBy$java$lang$String) {
        result.setUpdatedBy(value$updatedBy$java$lang$String);
      }
      if (isSet$storeId$java$lang$String) {
        result.setStoreId(value$storeId$java$lang$String);
      }
      if (isSet$isDeleted$java$lang$Integer) {
        result.setIsDeleted(value$isDeleted$java$lang$Integer);
      }
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
