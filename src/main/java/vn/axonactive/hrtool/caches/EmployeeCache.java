package vn.axonactive.hrtool.caches;

import org.ehcache.Cache;
import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;

import vn.axonactive.hrtool.entities.Employee;

public class EmployeeCache {

	CacheManager cacheManager = CacheManagerBuilder.newCacheManagerBuilder()
			.withCache("employeeInfoCache", CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, Employee.class, ResourcePoolsBuilder.heap(100)).build())
			.build(true);
	
	Cache<Integer, Employee> preConfig = cacheManager.getCache("employeeInfoCache", Integer.class, Employee.class);
	
	Cache<Integer, Employee> employeeInfoCache = cacheManager.createCache("employeeInfoCache", 
			CacheConfigurationBuilder.newCacheConfigurationBuilder(Integer.class, Employee.class,
					ResourcePoolsBuilder.heap(100).build()));
	
	
}