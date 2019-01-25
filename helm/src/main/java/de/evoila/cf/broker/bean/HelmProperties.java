package de.evoila.cf.broker.bean;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Johannes Hiemer.
 */
@Configuration
@ConfigurationProperties(prefix = "bosh")
@ConditionalOnProperty(prefix = "bosh", name = {"host", "username",
        "password", "stemcellVersion", "stemcellOs", "authentication"}, havingValue = "")
public class HelmProperties {

    private String host;

    private int port = 25555;

    private String username;

    private String password;

    private String stemcellVersion;

    private String stemcellOs;

    private String vipNetwork = "not-defined";

    public String getHost() { return host; }

    public void setHost(String host) { this.host = host; }

    public int getPort() { return port; }

    public void setPort(int port) { this.port = port;  }

    public String getUsername() { return username; }

    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }

    public void setPassword(String password) { this.password = password; }

    public String getStemcellVersion() { return stemcellVersion; }

    public void setStemcellVersion(String stemcellVersion) { this.stemcellVersion = stemcellVersion; }

    public String getStemcellOs() { return stemcellOs; }

    public void setStemcellOs(String stemcellOs) { this.stemcellOs = stemcellOs; }

    public String getVipNetwork() { return vipNetwork; }

    public void setVipNetwork(String vipNetwork) { this.vipNetwork = vipNetwork;
    }
}
