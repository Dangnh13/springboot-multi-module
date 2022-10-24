package jp.co.htkk.framework.util;

import jp.co.htkk.framework.constant.CommonConstant;
import org.springframework.util.StringUtils;

import java.util.Objects;

public class PageUtil {


    private PageUtil() {
    }

    public static Pageable convertToPageable(Page page) {
        Pageable pageable = new Pageable();
        String offsetPage = (Objects.nonNull(page) ? page.getOffset() : null);
        String limitPage = (Objects.nonNull(page) ? page.getLimit() : null);
        pageable.setOffset(getOffsetPage(offsetPage));
        pageable.setLimit(getLimit(limitPage));
        return pageable;
    }

    private static final int getOffsetPage(String offsetPage) {
        if (StringUtils.isEmpty(offsetPage))
            return CommonConstant.PAGING.PAGE_OFFSET_DEFAULT;
        return Integer.parseInt(offsetPage);
    }

    private static final int getLimit(String limit) {
        if (StringUtils.isEmpty(limit))
            return CommonConstant.PAGING.PAGE_SIZE;
        return Integer.parseInt(limit);
    }
}
