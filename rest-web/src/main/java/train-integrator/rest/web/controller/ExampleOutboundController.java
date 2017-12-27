package train-integrator.rest.web.controller;

import train-integrator.entity.constant.ApiPath;
import train-integrator.entity.constant.enums.ResponseCode;
import train-integrator.entity.outbound.ExternalSystemParameter;
import train-integrator.service.api.ExternalSystemParameterService;
import train-integrator.rest.web.model.response.ExternalSystemParameterResponse;
import train-integrator.common.libraries.BeanMapper;
import train-integrator.common.rest.web.model.request.MandatoryRequest;
import train-integrator.common.rest.web.model.response.BaseResponse;
import train-integrator.common.rest.web.model.response.CommonResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping(ApiPath.EXTERNAL_SYSTEM_PARAMETER)
@Api(value = "External System Parameter", description = "External System Parameter API")
public class ExampleOutboundController {

  @Autowired
  private ExternalSystemParameterService externalSystemParameterService;

  private static final Logger LOGGER = LoggerFactory.getLogger(ExampleOutboundController.class);

  @ApiOperation(value = "Get.externalSystemParameter", notes = "Put all mandatory parameter")
  @RequestMapping(method = RequestMethod.GET)
  public BaseResponse<ExternalSystemParameterResponse> getExternalParameterList(
      @ApiIgnore @Valid @ModelAttribute
          MandatoryRequest mandatoryRequest) {
    ExternalSystemParameter externalSystemParameter = this.externalSystemParameterService
        .getAll();

    ExternalSystemParameterResponse externalSystemParameterResponses = BeanMapper
        .map(externalSystemParameter, ExternalSystemParameterResponse.class);

    return CommonResponse.constructResponse(ResponseCode.SUCCESS.getCode(), ResponseCode.SUCCESS.getMessage(),
        null, externalSystemParameterResponses);
  }
}
