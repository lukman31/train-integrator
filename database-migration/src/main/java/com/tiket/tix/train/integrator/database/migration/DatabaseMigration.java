package com.tiket.tix.train.integrator.database.migration;

import com.github.mongobee.changeset.ChangeLog;
import com.github.mongobee.changeset.ChangeSet;
import com.tiket.tix.train.integrator.entity.dao.SystemParameter;
import org.springframework.data.mongodb.core.MongoTemplate;

@ChangeLog
public class DatabaseMigration {

  @ChangeSet(order = "001", id = "addSystemParam", author = "testAuthor")
  public void addNewSystemParam(MongoTemplate mongoTemplate){
    for(int a = 0; a < 100; a++){
      SystemParameter systemParameter = new SystemParameter();
      systemParameter.setVariable("test1");
      systemParameter.setValue("Value 1");
      systemParameter.setDescription("Isi baru");
      systemParameter.setStoreId("TIKETCOM");
      mongoTemplate.save(systemParameter);
    }
  }


}
