package me.unc.ribbonconsumer.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import me.unc.ribbonconsumer.domain.User;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private RestTemplate restTemplate;

    @CacheResult(cacheKeyMethod = "getUserByIdCacheKey")    //设置开启缓存，设置CacheKey方法
    @HystrixCommand(fallbackMethod = "defaultUser")  //设置服务降级逻辑
    public User getUserById(long id) {
        logger.info("call USER-SERVICE");
        return restTemplate.getForObject("http://USER-SERVICE/user/{1}", User.class, id);
    }

    @CacheRemove(commandKey = "getUserById", cacheKeyMethod = "getUserByIdCacheKey")  //设置缓存失效
    @HystrixCommand
    public void update(User user) {
        restTemplate.postForObject("http://USER-SERVICE/users/", user, User.class);
    }

    //请求合并
    @HystrixCollapser(batchMethod = "findAll", collapserProperties = {   //设置请求合并器
            @HystrixProperty(name = "timerDelayInMilliseconds", value = "100")  //延时
    })
    public User find(long id) {
        return null;
    }

    @HystrixCommand
    public List<User> findAll(List<Long> ids) {
        return restTemplate.getForObject("http://USER-SERVICE/users?ids={1}", List.class, StringUtils.join(ids, ","));
    }

    public User defaultUser(long id, Throwable throwable) {
        if (throwable != null) {
            logger.error(throwable.getMessage());
        }
        return new User();
    }

    //用于指定CacheKey
    public String getUserByIdCacheKey(long id) {
        return id + "";
    }

}
