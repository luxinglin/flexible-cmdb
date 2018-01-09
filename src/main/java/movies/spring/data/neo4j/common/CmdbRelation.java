package movies.spring.data.neo4j.common;

import org.neo4j.graphdb.RelationshipType;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
public enum CmdbRelation implements RelationshipType {
    /**
     * 依赖、影响、部署在、连接、包含、负责
     */
    DEPENDON_ON, REFFECT, DEPLOY_ON, LINK_TO, CONTAINS, OWNED
}
