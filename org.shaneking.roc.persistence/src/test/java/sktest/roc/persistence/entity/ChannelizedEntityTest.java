package sktest.roc.persistence.entity;

import org.junit.jupiter.api.Test;
import org.shaneking.ling.jackson.databind.OM3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChannelizedEntityTest {

  @Test
  void testToString() {
    assertAll(
      () -> assertEquals("HelloChannelizedEntity(super=ChannelizedEntity(super=TenantedEntity(super=CacheableEntity(super=AbstractIdAdtVerSqlEntity(id=null, invalid=null, lastModifyDateTime=null, lastModifyUserId=null, version=null), lastModifyUser=null), tenantId=null), channelId=null))", new HelloChannelizedEntity().toString()),
      () -> assertEquals("{}", OM3.writeValueAsString(new HelloChannelizedEntity().nullSetter()))
    );
  }
}
