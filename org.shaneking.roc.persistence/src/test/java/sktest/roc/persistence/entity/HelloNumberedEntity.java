package sktest.roc.persistence.entity;

import lombok.ToString;
import lombok.experimental.Accessors;
import org.shaneking.ling.persistence.entity.Numbered;
import org.shaneking.ling.persistence.entity.sql.sqllite.SqlliteSqlEntities;
import org.shaneking.ling.persistence.hello.NullSetter;
import org.shaneking.roc.persistence.CacheableEntity;
import org.shaneking.roc.persistence.entity.NumberedEntities;

import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Accessors(chain = true)
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {Numbered.COLUMN__NO})})
@ToString(callSuper = true)
public class HelloNumberedEntity extends CacheableEntity implements SqlliteSqlEntities, NumberedEntities, NullSetter {
}
