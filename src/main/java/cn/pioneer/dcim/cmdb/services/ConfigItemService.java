package cn.pioneer.dcim.cmdb.services;


import cn.pioneer.dcim.cmdb.common.graph.GraphResult;

import java.awt.print.Pageable;
import java.util.List;

/**
 * 配置项通用接口
 *
 * @param <T> 实际配置类型
 * @author luxinglin
 * @since 2018-01-19
 */
public interface ConfigItemService<T> {
    /**
     * 保存对象到neo4j数据库
     *
     * @param item
     * @return
     */
    T save(T item);

    /**
     * 批量保存对象到neo4j数据库
     *
     * @param items
     * @return
     */
    List<T> save(List<T> items);

    /**
     * 删除对象
     *
     * @param item
     */
    void delete(T item);

    /**
     * 删除对象
     *
     * @param id 对象ID
     */
    void delete(Long id);

    /**
     * 批量删除对象
     *
     * @param items
     */
    void delete(List<T> items);

    /**
     * 分页查找对象
     *
     * @param pageable 分页参数
     * @return 分页查询结果
     */
    Pageable page(Pageable pageable);

    /**
     * 列表查询
     *
     * @param param 查询参数
     * @return
     */
    List<T> findList(T param);

    /**
     * 查询单个对象
     *
     * @param id 对象ID
     * @return
     */
    T findOne(Long id);

    /**
     * 图形数据查询
     *
     * @param id    对象id
     * @param limit 返回节点数量
     * @return
     */
    GraphResult graph(Long id, int limit);

}
