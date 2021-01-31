package sktest.roc.persistence.entity;

import org.junit.jupiter.api.Test;
import org.shaneking.ling.jackson.databind.OM3;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ChannelizedEntityTest {

  @Test
  void testToString() {
    assertAll(
      () -> assertEquals("Test4ChannelizedEntity(super=ChannelizedEntity(super=CacheableEntity(super=IdAdtVerEntity(super=IdAdtEntity(super=IdEntity(id=null), invalid=null, lastModifyDateTime=null, lastModifyUserId=null), version=null)), channelId=null))", new Test4ChannelizedEntity().toString()),
      () -> assertEquals("{}", OM3.writeValueAsString(new Test4ChannelizedEntity().nullSetter()))
    );
  }
}
