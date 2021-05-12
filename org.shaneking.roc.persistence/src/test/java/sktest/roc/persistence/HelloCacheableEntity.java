package sktest.roc.persistence;

import lombok.ToString;
import lombok.experimental.Accessors;
import org.shaneking.ling.persistence.entity.sql.sqllite.SqlliteSqlEntities;
import org.shaneking.roc.persistence.AbstractCacheableEntity;

import javax.persistence.Table;

@Accessors(chain = true)
@Table
@ToString(callSuper = true)
public class HelloCacheableEntity extends AbstractCacheableEntity implements SqlliteSqlEntities {

}
