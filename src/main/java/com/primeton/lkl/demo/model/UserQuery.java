package com.primeton.lkl.demo.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class UserQuery {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    protected String fields;

    public UserQuery() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
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

    public void setFields(String fields) {
        this.fields=fields;
    }

    public String getFields() {
        return fields;
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andUserIdIsNull() {
            addCriterion("USER_ID is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("USER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("USER_ID =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("USER_ID <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("USER_ID >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("USER_ID >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("USER_ID <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("USER_ID <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("USER_ID in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("USER_ID not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("USER_ID not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNull() {
            addCriterion("USER_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUserNameIsNotNull() {
            addCriterion("USER_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUserNameEqualTo(String value) {
            addCriterion("USER_NAME =", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotEqualTo(String value) {
            addCriterion("USER_NAME <>", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThan(String value) {
            addCriterion("USER_NAME >", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameGreaterThanOrEqualTo(String value) {
            addCriterion("USER_NAME >=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThan(String value) {
            addCriterion("USER_NAME <", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLessThanOrEqualTo(String value) {
            addCriterion("USER_NAME <=", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameLike(String value) {
            addCriterion("USER_NAME like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotLike(String value) {
            addCriterion("USER_NAME not like", value, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameIn(List<String> values) {
            addCriterion("USER_NAME in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotIn(List<String> values) {
            addCriterion("USER_NAME not in", values, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameBetween(String value1, String value2) {
            addCriterion("USER_NAME between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserNameNotBetween(String value1, String value2) {
            addCriterion("USER_NAME not between", value1, value2, "userName");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNull() {
            addCriterion("USER_PASSWORD is null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIsNotNull() {
            addCriterion("USER_PASSWORD is not null");
            return (Criteria) this;
        }

        public Criteria andUserPasswordEqualTo(String value) {
            addCriterion("USER_PASSWORD =", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotEqualTo(String value) {
            addCriterion("USER_PASSWORD <>", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThan(String value) {
            addCriterion("USER_PASSWORD >", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("USER_PASSWORD >=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThan(String value) {
            addCriterion("USER_PASSWORD <", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLessThanOrEqualTo(String value) {
            addCriterion("USER_PASSWORD <=", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordLike(String value) {
            addCriterion("USER_PASSWORD like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotLike(String value) {
            addCriterion("USER_PASSWORD not like", value, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordIn(List<String> values) {
            addCriterion("USER_PASSWORD in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotIn(List<String> values) {
            addCriterion("USER_PASSWORD not in", values, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordBetween(String value1, String value2) {
            addCriterion("USER_PASSWORD between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserPasswordNotBetween(String value1, String value2) {
            addCriterion("USER_PASSWORD not between", value1, value2, "userPassword");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNull() {
            addCriterion("USER_BIRTHDAY is null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIsNotNull() {
            addCriterion("USER_BIRTHDAY is not null");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayEqualTo(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY =", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotEqualTo(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY <>", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThan(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY >", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY >=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThan(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY <", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("USER_BIRTHDAY <=", value, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayIn(List<Date> values) {
            addCriterionForJDBCDate("USER_BIRTHDAY in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotIn(List<Date> values) {
            addCriterionForJDBCDate("USER_BIRTHDAY not in", values, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("USER_BIRTHDAY between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserBirthdayNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("USER_BIRTHDAY not between", value1, value2, "userBirthday");
            return (Criteria) this;
        }

        public Criteria andUserGenderIsNull() {
            addCriterion("USER_GENDER is null");
            return (Criteria) this;
        }

        public Criteria andUserGenderIsNotNull() {
            addCriterion("USER_GENDER is not null");
            return (Criteria) this;
        }

        public Criteria andUserGenderEqualTo(String value) {
            addCriterion("USER_GENDER =", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotEqualTo(String value) {
            addCriterion("USER_GENDER <>", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderGreaterThan(String value) {
            addCriterion("USER_GENDER >", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderGreaterThanOrEqualTo(String value) {
            addCriterion("USER_GENDER >=", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderLessThan(String value) {
            addCriterion("USER_GENDER <", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderLessThanOrEqualTo(String value) {
            addCriterion("USER_GENDER <=", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderLike(String value) {
            addCriterion("USER_GENDER like", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotLike(String value) {
            addCriterion("USER_GENDER not like", value, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderIn(List<String> values) {
            addCriterion("USER_GENDER in", values, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotIn(List<String> values) {
            addCriterion("USER_GENDER not in", values, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderBetween(String value1, String value2) {
            addCriterion("USER_GENDER between", value1, value2, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserGenderNotBetween(String value1, String value2) {
            addCriterion("USER_GENDER not between", value1, value2, "userGender");
            return (Criteria) this;
        }

        public Criteria andUserRemartIsNull() {
            addCriterion("USER_REMART is null");
            return (Criteria) this;
        }

        public Criteria andUserRemartIsNotNull() {
            addCriterion("USER_REMART is not null");
            return (Criteria) this;
        }

        public Criteria andUserRemartEqualTo(String value) {
            addCriterion("USER_REMART =", value, "userRemart");
            return (Criteria) this;
        }

        public Criteria andUserRemartNotEqualTo(String value) {
            addCriterion("USER_REMART <>", value, "userRemart");
            return (Criteria) this;
        }

        public Criteria andUserRemartGreaterThan(String value) {
            addCriterion("USER_REMART >", value, "userRemart");
            return (Criteria) this;
        }

        public Criteria andUserRemartGreaterThanOrEqualTo(String value) {
            addCriterion("USER_REMART >=", value, "userRemart");
            return (Criteria) this;
        }

        public Criteria andUserRemartLessThan(String value) {
            addCriterion("USER_REMART <", value, "userRemart");
            return (Criteria) this;
        }

        public Criteria andUserRemartLessThanOrEqualTo(String value) {
            addCriterion("USER_REMART <=", value, "userRemart");
            return (Criteria) this;
        }

        public Criteria andUserRemartLike(String value) {
            addCriterion("USER_REMART like", value, "userRemart");
            return (Criteria) this;
        }

        public Criteria andUserRemartNotLike(String value) {
            addCriterion("USER_REMART not like", value, "userRemart");
            return (Criteria) this;
        }

        public Criteria andUserRemartIn(List<String> values) {
            addCriterion("USER_REMART in", values, "userRemart");
            return (Criteria) this;
        }

        public Criteria andUserRemartNotIn(List<String> values) {
            addCriterion("USER_REMART not in", values, "userRemart");
            return (Criteria) this;
        }

        public Criteria andUserRemartBetween(String value1, String value2) {
            addCriterion("USER_REMART between", value1, value2, "userRemart");
            return (Criteria) this;
        }

        public Criteria andUserRemartNotBetween(String value1, String value2) {
            addCriterion("USER_REMART not between", value1, value2, "userRemart");
            return (Criteria) this;
        }

        public Criteria andOrgaIdIsNull() {
            addCriterion("ORGA_ID is null");
            return (Criteria) this;
        }

        public Criteria andOrgaIdIsNotNull() {
            addCriterion("ORGA_ID is not null");
            return (Criteria) this;
        }

        public Criteria andOrgaIdEqualTo(Integer value) {
            addCriterion("ORGA_ID =", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdNotEqualTo(Integer value) {
            addCriterion("ORGA_ID <>", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdGreaterThan(Integer value) {
            addCriterion("ORGA_ID >", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("ORGA_ID >=", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdLessThan(Integer value) {
            addCriterion("ORGA_ID <", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdLessThanOrEqualTo(Integer value) {
            addCriterion("ORGA_ID <=", value, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdIn(List<Integer> values) {
            addCriterion("ORGA_ID in", values, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdNotIn(List<Integer> values) {
            addCriterion("ORGA_ID not in", values, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdBetween(Integer value1, Integer value2) {
            addCriterion("ORGA_ID between", value1, value2, "orgaId");
            return (Criteria) this;
        }

        public Criteria andOrgaIdNotBetween(Integer value1, Integer value2) {
            addCriterion("ORGA_ID not between", value1, value2, "orgaId");
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
    }
}