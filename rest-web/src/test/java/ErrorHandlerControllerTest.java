import static org.hamcrest.CoreMatchers.equalTo;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.MockitoAnnotations.initMocks;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import com.tiket.tix.train.integrator.entity.constant.ApiPath;
import com.tiket.tix.train.integrator.entity.constant.enums.ResponseCode;
import com.tiket.tix.train.integrator.entity.constant.unit.test.CommonTestVariable;
import com.tiket.tix.train.integrator.entity.constant.unit.test.SystemParameterTestVariable;
import com.tiket.tix.train.integrator.rest.web.controller.ErrorHandlerController;
import com.tiket.tix.train.integrator.rest.web.controller.SystemParameterController;
import com.tiket.tix.train.integrator.service.api.SystemParameterService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.xml.sax.ErrorHandler;

public class ErrorHandlerControllerTest {

  private MockMvc mockMvc;

  @InjectMocks
  SystemParameterController systemParameterController;

  @Mock
  SystemParameterService systemParameterService;

  @Test
  public void bindExceptionTestEmptyStoreId() throws Exception {
    this.mockMvc
        .perform(
            get(ApiPath.SYSTEM_PARAMETER).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("storeId", "")
                .param("requestId", CommonTestVariable.REQUEST_ID)
                .param("channelId", CommonTestVariable.CHANNEL_ID)
                .param("serviceId", CommonTestVariable.SERVICE_ID)
                .param("username", CommonTestVariable.USERNAME)
                .param("variable", SystemParameterTestVariable.VARIABLE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code", equalTo(ResponseCode.BIND_ERROR.getCode())))
        .andExpect(jsonPath("$.message", equalTo(ResponseCode.BIND_ERROR.getMessage())));
  }

  @Test
  public void bindExceptionTestEmptyRequestId() throws Exception {
    this.mockMvc
        .perform(
            get(ApiPath.SYSTEM_PARAMETER).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("storeId", CommonTestVariable.STORE_ID)
                .param("requestId", "")
                .param("channelId", CommonTestVariable.CHANNEL_ID)
                .param("serviceId", CommonTestVariable.SERVICE_ID)
                .param("username", CommonTestVariable.USERNAME)
                .param("variable", SystemParameterTestVariable.VARIABLE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code", equalTo(ResponseCode.BIND_ERROR.getCode())))
        .andExpect(jsonPath("$.message", equalTo(ResponseCode.BIND_ERROR.getMessage())));
  }

  @Test
  public void bindExceptionTestEmptyChannelId() throws Exception {
    this.mockMvc
        .perform(
            get(ApiPath.SYSTEM_PARAMETER).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("storeId", CommonTestVariable.STORE_ID)
                .param("requestId", CommonTestVariable.REQUEST_ID)
                .param("channelId", "")
                .param("serviceId", CommonTestVariable.SERVICE_ID)
                .param("username", CommonTestVariable.USERNAME)
                .param("variable", SystemParameterTestVariable.VARIABLE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code", equalTo(ResponseCode.BIND_ERROR.getCode())))
        .andExpect(jsonPath("$.message", equalTo(ResponseCode.BIND_ERROR.getMessage())));
  }

  @Test
  public void bindExceptionTestEmptyServiceId() throws Exception {
    this.mockMvc
        .perform(
            get(ApiPath.SYSTEM_PARAMETER).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("storeId", CommonTestVariable.STORE_ID)
                .param("requestId", CommonTestVariable.REQUEST_ID)
                .param("channelId", CommonTestVariable.CHANNEL_ID)
                .param("serviceId", "")
                .param("username", CommonTestVariable.USERNAME)
                .param("variable", SystemParameterTestVariable.VARIABLE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code", equalTo(ResponseCode.BIND_ERROR.getCode())))
        .andExpect(jsonPath("$.message", equalTo(ResponseCode.BIND_ERROR.getMessage())));
  }

  @Test
  public void bindExceptionTestEmptyUsername() throws Exception {
    this.mockMvc
        .perform(
            get(ApiPath.SYSTEM_PARAMETER).accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .param("storeId", CommonTestVariable.STORE_ID)
                .param("requestId", CommonTestVariable.REQUEST_ID)
                .param("channelId", CommonTestVariable.CHANNEL_ID)
                .param("serviceId", CommonTestVariable.SERVICE_ID)
                .param("username", "")
                .param("variable", SystemParameterTestVariable.VARIABLE))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.code", equalTo(ResponseCode.BIND_ERROR.getCode())))
        .andExpect(jsonPath("$.message", equalTo(ResponseCode.BIND_ERROR.getMessage())));
  }

  @Before
  public void setUp() throws Exception {
    initMocks(this);

    this.mockMvc = standaloneSetup(this.systemParameterController).setControllerAdvice(new ErrorHandlerController()).build();
  }

  @After
  public void tearDown() throws Exception {
    verifyNoMoreInteractions(this.systemParameterService);
  }
}
