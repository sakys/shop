package com.shop.sqlProvider;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

@Slf4j
public class PromotionProvider {


    public String findProPromotionList(Map<String,Object> map) {

        SQL sql = new SQL();
        sql.SELECT("id, title, image");
        sql.FROM("tbl_promotion p");
        Integer parentId = (Integer) map.get("parentId");
        if (parentId != null) {
            sql.LEFT_OUTER_JOIN("tbl_product_category_promotion cp on cp.promotions = p.id")
                    .WHERE("cp.product_categories = #{parentId}");
        } else {
            sql.WHERE("1=1");
        }
        Boolean hasEnded = (Boolean) map.get("hasEnded");
        if (hasEnded != null) {
            if (hasEnded) { //结束
                sql.AND().WHERE("end_date < now()");
            } else {//没结束
                sql.AND().WHERE("end_date >= now() or end_date is null");
            }
        }

        String sqlStr = sql.toString();
        Integer count = (Integer) map.get("count");
        if (count > 0) {
            sqlStr += "limit #{count}";
        }
        log.info("findPromotionList sql: {}", sqlStr);
        return sqlStr;
    }

}
