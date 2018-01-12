package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.constants.CiLabelConstant;
import cn.pioneer.dcim.cmdb.common.constants.CiRelationConstant;
import cn.pioneer.dcim.cmdb.common.util.ToyUtil;
import cn.pioneer.dcim.cmdb.dao.BizSystemDao;
import cn.pioneer.dcim.cmdb.domain.entity.BizSystemConfigItem;
import cn.pioneer.dcim.cmdb.domain.relationship.BelongToRelation;
import cn.pioneer.dcim.cmdb.domain.relationship.DeployOnRelation;
import cn.pioneer.dcim.cmdb.repositories.BizSystemRepository;
import cn.pioneer.dcim.cmdb.services.ConfigItemAble;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.*;

/**
 * @author luxinglin
 * @since 2018-01-10
 */
@Service
public class BizSystemService implements ConfigItemAble<BizSystemConfigItem> {
    protected static Logger logger = LoggerFactory.getLogger(BizSystemService.class);
    @Autowired
    BizSystemRepository bizSystemRepository;
    @Autowired
    BizSystemDao bizSystemDao;


    @Override
    public BizSystemConfigItem save(BizSystemConfigItem item) {
        BizSystemConfigItem persist = bizSystemRepository.save(item);
        return persist;
    }

    @Override
    public List<BizSystemConfigItem> save(List<BizSystemConfigItem> items) {
        return null;
    }

    @Override
    public void delete(BizSystemConfigItem item) {

    }

    @Override
    public void delete(Long id) {
        if (!ToyUtil.validID(id)) {
            logger.error("业务系统删除失败，ID值不合法");
            return;
        }
        if (!bizSystemRepository.exists(id)) {
            logger.error("业务系统删除失败，指定ID的业务系统不存在");
            return;
        }
        this.bizSystemRepository.delete(id);
        logger.info("业务系统删除成功");
    }

    @Override
    public void delete(List<BizSystemConfigItem> items) {

    }

    @Override
    public Pageable page(Pageable pageable) {
        return null;
    }

    @Override
    public List<BizSystemConfigItem> findList(BizSystemConfigItem param) {
        List list = bizSystemDao.queryBizSystemConfigItemByPerproty(param);
        return list;
    }

    @Override
    public BizSystemConfigItem findOne(Long id) {
        return this.bizSystemRepository.findOne(id);
    }

    private Map<String, Object> toD3Format(Collection<BizSystemConfigItem> bizSystems) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<BizSystemConfigItem> result = bizSystems.iterator();
        while (result.hasNext()) {
            BizSystemConfigItem bizSystem = result.next();
            Map<String, Object> nodeAttrMap = ToyUtil.map("title", bizSystem.getName(), "label", CiLabelConstant.BIZSYSTEM);
            nodeAttrMap.put("image", "assets/img/system.svg");
            nodes.add(nodeAttrMap);

            int target = i;
            i++;
            if (bizSystem.getPersonSet() != null) {
                for (BelongToRelation relation : bizSystem.getPersonSet()) {
                    Map<String, Object> actor = ToyUtil.map("title", relation.getPerson().getName(), "label", CiLabelConstant.PERSON);
                    actor.put("image", "assets/img/person.svg");
                    int source = nodes.indexOf(actor);
                    if (source == -1) {
                        nodes.add(actor);
                        source = i++;
                    }

                    Map<String, Object> linkMap = ToyUtil.map("source", source, "target", target);
                    linkMap.put("relation", CiRelationConstant.BELONG_TO);
                    rels.add(linkMap);
                }
            }
            if (bizSystem.getServerSet() != null) {
                for (DeployOnRelation relation : bizSystem.getServerSet()) {
                    Map<String, Object> server = ToyUtil.map("title", relation.getServer().getName(), "label", CiLabelConstant.SERVER);
                    server.put("image", "assets/img/server.svg");
                    int source = nodes.indexOf(server);
                    if (source == -1) {
                        nodes.add(server);
                        source = i++;
                    }
                    Map<String, Object> linkMap = ToyUtil.map("source", source, "target", target);
                    linkMap.put("relation", CiRelationConstant.DEPLOY_ON);
                    rels.add(linkMap);
                }
            }
        }
        return ToyUtil.map("nodes", nodes, "links", rels);
    }

    @Transactional(readOnly = true)
    public Map<String, Object> graph(int limit) {
        Collection<BizSystemConfigItem> result = bizSystemRepository.graph(limit);
        return toD3Format(result);

    }

    /**
     * @param name
     * @return
     */
    public Collection<BizSystemConfigItem> findByNameLike(String name) {
        Collection<BizSystemConfigItem> bizSystems = bizSystemRepository.findByNameLike(name);
        return bizSystems;
    }

}
