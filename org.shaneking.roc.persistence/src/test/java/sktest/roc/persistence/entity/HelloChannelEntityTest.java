package sktest.roc.persistence.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.shaneking.ling.jackson.databind.OM3;
import org.shaneking.ling.test.SKUnit;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class HelloChannelEntityTest extends SKUnit {

  @Test
  void testToString() {
    assertAll(
      () -> Assertions.assertEquals("HelloChannelEntity(super=ChannelEntity(super=TenantedEntity(super=CacheableEntity(super=IdAdtVerEntity(super=IdAdtEntity(super=IdEntity(id=null), invalid=null, lastModifyDateTime=null, lastModifyUserId=null), version=null), lastModifyUser=null), tenantId=null), name=null, description=null, tokenValue=null, tokenForce=null, tokenAlgorithmType=null, tokenValueType=null))", new HelloChannelEntity().toString()),
      () -> assertEquals("{}", OM3.writeValueAsString(new HelloChannelEntity().nullSetter()))
    );
  }
}