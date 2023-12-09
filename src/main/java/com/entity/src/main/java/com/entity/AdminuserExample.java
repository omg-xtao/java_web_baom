package com.entity;

import java.util.ArrayList;
import java.util.List;

public class AdminuserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    private Integer limit;

    private Long offset;

    public AdminuserExample() {
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

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getOffset() {
        return offset;
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

        public Criteria andAdminidIsNull() {
            addCriterion("adminid is null");
            return (Criteria) this;
        }

        public Criteria andAdminidIsNotNull() {
            addCriterion("adminid is not null");
            return (Criteria) this;
        }

        public Criteria andAdminidEqualTo(Integer value) {
            addCriterion("adminid =", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotEqualTo(Integer value) {
            addCriterion("adminid <>", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThan(Integer value) {
            addCriterion("adminid >", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThanOrEqualTo(Integer value) {
            addCriterion("adminid >=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThan(Integer value) {
            addCriterion("adminid <", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThanOrEqualTo(Integer value) {
            addCriterion("adminid <=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidIn(List<Integer> values) {
            addCriterion("adminid in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotIn(List<Integer> values) {
            addCriterion("adminid not in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidBetween(Integer value1, Integer value2) {
            addCriterion("adminid between", value1, value2, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotBetween(Integer value1, Integer value2) {
            addCriterion("adminid not between", value1, value2, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminnameIsNull() {
            addCriterion("adminname is null");
            return (Criteria) this;
        }

        public Criteria andAdminnameIsNotNull() {
            addCriterion("adminname is not null");
            return (Criteria) this;
        }

        public Criteria andAdminnameEqualTo(String value) {
            addCriterion("adminname =", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotEqualTo(String value) {
            addCriterion("adminname <>", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameGreaterThan(String value) {
            addCriterion("adminname >", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameGreaterThanOrEqualTo(String value) {
            addCriterion("adminname >=", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLessThan(String value) {
            addCriterion("adminname <", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLessThanOrEqualTo(String value) {
            addCriterion("adminname <=", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameLike(String value) {
            addCriterion("adminname like", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotLike(String value) {
            addCriterion("adminname not like", value, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameIn(List<String> values) {
            addCriterion("adminname in", values, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotIn(List<String> values) {
            addCriterion("adminname not in", values, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameBetween(String value1, String value2) {
            addCriterion("adminname between", value1, value2, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminnameNotBetween(String value1, String value2) {
            addCriterion("adminname not between", value1, value2, "adminname");
            return (Criteria) this;
        }

        public Criteria andAdminpassIsNull() {
            addCriterion("adminpass is null");
            return (Criteria) this;
        }

        public Criteria andAdminpassIsNotNull() {
            addCriterion("adminpass is not null");
            return (Criteria) this;
        }

        public Criteria andAdminpassEqualTo(String value) {
            addCriterion("adminpass =", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassNotEqualTo(String value) {
            addCriterion("adminpass <>", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassGreaterThan(String value) {
            addCriterion("adminpass >", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassGreaterThanOrEqualTo(String value) {
            addCriterion("adminpass >=", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassLessThan(String value) {
            addCriterion("adminpass <", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassLessThanOrEqualTo(String value) {
            addCriterion("adminpass <=", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassLike(String value) {
            addCriterion("adminpass like", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassNotLike(String value) {
            addCriterion("adminpass not like", value, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassIn(List<String> values) {
            addCriterion("adminpass in", values, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassNotIn(List<String> values) {
            addCriterion("adminpass not in", values, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassBetween(String value1, String value2) {
            addCriterion("adminpass between", value1, value2, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdminpassNotBetween(String value1, String value2) {
            addCriterion("adminpass not between", value1, value2, "adminpass");
            return (Criteria) this;
        }

        public Criteria andAdmingroupIsNull() {
            addCriterion("admingroup is null");
            return (Criteria) this;
        }

        public Criteria andAdmingroupIsNotNull() {
            addCriterion("admingroup is not null");
            return (Criteria) this;
        }

        public Criteria andAdmingroupEqualTo(String value) {
            addCriterion("admingroup =", value, "admingroup");
            return (Criteria) this;
        }

        public Criteria andAdmingroupNotEqualTo(String value) {
            addCriterion("admingroup <>", value, "admingroup");
            return (Criteria) this;
        }

        public Criteria andAdmingroupGreaterThan(String value) {
            addCriterion("admingroup >", value, "admingroup");
            return (Criteria) this;
        }

        public Criteria andAdmingroupGreaterThanOrEqualTo(String value) {
            addCriterion("admingroup >=", value, "admingroup");
            return (Criteria) this;
        }

        public Criteria andAdmingroupLessThan(String value) {
            addCriterion("admingroup <", value, "admingroup");
            return (Criteria) this;
        }

        public Criteria andAdmingroupLessThanOrEqualTo(String value) {
            addCriterion("admingroup <=", value, "admingroup");
            return (Criteria) this;
        }

        public Criteria andAdmingroupLike(String value) {
            addCriterion("admingroup like", value, "admingroup");
            return (Criteria) this;
        }

        public Criteria andAdmingroupNotLike(String value) {
            addCriterion("admingroup not like", value, "admingroup");
            return (Criteria) this;
        }

        public Criteria andAdmingroupIn(List<String> values) {
            addCriterion("admingroup in", values, "admingroup");
            return (Criteria) this;
        }

        public Criteria andAdmingroupNotIn(List<String> values) {
            addCriterion("admingroup not in", values, "admingroup");
            return (Criteria) this;
        }

        public Criteria andAdmingroupBetween(String value1, String value2) {
            addCriterion("admingroup between", value1, value2, "admingroup");
            return (Criteria) this;
        }

        public Criteria andAdmingroupNotBetween(String value1, String value2) {
            addCriterion("admingroup not between", value1, value2, "admingroup");
            return (Criteria) this;
        }
    }

    /**
     */
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