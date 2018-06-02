package com.iginite.sinkconnect;

import org.apache.kafka.common.config.AbstractConfig;
import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.common.config.ConfigDef.Type;
import org.apache.kafka.common.config.ConfigDef.Importance;

import java.util.Map;


public class CassandraSinkConnectorConfig extends AbstractConfig {


 // private static final String MY_SETTING_DOC = "This is a setting important to my connector.";

  public static final String  CASSANDRAHOST_CONFIG = "casandrahost";
  public static final String  CASSANDRAPORT_CONFIG = "casandraport";
  public static final String  CASSANDRAKEYSPACE_CONFIG = "casandrakeyspace";
  public static final String  CASSANDRACONSISTENCYLEVEL_CONFIG = "casandraconsistencylevel";
  public static final String  MAXRETRY_CONFIG = "maxretry";
  public static final String  CASSANDRAUSER_CONFIG = "casandrauser";
  public static final String  CASSANDRAPASSWORD_CONFIG = "casandrapassword";


  public CassandraSinkConnectorConfig(ConfigDef config, Map<String, String> parsedConfig) {
    super(config, parsedConfig);
  }

  public CassandraSinkConnectorConfig(Map<String, String> parsedConfig) {
    this(conf(), parsedConfig);
  }

  public static ConfigDef conf() {
    return new ConfigDef()
        .define(CASSANDRAHOST_CONFIG, Type.STRING, Importance.HIGH, "Cassandra Host")
        .define(CASSANDRAPORT_CONFIG, Type.STRING, Importance.HIGH, "Cassandra Port")
        .define(CASSANDRAKEYSPACE_CONFIG, Type.STRING, Importance.HIGH, "Cassandra KeySpace")
        .define(CASSANDRACONSISTENCYLEVEL_CONFIG, Type.STRING, Importance.HIGH, "Cassandra ConsistencyLevel")
        .define(MAXRETRY_CONFIG, Type.STRING, Importance.HIGH, "Maxretry")
        .define(CASSANDRAUSER_CONFIG, Type.STRING, Importance.HIGH, "Cassandra Username")
        .define(CASSANDRAPASSWORD_CONFIG, Type.STRING, Importance.HIGH, "Cassandra Password");
  }

  public String getCassandrahostConfig(){
    return this.getString(CASSANDRAHOST_CONFIG);
  }
  public String getCassandraportConfig(){
    return this.getString(CASSANDRAPORT_CONFIG);
  }
  public String getCassandrakeyspaceConfig(){
    return this.getString(CASSANDRAKEYSPACE_CONFIG);
  }
  public String getCassandraconsistencylevelConfig(){
    return this.getString(CASSANDRACONSISTENCYLEVEL_CONFIG);
  }
  public String getMaxretryConfig(){
    return this.getString(MAXRETRY_CONFIG);
  }
  public String getCassandrauserConfig(){ return this.getString(CASSANDRAUSER_CONFIG);}
  public String getCassandrapasswordConfig(){
    return this.getPassword(CASSANDRAPASSWORD_CONFIG).value();
  }

}
