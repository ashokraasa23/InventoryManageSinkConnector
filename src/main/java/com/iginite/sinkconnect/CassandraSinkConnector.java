package com.iginite.sinkconnect;

import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CassandraSinkConnector extends SinkConnector {
  private static Logger log = LoggerFactory.getLogger(CassandraSinkConnector.class);
  private CassandraSinkConnectorConfig config;

  @Override
  public String version() {
    return VersionUtil.getVersion();
  }

  @Override
  public void start(Map<String, String> map) {
    config = new CassandraSinkConnectorConfig(map);

    //TODO: Add things you need to do to setup your connector.

    /**
     * This will be executed once per connector. This can be used to handle connector level setup.
     */

  }

  @Override
  public Class<? extends Task> taskClass() {
    //TODO: Return your task implementation.
    return CassandraSinkTask.class;
  }

  @Override
  public List<Map<String, String>> taskConfigs(int maxTasks) {
    ArrayList<Map<String, String>> configs = new ArrayList<>();
    for(int i = 0; i < maxTasks; i++){
      configs.add(config.originalsStrings());
    }
    return configs;
  }

  @Override
  public void stop() {
    //TODO: Do things that are necessary to stop your connector.
  }

  @Override
  public ConfigDef config() {
    return CassandraSinkConnectorConfig.conf();
  }
}
