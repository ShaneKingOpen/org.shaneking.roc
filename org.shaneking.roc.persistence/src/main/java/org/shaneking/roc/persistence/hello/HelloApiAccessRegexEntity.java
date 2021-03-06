package org.shaneking.roc.persistence.hello;

import com.github.liaochong.myexcel.core.annotation.ExcelModel;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.shaneking.ling.persistence.entity.sql.Channelized;
import org.shaneking.ling.persistence.entity.sql.Tenanted;
import org.shaneking.ling.persistence.entity.sql.sqllite.SqlliteSqlEntities;
import org.shaneking.roc.persistence.entity.sql.ApiAccessRegexExample;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Accessors(chain = true)
@Component
@ConditionalOnProperty(prefix = "sk.roc.persistence.hello.entity", value = "enabled")
@ExcelModel(includeAllField = false, useFieldNameAsTitle = true)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {Channelized.COLUMN__CHANNEL_ID, Tenanted.COLUMN__TENANT_ID})})
@ToString(callSuper = true)
public class HelloApiAccessRegexEntity extends ApiAccessRegexExample implements SqlliteSqlEntities {
  @Override
  public Class<? extends HelloApiAccessRegexEntity> entityClass() {
    return this.getClass();
  }
}
