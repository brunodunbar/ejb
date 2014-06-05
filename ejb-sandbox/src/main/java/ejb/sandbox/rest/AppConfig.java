package ejb.sandbox.rest;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * 
 * Classe de configuração do JAX-RS, evitando assim que seja necessário ter um
 * Servlet mapeado no web.xml
 * 
 * @author Bruno
 *
 */
@ApplicationPath("/rest")
public class AppConfig extends Application {
}