package be.jimve.ws;

import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class ActuatorInfo implements InfoContributor {
    @Override
    public void contribute(Info.Builder builder) {
        Map<String,String> data= new HashMap<>();
        data.put("build.version", "My version comes here !");
        builder.withDetail("buildInfo", data);
    }
}
