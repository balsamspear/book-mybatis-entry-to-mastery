package com.balsam.chapter03.mapper.provider;

import org.apache.ibatis.jdbc.SQL;

public class PrivilegeProvider {

    public String selectById1() {
        return new SQL(){
            {
                SELECT("id, privilege_name, privilege_url");
                FROM("sys_privilege");
                WHERE("id = #{id}");
            }
        }.toString();
    }

    public String selectById2() {
        return "select id, privilege_name, privilege_url from sys_privilege where id = #{id}";
    }
}
