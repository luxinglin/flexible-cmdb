package cn.pioneer.dcim.cmdb.services;


import java.awt.print.Pageable;
import java.util.List;

/**
 * @param <T>
 */
public interface ConfigItemAble<T> {
    T save(T item);

    List<T> save(List<T> items);

    void delete(T item);

    void delete(Long id);

    void delete(List<T> items);

    Pageable page(Pageable pageable);

    List<T> findList(T param);

    T findOne(Long id);

}
