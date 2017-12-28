package com.tiket.tix.train.integrator.rest.web.controller;

import com.tiket.tix.train.integrator.entity.constant.ApiPath;
import com.tiket.tix.train.integrator.entity.constant.enums.ResponseCode;
import com.tiket.tix.train.integrator.entity.dao.SystemParameter;
import com.tiket.tix.train.integrator.entity.dao.SystemParameterBuilder;
import com.tiket.tix.train.integrator.libraries.exception.BusinessLogicException;
import com.tiket.tix.train.integrator.rest.web.model.request.CreateSystemParameterRequest;
import com.tiket.tix.train.integrator.rest.web.model.request.UpdateSystemParameterRequest;
import com.tiket.tix.train.integrator.rest.web.model.response.SystemParameterResponse;
import com.tiket.tix.train.integrator.service.api.SystemParameterService;
import com.tiket.tix.common.libraries.BeanMapper;
import com.tiket.tix.common.rest.web.model.request.MandatoryRequest;
import com.tiket.tix.common.rest.web.model.response.BaseResponse;
import com.tiket.tix.common.rest.web.model.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(ApiPath.SYSTEM_PARAMETER)
@Api(value = "System Parameter", description = "System Parameter API")
public class SystemParameterController {

  @Autowired
  private SystemParameterService systemParameterService;

  @ApiOperation(value = "Get.systemParameter", notes = "Put all mandatory parameter")
  @RequestMapping(path = ApiPath.SYSTEM_PARAMETER_VARIABLE, method = RequestMethod.GET)
  public BaseResponse<SystemParameterResponse> findByStoreIdAndVariable(
      @PathVariable("variable") String variable,
      @Valid @ModelAttribute MandatoryRequest mandatoryRequest) {
    SystemParameter systemParameter = this.systemParameterService
        .findSystemParameterByStoreId(mandatoryRequest
            .getStoreId(), variable);
    if (systemParameter == null) {
      throw new BusinessLogicException(ResponseCode.DATA_NOT_EXIST.getCode(),
          ResponseCode.DATA_NOT_EXIST.getMessage());
    }
    SystemParameterResponse systemParameterResponse = BeanMapper
        .map(systemParameter, SystemParameterResponse
            .class);

    return CommonResponse
        .constructResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(),
            null,
            systemParameterResponse);
  }

  @ApiOperation(value = "Get.systemParameters (Paginated)", notes = "Put all mandatory parameter")
  @RequestMapping(method = RequestMethod.GET)
  public BaseResponse<Page<SystemParameter>> findByStoreIdAndVariablePaginated(
      @Valid @ModelAttribute MandatoryRequest mandatoryRequest, @RequestParam Integer page,
      @RequestParam Integer limit) {
    Page<SystemParameter> systemParameters = this.systemParameterService
        .findAll(mandatoryRequest
            .getStoreId(), page, limit);

    return CommonResponse
        .constructResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(),
            null,
            systemParameters);
  }

  @RequestMapping(method = RequestMethod.POST)
  public BaseResponse createSystemParameter(
      @Valid @ModelAttribute MandatoryRequest mandatoryRequest, @RequestBody
      CreateSystemParameterRequest createSystemParameterRequest) {
    SystemParameter systemParameter = new SystemParameterBuilder()
        .withStoreId(mandatoryRequest.getStoreId())
        .withVariable(createSystemParameterRequest.getVariable())
        .withValue(createSystemParameterRequest.getValue())
        .withDescription(createSystemParameterRequest.getDescription())
        .withCreatedBy(mandatoryRequest.getUsername())
        .withUpdatedBy(mandatoryRequest.getUsername()).build();

    this.systemParameterService.createSystemParameter(systemParameter);

    return CommonResponse
        .constructResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(),
            null, null);
  }

  @RequestMapping(path = ApiPath.SYSTEM_PARAMETER_VARIABLE, method = RequestMethod.PUT)
  public BaseResponse updateSystemParameter(
      @PathVariable("variable") String variable,
      @Valid @ModelAttribute MandatoryRequest mandatoryRequest,
      @RequestBody UpdateSystemParameterRequest updateSystemParameterRequest) {
    SystemParameter systemParameter = new SystemParameterBuilder()
        .withStoreId(mandatoryRequest.getStoreId())
        .withVariable(variable)
        .withValue(updateSystemParameterRequest.getValue())
        .withDescription(updateSystemParameterRequest.getDescription())
        .withUpdatedBy(mandatoryRequest.getUsername()).build();

    this.systemParameterService.updateSystemParameter(systemParameter);

    return CommonResponse
        .constructResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(),
            null, null);
  }

  @RequestMapping(path = ApiPath.SYSTEM_PARAMETER_VARIABLE, method = RequestMethod.DELETE)
  public BaseResponse deleteByStoreIdAndVariable(
      @Valid @ModelAttribute MandatoryRequest mandatoryRequest,
      @RequestParam String variable) {
    this.systemParameterService.deleteByStoreIdAndVariable(mandatoryRequest.getStoreId(), variable);

    return CommonResponse
        .constructResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(),
            null, null);
  }
}
