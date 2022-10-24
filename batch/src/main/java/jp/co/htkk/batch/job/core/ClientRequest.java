package jp.co.htkk.batch.job.core;

import jp.co.htkk.batch.job.type.JobID;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.boot.ApplicationArguments;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@NoArgsConstructor
@ToString
public class ClientRequest {

    public ClientRequest(ApplicationArguments args) {
        if (CollectionUtils.isNotEmpty(args.getOptionNames())) {
            metaData = new HashMap<>();
            args.getOptionNames().stream().forEach(name -> {
                metaData.put(name, args.getOptionValues(name));
            });
        }
    }

    private JobID jobID;

    private Map<String, List<String>> metaData;

}
