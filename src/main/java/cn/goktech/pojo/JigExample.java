package cn.goktech.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class JigExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public JigExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andJigmcIsNull() {
            addCriterion("JIGMC is null");
            return (Criteria) this;
        }

        public Criteria andJigmcIsNotNull() {
            addCriterion("JIGMC is not null");
            return (Criteria) this;
        }

        public Criteria andJigmcEqualTo(String value) {
            addCriterion("JIGMC =", value, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJigmcNotEqualTo(String value) {
            addCriterion("JIGMC <>", value, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJigmcGreaterThan(String value) {
            addCriterion("JIGMC >", value, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJigmcGreaterThanOrEqualTo(String value) {
            addCriterion("JIGMC >=", value, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJigmcLessThan(String value) {
            addCriterion("JIGMC <", value, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJigmcLessThanOrEqualTo(String value) {
            addCriterion("JIGMC <=", value, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJigmcLike(String value) {
            addCriterion("JIGMC like", value, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJigmcNotLike(String value) {
            addCriterion("JIGMC not like", value, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJigmcIn(List<String> values) {
            addCriterion("JIGMC in", values, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJigmcNotIn(List<String> values) {
            addCriterion("JIGMC not in", values, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJigmcBetween(String value1, String value2) {
            addCriterion("JIGMC between", value1, value2, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJigmcNotBetween(String value1, String value2) {
            addCriterion("JIGMC not between", value1, value2, "jigmc");
            return (Criteria) this;
        }

        public Criteria andJiglxIsNull() {
            addCriterion("JIGLX is null");
            return (Criteria) this;
        }

        public Criteria andJiglxIsNotNull() {
            addCriterion("JIGLX is not null");
            return (Criteria) this;
        }

        public Criteria andJiglxEqualTo(String value) {
            addCriterion("JIGLX =", value, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJiglxNotEqualTo(String value) {
            addCriterion("JIGLX <>", value, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJiglxGreaterThan(String value) {
            addCriterion("JIGLX >", value, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJiglxGreaterThanOrEqualTo(String value) {
            addCriterion("JIGLX >=", value, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJiglxLessThan(String value) {
            addCriterion("JIGLX <", value, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJiglxLessThanOrEqualTo(String value) {
            addCriterion("JIGLX <=", value, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJiglxLike(String value) {
            addCriterion("JIGLX like", value, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJiglxNotLike(String value) {
            addCriterion("JIGLX not like", value, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJiglxIn(List<String> values) {
            addCriterion("JIGLX in", values, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJiglxNotIn(List<String> values) {
            addCriterion("JIGLX not in", values, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJiglxBetween(String value1, String value2) {
            addCriterion("JIGLX between", value1, value2, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJiglxNotBetween(String value1, String value2) {
            addCriterion("JIGLX not between", value1, value2, "jiglx");
            return (Criteria) this;
        }

        public Criteria andJigdhIsNull() {
            addCriterion("JIGDH is null");
            return (Criteria) this;
        }

        public Criteria andJigdhIsNotNull() {
            addCriterion("JIGDH is not null");
            return (Criteria) this;
        }

        public Criteria andJigdhEqualTo(String value) {
            addCriterion("JIGDH =", value, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigdhNotEqualTo(String value) {
            addCriterion("JIGDH <>", value, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigdhGreaterThan(String value) {
            addCriterion("JIGDH >", value, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigdhGreaterThanOrEqualTo(String value) {
            addCriterion("JIGDH >=", value, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigdhLessThan(String value) {
            addCriterion("JIGDH <", value, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigdhLessThanOrEqualTo(String value) {
            addCriterion("JIGDH <=", value, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigdhLike(String value) {
            addCriterion("JIGDH like", value, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigdhNotLike(String value) {
            addCriterion("JIGDH not like", value, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigdhIn(List<String> values) {
            addCriterion("JIGDH in", values, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigdhNotIn(List<String> values) {
            addCriterion("JIGDH not in", values, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigdhBetween(String value1, String value2) {
            addCriterion("JIGDH between", value1, value2, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigdhNotBetween(String value1, String value2) {
            addCriterion("JIGDH not between", value1, value2, "jigdh");
            return (Criteria) this;
        }

        public Criteria andJigjbIsNull() {
            addCriterion("JIGJB is null");
            return (Criteria) this;
        }

        public Criteria andJigjbIsNotNull() {
            addCriterion("JIGJB is not null");
            return (Criteria) this;
        }

        public Criteria andJigjbEqualTo(String value) {
            addCriterion("JIGJB =", value, "jigjb");
            return (Criteria) this;
        }

        public Criteria andJigjbNotEqualTo(String value) {
            addCriterion("JIGJB <>", value, "jigjb");
            return (Criteria) this;
        }

        public Criteria andJigjbGreaterThan(String value) {
            addCriterion("JIGJB >", value, "jigjb");
            return (Criteria) this;
        }

        public Criteria andJigjbGreaterThanOrEqualTo(String value) {
            addCriterion("JIGJB >=", value, "jigjb");
            return (Criteria) this;
        }

        public Criteria andJigjbLessThan(String value) {
            addCriterion("JIGJB <", value, "jigjb");
            return (Criteria) this;
        }

        public Criteria andJigjbLessThanOrEqualTo(String value) {
            addCriterion("JIGJB <=", value, "jigjb");
            return (Criteria) this;
        }

        public Criteria andJigjbLike(String value) {
            addCriterion("JIGJB like", value, "jigjb");
            return (Criteria) this;
        }

        public Criteria andJigjbNotLike(String value) {
            addCriterion("JIGJB not like", value, "jigjb");
            return (Criteria) this;
        }

        public Criteria andJigjbIn(List<String> values) {
            addCriterion("JIGJB in", values, "jigjb");
            return (Criteria) this;
        }

        public Criteria andJigjbNotIn(List<String> values) {
            addCriterion("JIGJB not in", values, "jigjb");
            return (Criteria) this;
        }

        public Criteria andJigjbBetween(String value1, String value2) {
            addCriterion("JIGJB between", value1, value2, "jigjb");
            return (Criteria) this;
        }

        public Criteria andJigjbNotBetween(String value1, String value2) {
            addCriterion("JIGJB not between", value1, value2, "jigjb");
            return (Criteria) this;
        }

        public Criteria andLianxrIsNull() {
            addCriterion("LIANXR is null");
            return (Criteria) this;
        }

        public Criteria andLianxrIsNotNull() {
            addCriterion("LIANXR is not null");
            return (Criteria) this;
        }

        public Criteria andLianxrEqualTo(String value) {
            addCriterion("LIANXR =", value, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxrNotEqualTo(String value) {
            addCriterion("LIANXR <>", value, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxrGreaterThan(String value) {
            addCriterion("LIANXR >", value, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxrGreaterThanOrEqualTo(String value) {
            addCriterion("LIANXR >=", value, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxrLessThan(String value) {
            addCriterion("LIANXR <", value, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxrLessThanOrEqualTo(String value) {
            addCriterion("LIANXR <=", value, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxrLike(String value) {
            addCriterion("LIANXR like", value, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxrNotLike(String value) {
            addCriterion("LIANXR not like", value, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxrIn(List<String> values) {
            addCriterion("LIANXR in", values, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxrNotIn(List<String> values) {
            addCriterion("LIANXR not in", values, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxrBetween(String value1, String value2) {
            addCriterion("LIANXR between", value1, value2, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxrNotBetween(String value1, String value2) {
            addCriterion("LIANXR not between", value1, value2, "lianxr");
            return (Criteria) this;
        }

        public Criteria andLianxdhIsNull() {
            addCriterion("LIANXDH is null");
            return (Criteria) this;
        }

        public Criteria andLianxdhIsNotNull() {
            addCriterion("LIANXDH is not null");
            return (Criteria) this;
        }

        public Criteria andLianxdhEqualTo(String value) {
            addCriterion("LIANXDH =", value, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andLianxdhNotEqualTo(String value) {
            addCriterion("LIANXDH <>", value, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andLianxdhGreaterThan(String value) {
            addCriterion("LIANXDH >", value, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andLianxdhGreaterThanOrEqualTo(String value) {
            addCriterion("LIANXDH >=", value, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andLianxdhLessThan(String value) {
            addCriterion("LIANXDH <", value, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andLianxdhLessThanOrEqualTo(String value) {
            addCriterion("LIANXDH <=", value, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andLianxdhLike(String value) {
            addCriterion("LIANXDH like", value, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andLianxdhNotLike(String value) {
            addCriterion("LIANXDH not like", value, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andLianxdhIn(List<String> values) {
            addCriterion("LIANXDH in", values, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andLianxdhNotIn(List<String> values) {
            addCriterion("LIANXDH not in", values, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andLianxdhBetween(String value1, String value2) {
            addCriterion("LIANXDH between", value1, value2, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andLianxdhNotBetween(String value1, String value2) {
            addCriterion("LIANXDH not between", value1, value2, "lianxdh");
            return (Criteria) this;
        }

        public Criteria andXiangxdzIsNull() {
            addCriterion("XIANGXDZ is null");
            return (Criteria) this;
        }

        public Criteria andXiangxdzIsNotNull() {
            addCriterion("XIANGXDZ is not null");
            return (Criteria) this;
        }

        public Criteria andXiangxdzEqualTo(String value) {
            addCriterion("XIANGXDZ =", value, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andXiangxdzNotEqualTo(String value) {
            addCriterion("XIANGXDZ <>", value, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andXiangxdzGreaterThan(String value) {
            addCriterion("XIANGXDZ >", value, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andXiangxdzGreaterThanOrEqualTo(String value) {
            addCriterion("XIANGXDZ >=", value, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andXiangxdzLessThan(String value) {
            addCriterion("XIANGXDZ <", value, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andXiangxdzLessThanOrEqualTo(String value) {
            addCriterion("XIANGXDZ <=", value, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andXiangxdzLike(String value) {
            addCriterion("XIANGXDZ like", value, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andXiangxdzNotLike(String value) {
            addCriterion("XIANGXDZ not like", value, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andXiangxdzIn(List<String> values) {
            addCriterion("XIANGXDZ in", values, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andXiangxdzNotIn(List<String> values) {
            addCriterion("XIANGXDZ not in", values, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andXiangxdzBetween(String value1, String value2) {
            addCriterion("XIANGXDZ between", value1, value2, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andXiangxdzNotBetween(String value1, String value2) {
            addCriterion("XIANGXDZ not between", value1, value2, "xiangxdz");
            return (Criteria) this;
        }

        public Criteria andJingdIsNull() {
            addCriterion("JINGD is null");
            return (Criteria) this;
        }

        public Criteria andJingdIsNotNull() {
            addCriterion("JINGD is not null");
            return (Criteria) this;
        }

        public Criteria andJingdEqualTo(BigDecimal value) {
            addCriterion("JINGD =", value, "jingd");
            return (Criteria) this;
        }

        public Criteria andJingdNotEqualTo(BigDecimal value) {
            addCriterion("JINGD <>", value, "jingd");
            return (Criteria) this;
        }

        public Criteria andJingdGreaterThan(BigDecimal value) {
            addCriterion("JINGD >", value, "jingd");
            return (Criteria) this;
        }

        public Criteria andJingdGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("JINGD >=", value, "jingd");
            return (Criteria) this;
        }

        public Criteria andJingdLessThan(BigDecimal value) {
            addCriterion("JINGD <", value, "jingd");
            return (Criteria) this;
        }

        public Criteria andJingdLessThanOrEqualTo(BigDecimal value) {
            addCriterion("JINGD <=", value, "jingd");
            return (Criteria) this;
        }

        public Criteria andJingdIn(List<BigDecimal> values) {
            addCriterion("JINGD in", values, "jingd");
            return (Criteria) this;
        }

        public Criteria andJingdNotIn(List<BigDecimal> values) {
            addCriterion("JINGD not in", values, "jingd");
            return (Criteria) this;
        }

        public Criteria andJingdBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JINGD between", value1, value2, "jingd");
            return (Criteria) this;
        }

        public Criteria andJingdNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("JINGD not between", value1, value2, "jingd");
            return (Criteria) this;
        }

        public Criteria andWeidIsNull() {
            addCriterion("WEID is null");
            return (Criteria) this;
        }

        public Criteria andWeidIsNotNull() {
            addCriterion("WEID is not null");
            return (Criteria) this;
        }

        public Criteria andWeidEqualTo(BigDecimal value) {
            addCriterion("WEID =", value, "weid");
            return (Criteria) this;
        }

        public Criteria andWeidNotEqualTo(BigDecimal value) {
            addCriterion("WEID <>", value, "weid");
            return (Criteria) this;
        }

        public Criteria andWeidGreaterThan(BigDecimal value) {
            addCriterion("WEID >", value, "weid");
            return (Criteria) this;
        }

        public Criteria andWeidGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("WEID >=", value, "weid");
            return (Criteria) this;
        }

        public Criteria andWeidLessThan(BigDecimal value) {
            addCriterion("WEID <", value, "weid");
            return (Criteria) this;
        }

        public Criteria andWeidLessThanOrEqualTo(BigDecimal value) {
            addCriterion("WEID <=", value, "weid");
            return (Criteria) this;
        }

        public Criteria andWeidIn(List<BigDecimal> values) {
            addCriterion("WEID in", values, "weid");
            return (Criteria) this;
        }

        public Criteria andWeidNotIn(List<BigDecimal> values) {
            addCriterion("WEID not in", values, "weid");
            return (Criteria) this;
        }

        public Criteria andWeidBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEID between", value1, value2, "weid");
            return (Criteria) this;
        }

        public Criteria andWeidNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("WEID not between", value1, value2, "weid");
            return (Criteria) this;
        }

        public Criteria andYoubIsNull() {
            addCriterion("YOUB is null");
            return (Criteria) this;
        }

        public Criteria andYoubIsNotNull() {
            addCriterion("YOUB is not null");
            return (Criteria) this;
        }

        public Criteria andYoubEqualTo(Object value) {
            addCriterion("YOUB =", value, "youb");
            return (Criteria) this;
        }

        public Criteria andYoubNotEqualTo(Object value) {
            addCriterion("YOUB <>", value, "youb");
            return (Criteria) this;
        }

        public Criteria andYoubGreaterThan(Object value) {
            addCriterion("YOUB >", value, "youb");
            return (Criteria) this;
        }

        public Criteria andYoubGreaterThanOrEqualTo(Object value) {
            addCriterion("YOUB >=", value, "youb");
            return (Criteria) this;
        }

        public Criteria andYoubLessThan(Object value) {
            addCriterion("YOUB <", value, "youb");
            return (Criteria) this;
        }

        public Criteria andYoubLessThanOrEqualTo(Object value) {
            addCriterion("YOUB <=", value, "youb");
            return (Criteria) this;
        }

        public Criteria andYoubIn(List<Object> values) {
            addCriterion("YOUB in", values, "youb");
            return (Criteria) this;
        }

        public Criteria andYoubNotIn(List<Object> values) {
            addCriterion("YOUB not in", values, "youb");
            return (Criteria) this;
        }

        public Criteria andYoubBetween(Object value1, Object value2) {
            addCriterion("YOUB between", value1, value2, "youb");
            return (Criteria) this;
        }

        public Criteria andYoubNotBetween(Object value1, Object value2) {
            addCriterion("YOUB not between", value1, value2, "youb");
            return (Criteria) this;
        }

        public Criteria andQiyIsNull() {
            addCriterion("QIY is null");
            return (Criteria) this;
        }

        public Criteria andQiyIsNotNull() {
            addCriterion("QIY is not null");
            return (Criteria) this;
        }

        public Criteria andQiyEqualTo(Object value) {
            addCriterion("QIY =", value, "qiy");
            return (Criteria) this;
        }

        public Criteria andQiyNotEqualTo(Object value) {
            addCriterion("QIY <>", value, "qiy");
            return (Criteria) this;
        }

        public Criteria andQiyGreaterThan(Object value) {
            addCriterion("QIY >", value, "qiy");
            return (Criteria) this;
        }

        public Criteria andQiyGreaterThanOrEqualTo(Object value) {
            addCriterion("QIY >=", value, "qiy");
            return (Criteria) this;
        }

        public Criteria andQiyLessThan(Object value) {
            addCriterion("QIY <", value, "qiy");
            return (Criteria) this;
        }

        public Criteria andQiyLessThanOrEqualTo(Object value) {
            addCriterion("QIY <=", value, "qiy");
            return (Criteria) this;
        }

        public Criteria andQiyIn(List<Object> values) {
            addCriterion("QIY in", values, "qiy");
            return (Criteria) this;
        }

        public Criteria andQiyNotIn(List<Object> values) {
            addCriterion("QIY not in", values, "qiy");
            return (Criteria) this;
        }

        public Criteria andQiyBetween(Object value1, Object value2) {
            addCriterion("QIY between", value1, value2, "qiy");
            return (Criteria) this;
        }

        public Criteria andQiyNotBetween(Object value1, Object value2) {
            addCriterion("QIY not between", value1, value2, "qiy");
            return (Criteria) this;
        }

        public Criteria andJianymsIsNull() {
            addCriterion("JIANYMS is null");
            return (Criteria) this;
        }

        public Criteria andJianymsIsNotNull() {
            addCriterion("JIANYMS is not null");
            return (Criteria) this;
        }

        public Criteria andJianymsEqualTo(String value) {
            addCriterion("JIANYMS =", value, "jianyms");
            return (Criteria) this;
        }

        public Criteria andJianymsNotEqualTo(String value) {
            addCriterion("JIANYMS <>", value, "jianyms");
            return (Criteria) this;
        }

        public Criteria andJianymsGreaterThan(String value) {
            addCriterion("JIANYMS >", value, "jianyms");
            return (Criteria) this;
        }

        public Criteria andJianymsGreaterThanOrEqualTo(String value) {
            addCriterion("JIANYMS >=", value, "jianyms");
            return (Criteria) this;
        }

        public Criteria andJianymsLessThan(String value) {
            addCriterion("JIANYMS <", value, "jianyms");
            return (Criteria) this;
        }

        public Criteria andJianymsLessThanOrEqualTo(String value) {
            addCriterion("JIANYMS <=", value, "jianyms");
            return (Criteria) this;
        }

        public Criteria andJianymsLike(String value) {
            addCriterion("JIANYMS like", value, "jianyms");
            return (Criteria) this;
        }

        public Criteria andJianymsNotLike(String value) {
            addCriterion("JIANYMS not like", value, "jianyms");
            return (Criteria) this;
        }

        public Criteria andJianymsIn(List<String> values) {
            addCriterion("JIANYMS in", values, "jianyms");
            return (Criteria) this;
        }

        public Criteria andJianymsNotIn(List<String> values) {
            addCriterion("JIANYMS not in", values, "jianyms");
            return (Criteria) this;
        }

        public Criteria andJianymsBetween(String value1, String value2) {
            addCriterion("JIANYMS between", value1, value2, "jianyms");
            return (Criteria) this;
        }

        public Criteria andJianymsNotBetween(String value1, String value2) {
            addCriterion("JIANYMS not between", value1, value2, "jianyms");
            return (Criteria) this;
        }

        public Criteria andUseridIsNull() {
            addCriterion("USERID is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("USERID is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(Object value) {
            addCriterion("USERID =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(Object value) {
            addCriterion("USERID <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(Object value) {
            addCriterion("USERID >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(Object value) {
            addCriterion("USERID >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(Object value) {
            addCriterion("USERID <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(Object value) {
            addCriterion("USERID <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<Object> values) {
            addCriterion("USERID in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<Object> values) {
            addCriterion("USERID not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(Object value1, Object value2) {
            addCriterion("USERID between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(Object value1, Object value2) {
            addCriterion("USERID not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNull() {
            addCriterion("UPDATETIME is null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIsNotNull() {
            addCriterion("UPDATETIME is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeEqualTo(Date value) {
            addCriterion("UPDATETIME =", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotEqualTo(Date value) {
            addCriterion("UPDATETIME <>", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThan(Date value) {
            addCriterion("UPDATETIME >", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME >=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThan(Date value) {
            addCriterion("UPDATETIME <", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeLessThanOrEqualTo(Date value) {
            addCriterion("UPDATETIME <=", value, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeIn(List<Date> values) {
            addCriterion("UPDATETIME in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotIn(List<Date> values) {
            addCriterion("UPDATETIME not in", values, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andUpdatetimeNotBetween(Date value1, Date value2) {
            addCriterion("UPDATETIME not between", value1, value2, "updatetime");
            return (Criteria) this;
        }

        public Criteria andSuozqyIsNull() {
            addCriterion("SUOZQY is null");
            return (Criteria) this;
        }

        public Criteria andSuozqyIsNotNull() {
            addCriterion("SUOZQY is not null");
            return (Criteria) this;
        }

        public Criteria andSuozqyEqualTo(String value) {
            addCriterion("SUOZQY =", value, "suozqy");
            return (Criteria) this;
        }

        public Criteria andSuozqyNotEqualTo(String value) {
            addCriterion("SUOZQY <>", value, "suozqy");
            return (Criteria) this;
        }

        public Criteria andSuozqyGreaterThan(String value) {
            addCriterion("SUOZQY >", value, "suozqy");
            return (Criteria) this;
        }

        public Criteria andSuozqyGreaterThanOrEqualTo(String value) {
            addCriterion("SUOZQY >=", value, "suozqy");
            return (Criteria) this;
        }

        public Criteria andSuozqyLessThan(String value) {
            addCriterion("SUOZQY <", value, "suozqy");
            return (Criteria) this;
        }

        public Criteria andSuozqyLessThanOrEqualTo(String value) {
            addCriterion("SUOZQY <=", value, "suozqy");
            return (Criteria) this;
        }

        public Criteria andSuozqyLike(String value) {
            addCriterion("SUOZQY like", value, "suozqy");
            return (Criteria) this;
        }

        public Criteria andSuozqyNotLike(String value) {
            addCriterion("SUOZQY not like", value, "suozqy");
            return (Criteria) this;
        }

        public Criteria andSuozqyIn(List<String> values) {
            addCriterion("SUOZQY in", values, "suozqy");
            return (Criteria) this;
        }

        public Criteria andSuozqyNotIn(List<String> values) {
            addCriterion("SUOZQY not in", values, "suozqy");
            return (Criteria) this;
        }

        public Criteria andSuozqyBetween(String value1, String value2) {
            addCriterion("SUOZQY between", value1, value2, "suozqy");
            return (Criteria) this;
        }

        public Criteria andSuozqyNotBetween(String value1, String value2) {
            addCriterion("SUOZQY not between", value1, value2, "suozqy");
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