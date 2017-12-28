import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import com.tiket.tix.train.integrator.dao.api.SystemParameterRepository;
import com.tiket.tix.train.integrator.entity.constant.enums.ResponseCode;
import com.tiket.tix.train.integrator.entity.constant.unit.test.CommonTestVariable;
import com.tiket.tix.train.integrator.entity.constant.unit.test.SystemParameterTestVariable;
import com.tiket.tix.train.integrator.entity.dao.SystemParameter;
import com.tiket.tix.train.integrator.libraries.exception.BusinessLogicException;
import com.tiket.tix.train.integrator.service.impl.SystemParameterServiceImpl;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

public class SystemParameterServiceImplTest extends SystemParameterTestVariable {

  @InjectMocks
  SystemParameterServiceImpl systemParameterServiceImpl;

  @Mock
  SystemParameterRepository systemParameterRepository;

  @Test
  public void findAllTest() throws Exception {
    Pageable pageable = new PageRequest(this.PAGE,
        this.SIZE);
    List<SystemParameter> systemParameterList = new ArrayList<>();
    systemParameterList.add(this.SYSTEM_PARAMETER);

    Page<SystemParameter> systemParameterPage = new PageImpl<SystemParameter>(systemParameterList);

    when(this.systemParameterRepository.findByStoreId(CommonTestVariable.STORE_ID, pageable))
        .thenReturn(systemParameterPage);

    Page<SystemParameter> systemParameters = this.systemParameterServiceImpl
        .findAll(CommonTestVariable.STORE_ID, this.PAGE,
            this.SIZE);

    verify(this.systemParameterRepository)
        .findByStoreId(CommonTestVariable.STORE_ID,
            this.PAGEABLE);

    assertEquals(this.VARIABLE,
        systemParameters.getContent().get(0).getVariable());
    assertEquals(this.VALUE,
        systemParameters.getContent().get(0).getValue());
    assertEquals(this.DESCRIPTION,
        systemParameters.getContent().get(0).getDescription());
  }

  @Test
  public void findSystemParameterByStoreIdAndVariableTest() throws Exception {
    when(this.systemParameterRepository
        .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
            this.VARIABLE))
        .thenReturn(this.SYSTEM_PARAMETER);

    SystemParameter systemParameter = this.systemParameterServiceImpl
        .findSystemParameterByStoreId(CommonTestVariable.STORE_ID,
            this.VARIABLE);

    verify(this.systemParameterRepository)
        .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
            this.VARIABLE);

    assertEquals(this.VARIABLE, systemParameter.getVariable());
    assertEquals(this.VALUE, systemParameter.getValue());
    assertEquals(this.DESCRIPTION, systemParameter.getDescription());
  }

  @Test
  public void findSystemParameterByStoreIdAndVariableTestExceptionDataNotExist()
      throws Exception {
    when(this.systemParameterRepository
        .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
            this.VARIABLE))
        .thenReturn(null);
    try {
      this.systemParameterServiceImpl
          .findSystemParameterByStoreId(CommonTestVariable.STORE_ID,
              this.VARIABLE);
    } catch (BusinessLogicException be) {
      assertEquals(ResponseCode.DATA_NOT_EXIST.getCode(), be.getCode());
      assertEquals(ResponseCode.DATA_NOT_EXIST.getMessage(), be.getMessage());

      verify(this.systemParameterRepository)
          .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
              this.VARIABLE);
    }
  }

  @Test
  public void createSystemParameterTest() throws Exception {
    when(this.systemParameterRepository
        .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
            this.VARIABLE))
        .thenReturn(null);

    this.systemParameterServiceImpl
        .createSystemParameter(this.SYSTEM_PARAMETER);

    verify(this.systemParameterRepository)
        .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
            this.VARIABLE);
    verify(this.systemParameterRepository).save(this.SYSTEM_PARAMETER);
  }

  @Test
  public void createSystemParameterTestExceptionDuplicateData() throws Exception {
    when(this.systemParameterRepository
        .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
            this.VARIABLE))
        .thenReturn(this.SYSTEM_PARAMETER);

    try {
      this.systemParameterServiceImpl
          .createSystemParameter(this.SYSTEM_PARAMETER);
    } catch (BusinessLogicException be) {
      assertEquals(ResponseCode.DUPLICATE_DATA.getCode(), be.getCode());
      assertEquals(ResponseCode.DUPLICATE_DATA.getMessage(), be.getMessage());

      verify(this.systemParameterRepository)
          .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
              this.VARIABLE);
    }
  }

  @Test
  public void updateSystemParameterTest() throws Exception {
    when(this.systemParameterRepository
        .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
            this.VARIABLE))
        .thenReturn(this.SYSTEM_PARAMETER);

    this.systemParameterServiceImpl
        .updateSystemParameter(this.SYSTEM_PARAMETER);

    verify(this.systemParameterRepository)
        .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
            this.VARIABLE);
    verify(this.systemParameterRepository).save(this.SYSTEM_PARAMETER);
  }

  @Test
  public void updateSystemParameterTestException_DataNotExist() throws Exception {
    when(this.systemParameterRepository
        .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
            this.VARIABLE)).thenReturn(null);

    try {
      this.systemParameterServiceImpl
          .updateSystemParameter(this.SYSTEM_PARAMETER);
    } catch (BusinessLogicException be) {
      assertEquals(ResponseCode.DATA_NOT_EXIST.getCode(), be.getCode());
      assertEquals(ResponseCode.DATA_NOT_EXIST.getMessage(), be.getMessage());

      verify(this.systemParameterRepository)
          .findSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
              this.VARIABLE);
    }
  }

  @Test
  public void deleteByStoreIdAndVariable() throws Exception {
    this.systemParameterServiceImpl
        .deleteByStoreIdAndVariable(CommonTestVariable.STORE_ID,
            this.VARIABLE);

    verify(this.systemParameterRepository)
        .deleteSystemParameterByStoreIdAndVariable(CommonTestVariable.STORE_ID,
            this.VARIABLE);
  }

  @Before
  public void setUp() throws Exception {
    initMocks(this);
  }

  @After
  public void tearDown() throws Exception {
    verifyNoMoreInteractions(this.systemParameterRepository);
  }
}
