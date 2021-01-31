package sktest.roc.persistence.entity;

import lombok.ToString;
import lombok.experimental.Accessors;
import org.shaneking.ling.persistence.sql.entity.sqllite.SqlliteDialectSqlEntities;
import org.shaneking.ling.persistence.test.NullSetter;
import org.shaneking.roc.persistence.entity.IdentifiedTenantedEntity;

import javax.persistence.Table;

@Accessors(chain = true)
@Table
@ToString(callSuper = true)
public class Test4IdentifiedTenantedEntity extends IdentifiedTenantedEntity implements SqlliteDialectSqlEntities, NullSetter {

}
