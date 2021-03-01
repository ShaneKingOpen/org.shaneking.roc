package org.shaneking.roc.persistence.entity.sql;

import org.shaneking.roc.persistence.entity.TenantedEntities;

import javax.persistence.Transient;

public interface ChannelEntities extends TenantedEntities {

  @Transient
  String ERR_CODE__NEED_ENCODING = "API_ACCESS__NEED_ENCODING";

  @Transient
  String TOKEN_VALUE_TYPE__SELF = "SELF";
  @Transient
  String TOKEN_VALUE_TYPE__PROP = "PROP";

  String getName();

  <T extends ChannelEntities> T setName(String name);

  String getDescription();

  <T extends ChannelEntities> T setDescription(String description);

  String getTokenValue();

  <T extends ChannelEntities> T setTokenValue(String tokenValue);

  String getTokenForce();

  <T extends ChannelEntities> T setTokenForce(String tokenForce);

  String getTokenAlgorithmType();

  <T extends ChannelEntities> T setTokenAlgorithmType(String tokenAlgorithmType);

  String getTokenValueType();

  <T extends ChannelEntities> T setTokenValueType(String tokenValueType);

  //@see sktest.roc.rr.cfg.RrCfg.helloChannelEntity
  <T extends ChannelEntities> Class<T> entityClass();
}