package cn.pioneer.dcim.cmdb.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysUserExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andUserSidIsNull() {
            addCriterion("USER_SID is null");
            return (Criteria) this;
        }

        public Criteria andUserSidIsNotNull() {
            addCriterion("USER_SID is not null");
            return (Criteria) this;
        }

        public Criteria andUserSidEqualTo(Long value) {
            addCriterion("USER_SID =", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidNotEqualTo(Long value) {
            addCriterion("USER_SID <>", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidGreaterThan(Long value) {
            addCriterion("USER_SID >", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidGreaterThanOrEqualTo(Long value) {
            addCriterion("USER_SID >=", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidLessThan(Long value) {
            addCriterion("USER_SID <", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidLessThanOrEqualTo(Long value) {
            addCriterion("USER_SID <=", value, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidIn(List<Long> values) {
            addCriterion("USER_SID in", values, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidNotIn(List<Long> values) {
            addCriterion("USER_SID not in", values, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidBetween(Long value1, Long value2) {
            addCriterion("USER_SID between", value1, value2, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserSidNotBetween(Long value1, Long value2) {
            addCriterion("USER_SID not between", value1, value2, "userSid");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNull() {
            addCriterion("USER_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUserTypeIsNotNull() {
            addCriterion("USER_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUserTypeEqualTo(String value) {
            addCriterion("USER_TYPE =", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotEqualTo(String value) {
            addCriterion("USER_TYPE <>", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThan(String value) {
            addCriterion("USER_TYPE >", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeGreaterThanOrEqualTo(String value) {
            addCriterion("USER_TYPE >=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThan(String value) {
            addCriterion("USER_TYPE <", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLessThanOrEqualTo(String value) {
            addCriterion("USER_TYPE <=", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeLike(String value) {
            addCriterion("USER_TYPE like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotLike(String value) {
            addCriterion("USER_TYPE not like", value, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeIn(List<String> values) {
            addCriterion("USER_TYPE in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotIn(List<String> values) {
            addCriterion("USER_TYPE not in", values, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeBetween(String value1, String value2) {
            addCriterion("USER_TYPE between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andUserTypeNotBetween(String value1, String value2) {
            addCriterion("USER_TYPE not between", value1, value2, "userType");
            return (Criteria) this;
        }

        public Criteria andAccountIsNull() {
            addCriterion("ACCOUNT is null");
            return (Criteria) this;
        }

        public Criteria andAccountIsNotNull() {
            addCriterion("ACCOUNT is not null");
            return (Criteria) this;
        }

        public Criteria andAccountEqualTo(String value) {
            addCriterion("ACCOUNT =", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotEqualTo(String value) {
            addCriterion("ACCOUNT <>", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThan(String value) {
            addCriterion("ACCOUNT >", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountGreaterThanOrEqualTo(String value) {
            addCriterion("ACCOUNT >=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThan(String value) {
            addCriterion("ACCOUNT <", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLessThanOrEqualTo(String value) {
            addCriterion("ACCOUNT <=", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountLike(String value) {
            addCriterion("ACCOUNT like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotLike(String value) {
            addCriterion("ACCOUNT not like", value, "account");
            return (Criteria) this;
        }

        public Criteria andAccountIn(List<String> values) {
            addCriterion("ACCOUNT in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotIn(List<String> values) {
            addCriterion("ACCOUNT not in", values, "account");
            return (Criteria) this;
        }

        public Criteria andAccountBetween(String value1, String value2) {
            addCriterion("ACCOUNT between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andAccountNotBetween(String value1, String value2) {
            addCriterion("ACCOUNT not between", value1, value2, "account");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNull() {
            addCriterion("PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andPasswordIsNotNull() {
            addCriterion("PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andPasswordEqualTo(String value) {
            addCriterion("PASSWORD =", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotEqualTo(String value) {
            addCriterion("PASSWORD <>", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThan(String value) {
            addCriterion("PASSWORD >", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD >=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThan(String value) {
            addCriterion("PASSWORD <", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLessThanOrEqualTo(String value) {
            addCriterion("PASSWORD <=", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordLike(String value) {
            addCriterion("PASSWORD like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotLike(String value) {
            addCriterion("PASSWORD not like", value, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordIn(List<String> values) {
            addCriterion("PASSWORD in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotIn(List<String> values) {
            addCriterion("PASSWORD not in", values, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordBetween(String value1, String value2) {
            addCriterion("PASSWORD between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPasswordNotBetween(String value1, String value2) {
            addCriterion("PASSWORD not between", value1, value2, "password");
            return (Criteria) this;
        }

        public Criteria andPassword64IsNull() {
            addCriterion("PASSWORD64 is null");
            return (Criteria) this;
        }

        public Criteria andPassword64IsNotNull() {
            addCriterion("PASSWORD64 is not null");
            return (Criteria) this;
        }

        public Criteria andPassword64EqualTo(String value) {
            addCriterion("PASSWORD64 =", value, "password64");
            return (Criteria) this;
        }

        public Criteria andPassword64NotEqualTo(String value) {
            addCriterion("PASSWORD64 <>", value, "password64");
            return (Criteria) this;
        }

        public Criteria andPassword64GreaterThan(String value) {
            addCriterion("PASSWORD64 >", value, "password64");
            return (Criteria) this;
        }

        public Criteria andPassword64GreaterThanOrEqualTo(String value) {
            addCriterion("PASSWORD64 >=", value, "password64");
            return (Criteria) this;
        }

        public Criteria andPassword64LessThan(String value) {
            addCriterion("PASSWORD64 <", value, "password64");
            return (Criteria) this;
        }

        public Criteria andPassword64LessThanOrEqualTo(String value) {
            addCriterion("PASSWORD64 <=", value, "password64");
            return (Criteria) this;
        }

        public Criteria andPassword64Like(String value) {
            addCriterion("PASSWORD64 like", value, "password64");
            return (Criteria) this;
        }

        public Criteria andPassword64NotLike(String value) {
            addCriterion("PASSWORD64 not like", value, "password64");
            return (Criteria) this;
        }

        public Criteria andPassword64In(List<String> values) {
            addCriterion("PASSWORD64 in", values, "password64");
            return (Criteria) this;
        }

        public Criteria andPassword64NotIn(List<String> values) {
            addCriterion("PASSWORD64 not in", values, "password64");
            return (Criteria) this;
        }

        public Criteria andPassword64Between(String value1, String value2) {
            addCriterion("PASSWORD64 between", value1, value2, "password64");
            return (Criteria) this;
        }

        public Criteria andPassword64NotBetween(String value1, String value2) {
            addCriterion("PASSWORD64 not between", value1, value2, "password64");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNull() {
            addCriterion("REAL_NAME is null");
            return (Criteria) this;
        }

        public Criteria andRealNameIsNotNull() {
            addCriterion("REAL_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andRealNameEqualTo(String value) {
            addCriterion("REAL_NAME =", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotEqualTo(String value) {
            addCriterion("REAL_NAME <>", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThan(String value) {
            addCriterion("REAL_NAME >", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameGreaterThanOrEqualTo(String value) {
            addCriterion("REAL_NAME >=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThan(String value) {
            addCriterion("REAL_NAME <", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLessThanOrEqualTo(String value) {
            addCriterion("REAL_NAME <=", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameLike(String value) {
            addCriterion("REAL_NAME like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotLike(String value) {
            addCriterion("REAL_NAME not like", value, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameIn(List<String> values) {
            addCriterion("REAL_NAME in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotIn(List<String> values) {
            addCriterion("REAL_NAME not in", values, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameBetween(String value1, String value2) {
            addCriterion("REAL_NAME between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andRealNameNotBetween(String value1, String value2) {
            addCriterion("REAL_NAME not between", value1, value2, "realName");
            return (Criteria) this;
        }

        public Criteria andSexIsNull() {
            addCriterion("SEX is null");
            return (Criteria) this;
        }

        public Criteria andSexIsNotNull() {
            addCriterion("SEX is not null");
            return (Criteria) this;
        }

        public Criteria andSexEqualTo(Integer value) {
            addCriterion("SEX =", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotEqualTo(Integer value) {
            addCriterion("SEX <>", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThan(Integer value) {
            addCriterion("SEX >", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexGreaterThanOrEqualTo(Integer value) {
            addCriterion("SEX >=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThan(Integer value) {
            addCriterion("SEX <", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexLessThanOrEqualTo(Integer value) {
            addCriterion("SEX <=", value, "sex");
            return (Criteria) this;
        }

        public Criteria andSexIn(List<Integer> values) {
            addCriterion("SEX in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotIn(List<Integer> values) {
            addCriterion("SEX not in", values, "sex");
            return (Criteria) this;
        }

        public Criteria andSexBetween(Integer value1, Integer value2) {
            addCriterion("SEX between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andSexNotBetween(Integer value1, Integer value2) {
            addCriterion("SEX not between", value1, value2, "sex");
            return (Criteria) this;
        }

        public Criteria andEmailIsNull() {
            addCriterion("EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andEmailIsNotNull() {
            addCriterion("EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andEmailEqualTo(String value) {
            addCriterion("EMAIL =", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotEqualTo(String value) {
            addCriterion("EMAIL <>", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThan(String value) {
            addCriterion("EMAIL >", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailGreaterThanOrEqualTo(String value) {
            addCriterion("EMAIL >=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThan(String value) {
            addCriterion("EMAIL <", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLessThanOrEqualTo(String value) {
            addCriterion("EMAIL <=", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailLike(String value) {
            addCriterion("EMAIL like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotLike(String value) {
            addCriterion("EMAIL not like", value, "email");
            return (Criteria) this;
        }

        public Criteria andEmailIn(List<String> values) {
            addCriterion("EMAIL in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotIn(List<String> values) {
            addCriterion("EMAIL not in", values, "email");
            return (Criteria) this;
        }

        public Criteria andEmailBetween(String value1, String value2) {
            addCriterion("EMAIL between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andEmailNotBetween(String value1, String value2) {
            addCriterion("EMAIL not between", value1, value2, "email");
            return (Criteria) this;
        }

        public Criteria andMobileIsNull() {
            addCriterion("MOBILE is null");
            return (Criteria) this;
        }

        public Criteria andMobileIsNotNull() {
            addCriterion("MOBILE is not null");
            return (Criteria) this;
        }

        public Criteria andMobileEqualTo(String value) {
            addCriterion("MOBILE =", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotEqualTo(String value) {
            addCriterion("MOBILE <>", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThan(String value) {
            addCriterion("MOBILE >", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileGreaterThanOrEqualTo(String value) {
            addCriterion("MOBILE >=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThan(String value) {
            addCriterion("MOBILE <", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLessThanOrEqualTo(String value) {
            addCriterion("MOBILE <=", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileLike(String value) {
            addCriterion("MOBILE like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotLike(String value) {
            addCriterion("MOBILE not like", value, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileIn(List<String> values) {
            addCriterion("MOBILE in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotIn(List<String> values) {
            addCriterion("MOBILE not in", values, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileBetween(String value1, String value2) {
            addCriterion("MOBILE between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andMobileNotBetween(String value1, String value2) {
            addCriterion("MOBILE not between", value1, value2, "mobile");
            return (Criteria) this;
        }

        public Criteria andOrgSidIsNull() {
            addCriterion("ORG_SID is null");
            return (Criteria) this;
        }

        public Criteria andOrgSidIsNotNull() {
            addCriterion("ORG_SID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgSidEqualTo(Long value) {
            addCriterion("ORG_SID =", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidNotEqualTo(Long value) {
            addCriterion("ORG_SID <>", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidGreaterThan(Long value) {
            addCriterion("ORG_SID >", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidGreaterThanOrEqualTo(Long value) {
            addCriterion("ORG_SID >=", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidLessThan(Long value) {
            addCriterion("ORG_SID <", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidLessThanOrEqualTo(Long value) {
            addCriterion("ORG_SID <=", value, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidIn(List<Long> values) {
            addCriterion("ORG_SID in", values, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidNotIn(List<Long> values) {
            addCriterion("ORG_SID not in", values, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidBetween(Long value1, Long value2) {
            addCriterion("ORG_SID between", value1, value2, "orgSid");
            return (Criteria) this;
        }

        public Criteria andOrgSidNotBetween(Long value1, Long value2) {
            addCriterion("ORG_SID not between", value1, value2, "orgSid");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNull() {
            addCriterion("DEP_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDepNameIsNotNull() {
            addCriterion("DEP_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDepNameEqualTo(String value) {
            addCriterion("DEP_NAME =", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotEqualTo(String value) {
            addCriterion("DEP_NAME <>", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThan(String value) {
            addCriterion("DEP_NAME >", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameGreaterThanOrEqualTo(String value) {
            addCriterion("DEP_NAME >=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThan(String value) {
            addCriterion("DEP_NAME <", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLessThanOrEqualTo(String value) {
            addCriterion("DEP_NAME <=", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameLike(String value) {
            addCriterion("DEP_NAME like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotLike(String value) {
            addCriterion("DEP_NAME not like", value, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameIn(List<String> values) {
            addCriterion("DEP_NAME in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotIn(List<String> values) {
            addCriterion("DEP_NAME not in", values, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameBetween(String value1, String value2) {
            addCriterion("DEP_NAME between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andDepNameNotBetween(String value1, String value2) {
            addCriterion("DEP_NAME not between", value1, value2, "depName");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidIsNull() {
            addCriterion("MGT_OBJ_SID is null");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidIsNotNull() {
            addCriterion("MGT_OBJ_SID is not null");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidEqualTo(String value) {
            addCriterion("MGT_OBJ_SID =", value, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidNotEqualTo(String value) {
            addCriterion("MGT_OBJ_SID <>", value, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidGreaterThan(String value) {
            addCriterion("MGT_OBJ_SID >", value, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidGreaterThanOrEqualTo(String value) {
            addCriterion("MGT_OBJ_SID >=", value, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidLessThan(String value) {
            addCriterion("MGT_OBJ_SID <", value, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidLessThanOrEqualTo(String value) {
            addCriterion("MGT_OBJ_SID <=", value, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidLike(String value) {
            addCriterion("MGT_OBJ_SID like", value, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidNotLike(String value) {
            addCriterion("MGT_OBJ_SID not like", value, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidIn(List<String> values) {
            addCriterion("MGT_OBJ_SID in", values, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidNotIn(List<String> values) {
            addCriterion("MGT_OBJ_SID not in", values, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidBetween(String value1, String value2) {
            addCriterion("MGT_OBJ_SID between", value1, value2, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andMgtObjSidNotBetween(String value1, String value2) {
            addCriterion("MGT_OBJ_SID not between", value1, value2, "mgtObjSid");
            return (Criteria) this;
        }

        public Criteria andBizSidIsNull() {
            addCriterion("BIZ_SID is null");
            return (Criteria) this;
        }

        public Criteria andBizSidIsNotNull() {
            addCriterion("BIZ_SID is not null");
            return (Criteria) this;
        }

        public Criteria andBizSidEqualTo(Long value) {
            addCriterion("BIZ_SID =", value, "bizSid");
            return (Criteria) this;
        }

        public Criteria andBizSidNotEqualTo(Long value) {
            addCriterion("BIZ_SID <>", value, "bizSid");
            return (Criteria) this;
        }

        public Criteria andBizSidGreaterThan(Long value) {
            addCriterion("BIZ_SID >", value, "bizSid");
            return (Criteria) this;
        }

        public Criteria andBizSidGreaterThanOrEqualTo(Long value) {
            addCriterion("BIZ_SID >=", value, "bizSid");
            return (Criteria) this;
        }

        public Criteria andBizSidLessThan(Long value) {
            addCriterion("BIZ_SID <", value, "bizSid");
            return (Criteria) this;
        }

        public Criteria andBizSidLessThanOrEqualTo(Long value) {
            addCriterion("BIZ_SID <=", value, "bizSid");
            return (Criteria) this;
        }

        public Criteria andBizSidIn(List<Long> values) {
            addCriterion("BIZ_SID in", values, "bizSid");
            return (Criteria) this;
        }

        public Criteria andBizSidNotIn(List<Long> values) {
            addCriterion("BIZ_SID not in", values, "bizSid");
            return (Criteria) this;
        }

        public Criteria andBizSidBetween(Long value1, Long value2) {
            addCriterion("BIZ_SID between", value1, value2, "bizSid");
            return (Criteria) this;
        }

        public Criteria andBizSidNotBetween(Long value1, Long value2) {
            addCriterion("BIZ_SID not between", value1, value2, "bizSid");
            return (Criteria) this;
        }

        public Criteria andPmNameIsNull() {
            addCriterion("PM_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPmNameIsNotNull() {
            addCriterion("PM_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPmNameEqualTo(String value) {
            addCriterion("PM_NAME =", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotEqualTo(String value) {
            addCriterion("PM_NAME <>", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameGreaterThan(String value) {
            addCriterion("PM_NAME >", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameGreaterThanOrEqualTo(String value) {
            addCriterion("PM_NAME >=", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameLessThan(String value) {
            addCriterion("PM_NAME <", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameLessThanOrEqualTo(String value) {
            addCriterion("PM_NAME <=", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameLike(String value) {
            addCriterion("PM_NAME like", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotLike(String value) {
            addCriterion("PM_NAME not like", value, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameIn(List<String> values) {
            addCriterion("PM_NAME in", values, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotIn(List<String> values) {
            addCriterion("PM_NAME not in", values, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameBetween(String value1, String value2) {
            addCriterion("PM_NAME between", value1, value2, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmNameNotBetween(String value1, String value2) {
            addCriterion("PM_NAME not between", value1, value2, "pmName");
            return (Criteria) this;
        }

        public Criteria andPmTelIsNull() {
            addCriterion("PM_TEL is null");
            return (Criteria) this;
        }

        public Criteria andPmTelIsNotNull() {
            addCriterion("PM_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andPmTelEqualTo(String value) {
            addCriterion("PM_TEL =", value, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmTelNotEqualTo(String value) {
            addCriterion("PM_TEL <>", value, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmTelGreaterThan(String value) {
            addCriterion("PM_TEL >", value, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmTelGreaterThanOrEqualTo(String value) {
            addCriterion("PM_TEL >=", value, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmTelLessThan(String value) {
            addCriterion("PM_TEL <", value, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmTelLessThanOrEqualTo(String value) {
            addCriterion("PM_TEL <=", value, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmTelLike(String value) {
            addCriterion("PM_TEL like", value, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmTelNotLike(String value) {
            addCriterion("PM_TEL not like", value, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmTelIn(List<String> values) {
            addCriterion("PM_TEL in", values, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmTelNotIn(List<String> values) {
            addCriterion("PM_TEL not in", values, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmTelBetween(String value1, String value2) {
            addCriterion("PM_TEL between", value1, value2, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmTelNotBetween(String value1, String value2) {
            addCriterion("PM_TEL not between", value1, value2, "pmTel");
            return (Criteria) this;
        }

        public Criteria andPmEmailIsNull() {
            addCriterion("PM_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andPmEmailIsNotNull() {
            addCriterion("PM_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andPmEmailEqualTo(String value) {
            addCriterion("PM_EMAIL =", value, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andPmEmailNotEqualTo(String value) {
            addCriterion("PM_EMAIL <>", value, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andPmEmailGreaterThan(String value) {
            addCriterion("PM_EMAIL >", value, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andPmEmailGreaterThanOrEqualTo(String value) {
            addCriterion("PM_EMAIL >=", value, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andPmEmailLessThan(String value) {
            addCriterion("PM_EMAIL <", value, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andPmEmailLessThanOrEqualTo(String value) {
            addCriterion("PM_EMAIL <=", value, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andPmEmailLike(String value) {
            addCriterion("PM_EMAIL like", value, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andPmEmailNotLike(String value) {
            addCriterion("PM_EMAIL not like", value, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andPmEmailIn(List<String> values) {
            addCriterion("PM_EMAIL in", values, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andPmEmailNotIn(List<String> values) {
            addCriterion("PM_EMAIL not in", values, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andPmEmailBetween(String value1, String value2) {
            addCriterion("PM_EMAIL between", value1, value2, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andPmEmailNotBetween(String value1, String value2) {
            addCriterion("PM_EMAIL not between", value1, value2, "pmEmail");
            return (Criteria) this;
        }

        public Criteria andTenantSidIsNull() {
            addCriterion("TENANT_SID is null");
            return (Criteria) this;
        }

        public Criteria andTenantSidIsNotNull() {
            addCriterion("TENANT_SID is not null");
            return (Criteria) this;
        }

        public Criteria andTenantSidEqualTo(Long value) {
            addCriterion("TENANT_SID =", value, "tenantSid");
            return (Criteria) this;
        }

        public Criteria andTenantSidNotEqualTo(Long value) {
            addCriterion("TENANT_SID <>", value, "tenantSid");
            return (Criteria) this;
        }

        public Criteria andTenantSidGreaterThan(Long value) {
            addCriterion("TENANT_SID >", value, "tenantSid");
            return (Criteria) this;
        }

        public Criteria andTenantSidGreaterThanOrEqualTo(Long value) {
            addCriterion("TENANT_SID >=", value, "tenantSid");
            return (Criteria) this;
        }

        public Criteria andTenantSidLessThan(Long value) {
            addCriterion("TENANT_SID <", value, "tenantSid");
            return (Criteria) this;
        }

        public Criteria andTenantSidLessThanOrEqualTo(Long value) {
            addCriterion("TENANT_SID <=", value, "tenantSid");
            return (Criteria) this;
        }

        public Criteria andTenantSidIn(List<Long> values) {
            addCriterion("TENANT_SID in", values, "tenantSid");
            return (Criteria) this;
        }

        public Criteria andTenantSidNotIn(List<Long> values) {
            addCriterion("TENANT_SID not in", values, "tenantSid");
            return (Criteria) this;
        }

        public Criteria andTenantSidBetween(Long value1, Long value2) {
            addCriterion("TENANT_SID between", value1, value2, "tenantSid");
            return (Criteria) this;
        }

        public Criteria andTenantSidNotBetween(Long value1, Long value2) {
            addCriterion("TENANT_SID not between", value1, value2, "tenantSid");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("STATUS is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("STATUS is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("STATUS =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("STATUS <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("STATUS >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("STATUS >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("STATUS <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("STATUS <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("STATUS like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("STATUS not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("STATUS in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("STATUS not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("STATUS between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("STATUS not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andErrorCountIsNull() {
            addCriterion("ERROR_COUNT is null");
            return (Criteria) this;
        }

        public Criteria andErrorCountIsNotNull() {
            addCriterion("ERROR_COUNT is not null");
            return (Criteria) this;
        }

        public Criteria andErrorCountEqualTo(Integer value) {
            addCriterion("ERROR_COUNT =", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotEqualTo(Integer value) {
            addCriterion("ERROR_COUNT <>", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountGreaterThan(Integer value) {
            addCriterion("ERROR_COUNT >", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("ERROR_COUNT >=", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountLessThan(Integer value) {
            addCriterion("ERROR_COUNT <", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountLessThanOrEqualTo(Integer value) {
            addCriterion("ERROR_COUNT <=", value, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountIn(List<Integer> values) {
            addCriterion("ERROR_COUNT in", values, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotIn(List<Integer> values) {
            addCriterion("ERROR_COUNT not in", values, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_COUNT between", value1, value2, "errorCount");
            return (Criteria) this;
        }

        public Criteria andErrorCountNotBetween(Integer value1, Integer value2) {
            addCriterion("ERROR_COUNT not between", value1, value2, "errorCount");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNull() {
            addCriterion("LAST_LOGIN_TIME is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIsNotNull() {
            addCriterion("LAST_LOGIN_TIME is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME =", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME <>", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThan(Date value) {
            addCriterion("LAST_LOGIN_TIME >", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME >=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThan(Date value) {
            addCriterion("LAST_LOGIN_TIME <", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeLessThanOrEqualTo(Date value) {
            addCriterion("LAST_LOGIN_TIME <=", value, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeIn(List<Date> values) {
            addCriterion("LAST_LOGIN_TIME in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotIn(List<Date> values) {
            addCriterion("LAST_LOGIN_TIME not in", values, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_TIME between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginTimeNotBetween(Date value1, Date value2) {
            addCriterion("LAST_LOGIN_TIME not between", value1, value2, "lastLoginTime");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNull() {
            addCriterion("LAST_LOGIN_IP is null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIsNotNull() {
            addCriterion("LAST_LOGIN_IP is not null");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP =", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP <>", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThan(String value) {
            addCriterion("LAST_LOGIN_IP >", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpGreaterThanOrEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP >=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThan(String value) {
            addCriterion("LAST_LOGIN_IP <", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLessThanOrEqualTo(String value) {
            addCriterion("LAST_LOGIN_IP <=", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpLike(String value) {
            addCriterion("LAST_LOGIN_IP like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotLike(String value) {
            addCriterion("LAST_LOGIN_IP not like", value, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpIn(List<String> values) {
            addCriterion("LAST_LOGIN_IP in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotIn(List<String> values) {
            addCriterion("LAST_LOGIN_IP not in", values, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpBetween(String value1, String value2) {
            addCriterion("LAST_LOGIN_IP between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andLastLoginIpNotBetween(String value1, String value2) {
            addCriterion("LAST_LOGIN_IP not between", value1, value2, "lastLoginIp");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityIsNull() {
            addCriterion("SERVICE_LIMIT_QUANTITY is null");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityIsNotNull() {
            addCriterion("SERVICE_LIMIT_QUANTITY is not null");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityEqualTo(Integer value) {
            addCriterion("SERVICE_LIMIT_QUANTITY =", value, "serviceLimitQuantity");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityNotEqualTo(Integer value) {
            addCriterion("SERVICE_LIMIT_QUANTITY <>", value, "serviceLimitQuantity");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityGreaterThan(Integer value) {
            addCriterion("SERVICE_LIMIT_QUANTITY >", value, "serviceLimitQuantity");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityGreaterThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_LIMIT_QUANTITY >=", value, "serviceLimitQuantity");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityLessThan(Integer value) {
            addCriterion("SERVICE_LIMIT_QUANTITY <", value, "serviceLimitQuantity");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityLessThanOrEqualTo(Integer value) {
            addCriterion("SERVICE_LIMIT_QUANTITY <=", value, "serviceLimitQuantity");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityIn(List<Integer> values) {
            addCriterion("SERVICE_LIMIT_QUANTITY in", values, "serviceLimitQuantity");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityNotIn(List<Integer> values) {
            addCriterion("SERVICE_LIMIT_QUANTITY not in", values, "serviceLimitQuantity");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_LIMIT_QUANTITY between", value1, value2, "serviceLimitQuantity");
            return (Criteria) this;
        }

        public Criteria andServiceLimitQuantityNotBetween(Integer value1, Integer value2) {
            addCriterion("SERVICE_LIMIT_QUANTITY not between", value1, value2, "serviceLimitQuantity");
            return (Criteria) this;
        }

        public Criteria andApplyReasonIsNull() {
            addCriterion("APPLY_REASON is null");
            return (Criteria) this;
        }

        public Criteria andApplyReasonIsNotNull() {
            addCriterion("APPLY_REASON is not null");
            return (Criteria) this;
        }

        public Criteria andApplyReasonEqualTo(String value) {
            addCriterion("APPLY_REASON =", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonNotEqualTo(String value) {
            addCriterion("APPLY_REASON <>", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonGreaterThan(String value) {
            addCriterion("APPLY_REASON >", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_REASON >=", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonLessThan(String value) {
            addCriterion("APPLY_REASON <", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonLessThanOrEqualTo(String value) {
            addCriterion("APPLY_REASON <=", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonLike(String value) {
            addCriterion("APPLY_REASON like", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonNotLike(String value) {
            addCriterion("APPLY_REASON not like", value, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonIn(List<String> values) {
            addCriterion("APPLY_REASON in", values, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonNotIn(List<String> values) {
            addCriterion("APPLY_REASON not in", values, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonBetween(String value1, String value2) {
            addCriterion("APPLY_REASON between", value1, value2, "applyReason");
            return (Criteria) this;
        }

        public Criteria andApplyReasonNotBetween(String value1, String value2) {
            addCriterion("APPLY_REASON not between", value1, value2, "applyReason");
            return (Criteria) this;
        }

        public Criteria andSmsMaxIsNull() {
            addCriterion("sms_max is null");
            return (Criteria) this;
        }

        public Criteria andSmsMaxIsNotNull() {
            addCriterion("sms_max is not null");
            return (Criteria) this;
        }

        public Criteria andSmsMaxEqualTo(Integer value) {
            addCriterion("sms_max =", value, "smsMax");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNotEqualTo(Integer value) {
            addCriterion("sms_max <>", value, "smsMax");
            return (Criteria) this;
        }

        public Criteria andSmsMaxGreaterThan(Integer value) {
            addCriterion("sms_max >", value, "smsMax");
            return (Criteria) this;
        }

        public Criteria andSmsMaxGreaterThanOrEqualTo(Integer value) {
            addCriterion("sms_max >=", value, "smsMax");
            return (Criteria) this;
        }

        public Criteria andSmsMaxLessThan(Integer value) {
            addCriterion("sms_max <", value, "smsMax");
            return (Criteria) this;
        }

        public Criteria andSmsMaxLessThanOrEqualTo(Integer value) {
            addCriterion("sms_max <=", value, "smsMax");
            return (Criteria) this;
        }

        public Criteria andSmsMaxIn(List<Integer> values) {
            addCriterion("sms_max in", values, "smsMax");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNotIn(List<Integer> values) {
            addCriterion("sms_max not in", values, "smsMax");
            return (Criteria) this;
        }

        public Criteria andSmsMaxBetween(Integer value1, Integer value2) {
            addCriterion("sms_max between", value1, value2, "smsMax");
            return (Criteria) this;
        }

        public Criteria andSmsMaxNotBetween(Integer value1, Integer value2) {
            addCriterion("sms_max not between", value1, value2, "smsMax");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNull() {
            addCriterion("CREATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andCreatedByIsNotNull() {
            addCriterion("CREATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedByEqualTo(String value) {
            addCriterion("CREATED_BY =", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotEqualTo(String value) {
            addCriterion("CREATED_BY <>", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThan(String value) {
            addCriterion("CREATED_BY >", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByGreaterThanOrEqualTo(String value) {
            addCriterion("CREATED_BY >=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThan(String value) {
            addCriterion("CREATED_BY <", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLessThanOrEqualTo(String value) {
            addCriterion("CREATED_BY <=", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByLike(String value) {
            addCriterion("CREATED_BY like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotLike(String value) {
            addCriterion("CREATED_BY not like", value, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByIn(List<String> values) {
            addCriterion("CREATED_BY in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotIn(List<String> values) {
            addCriterion("CREATED_BY not in", values, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByBetween(String value1, String value2) {
            addCriterion("CREATED_BY between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedByNotBetween(String value1, String value2) {
            addCriterion("CREATED_BY not between", value1, value2, "createdBy");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNull() {
            addCriterion("CREATED_DT is null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIsNotNull() {
            addCriterion("CREATED_DT is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedDtEqualTo(Date value) {
            addCriterion("CREATED_DT =", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotEqualTo(Date value) {
            addCriterion("CREATED_DT <>", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThan(Date value) {
            addCriterion("CREATED_DT >", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtGreaterThanOrEqualTo(Date value) {
            addCriterion("CREATED_DT >=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThan(Date value) {
            addCriterion("CREATED_DT <", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtLessThanOrEqualTo(Date value) {
            addCriterion("CREATED_DT <=", value, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtIn(List<Date> values) {
            addCriterion("CREATED_DT in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotIn(List<Date> values) {
            addCriterion("CREATED_DT not in", values, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtBetween(Date value1, Date value2) {
            addCriterion("CREATED_DT between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andCreatedDtNotBetween(Date value1, Date value2) {
            addCriterion("CREATED_DT not between", value1, value2, "createdDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNull() {
            addCriterion("UPDATED_BY is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIsNotNull() {
            addCriterion("UPDATED_BY is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedByEqualTo(String value) {
            addCriterion("UPDATED_BY =", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotEqualTo(String value) {
            addCriterion("UPDATED_BY <>", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThan(String value) {
            addCriterion("UPDATED_BY >", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByGreaterThanOrEqualTo(String value) {
            addCriterion("UPDATED_BY >=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThan(String value) {
            addCriterion("UPDATED_BY <", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLessThanOrEqualTo(String value) {
            addCriterion("UPDATED_BY <=", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByLike(String value) {
            addCriterion("UPDATED_BY like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotLike(String value) {
            addCriterion("UPDATED_BY not like", value, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByIn(List<String> values) {
            addCriterion("UPDATED_BY in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotIn(List<String> values) {
            addCriterion("UPDATED_BY not in", values, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByBetween(String value1, String value2) {
            addCriterion("UPDATED_BY between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedByNotBetween(String value1, String value2) {
            addCriterion("UPDATED_BY not between", value1, value2, "updatedBy");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtIsNull() {
            addCriterion("UPDATED_DT is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtIsNotNull() {
            addCriterion("UPDATED_DT is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtEqualTo(Date value) {
            addCriterion("UPDATED_DT =", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtNotEqualTo(Date value) {
            addCriterion("UPDATED_DT <>", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtGreaterThan(Date value) {
            addCriterion("UPDATED_DT >", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATED_DT >=", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtLessThan(Date value) {
            addCriterion("UPDATED_DT <", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtLessThanOrEqualTo(Date value) {
            addCriterion("UPDATED_DT <=", value, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtIn(List<Date> values) {
            addCriterion("UPDATED_DT in", values, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtNotIn(List<Date> values) {
            addCriterion("UPDATED_DT not in", values, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtBetween(Date value1, Date value2) {
            addCriterion("UPDATED_DT between", value1, value2, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andUpdatedDtNotBetween(Date value1, Date value2) {
            addCriterion("UPDATED_DT not between", value1, value2, "updatedDt");
            return (Criteria) this;
        }

        public Criteria andVersionIsNull() {
            addCriterion("VERSION is null");
            return (Criteria) this;
        }

        public Criteria andVersionIsNotNull() {
            addCriterion("VERSION is not null");
            return (Criteria) this;
        }

        public Criteria andVersionEqualTo(Long value) {
            addCriterion("VERSION =", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotEqualTo(Long value) {
            addCriterion("VERSION <>", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThan(Long value) {
            addCriterion("VERSION >", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionGreaterThanOrEqualTo(Long value) {
            addCriterion("VERSION >=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThan(Long value) {
            addCriterion("VERSION <", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionLessThanOrEqualTo(Long value) {
            addCriterion("VERSION <=", value, "version");
            return (Criteria) this;
        }

        public Criteria andVersionIn(List<Long> values) {
            addCriterion("VERSION in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotIn(List<Long> values) {
            addCriterion("VERSION not in", values, "version");
            return (Criteria) this;
        }

        public Criteria andVersionBetween(Long value1, Long value2) {
            addCriterion("VERSION between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andVersionNotBetween(Long value1, Long value2) {
            addCriterion("VERSION not between", value1, value2, "version");
            return (Criteria) this;
        }

        public Criteria andUuidIsNull() {
            addCriterion("UUID is null");
            return (Criteria) this;
        }

        public Criteria andUuidIsNotNull() {
            addCriterion("UUID is not null");
            return (Criteria) this;
        }

        public Criteria andUuidEqualTo(String value) {
            addCriterion("UUID =", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotEqualTo(String value) {
            addCriterion("UUID <>", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThan(String value) {
            addCriterion("UUID >", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidGreaterThanOrEqualTo(String value) {
            addCriterion("UUID >=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThan(String value) {
            addCriterion("UUID <", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLessThanOrEqualTo(String value) {
            addCriterion("UUID <=", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidLike(String value) {
            addCriterion("UUID like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotLike(String value) {
            addCriterion("UUID not like", value, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidIn(List<String> values) {
            addCriterion("UUID in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotIn(List<String> values) {
            addCriterion("UUID not in", values, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidBetween(String value1, String value2) {
            addCriterion("UUID between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andUuidNotBetween(String value1, String value2) {
            addCriterion("UUID not between", value1, value2, "uuid");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNull() {
            addCriterion("company_id is null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIsNotNull() {
            addCriterion("company_id is not null");
            return (Criteria) this;
        }

        public Criteria andCompanyIdEqualTo(Long value) {
            addCriterion("company_id =", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotEqualTo(Long value) {
            addCriterion("company_id <>", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThan(Long value) {
            addCriterion("company_id >", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdGreaterThanOrEqualTo(Long value) {
            addCriterion("company_id >=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThan(Long value) {
            addCriterion("company_id <", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdLessThanOrEqualTo(Long value) {
            addCriterion("company_id <=", value, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdIn(List<Long> values) {
            addCriterion("company_id in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotIn(List<Long> values) {
            addCriterion("company_id not in", values, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdBetween(Long value1, Long value2) {
            addCriterion("company_id between", value1, value2, "companyId");
            return (Criteria) this;
        }

        public Criteria andCompanyIdNotBetween(Long value1, Long value2) {
            addCriterion("company_id not between", value1, value2, "companyId");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }
    }
}