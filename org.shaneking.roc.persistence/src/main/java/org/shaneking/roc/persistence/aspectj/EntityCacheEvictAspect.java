package org.shaneking.roc.persistence.aspectj;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.shaneking.ling.jackson.databind.OM3;
import org.shaneking.ling.zero.annotation.ZeroAnnotation;
import org.shaneking.ling.zero.lang.Object0;
import org.shaneking.ling.zero.lang.String0;
import org.shaneking.roc.cache.RocCaches;
import org.shaneking.roc.persistence.annotation.EntityCacheEvict;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

@Aspect
@Component
@ConditionalOnProperty(prefix = "sk.roc.persistence.entity.cache", value = "enabled")
@Slf4j
public class EntityCacheEvictAspect {
  @Value("${sk.roc.persistence.entity.cache.enabled:false}")
  private boolean enabled;
  @Autowired
  private RocCaches cache;

  @Pointcut("execution(@org.shaneking.roc.persistence.annotation.EntityCacheEvict * *..*.*(..))")
  private void pointcut() {
  }

  @After("pointcut() && @annotation(entityCacheEvict)")
  public void after(JoinPoint jp, EntityCacheEvict entityCacheEvict) throws Throwable {
    if (enabled) {
      if (jp.getArgs().length > entityCacheEvict.clsIdx() && jp.getArgs()[entityCacheEvict.clsIdx()] instanceof Class) {
        Class clazz = (Class) jp.getArgs()[entityCacheEvict.clsIdx()];
        try {
          if (entityCacheEvict.empty()) {
            cache.del(clazz.getName());
          } else {
            if (entityCacheEvict.pKeyIdx() > -1) {
              Object pKeyObj = jp.getArgs()[entityCacheEvict.pKeyIdx()];
              if (pKeyObj instanceof List) {
                //org.shaneking.roc.persistence.dao.CacheableDao.delByIds
                List<String> pKeyList = String0.isNullOrEmpty(entityCacheEvict.pKeyPath()) ? (List<String>) pKeyObj : ((List<Object>) pKeyObj).parallelStream().map(o -> String.valueOf(Object0.gs(o, entityCacheEvict.pKeyPath()))).filter(s -> !String0.isNullOrEmpty(s)).collect(Collectors.toList());
                log.info(MessageFormat.format("{0} - {1}({2}) : {3}", clazz.getName(), RocCaches.ERR_CODE__CACHE_HIT_PART, cache.hdel(clazz.getName(), pKeyList.toArray(new String[0])), OM3.writeValueAsString(pKeyList)));
              } else {
                //org.shaneking.roc.persistence.dao.CacheableDao.delById(java.lang.Class<T>, T)
                //org.shaneking.roc.persistence.dao.CacheableDao.delById(java.lang.Class<T>, T, java.lang.String)
                String k = String.valueOf(String0.isNullOrEmpty(entityCacheEvict.pKeyPath()) ? pKeyObj : Object0.gs(pKeyObj, entityCacheEvict.pKeyPath()));
                if (String0.isNull2Empty(k)) {
                  log.warn(MessageFormat.format("{0} - {1}", jp.getSignature().toLongString(), ZeroAnnotation.ERR_CODE__ANNOTATION_SETTING_ERROR));
                } else {
                  log.info(MessageFormat.format("{0} - {1}({2}) : {3}", clazz.getName(), RocCaches.ERR_CODE__CACHE_HIT_PART, cache.hdel(clazz.getName(), k), k));
                }
              }
            }
          }
        } catch (Throwable e) {
          ///ignore exception : if exception, what do you want?
          log.error(String.valueOf(clazz), e);
        }
      } else {
        log.warn(MessageFormat.format("{0} - {1}", jp.getSignature().toLongString(), ZeroAnnotation.ERR_CODE__ANNOTATION_SETTING_ERROR));
      }
    }
  }
}
