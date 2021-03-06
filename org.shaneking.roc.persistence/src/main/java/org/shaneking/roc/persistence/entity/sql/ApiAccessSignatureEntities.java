package org.shaneking.roc.persistence.entity.sql;

import org.shaneking.roc.persistence.entity.ApiAccessOpEntities;

import javax.persistence.Transient;

public interface ApiAccessSignatureEntities extends ApiAccessOpEntities {
  @Transient
  String COLUMN__SIGNATURE = "signature";
  @Transient
  String FIELD__SIGNATURE = "signature";

  String getSignature();

  <T extends ApiAccessSignatureEntities> T setSignature(String signature);

  //@see sktest.roc.rr.cfg.RrCfg.helloApiAccessSignatureEntity
  <T extends ApiAccessSignatureEntities> Class<T> entityClass();
}
