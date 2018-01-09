package movies.spring.data.neo4j.common;

import org.neo4j.graphdb.Label;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
public enum CmdbLabel implements Label {
    BIZSYSTEM, NETWORK, PERSON, SERVER, STORAGE, PASSWORD
}
