package jp.co.htkk.batch.enums;

import lombok.Getter;

@Getter
public enum EProcessStatus {
    UPDATE_CORE_WAITING,
    UPDATE_CORE_RUNNING,
    UPDATE_CORE_ERROR,
    UPDATE_JUST_FILE_CREATING,
    UPDATE_JUST_FILE_CREATED,
    UPDATE_NOT_RUN,
    UD_JUST_FILE_CREATED_FAILED,
    UD_JUST_FILE_UPLOAD_FAILED;
}
