package jp.co.htkk.batch.job.type;

import java.util.EnumSet;

public enum JobID {

    /** download file xlsx from website and store data to database */
    JOB0001(50),
    ;

    public final Integer uid;

    JobID(Integer uid) {
        this.uid = uid;
    }

    public static JobID atUid(Integer uid) {
        return EnumSet.allOf(JobID.class).stream()
                .filter(command -> command.uid == uid)
                .findFirst()
                .orElse(null);
    }
}
