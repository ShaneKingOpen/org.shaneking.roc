package org.shaneking.roc.persistence.hello.entity;

import com.github.liaochong.myexcel.core.annotation.ExcelModel;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.shaneking.ling.persistence.entity.sql.sqllite.SqlliteEntities;
import org.shaneking.ling.persistence.hello.NullSetter;
import org.shaneking.roc.persistence.entity.ApiAccessEntity;
import org.springframework.stereotype.Component;

import javax.persistence.Table;

@Accessors(chain = true)
@Component
@ExcelModel(includeAllField = false, useFieldNameAsTitle = true)
@Table
@ToString(callSuper = true)
public class HelloApiAccessEntity extends ApiAccessEntity implements SqlliteEntities, NullSetter {
  @Override
  public Class<? extends HelloApiAccessEntity> entityClass() {
    return HelloApiAccessEntity.class;
  }
}
