package cn.pioneer.dcim.cmdb.common.util;

import cn.pioneer.dcim.cmdb.common.emun.ConfigTypeEmun;
import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

import static cn.pioneer.dcim.cmdb.common.constants.CommConst.NEW_LINE;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: CMDB通用信息处理工具类
 * @create 2018-01-11 10:15
 */
public class CmdbUtil {
    private CmdbUtil() {
    }

    /**
     * patch基本的更新信息
     *
     * @param abstractEntity     配置项
     * @param httpServletRequest 请求头
     */
    public static void patchUpdateInfo(AbstractConfigItem abstractEntity, HttpServletRequest httpServletRequest) {
        Date now = new Date();
        abstractEntity.setCreatedBy("luxinglin");
        abstractEntity.setUpdateBy("luxinglin");
        abstractEntity.setCreatedDt(now);
        abstractEntity.setUpdatedDt(now);
        abstractEntity.setDataSource("人工更新");
    }

    /**
     * 图形数据完善，追加节点名称、图片、类型、类型名称、tips等信息
     *
     * @param graphResult 图形数据简要结果
     */
    public static void patchGraph(GraphResult graphResult) {
        if (graphResult == null) {
            return;
        }
        if (graphResult.getNodes().size() == 0) {
            return;
        }

        graphResult.getNodes().forEach(graphNode -> {
            AbstractConfigItem configItem = graphNode.getConfigItem();
            graphNode.setTitle(configItem.getName());
            patchTypeInfo(configItem);
            graphNode.setTypeCode(configItem.getTypeCode());
            graphNode.setTypeName(configItem.getTypeName());
            graphNode.setTips(tips(configItem));
            graphNode.setImage("assets/config_item/".concat(configItem.getTypeCode()).concat(".svg"));
        });
    }

    /**
     * 设置配置项类型
     *
     * @param configItem
     */
    public static void patchTypeInfo(AbstractConfigItem configItem) {
        if (configItem == null) {
            return;
        }
        //1
        if (configItem instanceof BizSystemConfigItem) {
            configItem.setTypeCode(ConfigTypeEmun.BIZSYSTEM.getCode());
            configItem.setTypeName(ConfigTypeEmun.BIZSYSTEM.getName());
            return;
        }
        //2
        if (configItem instanceof ServerConfigItem) {
            configItem.setTypeCode(ConfigTypeEmun.SERVER.getCode());
            configItem.setTypeName(ConfigTypeEmun.SERVER.getName());
            return;
        }
        //3
        if (configItem instanceof NetworkConfigItem) {
            configItem.setTypeCode(ConfigTypeEmun.NETWORK.getCode());
            configItem.setTypeName(ConfigTypeEmun.NETWORK.getName());
            return;
        }
        //4
        if (configItem instanceof StorageConfigItem) {
            configItem.setTypeCode(ConfigTypeEmun.STORAGE.getCode());
            configItem.setTypeName(ConfigTypeEmun.STORAGE.getName());
            return;
        }
        //5
        if (configItem instanceof MiddlewareConfigItem) {
            configItem.setTypeCode(ConfigTypeEmun.MIDDLEWARE.getCode());
            configItem.setTypeName(ConfigTypeEmun.MIDDLEWARE.getName());
            return;
        }
        //6
        if (configItem instanceof PasswordConfigItem) {
            configItem.setTypeCode(ConfigTypeEmun.PASSWORD.getCode());
            configItem.setTypeName(ConfigTypeEmun.PASSWORD.getName());
            return;
        }
        //7
        if (configItem instanceof PersonConfigItem) {
            configItem.setTypeCode(ConfigTypeEmun.PERSON.getCode());
            configItem.setTypeName(ConfigTypeEmun.PERSON.getName());
            return;
        }
    }


    /**
     * 获取配置项的tooltips信息
     *
     * @param configItem 配置项对象
     * @return
     */
    public static String tips(AbstractConfigItem configItem) {
        if (configItem == null) {
            return "NULL";
        }
        if (configItem instanceof PersonConfigItem) {
            return "姓名：".concat(configItem.getName()).concat(NEW_LINE).
                    concat("电话：").concat(((PersonConfigItem) configItem).getMobile()).concat(NEW_LINE).
                    concat("邮箱：").concat(((PersonConfigItem) configItem).getEmail());
        }
        if (configItem instanceof BizSystemConfigItem) {
            return "系统名称：" + configItem.getName();
        }
        if (configItem instanceof ServerConfigItem) {
            return "主机名称：" + configItem.getName();
        }
        if (configItem instanceof NetworkConfigItem) {
            return "设备名称：" + configItem.getName();
        }
        if (configItem instanceof StorageConfigItem) {
            return "存储名称：" + configItem.getName();
        }
        if (configItem instanceof MiddlewareConfigItem) {
            return "中间件名称：" + configItem.getName();
        }
        if (configItem instanceof PasswordConfigItem) {
            return "密码名称：" + configItem.getName();
        }

        return "";
    }
}
