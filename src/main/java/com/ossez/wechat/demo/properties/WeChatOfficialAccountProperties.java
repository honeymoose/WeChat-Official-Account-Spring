package com.ossez.wechat.demo.properties;

import com.ossez.wechat.demo.enums.HttpClientType;
import com.ossez.wechat.demo.enums.StorageType;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

import java.io.Serializable;

import static com.ossez.wechat.demo.enums.StorageType.Memory;

/**
 * 微信接入相关配置属性.
 *
 * @author someone
 */
@Data
@ConfigurationProperties(prefix = "wechat.official-account")
public class WeChatOfficialAccountProperties {

  /**
   * 设置微信公众号的appid.
   */
  private String appId;

  /**
   * 设置微信公众号的app secret.
   */
  private String secret;

  /**
   * 设置微信公众号的token.
   */
  private String token;

  /**
   * 设置微信公众号的EncodingAESKey.
   */
  private String aesKey;

  /**
   * 自定义host配置
   */
  private HostConfig hosts;

  /**
   * 存储策略
   */
  private final ConfigStorage configStorage = new ConfigStorage();

  @Data
  public static class ConfigStorage implements Serializable {
    private static final long serialVersionUID = 4815731027000065434L;

    /**
     * 存储类型.
     */
    private StorageType type = Memory;

    /**
     * 指定key前缀.
     */
    private String keyPrefix = "wx";

    /**
     * redis连接配置.
     */
    @NestedConfigurationProperty
    private final RedisProperties redis = new RedisProperties();

    /**
     * http客户端类型.
     */
    private HttpClientType httpClientType = HttpClientType.HttpClient;

    /**
     * http代理主机.
     */
    private String httpProxyHost;

    /**
     * http代理端口.
     */
    private Integer httpProxyPort;

    /**
     * http代理用户名.
     */
    private String httpProxyUsername;

    /**
     * http代理密码.
     */
    private String httpProxyPassword;

  }

}