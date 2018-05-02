package hz.config;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

/**
 * Created by xhz on 2017/11/17.
 * Druid内置提供了一个StatViewServlet用于展示Druid的统计信息。
 * 这个StatViewServlet的用途包括：
 * 提供监控信息展示的html页面
 * 提供监控信息的JSON API
 */
@WebServlet(urlPatterns="/druid/*",
        initParams={
                @WebInitParam(name="allow",value="127.0.0.1,192.168.163.1"),// IP白名单(没有配置或者为空，则允许所有访问)
                @WebInitParam(name="deny",value="192.168.1.73"),// IP黑名单 (存在共同时，deny优先于allow)
                @WebInitParam(name="loginUsername",value="admin"),// 用户名
                @WebInitParam(name="loginPassword",value="123456"),// 密码
                @WebInitParam(name="resetEnable",value="false")// 禁用HTML页面上的“Reset All”功能
        })
public class DruidStatViewServlet {

}
