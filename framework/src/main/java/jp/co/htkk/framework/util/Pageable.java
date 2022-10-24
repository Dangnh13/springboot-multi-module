package jp.co.htkk.framework.util;

import lombok.Data;

@Data
public class Pageable {
    private int offset;

    private int limit;
}
