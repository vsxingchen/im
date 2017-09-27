package com.im.user.domain;

import java.util.Date;


/**
 * 用户
 * @author Administrator
 *
 */
public class User {
    /** */
    private Integer id;

    /** 昵称*/
    private String nickname;

    /** */
    private String password;

    /** 邮箱*/
    private String email;

    /** 电话*/
    private String tel;

    /** 用户名（备用）*/
    private String username;

    /** 真实姓名*/
    private String realname;

    /** 生日*/
    private Date birthday;

    /** 注册日期*/
    private Date createtime;

    /** 身高*/
    private String height;

    /** 体重*/
    private String weight;

    /** 0未婚 1离异有子女 2离异无子女*/
    private Integer marriage;

    /** 学历 0无 1小学 2初中 3高中 4大学本科 5大专 6中专 7研究生 8博士 9其他*/
    private Integer educational;

    /** 单位性质 1 政府部门、2国企、3事业单位、4私企、5个体自营*/
    private Integer unitproperties;

    /** 收入状况 1 1000—2000、2 2001—3000、3 3001—4000、4 4001—5000、5  5000以上*/
    private Integer income;

    /** 家庭成员（多选：父母、单亲、兄弟姐妹、独生子女）*/
    private String family;

    /** 家庭住址*/
    private String familyaddress;

    /** 现住址*/
    private String nowaddress;

    /** 独立住房 0无 1有*/
    private Integer independenthouse;

    /** 0 无 1有*/
    private Integer privatecar;

    /** 兴趣爱好（多选：唱歌、旅游、运动、电影……等）*/
    private String interest;

    /** 健康状况 2 残疾、3有重大疾病、1 健康*/
    private Integer health;

    /** 自我评价（多选：开朗、乐观、温柔、稳重、孝顺、善良、幽默、有责任心……等）*/
    private String evaluation;

    /** 交友宣言*/
    private String declaration;

    /** 头像*/
    private String headsculpture;

    /** 状态*/
    private Integer status;

    /** 权限*/
    private Integer roleid;

    /** 另一半年龄段开始时间*/
    private Date otheragestart;

    /** 另一半年龄段结束时间*/
    private Date otherageend;

    /** 另一半身高开始*/
    private String otherheightstart;

    /** 另一半身高结束*/
    private String otherheightend;

    /** 另一半学历*/
    private String othereducational;

    /** 另一半工作*/
    private String otherunitproperties;

    /** 另一半婚姻状况*/
    private String othermarriage;

    /** 另一半房*/
    private String otherindependenthouse;

    /** 另一半车*/
    private String otherprivatecar;

    /** 其他（多选：开朗、乐观、温柔、稳重、孝顺、善良、幽默、有责任心……等）*/
    private String others;
    /**
     * 性别 1男 2女
     */
    private Integer sex;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height == null ? null : height.trim();
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight == null ? null : weight.trim();
    }

    public Integer getMarriage() {
        return marriage;
    }

    public void setMarriage(Integer marriage) {
        this.marriage = marriage;
    }

    public Integer getEducational() {
        return educational;
    }

    public void setEducational(Integer educational) {
        this.educational = educational;
    }

    public Integer getUnitproperties() {
        return unitproperties;
    }

    public void setUnitproperties(Integer unitproperties) {
        this.unitproperties = unitproperties;
    }

    public Integer getIncome() {
        return income;
    }

    public void setIncome(Integer income) {
        this.income = income;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family == null ? null : family.trim();
    }

    public String getFamilyaddress() {
        return familyaddress;
    }

    public void setFamilyaddress(String familyaddress) {
        this.familyaddress = familyaddress == null ? null : familyaddress.trim();
    }

    public String getNowaddress() {
        return nowaddress;
    }

    public void setNowaddress(String nowaddress) {
        this.nowaddress = nowaddress == null ? null : nowaddress.trim();
    }

    public Integer getIndependenthouse() {
        return independenthouse;
    }

    public void setIndependenthouse(Integer independenthouse) {
        this.independenthouse = independenthouse;
    }

    public Integer getPrivatecar() {
        return privatecar;
    }

    public void setPrivatecar(Integer privatecar) {
        this.privatecar = privatecar;
    }

    public String getInterest() {
        return interest;
    }

    public void setInterest(String interest) {
        this.interest = interest == null ? null : interest.trim();
    }

    public Integer getHealth() {
        return health;
    }

    public void setHealth(Integer health) {
        this.health = health;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation == null ? null : evaluation.trim();
    }

    public String getDeclaration() {
        return declaration;
    }

    public void setDeclaration(String declaration) {
        this.declaration = declaration == null ? null : declaration.trim();
    }

    public String getHeadsculpture() {
        return headsculpture;
    }

    public void setHeadsculpture(String headsculpture) {
        this.headsculpture = headsculpture == null ? null : headsculpture.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Date getOtheragestart() {
        return otheragestart;
    }

    public void setOtheragestart(Date otheragestart) {
        this.otheragestart = otheragestart;
    }

    public Date getOtherageend() {
        return otherageend;
    }

    public void setOtherageend(Date otherageend) {
        this.otherageend = otherageend;
    }

    public String getOtherheightstart() {
        return otherheightstart;
    }

    public void setOtherheightstart(String otherheightstart) {
        this.otherheightstart = otherheightstart == null ? null : otherheightstart.trim();
    }

    public String getOtherheightend() {
        return otherheightend;
    }

    public void setOtherheightend(String otherheightend) {
        this.otherheightend = otherheightend == null ? null : otherheightend.trim();
    }

    public String getOthereducational() {
        return othereducational;
    }

    public void setOthereducational(String othereducational) {
        this.othereducational = othereducational == null ? null : othereducational.trim();
    }

    public String getOtherunitproperties() {
        return otherunitproperties;
    }

    public void setOtherunitproperties(String otherunitproperties) {
        this.otherunitproperties = otherunitproperties == null ? null : otherunitproperties.trim();
    }

    public String getOthermarriage() {
        return othermarriage;
    }

    public void setOthermarriage(String othermarriage) {
        this.othermarriage = othermarriage == null ? null : othermarriage.trim();
    }

    public String getOtherindependenthouse() {
        return otherindependenthouse;
    }

    public void setOtherindependenthouse(String otherindependenthouse) {
        this.otherindependenthouse = otherindependenthouse == null ? null : otherindependenthouse.trim();
    }

    public String getOtherprivatecar() {
        return otherprivatecar;
    }

    public void setOtherprivatecar(String otherprivatecar) {
        this.otherprivatecar = otherprivatecar == null ? null : otherprivatecar.trim();
    }

    public String getOthers() {
        return others;
    }

    public void setOthers(String others) {
        this.others = others == null ? null : others.trim();
    }

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}
    
}